export default {
  //setting searchState
  setSearchKeyword(state, keyword) {
    state.searchState.keyword = keyword;
  },
  setSearchFilters(state, filters) {
    state.searchState.filters = filters;
  },
  // setSearchVisible(state, visible) {
  //   state.searchState.visible = visible;
  // },
  setSearchState(state, payload) {
    state.searchState = payload;
  },

  //Toast
  setToastTogle(state) {
    state.toastActive = !state.toastActive;
  },
  setToastType(state, typeName) {
    if (typeName == 'search') {
      state.toastType.search = true;
      state.toastType.myinfo = false;
    } else if (typeName == 'myinfo') {
      state.toastType.search = false;
      state.toastType.myinfo = true;
    }
  },

  //comment
  CREATE_COMMENT(state,commentItem) {
    state.comments.push(commentItem)
  },

  //post
  CREATE_POST(state,postItem){
    state.posts.push(postItem)
  },
  POST_LIKE(state,flagLikeItem){

    // 지금은 api를 안쓰고 있으니까 index를 활용해서 find를 하고 있어요.
    // 그리고 이 방식은 현재 버그가 존재합니다.
    // 차후에 api를 가져오게 된다면 쉽게 post_id를 활용해서 데이터를 수정할 수 있을거에요. 
    
    const idx = flagLikeItem.post_id-1
    if(flagLikeItem.flagLike){
      state.posts[idx].post_like = state.posts[idx].post_like +1
    }else{
      state.posts[idx].post_like = state.posts[idx].post_like -1
    }
  }
};
