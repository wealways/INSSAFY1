//validation erro auth 관련 공통 코드 처리(유지보수를 위해)
import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8080/'
});

export default instance;