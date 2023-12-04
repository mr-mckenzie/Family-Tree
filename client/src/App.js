import './App.css';
import { useState } from 'react';
import { postAncestor } from './services/InternalServices';

function App() {

  const [forename, setForename] = useState("")
  const [surname, setSurname] = useState("")
  const [gender, setGender] = useState("")
  const [ancestor, setAncestor] = useState({})

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
    setAncestor({
      forename : forename,
      surname : surname,
      gender : gender
    })
    postAncestor(ancestor)
  }

  return (
    <div className="App">
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
  );
}

export default App;
