import { useRouter } from "next/router";
import { useEffect, useState } from "react";
import { Aside, Header, Background, Modal, Footer } from "../components";
import { getUserData } from "../logic";
import * as env from "../env";

function AdminPage() {
  const [userData, setUserData] = useState({});
  const [isLoading, setIsLoading] = useState(true);
  const [isShow, setIsShow] = useState({
    status: false,
    purpose: "",
    handler: "",
  });
  const router = useRouter();
  useEffect(() => {
    document.title = "Админ панель";
    getUserData({ setUserData, setIsLoading, router });
  }, []);
  const buttons = [
    {
      purpose: "AddWorker",
      name: "Добавить сотрудника",
      handler: addCategoryHandler,
    },
    { purpose: "AddTask", name: "Добавить задачу", handler: addTaskHandler },
    {
      purpose: "AddCategory",
      name: "Добавить категорию",
      handler: addCategoryHandler,
    },
    {
      purpose: "AddQualify",
      name: "Добавить квалификацию",
      handler: addQualifyHandler,
    },
    { purpose: "AddTitle", name: "Добавить должность", handler: addJobHandler },
    {
      purpose: "GetTitle",
      name: "Узнать должности",
      handler: () => getHandler("/manager/get_all_job_titles"),
    },
    {
      purpose: "GetQualify",
      name: "Узнать квалификации",
      handler: () => getHandler("/manager/get_all_qualifications"),
    },
    {
      purpose: "GetCategories",
      name: "Узнать категории задач",
      handler: () => getHandler("/task/get/task_categories"),
    },
  ];

  function addTaskHandler(e, name, description, points, deadline, categoryId) {
    e.preventDefault();
    if (name === "" || description === "" || points === "" || deadline === "" || categoryId === "") {
      return;
    }
    const accessToken = localStorage.getItem("accessToken");
    try {
      fetch(env.BACKEND_API_URL + "/task/add", {
        method: "POST",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          Authorization: `Bearer ${accessToken}`,
        },
        body: JSON.stringify({
          name: name,
          description: description,
          numberOfPoints: Number(points),
          deadline: deadline,
          taskCategoryId: categoryId
        }),
      });
      console.log("s");
    } catch (e) {
      console.log(e);
    }
  }

  function addJobHandler(e, jobName, jobDescription) {
    e.preventDefault();

    if (jobName === "" || jobDescription === "") {
      return;
    }
    const accessToken = localStorage.getItem("accessToken");
    try {
      fetch(env.BACKEND_API_URL + "/admin/add_job_title", {
        method: "POST",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          Authorization: `Bearer ${accessToken}`,
        },
        body: JSON.stringify({ name: jobName, description: jobDescription }),
      });
    } catch (e) {
      console.log(e);
    }
  }

  async function addQualifyHandler(e, jobTitleId, qualificationName) {
    e.preventDefault();
    if (jobTitleId === "" || qualificationName === "") {
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

  async function addCategoryHandler(e, categoryName, categoryDescription) {
    e.preventDefault();
    if (categoryName === "" || categoryDescription === "") {
      return;
    }
    const accessToken = localStorage.getItem("accessToken");
    try {
      fetch(env.BACKEND_API_URL + "/task/add_task_category", {
        method: "POST",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          Authorization: `Bearer ${accessToken}`,
        },
        body: JSON.stringify({
          name: categoryName,
          description: categoryDescription,
        }),
      });
    } catch (e) {
      console.log(e);
    }
  }
  async function getHandler(link) {
    const accessToken = localStorage.getItem("accessToken");
    try {
      const a = await fetch(env.BACKEND_API_URL + link, {
        method: "GET",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          Authorization: `Bearer ${accessToken}`,
        },
      });
      const b = await a.json();
      return b;
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <>
      <Header title="Админ панель" userData={userData} isLoading={isLoading} />
      <Aside userRole={userData.rolesName} />
      <main className="lg:pl-20 px-6 pt-32 h-[100vh]">
        <Background>
          <div
            className={`w-[100%] h-[100%] bg-milk dark:bg-dark-coffee rounded-2xl p-10 flex flex-wrap gap-x-10 gap-y-0 justify-center`}
          >
            {buttons.map((item) => (
              <button
                key={item.name}
                className="bg-white dark:bg-dark-chocolate dark:border-dark-milk border-2 border-chocolate box-border rounded-2xl min-w-70 h-[30%] p-5 text-waffle dark:text-dark-milk"
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
            ))}
          </div>
        </Background>
        <Modal
          handler={isShow.handler}
          purpose={isShow.purpose}
          isShow={{ isShow, setIsShow }}
        />
      </main>
      <Footer></Footer>
    </>
  );
}

export default AdminPage;
