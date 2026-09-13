package com.deekshant.churn_dashboard.controller;

import com.deekshant.churn_dashboard.entity.Customer;
import com.deekshant.churn_dashboard.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.HashMap;
import com.deekshant.churn_dashboard.entity.ChurnScore;
import com.deekshant.churn_dashboard.repository.ChurnScoreRepository;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired private ChurnScoreRepository churnScoreRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return customerRepository.findById(id).orElse(null);
    }
    @GetMapping("/search")
    public Page<Customer> searchCustomers(
            @RequestParam(required = false) String contractType,
            Pageable pageable) {

        if (contractType != null) {
            return customerRepository.findByContractType(contractType, pageable);
        }
        return customerRepository.findAll(pageable);
    }
    @GetMapping("/risk-summary")
    public Map<String, Long> getRiskSummary() {
        List<ChurnScore> allScores = churnScoreRepository.findAll();
        Map<String, Long> summary = new HashMap<>();
        summary.put("Low", allScores.stream().filter(s -> "Low".equals(s.getRiskTier())).count());
        summary.put("Medium", allScores.stream().filter(s -> "Medium".equals(s.getRiskTier())).count());
        summary.put("High", allScores.stream().filter(s -> "High".equals(s.getRiskTier())).count());
        return summary;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
    @GetMapping("/high-risk")
    @Cacheable("highRiskCustomers")
    public List<Customer> getHighRiskCustomers() {
        System.out.println("Querying MySQL for high-risk customers..."); // temporary, to observe caching behavior
        return customerRepository.findByContractType("Month-to-month");
    }
}
