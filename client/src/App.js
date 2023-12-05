import './App.css';
import { useEffect, useState } from 'react';
import { getAllAncestors, postAncestor } from './services/InternalServices';

function App() {

  const [forename, setForename] = useState("")
  const [surname, setSurname] = useState("")
  const [gender, setGender] = useState("")
  const [ancestors, setAncestors] = useState([])

  const handleFornameChange = (event) => {
    setForename(event.target.value)
  }
  const handleSurnameChange = (event) => {
    setSurname(event.target.value)
  }
  const handleGenderChange = (event) => {
    setGender(event.target.value)
  }

  const handleSubmit = (event) => {
    event.preventDefault()
    postAncestor({
      forename: forename, 
      surname : surname, 
      gender : gender
    })
    setForename("")
    setSurname("")
    setGender("")
  }

  useEffect( () => {
    getAllAncestors().then((results) => {
      setAncestors(results)
    })
  }, [])

  const ancestorList = ancestors.map((ancestor) => {
    return (
        <p key={ancestor.id} value={ancestor.id}>{ancestor.forename} {ancestor.surname}, {ancestor.gender}</p>
    );
});

  return (
    <>
      <div className="ancestorForm">
        <form onSubmit={handleSubmit}>
          <label>Forename:
            <input className="forename" type="text" onChange={handleFornameChange} value={forename} required/>
          </label>
          <label>Surname:
            <input className="surname" type="text" onChange={handleSurnameChange} value={surname} required/>
          </label>
          <label>Gender:
            <select className="gender" type="select" onChange={handleGenderChange} value={gender} required>
              <option value="">Please select</option>
              <option value="MALE">Male</option>
              <option value="FEMALE">Female</option>
            </select>
          </label>
          <input className="submit" type="submit" value="Submit"/>
        </form>
      </div>
      <div className="ancestorsList">
        {ancestorList}
      </div>
    </>
  );
}

export default App;
