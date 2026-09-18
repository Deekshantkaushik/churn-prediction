package com.deekshant.churn_dashboard.controller;
import java.util.Comparator;
import java.util.List;
import com.deekshant.churn_dashboard.dto.CustomerPredictionRequest;
import com.deekshant.churn_dashboard.entity.ChurnScore;
import com.deekshant.churn_dashboard.entity.Customer;
import com.deekshant.churn_dashboard.repository.ChurnScoreRepository;
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

    @Autowired private ChurnScoreRepository churnScoreRepository;

    @PostMapping("/{customerId}")
    public ChurnScore scoreCustomer(@PathVariable Integer customerId, @RequestBody CustomerPredictionRequest request) {
        System.out.println("🔥 CONTROLLER REACHED: customer " + customerId);
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        return churnPredictionService.scoreCustomer(customer, request);
    }
    @GetMapping("/latest/{customerId}")
    public ChurnScore getLatestScore(@PathVariable Integer customerId) {
        List<ChurnScore> scores = churnScoreRepository.findByCustomer_CustomerId(customerId);
        if (scores.isEmpty()) {
            return null;
        }
        return scores.stream()
                .max(Comparator.comparing(ChurnScore::getScoredAt))
                .orElse(null);
    }
}
