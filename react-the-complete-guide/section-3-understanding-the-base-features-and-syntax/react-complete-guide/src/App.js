import React, { Component } from "react";
import "./App.css";
import Person from "./Person/Person";

class App extends Component {
  render() {
    return (
      <div className="App">
        <h1>Hi, I'm a React App</h1>
        <Person name="Max" age={Math.floor(Math.random() * 30)} />
        <Person name="Manu" age={Math.floor(Math.random() * 30)}>My Hobbies: Racing</Person>
        <Person name="Stephanie" age={Math.floor(Math.random() * 30)} />
      </div>
    );

    // return React.createElement(
    //   "div",
    //   null,
    //   React.createElement("h1", null, " Does this work now?")
    // );
  }
}

export default App;
