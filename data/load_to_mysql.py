import pandas as pd
import mysql.connector

# Load your cleaned Telco data
df = pd.read_csv('WA_Fn-UseC_-Telco-Customer-Churn.csv')

# Connect to MySQL
conn = mysql.connector.connect(
    host="localhost",
    user="root",
    password="Deekshant@86",
    database="churn_db"
)
cursor = conn.cursor()

insert_query = """
INSERT INTO customers 
(name, email, gender, contract_type, tenure_months, monthly_charges, total_charges, internet_service, payment_method, signup_date, is_active)
VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
"""

for i, row in df.iterrows():
    cursor.execute(insert_query, (
        f"Customer {row['customerID']}",           # name (placeholder, since Telco data has no real names)
        f"{row['customerID']}@example.com",          # email (placeholder)
        row['gender'],
        row['Contract'],
        int(row['tenure']),
        float(row['MonthlyCharges']),
        float(row['TotalCharges']) if str(row['TotalCharges']).strip() != '' else 0.0,
        row['InternetService'],
        row['PaymentMethod'],
        '2024-01-01',                                 # signup_date (placeholder, Telco data has no real date)
        True
    ))

conn.commit()
cursor.close()
conn.close()
print(f"Inserted {len(df)} customers successfully.")