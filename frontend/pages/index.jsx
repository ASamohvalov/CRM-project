import { useEffect } from "react";
import { Aside } from "../components/aside.jsx";
import { Footer } from "../components/footer.jsx";
import { Header } from "../components/header.jsx";

function HomePage() {
	useEffect(()=>{
		document.title = "Главная";
	},[])
	return (
		<>
			<Header title="Главная страница"/>
			<Aside/>
			<main className="lg:pl-20 px-6 pt-32">
				<button className="bg-black w-[100%]">ekffieifj</button>
			</main>
			<Footer/>
		</>
	);
}

export default HomePage;
