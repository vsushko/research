import React, { Component } from 'react';
import { connect } from 'react-redux';

import CounterControl from '../../components/CounterControl/CounterControl';
import CounterOutput from '../../components/CounterOutput/CounterOutput';

import * as actionTyps from '../../store/actions';

class Counter extends Component {

  render() {
    return (
      <div>
        <CounterOutput value={this.props.ctr} />
        <CounterControl label="Increment" clicked={this.props.onIncrementCounter} />
        <CounterControl label="Decrement" clicked={this.props.onDecrementCounter} />
        <CounterControl label="Add 10" clicked={this.props.onAddCounter} />
        <CounterControl label="Subtract 15" clicked={this.props.onSubtractCounter} />
        <hr />
        <button onClick={() => this.props.onStoreResult(this.props.ctr)}>Store Result</button>
        <ul>
          {
            this.props.storedResults.map(strResult =>
              <li key={strResult.id} onClick={() => this.props.onDeleteResult(strResult.id)}>{strResult.value}</li>)
          }
        </ul>
      </div>
    );
  }
}

const mapStateToProps = state => {
  return {
    ctr: state.ctr.counter,
    storedResults: state.res.results
  };
};

const mapDispatchToProps = dispatch => {
  return {
    onIncrementCounter: () => dispatch({ type: actionTyps.INCREMENT }),
    onDecrementCounter: () => dispatch({ type: actionTyps.DECREMENT }),
    onAddCounter: () => dispatch({ type: actionTyps.ADD, val: 10 }),
    onSubtractCounter: () => dispatch({ type: actionTyps.SUBTRACT, val: 15 }),
    onStoreResult: (result) => dispatch({ type: actionTyps.STORE_RESULT, result: result }),
    onDeleteResult: (id) => dispatch({ type: actionTyps.DELETE_RESULT, resultElId: id })
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(Counter);