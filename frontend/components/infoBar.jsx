import { Loading } from "./loading";

export function InfoBar({ userData, isLoading }) {
  return (
    <div className="flex gap-7 justify-center w-[90%] mx-auto lg:pr-16">
      <div className="flex flex-col items-center rounded-l-3xl bg-chocolate px-5 py-3 w-[19vw]">
        <h4 className="text-xl text-milk">Кол-во задач</h4>
        {isLoading ? <Loading className={"w-10 h-10"}/> : <h2 className="text-3xl text-milk">3</h2>}
      </div>
      <div className="flex flex-col items-center bg-chocolate px-5 py-3 w-[19vw]">
        <h4 className="text-xl text-milk">Кол-во очков</h4>
        {isLoading ? <Loading className={"w-10 h-10"}/> : <h2 className="text-3xl text-milk">3</h2>}
      </div>
      <div className="flex flex-col items-center bg-chocolate px-5 py-3 w-[19vw]">
        <h4 className="text-xl text-milk">Завершенные задачи</h4>
        {isLoading ? <Loading className={"w-10 h-10"}/> : <h2 className="text-3xl text-milk">3</h2>}
      </div>
      <div className="flex flex-col items-center rounded-r-3xl bg-chocolate px-5 py-3 w-[19vw]">
        <h4 className="text-xl text-milk">Должность</h4>
        {isLoading ? (
          <Loading className={"w-10 h-10"}/>
        ) : (
          <h2 className="text-3xl text-milk">{userData.jobTitleName}</h2>
        )}
      </div>
    </div>
  );
}
