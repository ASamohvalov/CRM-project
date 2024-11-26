import {Aside} from "../../components/aside.jsx";
import { Footer } from "../../components/footer.jsx";
import { Header } from "../../components/header.jsx";

function HomePage() {
	return (
		<div className="bg-[#F3E9DC] dark:bg-coffee">
			<Aside/>
			<Header title="Главная страница"/>
			<main className="pl-6 lg:pl-20 pr-6 mt-10">
				<button className="bg-black w-[100%]">ekffieifj</button>
			</main>
			<Footer/>
		</div>
	);
}

export default HomePage;
