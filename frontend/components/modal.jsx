import { UIModal } from "./ui/uiModal";
export function Modal({ handler, purpose, isShow }) {
  return (
    <UIModal isShow={isShow}>
      {purpose === "AddWorker" ? (
        <UIModal.AddTitle handler={handler}></UIModal.AddTitle>
      ) : purpose === "AddTask" ? (
        <UIModal.AddTitle handler={handler}></UIModal.AddTitle>
      ) : purpose === "AddCategory" ? (
        <UIModal.AddTitle handler={handler}></UIModal.AddTitle>
      ) : purpose === "AddQualify" ? (
        <UIModal.AddWork handler={handler}>Квалификация</UIModal.AddWork>
      ) : purpose === "AddTitle" ? (
        <UIModal.AddWork handler={handler}>Должность</UIModal.AddWork>
      ) : purpose === "GetWork" ? (
        <UIModal.GetWork handler={handler}></UIModal.GetWork>
      ) : (
        <></>
      )}
    </UIModal>
  );
}
