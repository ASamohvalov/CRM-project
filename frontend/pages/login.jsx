import { useEffect } from "react";

function LoginPage() {
  useEffect(()=>{
		document.title = "Логин"
	},[])
  return ( 
    <>
      Прив чувак!
    </>
   );
}

export default LoginPage;