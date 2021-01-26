export default {
  //userinfo
  getEmail: function(state) {
    return state.auth.email;
  },
  getToken: function(state) {
    return state.auth.token;
  },

  //searchState
  getSearchState: function(state) {
    return state.searchState;
  },
};
