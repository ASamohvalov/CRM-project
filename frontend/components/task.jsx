export function Task({header, children, points}) {
    return ( <div className="bg-milk text-waffle rounded-2xl pl-10 mb-2 flex h-[110px] box-border">
        <div className="pt-4">
        <h3 className="text-2xl">{header}</h3>
        <p className="max-w-[80vw]">{children}</p></div>
        <div className="h-[80%] w-[2px] bg-chocolate my-auto ml-auto"></div>
        <h2 className="max-w-[60vw] text-4xl my-auto px-10">{points}</h2>
    </div> );
}