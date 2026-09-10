package com.deekshant.churn_dashboard.controller;

import com.deekshant.churn_dashboard.dto.RetentionActionRequest;
import com.deekshant.churn_dashboard.entity.*;
import com.deekshant.churn_dashboard.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/retention-actions")
public class RetentionActionController {
    @Autowired private RetentionActionRepository retentionActionRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private UserRepository userRepository;

    @PostMapping("/{customerId}")
    public RetentionAction logAction(@PathVariable Integer customerId, @RequestBody RetentionActionRequest request) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();

        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByUsername(currentUsername).orElseThrow();

        RetentionAction action = new RetentionAction();
        action.setCustomer(customer);
        action.setActionType(request.getActionType());
        action.setNotes(request.getNotes());
        action.setCreatedBy(currentUser);
        action.setCreatedAt(LocalDateTime.now());

        return retentionActionRepository.save(action);
    }
    @GetMapping("/customer/{customerId}")
    public List<RetentionAction> getActionsForCustomer(@PathVariable Integer customerId) {
        return retentionActionRepository.findByCustomer_CustomerId(customerId);
    }

}
