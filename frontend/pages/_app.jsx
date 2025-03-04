import "../styles/globals.css";
import "../styles/styles.css";

export default function App({ Component, pageProps }) {
  return (
    <div className={"text-slate-900 bg-[#F3E9DC] dark:bg-coffee min-h-[100vh]"}>
      <Component {...pageProps} />
      <div id="modals"></div>
    </div>
  );
}