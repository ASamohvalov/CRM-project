import clsx from "clsx";

export function UiButton({type="button",className, onClick, color, children}) {
	return (
		<button type={type} className={clsx("bg-waffle",`${className} bg-[${color}]`)} onClick={onClick}>
			{children}
		</button>
	);
}
