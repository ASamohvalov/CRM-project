import { useState } from "react";
import { Theme } from "./theme-switch";

function mousehandler(e) {
	if (e.type == "mouseover")
		document
			.querySelectorAll("#ok")
			.forEach((el) => (el.style.display = "flex"));
	else
		document.querySelectorAll("#ok").forEach((el) => (el.style.display = ""));
}

export function Header({ title, user = "Филиппов Михаил" }) {
	const [isClicked, setClicked] = useState(false);
	
	function burgerClickHandle() {
		if (document.documentElement.clientWidth > 1024) return;
		if (!isClicked) {
			setClicked(true);
		}
		if (isClicked) {
			setClicked(false);
		}
	}	

	return (
		<div className="fixed min-w-[100vw] pt-10">
			<header className="text-milk relative flex flex-col w-[100vw] max-h-96 lg:w-[100vw]" onClick={burgerClickHandle}>
				<div
					className="bg-coffee dark:bg-cream header cursor-pointer items-center relative w-64 h-16 flex text-3xl text-cream dark:text-coffee rounded-3xl py-4 mx-auto mb-6 lg:hover:w-[80vw] hover:justify-normal transition-all lg:hover:pl-4 overflow-hidden"
					onMouseOver={mousehandler}
					onMouseOut={mousehandler}
				>
					<h1 className="pl-2 text-nowrap text-">{title}</h1>
					<div
						className="hidden lg:flex items-center text-[28px] ml-auto gap-4 pr-10"
						id="ok"
					>
						<h1 className="pl-2 text-nowrap">{user}</h1>
						<Theme/>
						<h2 className="">Фильтры</h2>
					</div>
				</div>
				{isClicked && (
					<div
						className={
							"lg:hidden flex flex-col w-[327px] mx-auto gap-5 bg-coffee rounded-lg p-4 -bottom-52"
						}
					>
						huhuhuhuhuhuhu
					</div>
				)}
			</header>
		</div>
	);
}
