import { useEffect } from "react";
import "../styles/globals.css";
import "../styles/styles.css";

export default function Layout({ Component, pageProps }) {
  useEffect(() => {
    setInterval(async () => {
      try{
        const req = await fetch("http://localhost:8080/api/auth/update_tokens", {
        method: "POST",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
        },
        body: JSON.stringify({
          refreshToken: localStorage.getItem("refreshToken"),
        }),
      });
      if (req.ok) {
        const res = await req.json();
        localStorage.setItem("accessToken", res.accessToken);
        localStorage.setItem("refreshToken", res.refreshToken);
        document.cookie = `accessToken = ${res.accessToken}`;
        console.log("success");
      }else{
        throw new Error();
      }
      }catch(e){
        console.log(e.message);
      }
    }, 60000);
  }, []);

  return (
    <div className={"text-slate-900 bg-[#F3E9DC] dark:bg-coffee min-h-[100vh]"}>
      <Component {...pageProps} />
    </div>
  );
}
