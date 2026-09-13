import { useState } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from './login';
import CustomerTable from './CustomerTable';
import RiskChart from './RiskChart';
import CustomerDetail from './CustomerDetail';
function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem('token'));

  if (!isLoggedIn) {
    return <Login onLoginSuccess={() => setIsLoggedIn(true)} />;
  }

  return (
     <BrowserRouter>
            <div style={{ padding: '2rem' }}>
                <h1>Churn Dashboard</h1>
                <button onClick={() => { localStorage.removeItem('token'); setIsLoggedIn(false); }}>
                    Log Out
                </button>
                <Routes>
                    <Route path="/" element={
                        <>
                            <RiskChart />
                            <CustomerTable />
                        </>
                    } />
                    <Route path="/customers/:id" element={<CustomerDetail />} />
                </Routes>
            </div>
        </BrowserRouter>
  );
}

export default App;
