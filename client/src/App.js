import './App.css';
import { useEffect, useState } from 'react';
import { getAllAncestors, getAllBirths, postAncestor, postEvent } from './services/InternalServices';

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

  const handleAncestorSubmit = (event) => {
    event.preventDefault()
    postAncestor({
      forename: forename,
      surname: surname,
      gender: gender
    })
    setForename("")
    setSurname("")
    setGender("")
  }

  useEffect(() => {
    getAllAncestors().then((results) => {
      setAncestors(results)
    })
  }, [])

  const ancestorList = ancestors.map((ancestor) => {
    return (
      <p key={ancestor.id} value={ancestor.id}>{ancestor.forename} {ancestor.surname}, {ancestor.gender}</p>
    );
  });

  const [eventType, setEventType] = useState("")
  const [date, setDate] = useState("")
  const [location, setLocation] = useState("")
  const [citation, setCitation] = useState("")
  const [births, setBirths] = useState([])

  const handleEventTypeChange = (event) => {
    setEventType(event.target.value)
  }
  const handleDateChange = (event) => {
    setDate(event.target.value)
  }
  const handleLocationChange = (event) => {
    setLocation(event.target.value)
  }
  const handleCitationChange = (event) => {
    setCitation(event.target.value)
  }

  const handleEventSubmit = (event) => {
    event.preventDefault()
    postEvent({
      type: eventType,
      date: date,
      location: location,
      citation: citation
    })
    setEventType("")
    setDate("")
    setLocation("")
    setCitation("")
  }

  useEffect(() => {
    getAllBirths().then(results => { setBirths(results) })
  }, [])

  const birthsList = births.map((birth) => {
    return (
      <li key={birth.id} value={birth.id}>{birth.date} {birth.location}, {birth.citation}</li>
    );
  });

  return (
    <>
      <h1>Ancestors</h1>
      <div className="ancestorForm">
        <form onSubmit={handleAncestorSubmit}>
          <label>Forename:
            <input className="forename" type="text" onChange={handleFornameChange} value={forename} required />
          </label>
          <label>Surname:
            <input className="surname" type="text" onChange={handleSurnameChange} value={surname} required />
          </label>
          <label>Gender:
            <select className="gender" type="select" onChange={handleGenderChange} value={gender} required>
              <option value="">Please select</option>
              <option value="MALE">Male</option>
              <option value="FEMALE">Female</option>
            </select>
          </label>
          <input className="submit" type="submit" value="Submit" />
        </form>
      </div>
      <div className="ancestorsList">
        <h2>Ancestors</h2>
        {ancestorList}
      </div>
      <div>
        <form className="eventForm" onSubmit={handleEventSubmit}>
          <label>
            Event type:
            <select value={eventType} onChange={handleEventTypeChange} required>
              <option value="">Please select</option>
              <option value="BIRTH">Birth</option>
              {/* <option value="MARRIAGE">Marriage</option> */}
              {/* <option value="CENSUS">Census</option> */}
              <option value="DEATH">Death</option>
              {/* <option value="OTHER">Other</option> */}
            </select>
          </label>
          <label>Date:
            <input type="date" value={date} onChange={handleDateChange} required></input>
          </label>
          <label>
            Location:
            <input type="text" value={location} onChange={handleLocationChange} required />
          </label>
          <label>
            Citation:
            <input type="text" value={citation} onChange={handleCitationChange} required />
          </label>
          <input type="submit" />
        </form>
      </div>
      <div className="birthsList">
        <h2>Births</h2>
        <ul>{birthsList}
        </ul>
      </div>

    </>
  );
}

export default App;
