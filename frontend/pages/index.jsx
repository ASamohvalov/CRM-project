import { useEffect, useState } from "react";
import { Aside, Footer, Header, InfoBar, Task, Background } from "../components/";
import { useRouter } from "next/router";
import { getUserData } from "../logic";

function HomePage() {
  const [userData, setUserData] = useState({});
  const [isLoading, setIsLoading] = useState(true);
  const router = useRouter()

  useEffect(() => {
    document.title = "Главная страница";
    setTimeout(()=>getUserData({setUserData, setIsLoading, router}), 5000);
  }, []);
  
  return (
    <>
      <Header title="Главная страница" userData={userData} isLoading={isLoading}/>
      <Aside />
      <main className="lg:pl-20 px-6 pt-32 h-[100vh]">
        <InfoBar userData={userData} isLoading={isLoading}/>
        <Background>
          <Task header={"Пипська"} points={16} isLoading={isLoading}>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam
            fermentum, odio eget tristique cursus, risus augue convallis enim,
            vitae ornare sapien...Lorem ipsum dolor sit amet, consectetur
            adipiscing elit. Nullam fermentum, odio eget tristique cursus, risus
            augue convallis enim, vitae ornare sapien...
          </Task>
        </Background>
      </main>
      <Footer />
    </>
  );
}

export default HomePage;
