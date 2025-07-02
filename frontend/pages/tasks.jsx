import { useEffect, useState } from "react";
import { Aside, Footer, Header, Task, Background } from "../components/";
import { getUserData } from "../logic";
import { useRouter } from "next/router";
import * as env from "../env";

function TaskListPage() {
  const [userData, setUserData] = useState({});
  const [tasks, setTasks] = useState([]);
  const router = useRouter();
  const [isLoading, setIsLoading] = useState(true);
  const [line, setLine] = useState("");
  const [searchText, setSearchText] = useState("");

  useEffect(() => {
    document.title = "Задачи";
    getUserData({ setUserData, setIsLoading, router });
  }, []);
  useEffect(() => {
    getTasks();
  }, []);

  async function getTasks() {
    const accessToken = localStorage.getItem("accessToken");
    try {
      const req = await fetch(env.BACKEND_API_URL + "/task/get", {
        method: "GET",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          Authorization: `Bearer ${accessToken}`,
        },
      });
      const res = await req.json();
      setTasks(await res);
    } catch (e) {
      console.log(e);
    }
  }

  function onTake(e, id) {
    e.stopPropagation();
    const accessToken = localStorage.getItem("accessToken");
    fetch(env.BACKEND_API_URL + "/task/employee/take/" + id, {
      method: "GET",
      headers: {
        "Content-Type": "application/json;charset=utf-8",
        Authorization: `Bearer ${accessToken}`,
      }
    })
  }
  function onDelete(e, id) {
    e.stopPropagation();
    const accessToken = localStorage.getItem("accessToken");
    fetch(env.BACKEND_API_URL + "/task/delete/" + id, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json;charset=utf-8",
        Authorization: `Bearer ${accessToken}`,
      },
      body: {
        taskId: id,
      },
    });
    getTasks();
  }

  return (
    <>
      <Header title="Задачи" userData={userData} isLoading={isLoading} tasks setLine={setLine} searchText={searchText} setSearchText={setSearchText}/>
      <Aside userRole={userData.rolesName} />
      <main className="lg:pl-20 px-6 pt-32 h-[100vh]">
        <Background scale={1}>
          {tasks.filter((taska)=> taska.name.toLowerCase().includes(searchText.toLowerCase())).filter((taska)=> taska.category?.id.includes(line)).map((item) => {
            return (
              <Task
                key={item.id}
                item={item}
                status={item.status}
                isLoading={isLoading}
                onTake={userData.rolesName?.find((item)=> item !== "ROLE_ADMIN" || item !== "ROLE_MANAGER") && onTake}
                onDelete={userData.rolesName?.find((item)=> item === "ROLE_ADMIN") && onDelete}
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

export default TaskListPage;
