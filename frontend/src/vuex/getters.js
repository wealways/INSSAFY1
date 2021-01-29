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
  getDomain: function(state) {
    let email = state.auth.user.email;
    if (email == null) return null;
    let domain = email.substring(email.indexOf('@') + 1, email.length);
    console.log(domain);
    return domain;
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
