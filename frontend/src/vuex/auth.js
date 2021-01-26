import * as authApi from '../api/auth';

export default {
  namespaced: true,
  state: {
    user: {
      token: '',
      userId: '',
      email: '',
      nickname: '',
    },
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
  },
  actions: {
    async login(context, { email, password }) {
      try {
        const response = await authApi.login(email, password);
        if (response.data.message === 'success') {
          context.commit('setToken', response.data.auth_token);
          context.commit('setId', response.data.user.user_id);
          context.commit('setEmail', response.data.user.user_email);
          context.commit('setNickname', response.data.user.user_nickname);
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
