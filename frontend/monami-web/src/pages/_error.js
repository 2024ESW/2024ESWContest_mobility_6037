import Link from 'next/link';
import styles from '@/styles/error.module.css';

export default function Error({statusCode}) {
  console.log(`[${statusCode}] 에러 발생`);

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>{'존재하지 않는 페이지입니다.'}</h1>
      <p className={styles.message}>{'홈으로 돌아가기 버튼을 통해 다시 이용해주세요.'}</p>
      <Link href="/" className={styles.link}>
        홈으로 돌아가기
      </Link>
    </div>
  );
}

Error.getInitialProps = ({res, err}) => {
  const statusCode = res ? res.statusCode : err ? err.statusCode : 404;
  return {statusCode};
};
