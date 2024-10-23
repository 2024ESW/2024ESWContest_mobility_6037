import Image from "next/image";
import style from "./style";

export default function Home() {
  return (
    <style.Container>
      <Image src="/ic-192x192.png" width={192} height={192} />
      <h1>Monami153 CarPay</h1>
      <p>새로운 차량 결제 패러다임, 우결</p>
    </style.Container>
  );
}
