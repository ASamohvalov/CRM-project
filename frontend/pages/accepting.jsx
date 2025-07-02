import { useEffect, useState } from "react";
import { Aside, Footer, Header, Task, Background } from "../components/";
import { getUserData } from "../logic";
import { useRouter } from "next/router";
import * as env from "../env";

function SubmittingListPage() {
  const [userData, setUserData] = useState({});
  const [tasks, setTasks] = useState([]);
  const [accepting, setAccepting] = useState(false);
  const router = useRouter();
  const [isLoading, setIsLoading] = useState(true);
  const [line, setLine] = useState("");
  const [searchText, setSearchText] = useState("");

  useEffect(() => {
    document.title = "Принять заявки";
    getUserData({ setUserData, setIsLoading, router });
  }, []);
  useEffect(() => {
    getTasks();
    setAccepting(false);
  }, [userData, accepting]);

  async function getTasks() {
    const accessToken = localStorage.getItem("accessToken");   
    try {      
      const req = await fetch(env.BACKEND_API_URL + "/task/requests/get_employee_tasks_submitted_for_review", {
        method: "GET",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          Authorization: `Bearer ${accessToken}`,
        },
      });
      const res = await req.json();
      setTasks(res);
    } catch (e) {
      console.log(e);
    }
  }
  function acceptTask(id) {
    const accessToken = localStorage.getItem("accessToken"); 
    try {      
      fetch(env.BACKEND_API_URL + `/task/requests/accept_task_submitted_for_review/${id}`, {
        method: "GET",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          Authorization: `Bearer ${accessToken}`,
        },
      })
      setAccepting(true);
      getTasks();
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <>
      <Header title="Принять заявки" userData={userData} isLoading={isLoading} tasks setLine={setLine} searchText={searchText} setSearchText={setSearchText}/>
      <Aside userRole={userData.rolesName} />
      <main className="lg:pl-20 px-6 pt-32 h-[100vh]">
        <Background scale={0.8}>
          {tasks.filter((taska)=> taska.task.name.toLowerCase().includes(searchText.toLowerCase())).filter((taska)=> taska.task.category?.id.includes(line)).map((item) => {            
            return (
              <Task
                key={item.id}
                item={item.task}
                acceptTask={()=> acceptTask(item.id)}
                worker={item.employee}
                accepted={item.accepted}
                isLoading={isLoading}
                checking={userData?.rolesName?.includes("ROLE_ADMIN") || userData?.rolesName?.includes("ROLE_MANAGER")}
              >
                {item.task.description}
              </Task>
            );
          })}
        </Background>
      </main>
      <Footer />
    </>
  );
}

export default SubmittingListPage;
