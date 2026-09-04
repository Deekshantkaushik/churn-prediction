# API Testing Notes

## Test 1: High-risk customer profile
**Input:** tenure=2, month-to-month contract, Fiber optic internet, Electronic check payment, MonthlyCharges=90

**Result:**
```json
{
  "churn_probability": 0.923,
  "prediction": "Churn",
  "risk_tier": "High"
}
```

**Interpretation:** Matches expectations from Day 2 EDA and Day 5 feature importance —
month-to-month + fiber optic + low tenure is the strongest churn-risk pattern in the data.

## Test 2: low-risk customer profile
**Input:** tenure=60, two-year contract, no internet service, auto-pay via credit card

**Result:**
```json
{
  "churn_probability": 0.0054,
  "prediction": "No Churn",
  "risk_tier": "Low"
}
```



## Health check
```json
{"status": "ok", "model_loaded": true}
```
Confirms API and model are running correctly.