import { useEffect, useState } from "react";
import { Aside } from "../components/aside.jsx";
import { Footer } from "../components/footer.jsx";
import { Header } from "../components/header.jsx";

function HomePage() {
	const [hz, setHz] = useState("");
	useEffect(() => {
		document.title = "Главная";
		const g = async () => {
			try {
				const a = await fetch("http://localhost:8080");
				const b = await a.text();
				setHz(b);
			} catch (e) {
				console.log(e);
			}
		};
		g();
	}, []);
	return (
		<>
			<Header title="Главная страница" />
			<Aside />
			<main className="lg:pl-20 px-6 pt-32">
				
			</main>
			<Footer />
		</>
	);
}

export default HomePage;
