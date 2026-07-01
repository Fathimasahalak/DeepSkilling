import React, { useState } from 'react';
import axios from 'axios';

function Register({ setPage }) {
  const [form, setForm] = useState({ username: '', email: '', password: '' });
  const [msg, setMsg] = useState('');

  const handleRegister = async () => {
    try {
      const res = await axios.post('http://localhost:8080/auth/register', form);
      setMsg(res.data);
      if (res.data === 'User registered successfully!') setTimeout(() => setPage('login'), 1500);
    } catch {
      setMsg('Registration failed!');
    }
  };

  return (
    <div style={styles.container}>
      <div style={styles.box}>
        <h2 style={styles.title}>Create Account</h2>
        <input style={styles.input} placeholder="Username"
          onChange={e => setForm({ ...form, username: e.target.value })} />
        <input style={styles.input} placeholder="Email"
          onChange={e => setForm({ ...form, email: e.target.value })} />
        <input style={styles.input} placeholder="Password" type="password"
          onChange={e => setForm({ ...form, password: e.target.value })} />
        {msg && <p style={{ textAlign:'center', color: msg.includes('success') ? 'green' : 'red' }}>{msg}</p>}
        <button style={styles.btn} onClick={handleRegister}>Register</button>
        <p style={styles.link}>Already have an account? <span onClick={() => setPage('login')}
          style={styles.span}>Login</span></p>
      </div>
    </div>
  );
}

const styles = {
  container: { display:'flex', justifyContent:'center', alignItems:'center', height:'100vh', background:'#f0f2f5' },
  box: { background:'white', padding:'40px', borderRadius:'10px', width:'350px', boxShadow:'0 2px 10px rgba(0,0,0,0.1)', display:'flex', flexDirection:'column', gap:'12px' },
  title: { textAlign:'center', color:'#1877f2', fontSize:'24px', margin:'0 0 10px' },
  input: { padding:'12px', borderRadius:'6px', border:'1px solid #ddd', fontSize:'16px' },
  btn: { padding:'12px', background:'#1877f2', color:'white', border:'none', borderRadius:'6px', fontSize:'16px', cursor:'pointer' },
  link: { textAlign:'center', margin:0 },
  span: { color:'#1877f2', cursor:'pointer', fontWeight:'bold' }
};

export default Register;