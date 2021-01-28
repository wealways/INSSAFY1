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
const PROBLEMS = () => [
  '시스템 기반 OO:OO까지 설문 완료(숫자만 입력)',
  '공가 내 규정으로 OOOOO 취득시 3일/월 허용',
  '6.복리후생(안전사고 대비 OOOOO 운영)',
  '2.생활수칙(OOO 운영)',
  '4.정보보안 규정 내에서 마지막 단어 OO',
];
const POPULAR = () => {};

const state = {
  //toast
  toastActive: false,
  toastType: {
    search: false,
    myinfo: false,
    email: false,
  },
  searchState: SEARCH_STATE(),
  comments: [{ user: '이름', comment: '댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글', date: '2021-01-28' }],

  //가입하기 인증 문제
  problems: PROBLEMS(),
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
