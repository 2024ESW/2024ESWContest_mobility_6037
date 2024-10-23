import {useState} from 'react';
import Image from 'next/image';
import styles from '@/styles/card.module.css';

export default function Card({href, src, alt, title}) {
  const [error, setError] = useState(false);

  return (
    <div className={styles.card}>
      <a href={href} className={styles.link}>
        {error ? (
          <div className={styles.errorPlaceholder}>
            <p>이미지를 불러올 수 없습니다.</p>
          </div>
        ) : (
          <Image src={src} alt={alt} width={864} height={480} className={styles.image} onError={() => setError(true)} />
        )}
        <h2 className={styles.title}>{title}</h2>
      </a>
    </div>
  );
}
