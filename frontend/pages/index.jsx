import { useEffect, useState } from "react";
import { Aside, Footer, Header, InfoBar, Task, Tasks } from "../components/";
import { useRouter } from "next/router";

function HomePage() {
  const [userData, setUserData] = useState({});
  const router = useRouter()

  useEffect(() => {
    document.title = "Главная страница";
    async function getUserData() {
      const accessToken = localStorage.getItem("accessToken");
      const getData = await fetch(
        "http://localhost:8080/api/employee/get_employee_data",
        {
          method: "GET",
          headers: {
            "Content-Type": "application/json;charset=utf-8",
            Authorization: `Bearer ${accessToken}`,
          },
        }
      );
      if(getData.ok){
        const DataJSON = await getData.json();
        setUserData(DataJSON);
      }else{
        router.push('/login');
      }
    }
    getUserData();
  }, []);
  return (
    <>
      <Header title="Главная страница" userData={userData} />
      <Aside />
      <main className="lg:pl-20 px-6 pt-32 h-[100vh]">
        <InfoBar userData={userData}/>
        <Tasks>
          <Task header={"Пипська"} points={16}>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam
            fermentum, odio eget tristique cursus, risus augue convallis enim,
            vitae ornare sapien...Lorem ipsum dolor sit amet, consectetur
            adipiscing elit. Nullam fermentum, odio eget tristique cursus, risus
            augue convallis enim, vitae ornare sapien...
          </Task>
        </Tasks>
      </main>
      <Footer />
    </>
  );
}

export default HomePage;
