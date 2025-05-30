import * as env from "./env";

function Logout() {
  localStorage.clear();
}

async function getUserData({ setUserData, router, setIsLoading }) {
  const accessToken = localStorage.getItem("accessToken");
  try {
    const getData = await fetch(
      `${env.BACKEND_API_URL}/employee/get_employee_data`,
      {
        method: "GET",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          Authorization: `Bearer ${accessToken}`,
        },
      }
    );
    const DataJSON = await getData.json();
    setUserData(DataJSON);
    setIsLoading(false);
  } catch (e) {
    router.push("/login");
  }
}

export { Logout, getUserData };
