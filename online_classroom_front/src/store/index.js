import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    
    // If token doesn't exist, return an empty string
    token : localStorage.getItem("token") || ''
  },

  // https://vuex.vuejs.org/zh/guide/mutations.html
  mutations: {
    SET_TOKEN : (state, token) => {
      state.token = token
    }
  },

  // https://vuex.vuejs.org/zh/guide/actions.html
  // To invoke the methods of actions in Vue, 
  // using this.$store.dispatch
  actions: {
    setToken(context, token) {
      context.commit('SET_TOKEN', token)
    },

    clearToken(context) {
      context.commit('SET_TOKEN', '')
    }
  },
  modules: {
  }
})
