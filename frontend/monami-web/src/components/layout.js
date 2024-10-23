import Header from './header';
import Sidebar from './sidebar';
import styles from '@/styles/layout.module.css'; // 분리된 CSS 파일 임포트

const Layout = ({children}) => {
  return (
    <div className={styles.layoutContainer}>
      <Sidebar />
      <div className={styles.content}>
        <Header />
        <main className={styles.mainContent}>{children}</main>
      </div>
    </div>
  );
};

export default Layout;
