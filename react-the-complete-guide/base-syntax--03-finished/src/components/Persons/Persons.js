import React, { Component } from 'react';
import Person from './Person/Person';

class Persons extends Component {

  // static getDerivedStateFromProps(props, state) {
  //   console.log('[App.js] getDerivedStateFromProps', props)
  //   return state;
  // }

  // componentWillReceiveProps() {
  //   console.log('Persons.js: componentWillReceiveProps');
  // }

  shouldComponentUpdate(nextProps, nextState) {
    console.log('Persons.js: shouldComponentUpdate');
    return true;
  }

  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log('Persons.js: getSnapshotBeforeUpdate');
    return { message: 'Snapshot!' };
  }

  componentWillUpdate() {
    console.log('Persons.js: componentWillUpdate ')
  }
 
  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log('Persons.js: componentDidUpdate');
    console.log(snapshot)
  }

  render() {
    console.log('[Persons.js] rendering...');

    return this.props.persons.map((person, index) => {
      return (
        <Person
          click={() => this.props.clicked(index)}
          name={person.name}
          age={person.age}
          changed={event => this.props.changed(event, person.id)}
        />
      )
    })
  }
}

export default Persons;
