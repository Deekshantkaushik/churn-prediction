package com.deekshant.churn_dashboard.controller;
import com.deekshant.churn_dashboard.dto.CustomerPredictionRequest;
import com.deekshant.churn_dashboard.entity.ChurnScore;
import com.deekshant.churn_dashboard.entity.Customer;
import com.deekshant.churn_dashboard.repository.CustomerRepository;
import com.deekshant.churn_dashboard.service.ChurnPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/churn-scores")
public class ChurnScoreController {
    @Autowired
    private ChurnPredictionService churnPredictionService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/{customerId}")
    public ChurnScore scoreCustomer(@PathVariable Integer customerId, @RequestBody CustomerPredictionRequest request) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        return churnPredictionService.scoreCustomer(customer, request);
    }
}
