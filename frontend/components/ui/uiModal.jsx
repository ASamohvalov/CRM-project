import { useEffect, useState } from "react";
import { UiInput } from "./uiInput";
import { UiButton } from "./uiButton";

export function UIModal({ isShow, children }) {
  if (!isShow.isShow.status) return;
  function Close(e) {
    const inModal = e.target.closest("[data-id=modal]");
    if (!inModal) isShow.setIsShow({ status: false, purpose: "" });
  }

  return (
    <div
      className="fixed bg-milk/30 dark:bg-dark-coffee/30 inset-0 backdrop-blur overflow-y-auto z-10 pt-35 pb-10"
      onClick={(e) => Close(e)}
    >
      <div
        className="mx-auto relative bg-waffle dark:bg-dark-waffle box-border max-w-[600px] p-10 rounded-3xl"
        data-id="modal"
      >
        <div className="bg-chocolate dark:bg-dark-coffee max-w-[600px] h-[600px] mx-auto rounded-2xl p-10 flex flex-col justify-center">
          {children}
        </div>
      </div>
    </div>
  );
}

UIModal.AddWork = function ({ handler, children }) {
  const [titleId, setTitleId] = useState("");
  const [naming, setNaming] = useState("");
  return (
    <form onSubmit={(e) => handler(e, titleId, naming)} className="flex flex-col items-center">
      <h1 className="text-4xl text-milk dark:text-dark-milk mb-[20%]">{children}</h1>
      <UiInput
        type="text"
        onChange={(e) => setNaming(e.target.value)}
        value={naming}
        placeholder="Название"
        className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-72"
      />
      <UiInput
        type="text"
        onChange={(e) => setTitleId(e.target.value)}
        value={titleId}
        placeholder="Описание"
        className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-72"
      />
      <UiButton type="submit" className={"w-72 h-20 rounded-2xl text-milk dark:bg-dark-chocolate dark:text-dark-milk text-2xl"}>Отправить</UiButton>
    </form>
  );
};

UIModal.GetWork = function ({ handler }) {
  const [titles, setTitles] = useState([]);
  useEffect(() => {
    async function name() {
      const b = await handler();
      setTitles(b);
    }
    name();
    return () => {};
  }, []);
  return (
    <>
      <h1 className="text-4xl text-milk dark:text-dark-milk mb-[10%] text-center">Должности</h1>
    <div className="overflow-y-auto max-h-[100%] titles__list">
      {titles ? Object.values(titles)?.map((item) => (
        <div className="bg-white dark:bg-dark-milk mb-5 flex flex-col items-center rounded-3xl mr-3" key={item.id}>
          <div className="bg-waffle px-3 pb-1 rounded-b-2xl text-2xl text-milk mb-2">{item.name}</div>
          <div className="text-3xl">{item.description}</div>
          <div className="bg-waffle px-1 pt-1 rounded-t-2xl text-lg text-milk mt-2">{item.id}</div>
        </div>
      )) : <div>ничего</div>}
    </div></>
  );
};
