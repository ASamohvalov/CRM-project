import { useState } from "react";
import { HouseIco } from "../components/icons/house.jsx";
import LoginIco from "./icons/Login.jsx";
import Link from 'next/link'

export function Aside() {
	const [hidden, setHidden] = useState(true);
	return (
		<aside
			className="hidden lg:block pt-[15vh] absolute top-0 h-[100%] w-14 bg-coffee dark:bg-cream hover:w-44 focus:w-44 transition-all rounded-r-2xl overflow-hidden"
			onMouseOver={() => setHidden(false)}
			onMouseOut={() => setHidden(true)}
		>
			<Link href="/" className="text-milk pl-1 flex relative items-center mt-5 mx-auto before:bg-white before:absolute before:bottom-0 before:left-0 hover:before:animate-down-to-end hover:before:h-[2px] before:animate-end-to-down">
				<HouseIco className="min-w-10 h-10 mr-5" />
				<p className="text-inherit dark:text-coffee text-2xl">Домой</p>  
			</Link>
			<Link href="./login" className="text-milk pl-1 flex relative items-center mt-5 mx-auto before:bg-white before:absolute before:bottom-0 before:left-0 hover:before:animate-down-to-end hover:before:h-[2px] transition-all">
				<LoginIco className="min-w-10 h-10 mr-5" />
				<p className="text-inherit dark:text-coffee text-2xl truncate">Логин</p>
			</Link>
		</aside>
	);
}
