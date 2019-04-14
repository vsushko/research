import axios from 'axios';

const instance = axios.create({
  baseURL: 'https://burger-builder-acf8d.firebaseio.com/'
});

export default instance;