import { useEffect, useState } from "react";
import { Aside, Footer, Header, InfoBar, Task, Background } from "../components/";
import { useRouter } from "next/router";
import { getUserData } from "../logic";
import * as env from "../env";

function HomePage() {
  const [userData, setUserData] = useState({});
  const [isLoading, setIsLoading] = useState(true);
  const [tasks, setTasks] = useState([]);
  const router = useRouter()

  useEffect(() => {
    document.title = "Главная страница";
    setTimeout(()=>getUserData({setUserData, setIsLoading, router}), 5000);
  }, []);
  useEffect(() => {
      
      getTasks();
    }, []);
  
    async function getTasks() {
        const accessToken = localStorage.getItem("accessToken");
        const req = await fetch(env.BACKEND_API_URL + "/task/get", {
          method: "GET",
          headers: {
            "Content-Type": "application/json;charset=utf-8",
            Authorization: `Bearer ${accessToken}`,
          },
        });
        const res = await req.json();
        setTasks(await res);
      }
  return (
    <>
      <Header title="Главная страница" userData={userData} isLoading={isLoading}/>
      <Aside userRole={userData.rolesName}/>
      <main className="lg:pl-20 px-6 pt-32 h-[100vh]">
        <InfoBar userData={userData} isLoading={isLoading} countOfTasks={tasks.length}/>
        <Background>
          {tasks.map((item) => {
            return (
              <Task
                key={item.id}
                item={item}
                isLoading={isLoading}
              >
                {item.description}
              </Task>
            );
          })}
        </Background>
      </main>
      <Footer />
    </>
  );
}

export default HomePage;
