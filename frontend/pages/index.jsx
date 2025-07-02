import { useEffect, useState } from "react";
import {
  Aside,
  Footer,
  Header,
  InfoBar,
  Task,
  Background,
} from "../components/";
import { useRouter } from "next/router";
import { getUserData } from "../logic";
import * as env from "../env";

function HomePage() {
  const [userData, setUserData] = useState({});
  const [isLoading, setIsLoading] = useState(true);
  const [tasks, setTasks] = useState([]);
  const [points, setPoints] = useState(0);
  const [line, setLine] = useState("");
  const [searchText, setSearchText] = useState("");
  const router = useRouter();

  useEffect(() => {
    document.title = "Главная страница";
    getUserData({ setUserData, setIsLoading, router });
  }, []);
  useEffect(() => {
    getPoints();
    getTasks();
  }, []);

  async function getTasks() {
    const accessToken = localStorage.getItem("accessToken");
    try {
      const req = await fetch(
        env.BACKEND_API_URL + "/task/employee/get_all_tasks",
        {
          method: "GET",
          headers: {
            "Content-Type": "application/json;charset=utf-8",
            Authorization: `Bearer ${accessToken}`,
          },
        }
      );
      const res = await req.json();
      setTasks(await res);
    } catch (e) {
      console.log(e);
    }
  }

  async function getPoints() {
    const accessToken = localStorage.getItem("accessToken");
    try {
      const req = await fetch(env.BACKEND_API_URL + "/employee/get_points", {
        method: "GET",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          Authorization: `Bearer ${accessToken}`,
        },
      });
      const res = await req.json();
      setPoints(await res);
    } catch (e) {
      console.log(e);
    }
  }
  function sendTask(id) {
    const accessToken = localStorage.getItem("accessToken");
    try {
      fetch(env.BACKEND_API_URL + `/task/employee/send_task_for_review/${id}`, {
        method: "GET",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          Authorization: `Bearer ${accessToken}`,
        },
      });
      getTasks();
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <>
      <Header
        title="Главная страница"
        userData={userData}
        isLoading={isLoading}
        tasks
        setLine={setLine}
        searchText={searchText}
        setSearchText={setSearchText}
      />
      <Aside userRole={userData.rolesName} />
      <main className="lg:pl-20 px-6 pt-32 h-[100vh]">
        <InfoBar
          userData={userData}
          isLoading={isLoading}
          countOfTasks={
            tasks.filter((item) => item.status != "COMPLETED").length
          }
          countOfCompleted={
            tasks.filter((item) => item.status == "COMPLETED").length
          }
          countOfPoints={points.points}
        />
        <Background scale={0.8}>
          {tasks
            .find((item) => item.status != "COMPLETED") ? (
              tasks
              .filter((taska) => taska.name.includes(searchText))
              .filter((taska) => taska.category?.id.includes(line))
              .filter((item) => item.status != "COMPLETED")
              .map((item) => {
                console.log(item);

                return (
                  <Task
                    key={item.id}
                    item={item}
                    isLoading={isLoading}
                    onTake={() => sendTask(item.id)}
                    action="Сдать задачу"
                  >
                    {item.description}
                  </Task>
                );
              })
          ) : (
            <div className="flex justify-center items-center w-[100%] h-[100%]">
              <p className="text-4xl text-milk">У вас нет задач</p>
            </div>
          )}
        </Background>
      </main>
      <Footer />
    </>
  );
}

export default HomePage;
