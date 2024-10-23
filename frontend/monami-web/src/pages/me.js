import Image from 'next/image';
import styles from '@/styles/me.module.css';

export default function Me() {
  return (
    <div className={styles.container}>
      <div className={styles.header}>
        <h1 className={styles.pageTitle}>내 정보</h1>
      </div>

      {/* 사용자 정보 */}
      <div className={styles.userInfo}>
        <Image
          src="/images/car.jpg" // 실제 차량 이미지 경로
          alt="차량 이미지"
          width={200}
          height={200}
          className={styles.profileImage}
        />
        <div className={styles.userDetails}>
          <h2>OOO님</h2>
          <p>99허 9999</p>
          <p>제네시스 GV 80</p>
          <p>멤버십 등급: 멜버른 그레이</p>
          <p>*2024년 10월 10일 Monami Pay 서비스 가입</p>
        </div>
        <button className={styles.editButton}>수정하기</button>
      </div>

      {/* 최근 결제 내역 및 소비 패턴 */}
      <div className={styles.recentHistory}>
        <div className={styles.sectionTitle}>최근 결제 내역</div>
        <div className={styles.sectionTitle}>소비 패턴</div>
      </div>

      <div className={styles.contentGrid}>
        <div className={styles.card}>
          <h3>결제 내역 리스트</h3>
          {/* 결제 내역 리스트 추가 */}
        </div>
        <div className={styles.card}>
          <h3>최근 결제 내역 기반 그래프</h3>
          {/* 소비 패턴 그래프 추가 */}
        </div>
      </div>
    </div>
  );
}
