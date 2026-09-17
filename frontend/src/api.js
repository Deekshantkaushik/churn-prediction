import axios from 'axios';

const API_BASE_URL = 'https://churn-prediction-1-pueb.onrender.com';

export function getAuthHeaders() {
    const token = localStorage.getItem('token');
    return { headers: { Authorization: `Bearer ${token}` } };
}

export function fetchCustomers(page = 0, size = 10, contractType = '') {
    let url = `${API_BASE_URL}/customers/search?page=${page}&size=${size}`;
    if (contractType) {
        url += `&contractType=${contractType}`;
    }
    return axios.get(url, getAuthHeaders());
}