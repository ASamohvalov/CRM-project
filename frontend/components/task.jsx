import { Loading } from "./features/loading";

export function Task({ header, children, points, isLoading }) {
  return (
    <div className="bg-milk dark:bg-dark-coffee text-waffle dark:text-dark-milk rounded-2xl pl-10 mb-2 flex h-[110px] box-border overflow-y-hidden">
      <div className="pt-4">
        {isLoading ? (
          <Loading className={"h-7 w-36"} />
        ) : (
          <h3 className="text-2xl">{header}</h3>
        )}
        {isLoading ? (
          <>
            <Loading className={"h-4 mt-3 w-[65vw]"} />
            <Loading className={"h-4 mt-2 w-[20vw]"} />
          </>
        ) : (
          <p className="max-w-[80vw]">{children}</p>
        )}
      </div>
      <div className="h-[80%] w-[2px] bg-chocolate my-auto ml-auto"></div>
      {isLoading ? (
        <Loading className={"my-auto mx-5 w-20 h-10"} />
      ) : (
        <h2 className="max-w-[60vw] text-4xl my-auto px-10">{points}</h2>
      )}
    </div>
  );
}
