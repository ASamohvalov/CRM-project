import { Loading } from "./features/loading";

export function InfoBar({ userData, isLoading, countOfTasks, countOfPoints=0, countOfCompleted=0 }) {
  return (
    <div className="flex gap-7 justify-center w-[90%] text-center leading-none mx-auto lg:pr-16">
      <div className="flex flex-col items-center rounded-l-3xl bg-chocolate dark:bg-dark-waffle px-5 py-3 w-[19vw] justify-center">
        <h4 className="text-lg lg:text-xl text-milk dark:text-dark-milk leading-5">Кол-во задач</h4>
        {isLoading ? (
          <Loading className={"w-10 h-10"} />
        ) : (
          <h2 className="text-md md:text-xl lg:text-3xl text-milk dark:text-dark-milk">{countOfTasks}</h2>
        )}
      </div>
      <div className="flex flex-col items-center bg-chocolate dark:bg-dark-waffle px-5 py-3 w-[19vw] justify-center">
        <h4 className="text-lg lg:text-xl text-milk dark:text-dark-milk leading-5">Кол-во очков</h4>
        {isLoading ? (
          <Loading className={"w-10 h-10"} />
        ) : (
          <h2 className="text-md md:text-xl lg:text-3xl text-milk dark:text-dark-milk">{countOfPoints}</h2>
        )}
      </div>
      <div className="flex flex-col items-center bg-chocolate dark:bg-dark-waffle px-5 py-3 w-[19vw] justify-center">
        <h4 className="text-lg lg:text-xl text-milk dark:text-dark-milk leading-5">
          Завершенные задачи
        </h4>
        {isLoading ? (
          <Loading className={"w-10 h-10"} />
        ) : (
          <h2 className="text-md md:text-xl lg:text-3xl text-milk dark:text-dark-milk">{countOfCompleted}</h2>
        )}
      </div>
      <div className="flex flex-col items-center rounded-r-3xl bg-chocolate dark:bg-dark-waffle px-5 py-3 w-[19vw] justify-center">
        <h4 className="text-lg lg:text-xl text-milk dark:text-dark-milk">Должность</h4>
        {isLoading ? (
          <Loading className={"w-10 h-10"} />
        ) : (
          <h2 className="text-md md:text-xl lg:text-3xl text-milk dark:text-dark-milk">
            {userData.jobTitleName}
          </h2>
        )}
      </div>
    </div>
  );
}
