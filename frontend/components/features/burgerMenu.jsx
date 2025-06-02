import Link from "next/link";
import { Logout } from "../../logic";
import { Loading } from "./loading";
import { AdminIcon, HouseIcon, LoginIcon, TaskIcon } from "../../icons";

export function BurgerMenu({ userData, isLoading }) {
  return (
    <div
      className={
        "lg:hidden border-dark-milk border-2 flex flex-col w-[327px] mx-auto gap-5 bg-coffee dark:bg-dark-coffee rounded-t-lg rounded-b-xl -bottom-52 z-50"
      }
    >
      <div className="px-4 pt-4">
        {isLoading ? (
        <Loading className={"min-w-36 h-10 "} />
      ) : (
        <p className="text-2xl sm:text-3xl text-center">
          {userData?.lastName} {userData?.firstName} {userData?.patronymic}
        </p>
      )}
      <hr className="my-2"></hr>
      <h2 className="text-2xl sm:text-3xl text-center">Фильтры</h2>
      </div>
      
      <div className="flex gap-5 justify-between bg-dark-chocolate text-dark-coffee py-2 rounded-b-xl">
        <Link
          href="/"
          className=" px-1 flex items-center "
        >
          <HouseIcon className=" min-w-10 h-10" />
        </Link>
        <Link
          href="./tasks"
          className="px-1 flex relative items-center before:bg-white before:absolute before:bottom-[-10px] before:left-0 hover:before:animate-down-to-end hover:before:h-[2px] transition-all"
        >
          <TaskIcon className="min-w-10 h-10" />
        </Link>
        {userData.rolesName?.find((item) => item === "ROLE_ADMIN") ? (
          <Link
            href="./admin"
            className="px-1 flex relative items-center before:bg-white before:absolute before:bottom-[-10px] before:left-0 hover:before:animate-down-to-end hover:before:h-[2px] transition-all"
          >
            <AdminIcon className="min-w-10 h-10" />
          </Link>
        ) : (
          <></>
        )}

        <Link
          href="./login"
          onClick={Logout}
          className="px-1 flex items-center before:bg-white before:absolute before:bottom-[-10px] before:left-0 hover:before:animate-down-to-end hover:before:h-[2px] transition-all"
        >
          <LoginIcon className="min-w-10 h-10" />
        </Link>
      </div>
    </div>
  );
}
