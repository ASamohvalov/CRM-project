import { useEffect, useState } from "react";
import { BurgerMenu, Loading, Theme } from "./features";
import * as env from "../env";
import { UiInput } from "../ui/uiInput";

function mousehandler(e) {
  if (document.documentElement.clientWidth <= 768) return;
  if (e.type == "mouseover")
    document
      .querySelectorAll("#ok")
      .forEach((el) => (el.style.display = "flex"));
  else
    document
      .querySelectorAll("#ok")
      .forEach((el) => (el.style.display = "none"));
}
async function getCategories(setter) {
  const accessToken = localStorage.getItem("accessToken");
  try {
    const req = await fetch(env.BACKEND_API_URL + "/task/get/task_categories", {
      method: "GET",
      headers: {
        "Content-Type": "application/json;charset=utf-8",
        Authorization: `Bearer ${accessToken}`,
      },
    });
    const res = await req.json();
    setter(await res);
  } catch (e) {
    console.log(e);
  }
}

export function Header({ title, userData, isLoading, tasks = false, setLine, searchText, setSearchText }) {
  const [isClicked, setClicked] = useState(false);
  const [categories, setCategories] = useState([]);
  const [numOfClicks, setNumOfClicks] = useState(0);
  useEffect(() => {
    getCategories(setCategories);
  }, []);

  function burgerClickHandle() {
    if (document.documentElement.clientWidth > 768) return;
    if (!isClicked) {
      setClicked(true);
    }
    if (isClicked) {
      setClicked(false);
    }
  }

  return (
    <div className="fixed min-w-[100vw] pt-10 z-50">
      <header
        className="text-milk dark:text-dark-milk relative flex flex-col w-[100vw] max-h-96 lg:w-[100vw]"
        onClick={burgerClickHandle}
      >
        <div
          className="bg-coffee dark:bg-dark-waffle header cursor-pointer items-center relative w-64 h-16 flex text-3xl justify-center text-cream rounded-3xl py-4 mx-auto mb-6 lg:hover:w-[80vw] hover:justify-normal transition-all lg:hover:pl-4 overflow-hidden"
          onMouseOver={mousehandler}
          onMouseOut={mousehandler}
        >
          <h1 className="text-nowrap">{title}</h1>
          <div
            className="hidden items-center text-[28px] ml-auto gap-4 pr-10"
            id="ok"
          >
            {tasks ? (
              <input
                name="searchTask"
                placeholder="Название задачи"
                type="text"
                value={searchText}
                onChange={(e)=> setSearchText(e.target.value)}
                className={
                  "ml-2 w-100px h-[80%] bg-chocolate dark:bg-dark-coffee text-md focus:outline-0 px-5 rounded-2xl"
                }
              />
            ) : (
              ""
            )}
            {isLoading ? (
              <Loading className={"min-w-36 h-10 "} />
            ) : (
              <h1 className="text-nowrap">
                {userData?.lastName} {userData?.firstName}{" "}
                {userData?.patronymic}
              </h1>
            )}
            <Theme />
            {tasks ? (
              <h2
                onClick={(e) => {
                  e.stopPropagation();
                  setNumOfClicks((prev) => {
                    if (prev == categories.length) {
                      setLine("");
                      return 0;
                    }
                    setLine(categories[numOfClicks - 1]?.id);
                    return (prev += 1);
                  });
                }}
              >
                {numOfClicks ? categories[numOfClicks - 1]?.name : "Фильтры"}
              </h2>
            ) : (
              ""
            )}
          </div>
        </div>
        {isClicked && (
          <BurgerMenu
            userData={userData}
            isLoading={isLoading}
            categories={categories}
            numOfClicks={numOfClicks}
            setNumOfClicks={setNumOfClicks}
            setLine={setLine}
          />
        )}
      </header>
    </div>
  );
}
