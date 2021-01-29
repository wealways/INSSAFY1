import axios from 'axios';
import * as authApi from '../api/auth';

// const enhanceAccessUser = () => {
//   const { user } = localStorage;
//   if (!user) {
//     return (axios.defaults.headers.common['Authorization'] = `Bearer ${user.token}`);
//   }
// };
// enhanceAccessUser();

//initialized
const INIT_USER = () => {
  return {
    token: localStorage.getItem('token'),
    userId: localStorage.getItem('userId'),
    email: localStorage.getItem('email'),
    nickname: localStorage.getItem('nickname'),
  };
};

export default {
  namespaced: true,
  state: {
    user: INIT_USER(),
  },
  mutations: {
    setToken(state, token) {
      state.user.token = token;
    },
    setId(state, id) {
      state.user.userId = id;
    },
    setNickname(state, nickname) {
      state.user.nickname = nickname;
    },
    setEmail(state, email) {
      state.user.email = email;
    },
    //로그인 시, 유저정보를 payload 형태로 set하고 localStorage에 저장
    setUser(state, payload) {
      state.user = payload;
      //로컬 저장
      localStorage.token = state.user.token;
      localStorage.userId = state.user.userId;
      localStorage.email = state.user.email;
      localStorage.nickname = state.user.nickname;
    },
    setLogoutState(state) {
      //로컬 삭제
      localStorage.clear();
      state.user = INIT_USER();
    },
  },
  actions: {
    async login(context, { email, password }) {
      try {
        const response = await authApi.login(email, password);
        console.log(response);
        //로그인 성공 && 인증 완료
        if (response.data.message === 'SUCCESS') {
          // context.commit('setToken', response.data.auth_token);
          // context.commit('setId', response.data.user.user_id);
          // context.commit('setEmail', response.data.user.user_email);
          // context.commit('setNickname', response.data.user.user_nickname);
          context.commit('setUser', {
            token: response.data.auth_token,
            userId: response.data.user_id,
            email: response.data.user_email,
            nickname: response.data.user_nickname,
          });

          //이메일 인증을 완료하지 않은 유저의 경우 email 활용하여 링크생성
        } else if (response.data.message === 'NO_AUTH') {
          context.commit('setEmail', response.data.user.user_email);
        }
        return response;
      } catch (error) {
        alert('이메일 또는 비밀번호 불일치!');
        return error;
      }
    },

    logout({ commit }) {
      // axios.defaults.headers.common['Authorization'] = undefined;
      commit('setLogoutState');
    },
    // //promise 형태 사용
    // login2(context, { email, password }) {
    //   authApi
    //     .login(email, password)
    //     .than((response) => {
    //       if (response.state === 200) {
    //         context.setToken('setToken', response.data.data);
    //       }
    //     })
    //     .catch((error) => {
    //       console.log(error);
    //       alert('이메일 또는 비밀번호 불일치!');
    //     });
    // },
  },
};
