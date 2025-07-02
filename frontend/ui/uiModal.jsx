import { useEffect, useState } from "react";
import { UiInput } from "./uiInput";
import { UiButton } from "./uiButton";
import * as env from "../env";

export function UIModal({ isShow, children }) {
  if (!isShow.isShow.status) return;
  function Close(e) {
    const inModal = e.target.closest("[data-id=modal]");
    if (!inModal) isShow.setIsShow({ status: false, purpose: "" });
  }

  return (
    <div
      className="fixed bg-milk/30 dark:bg-dark-coffee/30 inset-0 backdrop-blur overflow-y-auto z-10 pt-30 md:pt-35 pb-10"
      onClick={(e) => Close(e)}
    >
      <div
        className="mx-auto relative bg-waffle dark:bg-dark-waffle box-border max-w-[80vw] md:max-w-[600px] p-10 rounded-3xl"
        data-id="modal"
      >
        <div className="bg-chocolate dark:bg-dark-coffee h-[50vh] md:max-w-[600px] md:h-[600px] mx-auto rounded-2xl p-10 flex flex-col justify-center">
          {children}
        </div>
      </div>
    </div>
  );
}

UIModal.AddTask = function ({ handler, children }) {
  const [naming, setNaming] = useState("");
  const [description, setDescription] = useState("");
  const [points, setPoints] = useState("");
  const [deadline, setDeadline] = useState("");
  const [categoryId, setCategoryId] = useState("");
  return (
    <form
      onSubmit={(e) => {
        handler(e, naming, description, points, deadline, categoryId);
      }}
      className="flex flex-col items-center"
    >
      <h1 className="text-lg lg:text-4xl text-milk dark:text-dark-milk mb-[10%]">
        {children}
      </h1>
      <UiInput
        type="text"
        onChange={(e) => {
          setNaming(e.target.value);
        }}
        value={naming}
        placeholder="Название"
        mb={"mb-3"}
        className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-72"
      />
      <textarea
        type="text"
        onChange={(e) => {
          setDescription(e.target.value);
        }}
        mb={"mb-3"}
        value={description}
        placeholder="Описание"
        className="bg-white text-waffle mb-3 outline-0 rounded-lg h-28 text-sm md:text-lg px-4 dark:bg-dark-milk dark:text-dark-coffee w-72 list"
      />
      <UiInput
        type="text"
        onChange={(e) => {
          setPoints(e.target.value);
        }}
        value={points}
        placeholder="Очки"
        mb={"mb-3"}
        className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-72"
      />
      <UiInput
        type="date"
        onChange={(e) => {
          setDeadline(e.target.value);
        }}
        value={deadline}
        placeholder="дэдлайн"
        mb={"mb-3"}
        className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-72"
      />
      <UiInput
        type="text"
        onChange={(e) => setCategoryId(e.target.value)}
        value={categoryId}
        placeholder="id категории"
        className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-72"
      />
      <UiButton
        type="submit"
        className={
          "w-72 h-20 rounded-2xl text-milk dark:bg-dark-chocolate dark:text-dark-milk text-lg lg:text-2xl"
        }
      >
        Отправить
      </UiButton>
    </form>
  );
};
UIModal.AddTitle = function ({ handler, children }) {
  const [titleId, setTitleId] = useState({
    login: "",
    email: "",
    password: "",
    firstName: "",
    lastName: "",
    patronymic: "",
    qualificationId: "",
    role: "",
    phoneNumber: "",
    passportNumber: "",
    passportSeries: "",
  });
  return (
    <form
      onSubmit={(e) => {
        handler(e, titleId);
      }}
      className="flex flex-col items-center"
    >
      <h1 className="text-lg lg:text-4xl text-milk dark:text-dark-milk mb-[10%]">
        {children}
      </h1>
      <div className="flex flex-wrap gap-5 justify-center">
        <UiInput
          type="text"
          onChange={(e) => {
            setTitleId((last) => ({ ...last, login: e.target.value }));
          }}
          value={titleId.login}
          placeholder="Логин"
          mb="mb-3"
          className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-28"
        />
        <UiInput
          type="text"
          onChange={(e) => {
            setTitleId((last) => ({ ...last, email: e.target.value }));
          }}
          value={titleId.email}
          placeholder="Почта"
          mb="mb-3"
          className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-28"
        />
        <UiInput
          type="text"
          onChange={(e) => {
            setTitleId((last) => ({ ...last, password: e.target.value }));
          }}
          value={titleId.password}
          placeholder="Пароль"
          mb="mb-3"
          className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-28"
        />
      </div>

      <div className="flex flex-wrap gap-5 justify-center">
        <UiInput
          type="text"
          onChange={(e) => {
            setTitleId((last) => ({ ...last, firstName: e.target.value }));
          }}
          value={titleId.firstName}
          placeholder="Имя"
          mb="mb-3"
          className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-28"
        />
        <UiInput
          type="text"
          onChange={(e) => {
            setTitleId((last) => ({ ...last, lastName: e.target.value }));
          }}
          value={titleId.lastName}
          placeholder="Фамилия"
          mb="mb-3"
          className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-28"
        />
        <UiInput
          type="text"
          onChange={(e) =>
            setTitleId((last) => ({ ...last, patronymic: e.target.value }))
          }
          value={titleId.patronymic}
          placeholder="Отчество"
          mb="mb-3"
          className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-28"
        />
      </div>

      <UiInput
        type="text"
        onChange={(e) =>
          setTitleId((last) => ({ ...last, qualificationId: e.target.value }))
        }
        value={titleId.qualificationId}
        placeholder="Квалификация"
        mb="mb-3"
        className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-72"
      />
      <UiInput
        type="text"
        onChange={(e) =>
          setTitleId((last) => ({ ...last, role: e.target.value }))
        }
        value={titleId.role}
        placeholder="Роль"
        mb="mb-3"
        className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-72"
      />

      <div className="flex flex-wrap gap-5 justify-center">
        <UiInput
          type="text"
          onChange={(e) =>
            setTitleId((last) => ({ ...last, phoneNumber: e.target.value }))
          }
          value={titleId.phoneNumber}
          placeholder="Телефон"
          className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-28"
        />
        <UiInput
          type="text"
          onChange={(e) =>
            setTitleId((last) => ({ ...last, passportNumber: e.target.value }))
          }
          value={titleId.passportNumber}
          placeholder="Номер пасспорта"
          className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-28"
        />
        <UiInput
          type="text"
          onChange={(e) =>
            setTitleId((last) => ({ ...last, passportSeries: e.target.value }))
          }
          value={titleId.passportSeries}
          placeholder="Серия пасспорта"
          className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-28"
        />
      </div>

      <UiButton
        type="submit"
        className={
          "w-72 h-20 rounded-2xl text-milk dark:bg-dark-chocolate dark:text-dark-milk text-2xl"
        }
      >
        Добавить
      </UiButton>
    </form>
  );
};
UIModal.AddWork = function ({ handler, children }) {
  const [titleId, setTitleId] = useState("");
  const [naming, setNaming] = useState("");
  return (
    <form
      onSubmit={(e) => {
        handler(e, titleId, naming);
      }}
      className="flex flex-col items-center"
    >
      <h1 className="text-lg lg:text-4xl text-milk dark:text-dark-milk mb-[20%]">
        {children}
      </h1>
      <UiInput
        type="text"
        onChange={(e) => {
          setNaming(e.target.value);
        }}
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
      <UiButton
        type="submit"
        className={
          "w-72 h-20 rounded-2xl text-milk dark:bg-dark-chocolate dark:text-dark-milk text-2xl"
        }
      >
        Отправить
      </UiButton>
    </form>
  );
};

