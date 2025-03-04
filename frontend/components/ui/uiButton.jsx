export function UiButton({className, variant, color, children}) {
	return (
		<button className={`${className} bg-[${color}]`}>
			{children}
		</button>
	);
}
