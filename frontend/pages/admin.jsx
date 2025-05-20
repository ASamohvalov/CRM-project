import { useEffect } from "react";

function AdminPage() {
  useEffect(()=>{document.title = "Админ панель"},[])
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
    console.log("s");
  }

  async function subHand2(e) {
    const accessToken = localStorage.getItem("accessToken");
    e.preventDefault();
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
      console.log(b);
    } catch (e) {
      console.log(e);
    }
  }

  return (
    <form
      onSubmit={(e) =>
        subHand(
          e,
          document.getElementById("w").value,
          document.getElementById("l").value
        )
      }
    >
      <input type="text" id="w" placeholder="name" className="mr-10 bg-white" />
      <input type="text" id="l" placeholder="desc" className="mr-10 bg-white" />
      <button type="submit" className="bg-white">
        Отправить
      </button>
      <button className="bg-white" onClick={subHand2}>
        Отправить
      </button>
    </form>
  );
}

export default AdminPage;
