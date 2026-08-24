CREATE DATABASE IF NOT EXISTS churn_db;
USE churn_db;

-- Table 1: customers
CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    gender VARCHAR(10),
    contract_type VARCHAR(20),      -- e.g. Month-to-month, One year, Two year
    tenure_months INT,              -- how long they've been a customer
    monthly_charges DECIMAL(10,2),
    total_charges DECIMAL(10,2),
    internet_service VARCHAR(20),
    payment_method VARCHAR(30),
    signup_date DATE,
    is_active BOOLEAN DEFAULT TRUE
);

-- Table 2: churn_scores
CREATE TABLE churn_scores (
    score_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    churn_probability DECIMAL(5,4),   -- e.g. 0.8734
    risk_tier VARCHAR(10),            -- Low / Medium / High
    scored_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Table 3: users (app login accounts)
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL,        -- 'admin' or 'retention'
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table 4: retention_actions
CREATE TABLE retention_actions (
    action_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    action_type VARCHAR(50),          -- e.g. 'contacted', 'offer_sent', 'resolved'
    notes TEXT,
    created_by INT,                   -- references users.user_id (who logged this action)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (created_by) REFERENCES users(user_id)
);
