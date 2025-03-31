export function UiButton({className, onClick, color, children}) {
	return (
		<button className={`${className} bg-[${color}]`} onClick={onClick}>
			{children}
		</button>
	);
}
