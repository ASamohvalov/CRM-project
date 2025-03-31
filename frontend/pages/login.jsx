import { useEffect } from "react";
import { UiInput } from "../components/ui/uiInput";
import { UiButton } from "../components/ui/uiButton";

function LoginPage() {
  useEffect(()=>{
		document.title = "Авторизация"
	},[])

  function formHandler(e) {
    e.preventDefault();


  }

  return ( 
    <div className="w-[100vw] h-[100vh] flex justify-center items-center">
      <div className="w-80 h-[60vh] md:w-[30rem] md:h-[40rem] 2xl:w-[28vw] 2xl:h-[70vh] bg-waffle rounded-3xl px-7 py-7">
        <form onSubmit={formHandler} className="bg-coffee w-[100%] h-[100%] rounded-2xl text-milk flex flex-col pt-16 px-14">
          <h1 className="text-4xl mx-auto mb-16">Авторизация</h1>
          <UiInput placeholder={"Логин"} required className=""></UiInput>
          <UiInput placeholder={"Пароль"} required className=""></UiInput>
          <UiButton className="bg-waffle mt-16 py-3 px-4 rounded-2xl text-3xl mx-auto w-[100%] max-w-64">Войти</UiButton>
        </form>
      </div>
    </div>
   );
}

export default LoginPage;