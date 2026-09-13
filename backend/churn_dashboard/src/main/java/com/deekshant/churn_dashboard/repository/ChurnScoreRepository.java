package com.deekshant.churn_dashboard.repository;
import com.deekshant.churn_dashboard.entity.ChurnScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChurnScoreRepository extends JpaRepository<ChurnScore, Integer> {
    List<ChurnScore> findByCustomer_CustomerId(Integer customerId);
}
