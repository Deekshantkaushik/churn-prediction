package com.deekshant.churn_dashboard.controller;

import com.deekshant.churn_dashboard.entity.Customer;
import com.deekshant.churn_dashboard.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return customerRepository.findById(id).orElse(null);
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
