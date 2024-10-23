import styles from '@/styles/index.module.css';
import Card from '@/components/card';

export default function Home() {
  return (
    <div className={styles.container}>
      <div className={styles.grid}>
        {/* 첫 번째 버튼 - 결제하기 */}
        <Card
          href="/card"
          src="/images/payment.png" // 실제 결제 관련 이미지 경로
          alt="결제하기"
          title="결제하기"
        />

        {/* 두 번째 버튼 - 내 정보 */}
        <Card
          href="/me"
          src="/images/me.png" // 실제 내 정보 관련 이미지 경로
          alt="내 정보"
          title="내 정보"
        />

        {/* 세 번째 버튼 - 가맹점 찾아보기 */}
        <Card
          href="/map"
          src="/images/store.png" // 실제 가맹점 관련 이미지 경로
          alt="가맹점 찾아보기"
          title="가맹점 찾아보기"
        />

        {/* 네 번째 버튼 - 카드 관리 */}
        <Card
          href="/card"
          src="/images/card.png" // 실제 카드 관리 관련 이미지 경로
          alt="카드 관리"
          title="카드 관리"
        />
      </div>
    </div>
  );
}
