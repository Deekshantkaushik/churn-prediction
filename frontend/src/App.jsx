import { useState } from 'react';
import Login from './login';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem('token'));

  if (!isLoggedIn) {
    return <Login onLoginSuccess={() => setIsLoggedIn(true)} />;
  }

  return (
    <div>
      <h1>Churn Dashboard</h1>
      <p>You are logged in!</p>
    </div>
  );
}

export default App;
