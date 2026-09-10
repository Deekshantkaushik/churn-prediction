package com.deekshant.churn_dashboard.repository;
import com.deekshant.churn_dashboard.entity.RetentionAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RetentionActionRepository  extends JpaRepository<RetentionAction, Integer>  {
    List<RetentionAction> findByCustomer_CustomerId(Integer customerId);
}
