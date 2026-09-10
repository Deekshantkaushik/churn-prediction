package com.deekshant.churn_dashboard.repository;
import com.deekshant.churn_dashboard.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Custom query method — Spring auto-generates the SQL from this method name
    List<Customer> findByContractType(String contractType);
    Page<Customer> findByContractType(String contractType, Pageable pageable);
}
