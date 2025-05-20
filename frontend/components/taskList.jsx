export function Tasks({ children }) {
  return (
    <div className="w-[84vw] h-[80%] mt-5 mx-auto lg:pr-16">
      <div className="w-[100%] h-[100%] bg-waffle rounded-2xl p-4 overflow-y-auto">
        {/* дописать отрисовку map  */}
        {children}
      </div>
    </div>
  );
}
