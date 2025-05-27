import { useRouter } from "next/router";
import { useEffect, useState } from "react";
import { Aside, Header, Background, Modal } from "../components";
import { getUserData } from "../logic";
function AdminPage() {
  const [userData, setUserData] = useState({});
  const [isShow, setIsShow] = useState({status:false, purpose: "", handler: ""});
  const router = useRouter();
  useEffect(() => {
    document.title = "Админ панель";
    getUserData({ setUserData, router });
  }, []);
  function subHand(e, sm, sm2) {
    const accessToken = localStorage.getItem("accessToken");
    e.preventDefault();
    fetch("http://localhost:8080/api/admin/add_job_title", {
      method: "POST",
      headers: {
        "Content-Type": "application/json;charset=utf-8",
        Authorization: `Bearer ${accessToken}`,
      },
      body: JSON.stringify({ name: sm, description: sm2 }),
    });
  }

  async function subHand2() {
    const accessToken = localStorage.getItem("accessToken");
    try {
      const a = await fetch(
        "http://localhost:8080/api/admin/get_all_job_titles",
        {
          method: "GET",
          headers: {
            "Content-Type": "application/json;charset=utf-8",
            Authorization: `Bearer ${accessToken}`,
          },
        }
      );
      const b = await a.json();
      return b;
    } catch (e) {
      console.log(e);
    }
  }
  async function subHand3({e, jobTitleId, qualificationName}) {
    e.preventDefault();
    const accessToken = localStorage.getItem("accessToken");
    try {
      fetch(
        "http://localhost:8080/api/admin/add_qualification",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json;charset=utf-8",
            Authorization: `Bearer ${accessToken}`,
          },
          body: JSON.stringify({jobTitleId: jobTitleId, qualificationName: qualificationName})
        }
      );
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <>
      <Header title="Админ панель" userData={userData} />
      <Aside />
      <main className="lg:pl-20 px-6 pt-32 h-[100vh]">
        <Background>
          <div className={`w-[100%] h-[100%] bg-milk rounded-2xl p-10`}>
            <button className=" bg-white border-2 border-chocolate box-border rounded-2xl min-w-70 h-[20%] p-5 text-waffle mr-8" onClick={() => setIsShow({status:true, purpose:"AddWorker"})}>Добавить сотрудника</button>
            <button className=" bg-white border-2 border-chocolate box-border rounded-2xl min-w-70 h-[20%] p-5 text-waffle" onClick={() => setIsShow({status:true, purpose:"AddTask"})}>Добавить задачу</button>
            <button className=" bg-white border-2 border-chocolate box-border rounded-2xl min-w-70 h-[20%] p-5 text-waffle" onClick={() => setIsShow({status:true, purpose:"AddCategory"})}>Добавить категорию задач</button>
            <button className=" bg-white border-2 border-chocolate box-border rounded-2xl min-w-70 h-[20%] p-5 text-waffle" onClick={() => setIsShow({status:true, purpose:"AddQualify", handler: subHand3})}>Добавить квалификацию</button>
            <button className=" bg-white border-2 border-chocolate box-border rounded-2xl min-w-70 h-[20%] p-5 text-waffle" onClick={() => setIsShow({status:true, purpose:"AddTitle", handler: subHand})}>Добавить должность</button>
            <button className=" bg-white border-2 border-chocolate box-border rounded-2xl min-w-70 h-[20%] p-5 text-waffle" onClick={() => setIsShow({status:true, purpose:"GetTitle", handler: subHand2})}>Узнать должности</button>
          </div>
          </Background>
          <Modal handler={isShow.handler} purpose={isShow.purpose} isShow={{isShow, setIsShow}}/>
        </main>
    </>
  );
}

export default AdminPage;
