import { UIModal } from "../ui/uiModal";
export function Modal({ handler, purpose, isShow }) {
  return (
    <UIModal isShow={isShow}>
      {purpose === "AddWorker" ? (
        <UIModal.AddTitle handler={handler}></UIModal.AddTitle>
      ) : purpose === "AddTask" ? (
        <UIModal.AddTask handler={handler}></UIModal.AddTask>
      ) : purpose === "AddCategory" ? (
        <UIModal.AddCategory handler={handler}>Категория</UIModal.AddCategory>
      ) : purpose === "AddQualify" ? (
        <UIModal.AddWork handler={handler}>Квалификация</UIModal.AddWork>
      ) : purpose === "AddTitle" ? (
        <UIModal.AddWork handler={handler}>Должность</UIModal.AddWork>
      ) : purpose === "GetTitle" ? (
        <UIModal.GetWork handler={handler}>Должности</UIModal.GetWork>
      ) : purpose === "GetQualify" ? (
        <UIModal.GetWork handler={handler}>Квалификации</UIModal.GetWork>
      ) : purpose === "GetCategories" ? (
        <UIModal.GetWork handler={handler}>Категории</UIModal.GetWork>
      ) : (
        <></>
      )}
    </UIModal>
  );
}
