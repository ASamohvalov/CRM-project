//!Добавить сюда штуку с темой

import { Theme } from "./features/theme-switch";

export function Footer() {
  return (
    <footer className="absolute box-border bottom-0 flex justify-center items-center px-10 md:hidden bg-coffee dark:bg-chocolate h-14 w-[100vw] rounded-t-xl">
      <div className="relative">
        <h3 className="font-bold text-2xl text-[#F3E9DC]">MegaTiming</h3>
        <Theme className={"fixed right-10 bottom-2"} />
      </div>
    </footer>
  );
}
