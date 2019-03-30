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

  const switchNameHandler = () => {
    setPersons({
      persons: [
        { name: "Vasiliy", age: 28 },
        { name: "Manu", age: 29 },
        { name: "Stephanie", age: 27 }
      ]
    })
  };

  const [otherState, setOtherState]= useState('some other value');
  console.log(personsState, otherState);

  return (
    <div className="App">
      <h1>Hi, I'm a React App</h1>
      <button onClick={switchNameHandler}>Switch name</button>
      <Person name={personsState.persons[0].name} age={personsState.persons[0].age} />
      <Person name={personsState.persons[1].name} age={personsState.persons[1].age}>
        My Hobbies: Racing
        </Person>
      <Person name={personsState.persons[2].name} age={personsState.persons[2].age} />
    </div>
  );
}



export default app;
