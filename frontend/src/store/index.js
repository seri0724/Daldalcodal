import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

const resourceHost = 'http://192.168.1.61:9021'

const enhanceAccessToeken = () => {
  const {accessToken} = sessionStorage
  if (!accessToken) return
  axios.defaults.headers.common['Authorization'] = `Bearer ${accessToken}`;
}
enhanceAccessToeken()

export default new Vuex.Store({
  state: {
    accessToken: null
  },
  getters: {
    isAuthenticated (state) {
      state.accessToken = state.accessToken || sessionStorage.accessToken
      return state.accessToken
    }
  },
  mutations: {
    LOGIN (state, {accessToken}) {
      state.accessToken = accessToken
      sessionStorage.accessToken = accessToken
    },
    LOGOUT (state) {
      state.accessToken = null
      delete sessionStorage.accessToken
    }
  },
  actions: {
    LOGIN ({commit}, {email, password}) {
      return axios.post(`${resourceHost}/login`, {email, password})
        .then(({data}) => {
          commit('LOGIN', data)
          axios.defaults.headers.common['Authorization'] = `Bearer ${data.accessToken}`;
        })
    },
    LOGOUT ({commit}) {
      axios.defaults.headers.common['Authorization'] = undefined
      commit('LOGOUT')
    },
  }
})
