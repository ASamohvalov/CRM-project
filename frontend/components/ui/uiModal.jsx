import { useEffect, useState } from "react";
import { UiInput } from "./uiInput";
import { UiButton } from "./uiButton";

export function UIModal({ isShow, children }) {
  if (!isShow.isShow.status) return;
  function Close(e) {
    const inModal = e.target.closest("[data-id=modal]");
    if (!inModal) isShow.setIsShow({ status: false, purpose: "" });
  }
  function df(s,d){

  }

  return (
    <div
      className="fixed bg-milk/30 inset-0 backdrop-blur overflow-y-auto z-10 pt-35 pb-10"
      onClick={(e) => Close(e)}
    >
      <div
        className="mx-auto relative bg-waffle box-border max-w-[600px] p-10 rounded-3xl"
        data-id="modal"
      >
        <div className="bg-chocolate max-w-[600px] h-[600px] mx-auto rounded-2xl p-10">
          {children}
        </div>
      </div>
    </div>
  );
}

UIModal.AddWork = function ({ handler }) {
  const [titleId, setTitleId] = useState("");
  const [naming, setNaming] = useState("");
  return (
    <form
      onSubmit={(e) =>
        handler(
          e,
          titleId,
          naming
        )
      }
    >
      <UiInput type="text" onChange={(e)=>setNaming(e.target.value)} value={naming} placeholder="name" className="mr-10 bg-white" />
      <UiInput type="text" onChange={(e)=>setTitleId(e.target.value)} value={titleId} placeholder="description" className="mr-10 bg-white" />
      <button type="submit" className="bg-white">
        Отправить
      </button>
      <UiButton>Отправить</UiButton>
    </form>
  );
};

UIModal.GetTitle = function ({ handler }) {
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
    <div className="overflow-y-auto max-h-[100%]">
      {Object.values(titles).map((item) => (
        <div className="bg-white" key={item.id}>
        <div>{item.name}</div>
        <div>{item.description}</div>
        <div>{item.id}</div>
        </div>
      ))}
    </div>
  );
};
