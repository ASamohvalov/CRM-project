import { useState } from "react";
import { Loading } from "./features/loading";
import { UiButton } from "../ui/uiButton";
import { DeleteTaskIcon } from "../icons/DeleteTask";
import { EditTaskIcon } from "../icons/EditTask";

export function Task({
  children,
  item,
  acceptTask,
  isLoading,
  onTake,
  onDelete,
  accepted,
  onEdit,
  status,
  checking,
  worker,
  action = "Взять задачу",
}) {
  const [isClicked, setIsClicked] = useState(false);
  return (
    <div
      className={`tasks__list bg-milk dark:bg-dark-coffee text-waffle dark:text-dark-milk rounded-2xl pl-10 mb-2 flex ${
        isClicked ? "h-[400px]" : "h-[110px]"
      } box-border overflow-y-hidden transition-all relative`}
      onClick={() => setIsClicked((last) => !last)}
    >
      <div className="pt-4 w-[80%] h-[400px] overflow-hidden">
        {isLoading ? (
          <Loading className={"h-7 w-36"} />
        ) : (
          <h3 className="text-2xl">{item.name}</h3>
        )}
        {isLoading ? (
          <>
            <Loading className={"h-4 mt-3 w-[65vw]"} />
            <Loading className={"h-4 mt-2 w-[20vw]"} />
          </>
        ) : (
          <p
            className={`pt-1 max-h-[60%] ${
              isClicked ? "" : "truncate"
            } break-words overflow-y-auto scroll list`}
          >
            {children}
          </p>
        )}
        {checking ? (
          <div className="mt-auto text-xl">
            Работник:{" "}
            {worker?.firstName +
              " " +
              worker?.lastName +
              " " +
              worker?.patronymic +
              " (" +
              worker?.email +
              "), " +
              worker?.qualificationName}
          </div>
        ) : (
          ""
        )}
        {!isLoading && isClicked ? (
          <div className="flex flex-wrap gap-y-2 items-center justify-between pr-5 absolute left-10 bottom-5 w-[85%]">
            {item.category ? (
              <h2 className="max-w-[60vw] text-lg lg:text-2xl truncate">
                Категория: {item.category.name}
              </h2>
            ) : (
              ""
            )}

            {!checking && (
              <h2 className="max-w-[60vw] text-lg lg:text-3xl my-auto">
                Время сдачи: {item.deadline}
              </h2>
            )}
            <div className="flex items-center gap-4">
              {onEdit ? (
                <UiButton className="max-w-[60vw] text-3xl my-auto p-3 rounded-2xl ">
                  <EditTaskIcon className="w-8 h-8" />
                </UiButton>
              ) : (
                ""
              )}
              {onDelete ? (
                <UiButton
                  className="max-w-[60vw] text-3xl my-auto p-3 rounded-2xl"
                  onClick={(e) => onDelete(e, item.id)}
                >
                  <DeleteTaskIcon className="w-8 h-8" />
                </UiButton>
              ) : (
                ""
              )}
              {status === "COMPLETED" ? (
                <h5 className="text-5xl">✅</h5>
              ) : onTake ? (
                <UiButton
                  className="max-w-[60vw] text-3xl my-auto px-6 py-3 rounded-2xl"
                  onClick={(e) => onTake(e, item.id)}
                >
                  {action}
                </UiButton>
              ) : (
                <>
                  <p className="pr-10 text-2xl bor">
                    Статус: {accepted ? "Одобрена" : "Не одобрена"}
                  </p>
                  {checking ? (
                    <UiButton
                      className="mr-10 max-w-fit text-2xl my-auto p-3 rounded-2xl"
                      onClick={() => acceptTask()}
                    >
                      Одобрить
                    </UiButton>
                  ) : (
                    ""
                  )}
                </>
              )}
            </div>
          </div>
        ) : (
          <></>
        )}
      </div>
      <div className="h-[80%] w-[2px] bg-chocolate my-auto ml-auto"></div>
      {isLoading ? (
        <Loading className={"my-auto mx-5 w-20 h-10"} />
      ) : (
        <h2 className="max-w-30 truncate text-lg lg:text-4xl my-auto px-8">
          {item.numberOfPoints}
        </h2>
      )}
    </div>
  );
}
