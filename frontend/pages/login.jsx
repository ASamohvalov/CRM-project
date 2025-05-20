import { useEffect, useState } from "react";
import { UiInput } from "../components/ui/uiInput";
import { UiButton } from "../components/ui/uiButton";
import { useRouter } from 'next/router';

function LoginPage() {
  const [formInput, setFormInput] = useState({ login: "", password: "" });
  const [errMessage, setErrMessage] = useState(false);
  const router = useRouter()

  useEffect(() => {
    document.title = "Авторизация";
  }, []);

  async function formHandler(e) {
    e.preventDefault();
    try {
      const responce = await fetch("http://localhost:8080/api/auth/sign_in", {
        method: "POST",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
        },
        body: JSON.stringify(formInput),
      });
      if (responce.ok) {
        const jsonRes = await responce.json();
        localStorage.setItem("accessToken", jsonRes.accessToken);
        localStorage.setItem("refreshToken", jsonRes.refreshToken);
        document.cookie = `accessToken = ${jsonRes.accessToken}`;
        router.push('/');
      } else {
        setErrMessage(true);
      }
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <div className="w-[100vw] h-[100vh] flex justify-center items-center">
      <div className="w-80 h-[60vh] md:w-[30rem] md:h-[40rem] 2xl:w-[28vw] 2xl:h-[70vh] bg-waffle rounded-3xl px-7 py-7">
        <form
          onSubmit={formHandler}
          className="bg-coffee w-[100%] h-[100%] rounded-2xl text-milk flex flex-col pt-16 px-14"
        >
          <h1 className="text-4xl mx-auto mb-16">Авторизация</h1>
          <UiInput
            placeholder={"Логин"}
            required
            value={formInput.login}
            onChange={(e) =>
              setFormInput({ ...formInput, login: e.target.value })
            }
          ></UiInput>
          <UiInput
            placeholder={"Пароль"}
            required
            value={formInput.password}
            type={"password"}
            onChange={(e) =>
              setFormInput({ ...formInput, password: e.target.value })
            }
          ></UiInput>
          {errMessage ? (
            <p className="text-red-400 text-center">Логин или пароль неверны</p>
          ) : (
            ""
          )}
          <UiButton
            className={`${
              errMessage ? "mt-13" : "mt-16"
            } bg-waffle py-3 px-4 rounded-2xl text-3xl mx-auto w-[100%] max-w-64`}
          >
            Войти
          </UiButton>
        </form>
      </div>
    </div>
  );
}

export default LoginPage;
