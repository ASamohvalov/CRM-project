import { useRouter } from "next/router";
import { useEffect, useState } from "react";
import { Aside, Header, Background, Modal, Footer } from "../components";
import { getUserData } from "../logic";
import * as env from "../env";

function CoursePage() {
  const [userData, setUserData] = useState({});
  const [isLoading, setIsLoading] = useState(true);
  const [isShow, setIsShow] = useState({
    status: false,
    purpose: "",
    handler: "",
  });
  const router = useRouter();
  useEffect(() => {
    document.title = "Панель менджера";
    getUserData({ setUserData, setIsLoading, router });
  }, []);
  const buttons = [
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
    }
  ];

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
      <Header title="Панель менджера" userData={userData} isLoading={isLoading} />
      <Aside userRole={userData.rolesName} />
      <main className="lg:pl-20 px-6 pt-32 h-[100vh]">
        <Background>
          <div
            className={`w-[100%] h-[100%] bg-milk dark:bg-dark-coffee rounded-2xl p-10 flex flex-wrap gap-x-10 gap-y-0 justify-center overflow-y-scroll list`}
          >
            {buttons.map((item) => (
              <button
                key={item.name}
                className="bg-white mb-3 dark:bg-dark-chocolate dark:border-dark-milk border-2 border-chocolate box-border rounded-2xl min-w-70 h-[30%] p-5 text-waffle dark:text-dark-milk"
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

export default CoursePage;
