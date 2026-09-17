import { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import axios from 'axios';
import { getAuthHeaders } from './api';


function CustomerDetail() {
    const { id } = useParams();
    const [customer, setCustomer] = useState(null);
    const [actions, setActions] = useState([]);
    const [loading, setLoading] = useState(true);
    const [score, setScore] = useState(null);

    useEffect(() => {
        Promise.all([
            axios.get(`https://churn-prediction-1-pueb.onrender.com/customers/${id}`, getAuthHeaders()),
axios.get(`https://churn-prediction-1-pueb.onrender.com/retention-actions/customer/${id}`, getAuthHeaders()),
axios.get(`https://churn-prediction-1-pueb.onrender.com/churn-scores/latest/${id}`, getAuthHeaders())
        ]).then(([customerRes, actionsRes , scoreRes]) => {
            setCustomer(customerRes.data);
            setActions(actionsRes.data);
            setScore(scoreRes.data);
            setLoading(false);
        }).catch(err => {
            console.error('Failed to load customer details', err);
            setLoading(false);
        });
    }, [id]);

    if (loading) return <p>Loading...</p>;
    if (!customer) return <p>Customer not found.</p>;

    return (
        <div>
            <Link to="/">&larr; Back to dashboard</Link>
            <h2>{customer.name}</h2>
            {score ? (
    <div style={{
        padding: '1rem',
        marginBottom: '1rem',
        backgroundColor: score.riskTier === 'High' ? '#ffe6e6' : score.riskTier === 'Medium' ? '#fff8e6' : '#e6ffe6',
        borderRadius: '8px'
    }}>
        <strong>Churn Risk: {score.riskTier}</strong>
        <p>Probability: {(score.churnProbability * 100).toFixed(1)}%</p>
        <p>Last scored: {new Date(score.scoredAt).toLocaleString()}</p>
    </div>
) : (
    <p>No churn score available for this customer yet.</p>
)}
<p>Email: {customer.email}</p>
<p>Gender: {customer.gender}</p>
<p>Senior Citizen: {customer.seniorCitizen ? 'Yes' : 'No'}</p>
<p>Partner: {customer.partner ? 'Yes' : 'No'}</p>
<p>Dependents: {customer.dependents ? 'Yes' : 'No'}</p>
<p>Contract: {customer.contractType}</p>
<p>Tenure: {customer.tenureMonths} months</p>
<p>Phone Service: {customer.phoneService ? 'Yes' : 'No'}</p>
<p>Multiple Lines: {customer.multipleLines}</p>
<p>Internet Service: {customer.internetService}</p>
<p>Online Security: {customer.onlineSecurity}</p>
<p>Online Backup: {customer.onlineBackup}</p>
<p>Device Protection: {customer.deviceProtection}</p>
<p>Tech Support: {customer.techSupport}</p>
<p>Streaming TV: {customer.streamingTv}</p>
<p>Streaming Movies: {customer.streamingMovies}</p>
<p>Paperless Billing: {customer.paperlessBilling ? 'Yes' : 'No'}</p>
<p>Payment Method: {customer.paymentMethod}</p>
<p>Monthly Charges: ${customer.monthlyCharges}</p>
<p>Total Charges: ${customer.totalCharges}</p>

            <h3>Retention Actions</h3>
            {actions.length === 0 ? (
                <p>No retention actions logged for this customer yet.</p>
            ) : (
                <ul>
                    {actions.map(action => (
                        <li key={action.actionId}>
                            <strong>{action.actionType}</strong> — {action.notes} ({new Date(action.createdAt).toLocaleString()})
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
}

export default CustomerDetail;