package com.deekshant.churn_dashboard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerPredictionRequest {

    private Integer gender;
    private Integer SeniorCitizen;
    private Integer Partner;
    private Integer Dependents;
    private Integer tenure;
    private Integer PhoneService;
    private Integer PaperlessBilling;
    private Double MonthlyCharges;
    private Double TotalCharges;

    @JsonProperty("Contract_One year")
    private Integer contractOneYear;

    @JsonProperty("Contract_Two year")
    private Integer contractTwoYear;

    @JsonProperty("InternetService_Fiber optic")
    private Integer internetServiceFiberOptic;

    private Integer InternetService_No;

    @JsonProperty("PaymentMethod_Credit card (automatic)")
    private Integer paymentMethodCreditCard;

    @JsonProperty("PaymentMethod_Electronic check")
    private Integer paymentMethodElectronicCheck;

    @JsonProperty("PaymentMethod_Mailed check")
    private Integer paymentMethodMailedCheck;

    @JsonProperty("MultipleLines_No phone service")
    private Integer multipleLinesNoPhoneService;

    private Integer MultipleLines_Yes;

    @JsonProperty("OnlineSecurity_No internet service")
    private Integer onlineSecurityNoInternetService;

    private Integer OnlineSecurity_Yes;

    @JsonProperty("OnlineBackup_No internet service")
    private Integer onlineBackupNoInternetService;

    private Integer OnlineBackup_Yes;

    @JsonProperty("DeviceProtection_No internet service")
    private Integer deviceProtectionNoInternetService;

    private Integer DeviceProtection_Yes;

    @JsonProperty("TechSupport_No internet service")
    private Integer techSupportNoInternetService;

    private Integer TechSupport_Yes;

    @JsonProperty("StreamingTV_No internet service")
    private Integer streamingTVNoInternetService;

    private Integer StreamingTV_Yes;

    @JsonProperty("StreamingMovies_No internet service")
    private Integer streamingMoviesNoInternetService;

    private Integer StreamingMovies_Yes;

    // ---- Getters and Setters for every field ----

    public Integer getGender() { return gender; }
    public void setGender(Integer gender) { this.gender = gender; }

    public Integer getSeniorCitizen() { return SeniorCitizen; }
    public void setSeniorCitizen(Integer seniorCitizen) { this.SeniorCitizen = seniorCitizen; }

    public Integer getPartner() { return Partner; }
    public void setPartner(Integer partner) { this.Partner = partner; }

    public Integer getDependents() { return Dependents; }
    public void setDependents(Integer dependents) { this.Dependents = dependents; }

    public Integer getTenure() { return tenure; }
    public void setTenure(Integer tenure) { this.tenure = tenure; }

    public Integer getPhoneService() { return PhoneService; }
    public void setPhoneService(Integer phoneService) { this.PhoneService = phoneService; }

    public Integer getPaperlessBilling() { return PaperlessBilling; }
    public void setPaperlessBilling(Integer paperlessBilling) { this.PaperlessBilling = paperlessBilling; }

    public Double getMonthlyCharges() { return MonthlyCharges; }
    public void setMonthlyCharges(Double monthlyCharges) { this.MonthlyCharges = monthlyCharges; }

    public Double getTotalCharges() { return TotalCharges; }
    public void setTotalCharges(Double totalCharges) { this.TotalCharges = totalCharges; }

    public Integer getContractOneYear() { return contractOneYear; }
    public void setContractOneYear(Integer contractOneYear) { this.contractOneYear = contractOneYear; }

    public Integer getContractTwoYear() { return contractTwoYear; }
    public void setContractTwoYear(Integer contractTwoYear) { this.contractTwoYear = contractTwoYear; }

    public Integer getInternetServiceFiberOptic() { return internetServiceFiberOptic; }
    public void setInternetServiceFiberOptic(Integer internetServiceFiberOptic) { this.internetServiceFiberOptic = internetServiceFiberOptic; }

    public Integer getInternetService_No() { return InternetService_No; }
    public void setInternetService_No(Integer internetService_No) { this.InternetService_No = internetService_No; }

    public Integer getPaymentMethodCreditCard() { return paymentMethodCreditCard; }
    public void setPaymentMethodCreditCard(Integer paymentMethodCreditCard) { this.paymentMethodCreditCard = paymentMethodCreditCard; }

    public Integer getPaymentMethodElectronicCheck() { return paymentMethodElectronicCheck; }
    public void setPaymentMethodElectronicCheck(Integer paymentMethodElectronicCheck) { this.paymentMethodElectronicCheck = paymentMethodElectronicCheck; }

    public Integer getPaymentMethodMailedCheck() { return paymentMethodMailedCheck; }
    public void setPaymentMethodMailedCheck(Integer paymentMethodMailedCheck) { this.paymentMethodMailedCheck = paymentMethodMailedCheck; }

    public Integer getMultipleLinesNoPhoneService() { return multipleLinesNoPhoneService; }
    public void setMultipleLinesNoPhoneService(Integer multipleLinesNoPhoneService) { this.multipleLinesNoPhoneService = multipleLinesNoPhoneService; }

    public Integer getMultipleLines_Yes() { return MultipleLines_Yes; }
    public void setMultipleLines_Yes(Integer multipleLines_Yes) { this.MultipleLines_Yes = multipleLines_Yes; }

    public Integer getOnlineSecurityNoInternetService() { return onlineSecurityNoInternetService; }
    public void setOnlineSecurityNoInternetService(Integer onlineSecurityNoInternetService) { this.onlineSecurityNoInternetService = onlineSecurityNoInternetService; }

    public Integer getOnlineSecurity_Yes() { return OnlineSecurity_Yes; }
    public void setOnlineSecurity_Yes(Integer onlineSecurity_Yes) { this.OnlineSecurity_Yes = onlineSecurity_Yes; }

    public Integer getOnlineBackupNoInternetService() { return onlineBackupNoInternetService; }
    public void setOnlineBackupNoInternetService(Integer onlineBackupNoInternetService) { this.onlineBackupNoInternetService = onlineBackupNoInternetService; }

    public Integer getOnlineBackup_Yes() { return OnlineBackup_Yes; }
    public void setOnlineBackup_Yes(Integer onlineBackup_Yes) { this.OnlineBackup_Yes = onlineBackup_Yes; }

    public Integer getDeviceProtectionNoInternetService() { return deviceProtectionNoInternetService; }
    public void setDeviceProtectionNoInternetService(Integer deviceProtectionNoInternetService) { this.deviceProtectionNoInternetService = deviceProtectionNoInternetService; }

    public Integer getDeviceProtection_Yes() { return DeviceProtection_Yes; }
    public void setDeviceProtection_Yes(Integer deviceProtection_Yes) { this.DeviceProtection_Yes = deviceProtection_Yes; }

    public Integer getTechSupportNoInternetService() { return techSupportNoInternetService; }
    public void setTechSupportNoInternetService(Integer techSupportNoInternetService) { this.techSupportNoInternetService = techSupportNoInternetService; }

    public Integer getTechSupport_Yes() { return TechSupport_Yes; }
    public void setTechSupport_Yes(Integer techSupport_Yes) { this.TechSupport_Yes = techSupport_Yes; }

    public Integer getStreamingTVNoInternetService() { return streamingTVNoInternetService; }
    public void setStreamingTVNoInternetService(Integer streamingTVNoInternetService) { this.streamingTVNoInternetService = streamingTVNoInternetService; }

    public Integer getStreamingTV_Yes() { return StreamingTV_Yes; }
    public void setStreamingTV_Yes(Integer streamingTV_Yes) { this.StreamingTV_Yes = streamingTV_Yes; }

    public Integer getStreamingMoviesNoInternetService() { return streamingMoviesNoInternetService; }
    public void setStreamingMoviesNoInternetService(Integer streamingMoviesNoInternetService) { this.streamingMoviesNoInternetService = streamingMoviesNoInternetService; }

    public Integer getStreamingMovies_Yes() { return StreamingMovies_Yes; }
    public void setStreamingMovies_Yes(Integer streamingMovies_Yes) { this.StreamingMovies_Yes = streamingMovies_Yes; }
}
