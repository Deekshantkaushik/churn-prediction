import { useState } from 'react';
import Login from './login';
import CustomerTable from './CustomerTable';
function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem('token'));

  if (!isLoggedIn) {
    return <Login onLoginSuccess={() => setIsLoggedIn(true)} />;
  }

  return (
    <div style={{ padding: '2rem' }}>
            <h1>Churn Dashboard</h1>
            <CustomerTable />
        </div>
  );
}

export default App;
