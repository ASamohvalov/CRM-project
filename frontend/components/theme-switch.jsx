import clsx from "clsx";
import { useEffect, useState } from "react";

export function Theme({ className }) {
  const [theme, setTheme] = useState("light");
  function lightDark() {
    if (localStorage.theme === "dark") {
      setTheme(() => "light");
      localStorage.theme = "light";
    } else {
      setTheme(() => "dark");
      localStorage.theme = "dark";
    }
  }
  useEffect(() => {
    setTheme(localStorage.theme);
  }, []);

  useEffect(() => {
    if (localStorage.theme === "dark") {
      document.documentElement.classList.add("dark");
    } else {
      document.documentElement.classList.remove("dark");
    }
  }, [theme]);
  return (
    <div
      className={
        clsx("dark:bg-dark-milk bg-dark-chocolate h-10 w-10 rounded-full", className)
      }
      onClick={() => {
        lightDark();
      }}
    ></div>
  );
}
