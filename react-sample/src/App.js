import React, { useState, useEffect } from 'react';
import axios from 'axios';

const initialEmployeeData = {};

const client = axios.create({
  baseURL: `http://${process.env.REACT_APP_BACKEND_HOST}`
});

const App = () => {

  const [employeeData, setEmployeeData] = useState(initialEmployeeData);

  const [inputEmployeeId, setInputEmployeeId] = useState('');

  const handleInputId = (e) => {
    setInputEmployeeId(e.target.value);
  };

  const submitSearch = async () => {
    client.get(`/spring-boot-aks/v1/employee/${inputEmployeeId}`)
      .then(response => {
        setEmployeeData(response.data);
      })
  };

  return (
    <div className="App">
      <header>
        <title>サンプル</title>
      </header>
      <div style={{textAlign: "center"}}>
        <div>
          <img src={`${process.env.PUBLIC_URL}/searchLogo.png`} width={170} height={156}alt="Logo" />
        </div>
        <div >
          従業員番号を入力してください:
        </div>
        <div>
          <input onChange={handleInputId}/>
          <button onClick={submitSearch}>検索</button>
        </div>
        <div>
          名前: {employeeData.full_name}
        </div>
        <div>
          詳細: {employeeData.description}
        </div>
      </div>
    </div>
  );

}

export default App;
