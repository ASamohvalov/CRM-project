function Logout(){
    localStorage.clear();
}

async function getUserData({setUserData, router}) {
      const accessToken = localStorage.getItem("accessToken");
      try{
        const getData = await fetch(
        "http://localhost:8080/api/employee/get_employee_data",
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
      }catch(e){
        router.push('/login');
      }}

export {Logout, getUserData}