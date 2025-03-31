import "../styles/globals.css";
import "../styles/styles.css";

export default function Layout({ Component, pageProps }) {
  return (
    <div className={"text-slate-900 bg-[#F3E9DC] dark:bg-coffee min-h-[100vh]"}>
      <Component {...pageProps} />
    </div>
  );
}