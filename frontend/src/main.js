// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'

// 라우터 객체에 등록할 컴포넌트 불러오기
import Home from './components/Home.vue'
import Login from './components/Login.vue'
import Join from './components/Join.vue'
import Write from './components/Write.vue'
import Route from './components/Route.vue'
import Myroute from './components/Myroute.vue'

// Google map api
import * as VueGoogleMaps from "vue2-google-maps";

Vue.use(VueGoogleMaps, {
  load: {
    key:"AIzaSyBkxRyjwMN9B-jjb6Znb5Romo-KBDB3hKI",
    libraries:"places" // necessary for places input
  }
})

// Axios
import axios from 'axios'
Vue.prototype.$axios = axios

// Vuetify
import Vuetify from 'vuetify'
Vue.use(Vuetify)
import 'vuetify/dist/vuetify.min.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'

// VueRouter
Vue.use(VueRouter)

// EventBus
Vue.prototype.$eventBus = new Vue()

Vue.config.productionTip = false

// 사용할 라우터 객체등록
const routes = [
    {name:'home', path:'/', component:Home},
    {name:'login', path:'/user/login', component:Login},
    {name:'join', path:'/user/join', component:Join},
    {name:'write', path:'/user/write', component:Write},
    {name:'route', path:'/user/route', component:Route},
    {name:'myroute', path:'/user/myroute', component:Myroute}
  ]

// 라우터 객체 생성
// history change
const router = new VueRouter({
    // base url, mode 설정
    // mode:'history',
    // base:'/',
    routes
})

/* eslint-disable no-new */
new Vue({
    el:'#app',
    router,
    template:'<App/>',
    components: {
      App
    }
})
