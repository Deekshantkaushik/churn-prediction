package com.deekshant.churn_dashboard.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "customers")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    private String name;
    private String email;
    private String gender;

    @Column(name = "contract_type")
    private String contractType;

    @Column(name = "tenure_months")
    private Integer tenureMonths;

    @Column(name = "monthly_charges")
    private Double monthlyCharges;

    @Column(name = "total_charges")
    private Double totalCharges;

    @Column(name = "internet_service")
    private String internetService;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "signup_date")
    private java.time.LocalDate signupDate;

    @Column(name = "is_active")
    private Boolean isActive;

    // Getters and Setters (required by JPA)
    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getContractType() { return contractType; }
    public void setContractType(String contractType) { this.contractType = contractType; }


    public Integer getTenureMonths() { return tenureMonths; }
    public void setTenureMonths(Integer tenureMonths) { this.tenureMonths = tenureMonths; }

    public Double getMonthlyCharges() { return monthlyCharges; }
    public void setMonthlyCharges(Double monthlyCharges) { this.monthlyCharges = monthlyCharges; }

    public Double getTotalCharges() { return totalCharges; }
    public void setTotalCharges(Double totalCharges) { this.totalCharges = totalCharges; }

    public String getInternetService() { return internetService; }
    public void setInternetService(String internetService) { this.internetService = internetService; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public java.time.LocalDate getSignupDate() { return signupDate; }
    public void setSignupDate(java.time.LocalDate signupDate) { this.signupDate = signupDate; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

}
