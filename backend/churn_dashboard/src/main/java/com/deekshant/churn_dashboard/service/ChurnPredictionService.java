package com.deekshant.churn_dashboard.service;
import com.deekshant.churn_dashboard.dto.CustomerPredictionRequest;
import com.deekshant.churn_dashboard.dto.PredictionResponse;
import com.deekshant.churn_dashboard.entity.ChurnScore;
import com.deekshant.churn_dashboard.entity.Customer;
import com.deekshant.churn_dashboard.repository.ChurnScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;

@Service
public class ChurnPredictionService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ChurnScoreRepository churnScoreRepository;

    @Value("${ml.service.url}")
    private String mlServiceUrl;

    public ChurnScore scoreCustomer(Customer customer, CustomerPredictionRequest request) {
        // Step 1: Call the FastAPI service
        PredictionResponse response = restTemplate.postForObject(mlServiceUrl, request, PredictionResponse.class);

        // Step 2: Build a ChurnScore entity from the response
        ChurnScore churnScore = new ChurnScore();
        churnScore.setCustomer(customer);
        churnScore.setChurnProbability(response.getChurnProbability());
        churnScore.setRiskTier(response.getRiskTier());
        churnScore.setScoredAt(LocalDateTime.now());

        // Step 3: Save it to MySQL
        return churnScoreRepository.save(churnScore);
    }
}