UIModal.AddCategory = function ({ handler, children }) {
  const [naming, setNaming] = useState("");
  const [description, setDescription] = useState("");
  return (
    <form
      onSubmit={(e) => {
        handler(e, naming, description);
      }}
      className="flex flex-col items-center"
    >
      <h1 className="text-lg lg:text-4xl text-milk dark:text-dark-milk mb-[20%]">
        {children}
      </h1>
      <UiInput
        type="text"
        onChange={(e) => setNaming(e.target.value)}
        value={naming}
        placeholder="Название"
        className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-72"
      />
      <UiInput
        type="text"
        onChange={(e) => setDescription(e.target.value)}
        value={description}
        placeholder="Описание"
        className="bg-white dark:bg-dark-milk dark:text-dark-coffee w-72"
      />
      <UiButton
        type="submit"
        className={
          "w-72 h-20 rounded-2xl text-milk dark:bg-dark-chocolate dark:text-dark-milk text-lg lg:text-2xl"
        }
      >
        Отправить
      </UiButton>
    </form>
  );
};

UIModal.GetWork = function ({ handler, children }) {
  const [titles, setTitles] = useState([]);
  const [deleted, setDeleted] = useState(false);
  useEffect(() => {
    async function name() {
      const b = await handler();
      setTitles(b);
    }
    name();
    setDeleted(false);
  }, [deleted]);

  function deleteQPunct(id) {
    const accessToken = localStorage.getItem("accessToken");
    try {
      fetch(env.BACKEND_API_URL + `/admin/delete/qualification/${id}`, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          Authorization: `Bearer ${accessToken}`,
        },
      });
    } catch (e) {
      console.log(e);
    } finally {
      setDeleted(() => true);
    }
  }
  function deleteJPunct(id) {
    const accessToken = localStorage.getItem("accessToken");
    try {
      fetch(env.BACKEND_API_URL + `/admin/delete/job_title/${id}`, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          Authorization: `Bearer ${accessToken}`,
        },
      });
    } catch (e) {
      console.log(e);
    } finally {
      setDeleted(() => true);
    }
  }
  return (
    <>
      <h1 className="text-lg lg:text-4xl text-milk dark:text-dark-milk mb-[10%] text-center">
        {children}
      </h1>
      <div className="overflow-y-auto max-h-[100%] titles__list">
        {titles ? (
          Object.values(titles)?.map((item) => (
            <div
              className="bg-white dark:bg-dark-milk mb-5 flex flex-col items-center rounded-3xl mr-3"
              key={item.id}
              onClick={
                children == "Квалификации"
                  ? () => deleteQPunct(item.id)
                  : children == "Должности"
                  ? () => deleteJPunct(item.id)
                  : null
              }
            >
              <div className="bg-waffle px-3 pb-1 rounded-b-2xl text-lg lg:text-3xl text-milk mb-2 text-center" onClick={(e)=>e.stopPropagation()}>
                {item.name}
              </div>
              <div className="text-lg lg:text-3xl text-center">{item.description}</div>
              <div className="bg-waffle px-1 pt-1 rounded-t-2xl text-lg text-milk mt-2 text-center" onClick={(e)=>e.stopPropagation()}>
                {item.id}
              </div>
            </div>
          ))
        ) : (
          <div>ничего</div>
        )}
      </div>
    </>
  );
};
