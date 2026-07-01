import React, { useState } from 'react';
import Login from './pages/Login';
import Register from './pages/Register';
import Home from './pages/Home';

function App() {
  const [page, setPage] = useState('login');
  const [token, setToken] = useState(localStorage.getItem('token'));

  if (token) return <Home token={token} setToken={setToken} />;
  if (page === 'login') return <Login setToken={setToken} setPage={setPage} />;
  return <Register setPage={setPage} />;
}

export default App;