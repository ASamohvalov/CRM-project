import clsx from "clsx";

export function Loading({ className }) {
  return (
    <div className={clsx("bg-gray-400/60 rounded-2xl overflow-hidden", className)}>
      <div className={`w-10 h-[100%] bg-gray-500/70 blur-sm rounded-4xl animate-loading`}></div>
    </div>
  );
}
