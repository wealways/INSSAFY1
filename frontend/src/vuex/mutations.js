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
};
