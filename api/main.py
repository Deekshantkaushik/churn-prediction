from fastapi import FastAPI , HTTPException
from pydantic import BaseModel, Field
import joblib
import pandas as pd
import logging

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger("churn_api")

app = FastAPI(title="Churn Prediction API")

# Load the model package once, when the server starts
model_package = joblib.load("final_churn_model.pkl")
model = model_package["model"]
scaler = model_package["scaler"]
threshold = model_package["threshold"]
@app.get("/")
def root():
    return {"message": "Churn Prediction API is running. Visit /docs to test the /predict endpoint."}
@app.get("/health")
def health_check():
    return {"status": "ok", "model_loaded": model is not None}
class CustomerData(BaseModel):
    gender: int
    SeniorCitizen: int
    Partner: int
    Dependents: int
    tenure: int
    PhoneService: int
    PaperlessBilling: int
    MonthlyCharges: float
    TotalCharges: float
    Contract_One_year: int = Field(alias="Contract_One year")
    Contract_Two_year: int = Field(alias="Contract_Two year")
    InternetService_Fiber_optic: int = Field(alias="InternetService_Fiber optic")
    InternetService_No: int
    PaymentMethod_Credit_card: int = Field(alias="PaymentMethod_Credit card (automatic)")
    PaymentMethod_Electronic_check: int = Field(alias="PaymentMethod_Electronic check")
    PaymentMethod_Mailed_check: int = Field(alias="PaymentMethod_Mailed check")
    MultipleLines_No_phone_service: int = Field(alias="MultipleLines_No phone service")
    MultipleLines_Yes: int
    OnlineSecurity_No_internet_service: int = Field(alias="OnlineSecurity_No internet service")
    OnlineSecurity_Yes: int
    OnlineBackup_No_internet_service: int = Field(alias="OnlineBackup_No internet service")
    OnlineBackup_Yes: int
    DeviceProtection_No_internet_service: int = Field(alias="DeviceProtection_No internet service")
    DeviceProtection_Yes: int
    TechSupport_No_internet_service: int = Field(alias="TechSupport_No internet service")
    TechSupport_Yes: int
    StreamingTV_No_internet_service: int = Field(alias="StreamingTV_No internet service")
    StreamingTV_Yes: int
    StreamingMovies_No_internet_service: int = Field(alias="StreamingMovies_No internet service")
    StreamingMovies_Yes: int

    class Config:
        populate_by_name = True
@app.post("/predict")
def predict(customer: CustomerData):
    try:
        
        # Convert to dict using the ORIGINAL column names (aliases), not the Python-safe names
        input_dict = customer.dict(by_alias=True)
        
        # Convert into a single-row DataFrame
        input_df = pd.DataFrame([input_dict])
    
        # Scale the input (Logistic Regression needs scaled data)
        input_scaled = scaler.transform(input_df)
    
        # Get churn probability
        probability = model.predict_proba(input_scaled)[0][1]
    
        # Apply our chosen threshold (0.3) from Day 6
        prediction = "Churn" if probability >= threshold else "No Churn"
    
        # Risk tier bucketing
        if probability >= 0.7:
            risk_tier = "High"
        elif probability >= 0.4:
            risk_tier = "Medium"
        else:
            risk_tier = "Low"
        logger.info(f"Prediction made: probability={probability:.4f}, risk_tier={risk_tier}")
        return {
           "churn_probability": round(float(probability), 4),
           "prediction": prediction,
          "risk_tier": risk_tier
        }
    except Exception as e:
         logger.error(f"Prediction failed: {str(e)}")
         raise HTTPException(status_code=500, detail=f"Prediction failed: {str(e)}")

