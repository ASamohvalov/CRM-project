import { useEffect, useState } from "react";
import { Aside, Footer, Header, InfoBar, Task, Background } from "../components/";
import { useRouter } from "next/router";
import { getUserData } from "../logic";

function HomePage() {
  const [userData, setUserData] = useState({});
  const router = useRouter()

  useEffect(() => {
    document.title = "Главная страница";
    getUserData({setUserData, router});
  }, []);
  
  return (
    <>
      <Header title="Главная страница" userData={userData} />
      <Aside />
      <main className="lg:pl-20 px-6 pt-32 h-[100vh]">
        <InfoBar userData={userData}/>
        <Background>
          <Task header={"Пипська"} points={16}>
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
