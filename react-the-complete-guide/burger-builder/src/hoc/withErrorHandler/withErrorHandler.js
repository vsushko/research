import React, { useState, useEffect } from 'react';
import Aux from '../Aux/Aux';
import Modal from '../../components/UI/Modal/Modal';

const withErrorHandler = (WrappedComponent, axios) => {
  return props {

    
    state = {
      error: null
    }

    componentWillMount() {
      this.reqInterceptor = axios.interceptors.request.use(req => {
        this.setState({ error: null });
        return req;
      });
      this.resInterceptor = axios.interceptors.response.use(res => res, error => {
        this.setState({ error: error });
      });
    }

    componentWillUnmount() {
      axios.interceptors.request.eject(this.reqInterceptor);
      axios.interceptors.request.eject(this.resInterceptor);
    }

    errorConfirmedHandler = () => {
      this.setState({ error: null });
    }

    return (
      <Aux>
        <Modal show={this.state.error}
          modalClosed={this.errorConfirmedHandler}>
          {this.state.error ? this.state.error.message : null}
        </Modal>
        <WrappedComponent {...this.props} />
      </Aux>
    );
  }
}

export default withErrorHandler;