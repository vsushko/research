import React, { useState } from "react";
import "./App.css";
import Person from "./Person/Person";

const app = props => {

  const [personsState, setPersons] = useState({
    persons: [
      { name: "Max", age: 28 },
      { name: "Manu", age: 29 },
      { name: "Stephanie", age: 26 }
    ]
  });

  const switchNameHandler = (newName) => {
    setPersons({
      persons: [
        { name: newName, age: 28 },
        { name: "Manu", age: 29 },
        { name: "Stephanie", age: 27 }
      ]
    })
  };

  const nameChangeHandler = (event) => {
    setPersons({
      persons: [
        { name: 'Max', age: 28 },
        { name: event.target.value, age: 29 },
        { name: "Stephanie", age: 27 }
      ]
    })
  }

  const [otherState, setOtherState] = useState('some other value');
  console.log(personsState, otherState);

  const style = {
    backgroundColor: 'white',
    font: 'inherit',
    padding: '10px',
    border: '1px solid blue',
    cursor: 'pointer'
  }

  return (
    <div className="App">
      <h1>Hi, I'm a React App</h1>
      <button style={style} onClick={switchNameHandler.bind(this, "Vasiliy!")}>Switch name</button>
      <Person name={personsState.persons[0].name} age={personsState.persons[0].age} />
      <Person name={personsState.persons[1].name} age={personsState.persons[1].age}
        changed={nameChangeHandler}>My Hobbies: Racing</Person>
      <Person name={personsState.persons[2].name} age={personsState.persons[2].age}
        // not recommended to use
        click={() => switchNameHandler("Petya!")} />
    </div>
  );
}



export default app;
