export function UiButton({className, variant="text", color="white", placeholder, children}) {
	return (
		<input type={variant} className={`${className} bg-[${color}]`} placeholder={placeholder} >
			{children}
		</input>
	);
}
