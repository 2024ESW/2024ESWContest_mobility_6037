import styles from '@/styles/header.module.css';

const Header = () => {
  return (
    <header className={styles.header}>
      <h1 className={styles.title}>Monami Pay</h1>
      <div className={styles.links}>
        <a href="/join" className={styles.link}>
          회원가입
        </a>
        <a href="/login" className={styles.link}>
          로그인
        </a>
      </div>
    </header>
  );
};

export default Header;
