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

    @Column(name = "senior_citizen")
    private Boolean seniorCitizen;

    private Boolean partner;
    private Boolean dependents;

    @Column(name = "phone_service")
    private Boolean phoneService;

    @Column(name = "paperless_billing")
    private Boolean paperlessBilling;

    @Column(name = "multiple_lines")
    private String multipleLines;

    @Column(name = "online_security")
    private String onlineSecurity;

    @Column(name = "online_backup")
    private String onlineBackup;

    @Column(name = "device_protection")
    private String deviceProtection;

    @Column(name = "tech_support")
    private String techSupport;

    @Column(name = "streaming_tv")
    private String streamingTv;

    @Column(name = "streaming_movies")
    private String streamingMovies;

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

    public Boolean getSeniorCitizen() { return seniorCitizen; }
    public void setSeniorCitizen(Boolean seniorCitizen) { this.seniorCitizen = seniorCitizen; }

    public Boolean getPartner() { return partner; }
    public void setPartner(Boolean partner) { this.partner = partner; }

    public Boolean getDependents() { return dependents; }
    public void setDependents(Boolean dependents) { this.dependents = dependents; }

    public Boolean getPhoneService() { return phoneService; }
    public void setPhoneService(Boolean phoneService) { this.phoneService = phoneService; }

    public Boolean getPaperlessBilling() { return paperlessBilling; }
    public void setPaperlessBilling(Boolean paperlessBilling) { this.paperlessBilling = paperlessBilling; }

    public String getMultipleLines() { return multipleLines; }
    public void setMultipleLines(String multipleLines) { this.multipleLines = multipleLines; }

    public String getOnlineSecurity() { return onlineSecurity; }
    public void setOnlineSecurity(String onlineSecurity) { this.onlineSecurity = onlineSecurity; }

    public String getOnlineBackup() { return onlineBackup; }
    public void setOnlineBackup(String onlineBackup) { this.onlineBackup = onlineBackup; }

    public String getDeviceProtection() { return deviceProtection; }
    public void setDeviceProtection(String deviceProtection) { this.deviceProtection = deviceProtection; }

    public String getTechSupport() { return techSupport; }
    public void setTechSupport(String techSupport) { this.techSupport = techSupport; }

    public String getStreamingTv() { return streamingTv; }
    public void setStreamingTv(String streamingTv) { this.streamingTv = streamingTv; }

    public String getStreamingMovies() { return streamingMovies; }
    public void setStreamingMovies(String streamingMovies) { this.streamingMovies = streamingMovies; }

}
