import Vue from 'vue'
import Router from 'vue-router'

// Component
import Home from '@/components/Home'
import Login from '@/components/Login'
import Join from '@/components/Join'
import Write from '@/components/Write'
import Route from '@/components/Route'
import Myroute from '@/components/Myroute'

// Axios
import axios from 'axios'
Vue.prototype.$axios = axios

// Vuetify
import Vuetify from 'vuetify'
Vue.use(Vuetify)
import 'vuetify/dist/vuetify.min.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'

// Router
Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/',
      name:'Home',
      component:Home
    },
    {
      path:'/user/login',
      name:'Login',
      component:Login,
    },
    {
      path:'/user/join',
      name:'Join',
      component:Join
    },
    {
      path:'/user/write',
      name:'Write',
      component:Write
    },
    {
      path:'/user/route',
      name:'Route',
      component:Route
    },
    {
      path:'/user/myroute',
      name:'Myroute',
      component:Myroute
    }
  ],
  mode: 'history'
})
