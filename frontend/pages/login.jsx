import { useEffect, useState } from "react";
import { UiInput } from "../ui/uiInput";
import { UiButton } from "../ui/uiButton";
import { useRouter } from "next/router";
import * as env from "../env";

function LoginPage() {
  const [formInput, setFormInput] = useState({ login: "", password: "" });
  const [errMessage, setErrMessage] = useState(false);
  const router = useRouter();

  useEffect(() => {
    document.title = "Авторизация";
  }, []);

  async function formHandler(e) {
    e.preventDefault();
    try {
      const responce = await fetch(env.BACKEND_API_URL + "/auth/sign_in", {
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
        router.push("/");
      } else {
        setErrMessage(true);
      }
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <div className="w-[100vw] h-[100vh] flex justify-center items-center">
      <div className="w-fit h-fit md:w-[30rem] md:h-[40rem] 2xl:w-[28vw] 2xl:h-[70vh] bg-waffle rounded-3xl px-4 md:px-7 py-4 md:py-7">
        <form
          onSubmit={formHandler}
          className="bg-coffee w-[100%] h-[100%] rounded-2xl text-milk flex flex-col py-12 md:pt-16 px-10 md:px-14"
        >
          <h1 className="text-xl md:text-4xl mx-auto mb-8 md:mb-16">
            Авторизация
          </h1>
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

          <UiButton
            onClick={() => console.log("efef")}
            type="submit"
            className={`
            } bg-waffle py-2 md:py-3 px-2 md:px-4 mb-5 rounded-lg md:rounded-2xl text-xl md:text-3xl mx-auto w-[100%] max-w-64`}
          >
            Войти
          </UiButton>
          {errMessage ? (
            <p className="text-red-400 text-center text-sm md:text-lg">
              Логин или пароль неверны <br />
              <span className="text-[10px] md:text-sm">
                (или наш сервер лег)
              </span>
            </p>
          ) : (
            ""
          )}
        </form>
      </div>
    </div>
  );
}

export default LoginPage;
