export default {
  //userinfo
  getEmail: function(state) {
    return state.auth.user.email;
  },
  getToken: function(state) {
    return state.auth.user.token;
  },
  getUser: function(state) {
    return state.auth.user;
  },

  //searchState
  getSearchStateFilters: function(state) {
    return state.searchState.filters;
  },

  //Toast
  getToastActive: function(state) {
    return state.toastActive;
  },
  getToastType: function(state) {
    return state.toastType;
  },
};
