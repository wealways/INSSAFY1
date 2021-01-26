import axios from 'axios';
//토큰 활용을 위한 import
import store from '../vuex/store';

// axios 인스턴스를 만들 때 구성 기본 값 설정
const instance = axios.create({
  baseURL: 'http://localhost:8080/',
});

//request 요청 전에 header에 토큰값을 넣기 위한 interceptor
instance.interceptors.request.use(function(config) {
  if (store.state.auth.token !== null) {
    config['headers'] = {
      Authorization: `Bearer ${store.state.auth.token}`,
    };
  }
  return config;
});

//catch 안에처 처리할 error 메시지 interceptor
instance.interceptors.response.use(
  //status === 200 일 때, validationerror를 빈 json 상태로 변경
  function(response) {
    console.log('done');
    store.commit('error/setErrorMessages', {});
    return response;
  },
  //status === 422(검증 에러)일 때 validationError 값 없데이트
  //422가 아닐 경우 error vue.js에서 fetch로 받을 수 있도록 reject 처리
  function(errors) {
    console.log(`errors: ${errors}`);
    if (errors.response.status === 422 || errors.response.status === 204) {
      store.commit('error/setErrorMessages', errors.response.data.data);
    } else {
      return Promise.reject(errors);
    }
  }
);

export default instance;

/*
.create() 메서드를 사용해 사용자 정의 구성을 사용하는
axios 인스턴스를 생성할 수 있다.

  //아래는 예시
  const instance = axios.create({
    baseURL: 'https://some-domain.com/api/',
    headers: { 'X-Custom-Header': 'foobar' },
    timeout: 1000,
  });
*/
