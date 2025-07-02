import clsx from "clsx";

export function UiButton({type="button",className, onClick, color="waffle", children}) {
	return (
		<button type={type} className={clsx("bg-waffle",`${className} bg-[${color}] text-milk`)} onClick={onClick}>
			{children}
		</button>
	);
}
