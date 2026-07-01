import React, { useState, useEffect } from 'react';

function Home({ token, setToken }) {
  const [posts, setPosts] = useState([]);
  const [content, setContent] = useState('');
  const [loading, setLoading] = useState(false);

  // Decode username from JWT token
  const getUsername = () => {
    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      return payload.sub;
    } catch {
      return 'Unknown';
    }
  };

  // Load all posts
  const fetchPosts = async () => {
    try {
      const res = await fetch('http://localhost:8080/posts', {
        headers: { Authorization: `Bearer ${token}` }
      });
      const data = await res.json();
      setPosts(data);
    } catch (err) {
      console.error('Failed to fetch posts:', err);
    }
  };

  useEffect(() => {
    fetchPosts();
  }, []);

  // Create a new post
  const handlePost = async () => {
    if (!content.trim()) return;
    setLoading(true);
    try {
      const res = await fetch('http://localhost:8080/posts', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          Authorization: `Bearer ${token}`
        },
        body: JSON.stringify({ content })
      });
      const newPost = await res.json();
      setPosts([newPost, ...posts]); // add to top of feed
      setContent('');
    } catch (err) {
      console.error('Failed to create post:', err);
    }
    setLoading(false);
  };

  const logout = () => {
    localStorage.removeItem('token');
    setToken(null);
  };

  const formatTime = (dateStr) => {
    if (!dateStr) return '';
    const date = new Date(dateStr);
    return date.toLocaleString();
  };

  return (
    <div style={styles.container}>
      {/* Navbar */}
      <div style={styles.navbar}>
        <h2 style={styles.logo}>Mathalam</h2>
        <div style={styles.navRight}>
          <span style={styles.welcomeText}>👤 {getUsername()}</span>
          <button style={styles.btn} onClick={logout}>Logout</button>
        </div>
      </div>

      <div style={styles.feedWrapper}>
        {/* Post creation box */}
        <div style={styles.card}>
          <textarea
            style={styles.textarea}
            placeholder="What's on your mind?"
            value={content}
            onChange={(e) => setContent(e.target.value)}
          />
          <div style={styles.postBtnRow}>
            <button
              style={{
                ...styles.btn,
                opacity: loading || !content.trim() ? 0.6 : 1
              }}
              onClick={handlePost}
              disabled={loading || !content.trim()}
            >
              {loading ? 'Posting...' : 'Post'}
            </button>
          </div>
        </div>

        {/* Feed */}
        {posts.length === 0 ? (
          <div style={styles.card}>
            <p style={{ color: '#666', textAlign: 'center' }}>
              No posts yet. Be the first! 🚀
            </p>
          </div>
        ) : (
          posts.map((post) => (
            <div key={post.id} style={styles.card}>
              <div style={styles.postHeader}>
                <span style={styles.postUsername}>@{post.username}</span>
                <span style={styles.postTime}>{formatTime(post.createdAt)}</span>
              </div>
              <p style={styles.postContent}>{post.content}</p>
            </div>
          ))
        )}
      </div>
    </div>
  );
}

const styles = {
  container: { minHeight: '100vh', background: '#f0f2f5' },
  navbar: {
    background: 'white', padding: '12px 24px',
    display: 'flex', justifyContent: 'space-between', alignItems: 'center',
    boxShadow: '0 2px 4px rgba(0,0,0,0.1)'
  },
  logo: { color: '#1877f2', margin: 0 },
  navRight: { display: 'flex', alignItems: 'center', gap: '16px' },
  welcomeText: { color: '#333', fontWeight: '500' },
  btn: {
    padding: '8px 16px', background: '#1877f2', color: 'white',
    border: 'none', borderRadius: '6px', cursor: 'pointer', fontWeight: '600'
  },
  feedWrapper: { maxWidth: '600px', margin: '24px auto', display: 'flex', flexDirection: 'column', gap: '16px' },
  card: {
    background: 'white', padding: '20px',
    borderRadius: '10px', boxShadow: '0 1px 3px rgba(0,0,0,0.1)'
  },
  textarea: {
    width: '100%', minHeight: '80px', border: '1px solid #ddd',
    borderRadius: '8px', padding: '12px', fontSize: '15px',
    resize: 'vertical', fontFamily: 'inherit', boxSizing: 'border-box'
  },
  postBtnRow: { display: 'flex', justifyContent: 'flex-end', marginTop: '10px' },
  postHeader: { display: 'flex', justifyContent: 'space-between', marginBottom: '10px' },
  postUsername: { fontWeight: '700', color: '#1877f2' },
  postTime: { fontSize: '12px', color: '#999' },
  postContent: { margin: 0, fontSize: '15px', lineHeight: '1.5', color: '#333' }
};

export default Home;