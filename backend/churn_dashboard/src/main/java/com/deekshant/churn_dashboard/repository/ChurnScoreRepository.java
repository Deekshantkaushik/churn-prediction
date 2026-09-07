package com.deekshant.churn_dashboard.repository;
import com.deekshant.churn_dashboard.entity.ChurnScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ChurnScoreRepository extends JpaRepository<ChurnScore, Integer> {
}
