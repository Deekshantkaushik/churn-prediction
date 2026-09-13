import { useState, useEffect } from 'react';
import { fetchCustomers } from './api';
import { Link } from 'react-router-dom';

function CustomerTable() {
    const [customers, setCustomers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState('');
    const [contractFilter, setContractFilter] = useState('');
    const [page, setPage] = useState(0);
    const [totalPages, setTotalPages] = useState(0);

    useEffect(() => {
        loadCustomers();
    }, [page, contractFilter]);

    const loadCustomers = async () => {
        setLoading(true);
        setError('');
        try {
            const response = await fetchCustomers(page, 10, contractFilter);
            setCustomers(response.data.content);
            setTotalPages(response.data.totalPages);
        } catch (err) {
            setError('Failed to load customers. Please try again.');
        } finally {
            setLoading(false);
        }
    };

    if (loading) return <p>Loading customers...</p>;
    if (error) return <p style={{ color: 'red' }}>{error}</p>;

    return (
        <div>
            <div>
                <label>Filter by contract: </label>
                <select
                    value={contractFilter}
                    onChange={(e) => { setContractFilter(e.target.value); setPage(0); }}
                >
                    <option value="">All</option>
                    <option value="Month-to-month">Month-to-month</option>
                    <option value="One year">One year</option>
                    <option value="Two year">Two year</option>
                </select>
            </div>

            <table border="1" cellPadding="8" style={{ marginTop: '1rem', width: '100%' }}>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Contract</th>
                        <th>Tenure (months)</th>
                        <th>Monthly Charges</th>
                        <th>Internet Service</th>
                    </tr>
                </thead>
                <tbody>
                    {customers.map(customer => (
                        <tr key={customer.customerId}>
                            <td>{customer.customerId}</td>
                            <td>{customer.name}</td>
                            <td>{customer.contractType}</td>
                            <td>{customer.tenureMonths}</td>
                            <td>{customer.monthlyCharges}</td>
                            <td>{customer.internetService}</td>
                            <td><Link to={`/customers/${customer.customerId}`}>{customer.customerId}</Link></td>
                        </tr>
                    ))}
                </tbody>
            </table>

            <div style={{ marginTop: '1rem' }}>
                <button disabled={page === 0} onClick={() => setPage(page - 1)}>Previous</button>
                <span style={{ margin: '0 1rem' }}>Page {page + 1} of {totalPages}</span>
                <button disabled={page + 1 >= totalPages} onClick={() => setPage(page + 1)}>Next</button>
            </div>
        </div>
    );
}

export default CustomerTable;