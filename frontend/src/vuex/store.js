//기본 셋팅
import Vue from 'vue';
import Vuex from 'vuex';
//vuex 분할
import getters from './getters';
import actions from './actions';
import mutations from './mutations';

//api 작업 구현부
import auth from './auth';
import error from './error';

Vue.use(Vuex);

//initialized
const SEARCH_STATE = () => {
  return {
    filters: [],
    keyword: '',
  };
};

const state = {
  searchState: SEARCH_STATE(),
  toastActive: false,
};

export default new Vuex.Store({
  state,
  mutations,
  getters,
  actions,
  modules: {
    auth,
    error,
  },
});
