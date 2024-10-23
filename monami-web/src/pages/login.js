import {useState} from 'react';
import styles from '@/styles/login.module.css';
import Link from 'next/link';

export default function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = e => {
    e.preventDefault();
    // TODO: 로그인 API 호출
    console.log('로그인 정보:', email, password);
  };

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>로그인</h1>
      <form onSubmit={handleLogin} className={styles.form}>
        <div className={styles.group}>
          <label htmlFor="email">이메일</label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={e => setEmail(e.target.value)}
            required
            className={styles.input}
          />
        </div>
        <div className={styles.group}>
          <label htmlFor="password">비밀번호</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={e => setPassword(e.target.value)}
            required
            className={styles.input}
          />
        </div>
        <button type="submit" className={styles.button}>
          로그인
        </button>
      </form>
      <p className={styles.switch}>
        아직 계정이 없으신가요? <Link href="/join">회원가입</Link>
      </p>
    </div>
  );
}
