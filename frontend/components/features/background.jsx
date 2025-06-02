import clsx from "clsx";

export function Background({ children, scale=1 }) {
  const choose = {
    "0.8": "w-[100%] h-[80%]",
    "1": "w-[100%] h-[100%]"
  }[scale]
  return (
    <div className="w-[84vw] h-[80%] mt-5 mx-auto lg:pr-16">
      <div className={clsx("bg-waffle dark:bg-dark-chocolate rounded-2xl p-4 overflow-y-auto list", choose)}>
        {/* дописать отрисовку map  */}
        {children}
      </div>
    </div>
  );
}
