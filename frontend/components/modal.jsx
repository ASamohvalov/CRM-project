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
        <UIModal.AddWork handler={handler}></UIModal.AddWork>
      ) : purpose === "AddTitle" ? (
        <UIModal.AddWork handler={handler}></UIModal.AddWork>
      ) : purpose === "GetTitle" ? (
        <UIModal.GetTitle handler={handler}></UIModal.GetTitle>
      ) : (
        <></>
      )}
    </UIModal>
  );
}
