import "../styles/globals.css";
import "../styles/styles.css";

export default function App({ Component, pageProps }) {
  return (
    <div className={"text-slate-900"}>
      <Component {...pageProps} />
      <div id="modals"></div>
    </div>
  );
}