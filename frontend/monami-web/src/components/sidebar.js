import {useState} from 'react';
import {useRouter} from 'next/router';
import Link from 'next/link';
import Image from 'next/image';
import styles from '@/styles/sidebar.module.css'; // Sidebar에 대한 CSS 추가

const Sidebar = () => {
  const router = useRouter(); // useRouter 훅을 사용하여 현재 라우트 가져오기
  const [logoLoading, setLogoLoading] = useState(true);
  const [logoError, setLogoError] = useState(false);

  // 활성화 여부에 따라 아이콘 경로를 설정하는 함수
  const getIcon = (route, iconName) => {
    return router.pathname === route ? `/icons/${iconName}Fill.svg` : `/icons/${iconName}.svg`;
  };

  return (
    <div className={styles.sidebar}>
      {/* 로고 영역 */}
      <div className={styles.logoContainer}>
        {logoLoading && !logoError && (
          <div className={styles.skeletonLogo}></div> // 스켈레톤 로고
        )}
        {logoError && <div className={styles.errorFallback}>로고 로딩 실패</div>} {/* 로딩 실패 시 대체 레이아웃 */}
        {!logoLoading && !logoError && (
          <Image
            src="/logo.png"
            alt="logo"
            width={40}
            height={40}
            onLoadingComplete={() => setLogoLoading(false)}
            onError={() => {
              setLogoLoading(false);
              setLogoError(true);
            }}
            className={styles.logo}
          />
        )}
      </div>

      {/* 메뉴 영역 */}
      <nav className={styles.nav}>
        <ul className={styles.menu}>
          <li className={router.pathname === '/history' ? styles.active : ''}>
            <Link href="/history">
              <Image src={getIcon('/history', 'history')} alt="history" width={40} height={40} />
            </Link>
          </li>
          <li className={router.pathname === '/card' ? styles.active : ''}>
            <Link href="/card">
              <Image src={getIcon('/card', 'card')} alt="card" width={40} height={40} />
            </Link>
          </li>
          <li className={router.pathname === '/' ? styles.active : ''}>
            <Link href="/">
              <Image src={getIcon('/', 'home')} alt="home" width={40} height={40} />
            </Link>
          </li>
          <li className={router.pathname === '/me' ? styles.active : ''}>
            <Link href="/me">
              <Image src={getIcon('/me', 'user')} alt="me" width={40} height={40} />
            </Link>
          </li>
          <li className={router.pathname === '/map' ? styles.active : ''}>
            <Link href="/map">
              <Image src={getIcon('/map', 'map')} alt="map" width={40} height={40} />
            </Link>
          </li>
          <li className={router.pathname === '/setting' ? styles.active : ''}>
            <Link href="/setting">
              <Image src={getIcon('/setting', 'setting')} alt="setting" width={40} height={40} />
            </Link>
          </li>
        </ul>
      </nav>
    </div>
  );
};

export default Sidebar;
