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
  getSearchState: function(state) {
    return state.searchState;
  },
};
