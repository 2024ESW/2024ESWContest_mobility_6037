import Head from 'next/head';
import Layout from '../components/layout';
import '@/styles/globals.css';

export default function App({Component, pageProps}) {
  return (
    <>
      <Head>
        <title>Monami Pay - 메인 페이지</title>
        <meta name="description" content="Monami Pay로 결제하고, 가맹점을 찾아보세요!" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <Layout>
        <Component {...pageProps} />
      </Layout>
    </>
  );
}
