import { useEffect, useState } from "react";
import { Aside, Footer, Header, Task, Background } from "../components/";
import { getUserData } from "../logic";
import { useRouter } from "next/router";
import * as env from "../env";

function TaskListPage() {
  const [userData, setUserData] = useState({});
  const [tasks, setTasks] = useState([]);
  const [accepting, setAccepting] = useState(false);
  const router = useRouter();
  const [isLoading, setIsLoading] = useState(true);
  const [filterLine, setLine] = useState("");
  const [searchText, setSearchText] = useState("");

  useEffect(() => {
    document.title = "Заявки";
    getUserData({ setUserData, setIsLoading, router });
  }, []);
  useEffect(() => {
    getTasks();
    setAccepting(false);
  }, [userData, accepting]);

  async function getTasks() {
    const accessToken = localStorage.getItem("accessToken");
    const line = userData.rolesName?.includes("ROLE_ADMIN") || userData.rolesName?.includes("ROLE_MANAGER") ? "/task/requests/get_unaccepted_execution_requests" : "/task/employee/get_all_requests" ;    
    try {      
      const req = await fetch(env.BACKEND_API_URL + line, {
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
      fetch(env.BACKEND_API_URL + `/task/requests/accept_execution_request/${id}`, {
        method: "GET",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          Authorization: `Bearer ${accessToken}`,
        },
      })
      setAccepting(true);
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <>
      <Header title="Заявки" userData={userData} isLoading={isLoading} tasks setLine={setLine} searchText={searchText} setSearchText={setSearchText}/>
      <Aside userRole={userData.rolesName} />
      <main className="lg:pl-20 px-6 pt-32 h-[100vh]">
        <Background scale={0.8}>
          {tasks.filter((taska)=> taska.task.name.toLowerCase().includes(searchText.toLowerCase())).filter((taska)=> taska.task.category?.id.includes(filterLine)).map((item) => {
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

export default TaskListPage;
