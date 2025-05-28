import { useRouter } from "next/router";
import { useEffect, useState } from "react";
import { Aside, Header, Background, Modal } from "../components";
import { getUserData } from "../logic";
import * as env from "../env";

function AdminPage() {
  const [userData, setUserData] = useState({});
  const [isShow, setIsShow] = useState({
    status: false,
    purpose: "",
    handler: "",
  });
  const router = useRouter();
  useEffect(() => {
    document.title = "Админ панель";
    getUserData({ setUserData, router });
  }, []);
  const buttons = [
    { purpose: "AddWorker", name: "Добавить сотрудника", handler: addQualifyHandler },
    { purpose: "AddTask", name: "Добавить задачу", handler: addQualifyHandler },
    { purpose: "AddCategory", name: "Добавить категорию", handler: addQualifyHandler },
    { purpose: "AddQualify", name: "Добавить квалификацию", handler: addQualifyHandler },
    { purpose: "AddTitle", name: "Добавить должность", handler: addJobHandler },
    { purpose: "GetWork", name: "Узнать должности", handler: getTitlesHandler },
    { purpose: "GetWork", name: "Узнать квалификации", handler: getQualifyHandler },
  ];
  function addJobHandler(e, sm, sm2) {
    e.preventDefault();
    if (jobTitleId || qualificationName == "") {
      return;
    }
    const accessToken = localStorage.getItem("accessToken");
    fetch(env.BACKEND_API_URL + "/admin/add_job_title", {
      method: "POST",
      headers: {
        "Content-Type": "application/json;charset=utf-8",
        Authorization: `Bearer ${accessToken}`,
      },
      body: JSON.stringify({ name: sm, description: sm2 }),
    });
  }

  async function getTitlesHandler() {
    const accessToken = localStorage.getItem("accessToken");
    try {
      const a = await fetch(
        env.BACKEND_API_URL + "/manager/get_all_job_titles",
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
  async function getQualifyHandler() {
    const accessToken = localStorage.getItem("accessToken");
    try {
      const a = await fetch(
        env.BACKEND_API_URL + "/manager/get_all_qualifications",
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
  async function addQualifyHandler(e, jobTitleId, qualificationName) {
    e.preventDefault();
    if (jobTitleId || qualificationName == "") {
      return;
    }
    const accessToken = localStorage.getItem("accessToken");
    try {
      fetch(env.BACKEND_API_URL + "/admin/add_qualification", {
        method: "POST",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          Authorization: `Bearer ${accessToken}`,
        },
        body: JSON.stringify({
          jobTitleId: jobTitleId,
          qualificationName: qualificationName,
        }),
      });
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
          <div
            className={`w-[100%] h-[100%] bg-milk rounded-2xl p-10 flex flex-wrap gap-x-10 gap-y-0 justify-center`}
          >
            {buttons.map((item) => 
              <button
                key={item.name}
                className="bg-white border-2 border-chocolate box-border rounded-2xl min-w-70 h-[30%] p-5 text-waffle"
                onClick={() =>
                setIsShow({
                  status: true,
                  purpose: item.purpose,
                  handler: item.handler,
                })
              }
              >
                {item.name}
              </button>
            )}
          </div>
        </Background>
        <Modal
          handler={isShow.handler}
          purpose={isShow.purpose}
          isShow={{ isShow, setIsShow }}
        />
      </main>
    </>
  );
}

export default AdminPage;
