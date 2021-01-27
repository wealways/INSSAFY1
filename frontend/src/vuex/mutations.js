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

  //set Toast
  setToastTogle(state) {
    state.toastActive = !state.toastActive;
  },
};
