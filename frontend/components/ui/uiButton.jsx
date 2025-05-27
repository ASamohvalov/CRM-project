import clsx from "clsx";

export function UiButton({className, onClick, color, children}) {
	return (
		<button className={clsx("bg-waffle",`${className} bg-[${color}]`)} onClick={onClick}>
			{children}
		</button>
	);
}
