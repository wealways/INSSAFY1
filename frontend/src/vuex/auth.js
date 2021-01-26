import * as authApi from '../api/auth';

export default {
  namespaced: true,
  state: {
    token: null,
    email: '',
  },
  mutations: {
    setToken(state, token) {
      state.token = token;
    },
    setEmail(state, email) {
      state.email = email;
    },
  },
  actions: {
    async login(context, { email, password }) {
      try {
        const response = await authApi.login(email, password);
        if (response.status === 200) {
          context.commit('setToken', response.data.data);
          context.commit('setEmail', email);
        }
        return response;
      } catch (error) {
        alert('이메일 또는 비밀번호 불일치!');
        return error;
      }
    },
    //promise 형태 사용
    login2(context, { email, password }) {
      authApi
        .login(email, password)
        .than((response) => {
          if (response.state === 200) {
            context.setToken('setToken', response.data.data);
          }
        })
        .catch((error) => {
          console.log(error);
          alert('이메일 또는 비밀번호 불일치!');
        });
    },
  },
};
