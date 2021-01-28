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
  },
  searchState: SEARCH_STATE(),

  // comment : user_id, post_id // comment_description, comment_date
  comments:[
    {comment_id:1,user:'이름',comment:'댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글',date:"2021-01-28"}
  ],
  // post : user_id, board_id // post_date, post_title, post_description, post_like, post_image, post_iframe, post_header, post_state
  posts:[
    {
      post_id:1,
      user:'이름', 
      post_title:"저희팀원들 짱이랍니다", 
      post_description:"다 똑똑박사들인가? 왜케 잘 하지...? 나만 잘하면 되겠다 :)",
      post_like:10,
      comment_count:1,
      post_date:"2021-01-28/22:53:35",
      image:''
    },
    {
      post_id:2,
      user:'coming', 
      post_title:"개발너무어렵다 때려치고싶다", 
      post_description:"라고 할뻔ㅎㅎ; 개발이 너무 좋아요",
      post_like:1,
      comment_count:1,
      post_date:"2021-01-28/23:40:32",
      image:''
    },
  ],

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
