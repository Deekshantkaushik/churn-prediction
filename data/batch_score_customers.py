import requests
import mysql.connector

conn = mysql.connector.connect(
    host="localhost",
    user="root",
    password="Deekshant@86",
    database="churn_db"
)
cursor = conn.cursor(dictionary=True)
cursor.execute("""
    SELECT customer_id, gender, contract_type, tenure_months, 
           monthly_charges, total_charges, internet_service, payment_method,
           senior_citizen, partner, dependents, phone_service, paperless_billing,
           multiple_lines, online_security, online_backup, device_protection,
           tech_support, streaming_tv, streaming_movies
    FROM customers
""")
customers = cursor.fetchall()
cursor.close()
conn.close()

login_response = requests.post("http://localhost:8080/auth/login", json={
    "username": "admin2",
    "password": "test123"
})
print("Login status code:", login_response.status_code)
print("Login response:", login_response.text)

token = login_response.json()["token"]
headers = {"Authorization": f"Bearer {token}"}

def build_payload(customer):
    return {
        "gender": 1 if customer["gender"] == "Male" else 0,
        "SeniorCitizen": 1 if customer["senior_citizen"] else 0,
        "Partner": 1 if customer["partner"] else 0,
        "Dependents": 1 if customer["dependents"] else 0,
        "tenure": customer["tenure_months"] or 0,
        "PhoneService": 1 if customer["phone_service"] else 0,
        "PaperlessBilling": 1 if customer["paperless_billing"] else 0,
        "MonthlyCharges": float(customer["monthly_charges"] or 0),
        "TotalCharges": float(customer["total_charges"] or 0),
        "Contract_One year": 1 if customer["contract_type"] == "One year" else 0,
        "Contract_Two year": 1 if customer["contract_type"] == "Two year" else 0,
        "InternetService_Fiber optic": 1 if customer["internet_service"] == "Fiber optic" else 0,
        "InternetService_No": 1 if customer["internet_service"] == "No" else 0,
        "PaymentMethod_Credit card (automatic)": 1 if customer["payment_method"] == "Credit card (automatic)" else 0,
        "PaymentMethod_Electronic check": 1 if customer["payment_method"] == "Electronic check" else 0,
        "PaymentMethod_Mailed check": 1 if customer["payment_method"] == "Mailed check" else 0,
        "MultipleLines_No phone service": 1 if customer["multiple_lines"] == "No phone service" else 0,
        "MultipleLines_Yes": 1 if customer["multiple_lines"] == "Yes" else 0,
        "OnlineSecurity_No internet service": 1 if customer["online_security"] == "No internet service" else 0,
        "OnlineSecurity_Yes": 1 if customer["online_security"] == "Yes" else 0,
        "OnlineBackup_No internet service": 1 if customer["online_backup"] == "No internet service" else 0,
        "OnlineBackup_Yes": 1 if customer["online_backup"] == "Yes" else 0,
        "DeviceProtection_No internet service": 1 if customer["device_protection"] == "No internet service" else 0,
        "DeviceProtection_Yes": 1 if customer["device_protection"] == "Yes" else 0,
        "TechSupport_No internet service": 1 if customer["tech_support"] == "No internet service" else 0,
        "TechSupport_Yes": 1 if customer["tech_support"] == "Yes" else 0,
        "StreamingTV_No internet service": 1 if customer["streaming_tv"] == "No internet service" else 0,
        "StreamingTV_Yes": 1 if customer["streaming_tv"] == "Yes" else 0,
        "StreamingMovies_No internet service": 1 if customer["streaming_movies"] == "No internet service" else 0,
        "StreamingMovies_Yes": 1 if customer["streaming_movies"] == "Yes" else 0
    }

success_count = 0
failed_count = 0

for customer in customers[:500]:
    payload = build_payload(customer)
    print(f"\nAttempting customer {customer['customer_id']}...")
    try:
        response = requests.post(
            f"http://localhost:8080/churn-scores/{customer['customer_id']}",
            json=payload,
            headers=headers,
            timeout=10
        )
        print(f"  Status: {response.status_code}")
        print(f"  Response: {response.text[:300]}")
        if response.status_code == 200:
            success_count += 1
        else:
            failed_count += 1
    except Exception as e:
        print(f"  EXCEPTION: {type(e).__name__}: {e}")
        failed_count += 1

print(f"\nFinal: Scored {success_count} customers successfully. {failed_count} failed.")