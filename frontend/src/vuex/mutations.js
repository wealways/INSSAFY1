export default {
  //setting searchState
  setSearchKeyword(state, keyword) {
    state.searchState.keyword = keyword;
  },
  setSearchFilters(state, filters) {
    state.searchState.filters = filters;
  },
  setSearchVisible(state, visible) {
    state.searchState.visible = visible;
  },
  getSearchState(state, searchState) {
    state.searchState = searchState;
  },

  //comment
  CREATE_COMMENT(state,commentItem) {
    state.comments.push(commentItem)
  },
};
