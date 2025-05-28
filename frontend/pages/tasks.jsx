import { useEffect, useState } from "react";
import { Aside, Footer, Header, Task, Background } from "../components/";
import { getUserData } from "../logic";
import { useRouter } from "next/router";

function TaskListPage() {
  const [userData, setUserData] = useState({});
  const router = useRouter();

  useEffect(() => {
    document.title = "Задачи";
    getUserData({setUserData, router})
  }, []);
  return (
    <>
      <Header title="Задачи" userData={userData} />
      <Aside />
      <main className="lg:pl-20 px-6 pt-32 h-[100vh]">
        <Background>
          <Task header={"Пипська"} points={16}>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam
            fermentum, odio eget tristique cursus, risus augue convallis enim,
            vitae ornare sapien...Lorem ipsum dolor sit amet, consectetur
            adipiscing elit. Nullam fermentum, odio eget tristique cursus, risus
            augue convallis enim, vitae ornare sapien...
          </Task>
        </Background>
      </main>
      <Footer />
    </>
  );
}

export default TaskListPage;