import Image from "next/image";
import { useEffect, useState } from "react";

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
	const [theme, setTheme] = useState("light");
	function burgerClickHandle() {
		if (!isClicked) {
			setClicked(true);
		}
		if (isClicked) {
			setClicked(false);
		}
	}
	function lightDark() {
		if (localStorage.theme === "dark") {
			setTheme(() => "light");
			localStorage.theme = "light";
		} else {
			setTheme(() => "dark");
			localStorage.theme = "dark";
		}
	}
	useEffect(() => {
		setTheme(localStorage.theme);
	}, []);

	useEffect(() => {
		if (localStorage.theme === "dark") {
			document.documentElement.classList.add("dark");
		} else {
			document.documentElement.classList.remove("dark");
		}
	}, [theme]);

	return (
		<>
			<header className="sticky flex flex-col top-6 w-[100vw] max-h-96">
				<div
					className="bg-coffee dark:bg-cream cursor-pointer items-center relative w-64 h-16 flex text-3xl text-cream dark:text-coffee rounded-3xl py-4 mx-auto lg:hover:w-[80vw] hover:justify-normal transition-all lg:hover:pl-4 overflow-hidden"
					onMouseOver={mousehandler}
					onMouseOut={mousehandler}
				>
					<h1 className="pl-2 text-nowrap">{title}</h1>
					<div
						className="hidden lg:flex items-center text-[28px] ml-auto gap-10 pr-10"
						id="ok"
					>
						<h1 className="pl-2 text-nowrap">{user}</h1>
						<h2 className="">Фильтры</h2>
						<div
							className="dark:bg-white bg-black h-10 w-10 rounded-full"
							onClick={() => {
								lightDark();
							}}
						></div>
					</div>
					<button
						className="lg:hidden absolute w-64 top-0 left-0 h-16"
						onClick={burgerClickHandle}
					/>
				</div>
				{isClicked && (
					<div
						className={
							"lg:hidden absolute flex flex-col top-20 left-10 w-96 mx-auto gap-5 bg-coffee rounded-lg p-4 "
						}
					>
						huhuhuhuhuhuhu
					</div>
				)}
			</header>
		</>
	);
}
