import { useState, useEffect } from 'react';
import { BarChart, Bar, XAxis, YAxis, Tooltip, ResponsiveContainer } from 'recharts';
import axios from 'axios';
import { getAuthHeaders } from './api';

function RiskChart() {
    const [data, setData] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/customers/risk-summary', getAuthHeaders())
            .then(response => {
                const chartData = Object.entries(response.data).map(([tier, count]) => ({
                    tier,
                    count
                }));
                setData(chartData);
            })
            .catch(err => console.error('Failed to load risk summary', err));
    }, []);

    return (
        <div style={{ marginBottom: '2rem' }}>
            <h3>Customer Risk Distribution</h3>
            <ResponsiveContainer width="100%" height={250}>
                <BarChart data={data}>
                    <XAxis dataKey="tier" />
                    <YAxis />
                    <Tooltip />
                    <Bar dataKey="count" fill="#8884d8" />
                </BarChart>
            </ResponsiveContainer>
        </div>
    );
}

export default RiskChart;