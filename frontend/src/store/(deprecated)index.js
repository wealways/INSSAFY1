import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

Vue.use(Vuex);

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default new Vuex.Store({
  state: {
    accessToken: null,
    email: "ssafy@ssafy.com",
    nickname: "ssafy"
  },
  getters: {
    getEmail(state) {
      return state.email;
    },
    getNickname(state) {
      return state.nickname;
    }
  },
  mutations: {},
  actions:{
    
  },
  modules:{}
});
