export function UiInput({className, variant="milk", placeholder, children}) {
	return (
		<input type="text" className={`bg-milk text-waffle mb-16 outline-0 rounded-lg h-10 text-lg px-4 ${className} bg-${variant}`} placeholder={placeholder} >
			{children}
		</input>
	);
}
