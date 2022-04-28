export const state = () => ({
  user: null
});

export const mutations = {
  set(state, user) {
    state.user = user;
  },

  remove(state) {
    state.user = null;
  },

  get(state) {
    return state.user;
  }
}
