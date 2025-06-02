import { useState } from "react";
import { HouseIcon, LoginIcon, TaskIcon, AdminIcon } from "../icons/";
import Link from "next/link";
import { Logout } from "../logic";

export function Aside({ userRole = [] }) {
  const [hidden, setHidden] = useState(false);
  
  return (
    <aside
      className={`hidden md:block pt-[15vh] absolute top-0 h-[100%] z-50 ${
        hidden ? "w-44" : "w-14"
      } bg-coffee dark:bg-dark-waffle text-milk dark:text-dark-milk text-2xl transition-all hover:w-44  rounded-r-2xl overflow-hidden`}
      onClick={() => setHidden((value) => !value)}
    >
      <Link
        href="/"
        className=" pl-1 flex relative items-center mt-5 mx-auto before:bg-white before:absolute before:bottom-[-10px] before:left-0 hover:before:animate-down-to-end hover:before:h-[2px] before:animate-end-to-down"
      >
        <HouseIcon className="min-w-10 h-10 mr-5" />
        <p className="text-inherit text-2xl">Домой</p>
      </Link>
      <Link
        href="./tasks"
        className="pl-1 flex relative items-center mt-5 mx-auto before:bg-white before:absolute before:bottom-[-10px] before:left-0 hover:before:animate-down-to-end hover:before:h-[2px] transition-all"
      >
        <TaskIcon className="min-w-10 h-10 mr-5" />
        <p className="text-inherit truncate">
          Задачи
        </p>
      </Link>
      {userRole?.find(item=>item==="ROLE_ADMIN") ? (
        <Link
          href="./admin"
          className="pl-1 flex relative items-center mt-5 mx-auto before:bg-white before:absolute before:bottom-[-10px] before:left-0 hover:before:animate-down-to-end hover:before:h-[2px] transition-all"
        >
          <AdminIcon className="min-w-10 h-10 mr-5" />
          <p className="text-inherit truncate">
            Админ
          </p>
        </Link>
      ) : (
        <></>
      )}

      <Link
        href="./login"
        onClick={Logout}
        className="pl-1 flex relative items-center mt-5 mx-auto before:bg-white before:absolute before:bottom-[-10px] before:left-0 hover:before:animate-down-to-end hover:before:h-[2px] transition-all"
      >
        <LoginIcon className="min-w-10 h-10 mr-5" />
        <p className="text-inherit truncate">Выход</p>
      </Link>
    </aside>
  );
}
