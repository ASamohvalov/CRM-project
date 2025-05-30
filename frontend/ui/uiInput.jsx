//import { useState } from "react";
//! Добавить функцию просмотра пароля
export function UiInput({
  className,
  value,
  onChange,
  variant = "milk",
  placeholder,
  type = "text",
  children,
}) {
  //const visible = useState(false)

  return (
    <input
      type={type}
      value={value}
      onChange={onChange}
      className={`bg-milk text-waffle mb-6 md:mb-16 outline-0 rounded-lg h-10 text-sm md:text-lg px-4 ${className} bg-${variant}`}
      placeholder={placeholder}
    >
      {children}
    </input>
  );
}
