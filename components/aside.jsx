import { useState } from "react";
import { HouseIco } from "../components/icons/house.jsx";
import LoginIco from "./icons/Login.jsx";

export function Aside() {
	const [hidden, setHidden] = useState(true);
	return (
		<aside
			className="hidden lg:block pl-1 pt-[15vh] hover:pt-[calc(15vh-100px)] absolute top-0 h-[100%] w-14 bg-coffee dark:bg-cream hover:w-44 transition-all rounded-r-2xl overflow-hidden"
			onMouseOver={() => setHidden(() => false)}
			onMouseOut={() => setHidden(() => true)}
		>
			{hidden ? (
				""
			) : (
				<img
					src="https://www.amocrm.ru/views/pages/landing/images/about_us/press_stuff/amocrm-logo-white_2.svg"
					alt=""
					className="mx-auto w-[100px] h-[100px]"
				/>
			)}
			<div className="flex relative items-center mt-5 mx-auto before:bg-white before:absolute before:bottom-0 before:left-0 hover:before:animate-downToEnd hover:before:h-[2px]">
				<HouseIco className="min-w-10 h-10 mr-5" />
				<p className="text-white dark:text-coffee text-2xl">Домой</p>  
			</div>
			<div className="flex relative items-center mt-5 mx-auto before:bg-white before:absolute before:bottom-0 before:left-0 hover:before:animate-downToEnd hover:before:h-[2px]">
				<LoginIco className="min-w-10 h-10 mr-5" />
				<p className="text-white dark:text-coffee text-2xl truncate">Логин</p>
			</div>
		</aside>
	);
}
