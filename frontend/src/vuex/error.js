export default {
  namespaced: true,
  state: {
    errorMessages: {},
  },
  mutations: {
    setErrorMessages(state, error) {
      state.errorMessages = error;
    },
  },
};
