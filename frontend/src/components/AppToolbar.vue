<template>
  <v-toolbar color="pink lighten-5" flat height="40px">
    <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
    <v-spacer></v-spacer>
    <div>
      <router-link to="/user/myroute" v-show="bell">
          <v-btn flat icon color="red">
            <v-icon>notifications_active</v-icon>
          </v-btn>
          <span>평가해주세요</span>
      </router-link>
      <router-link to="/user/login">
        <v-btn flat class="pink--text">로그인</v-btn>
      </router-link>
      <router-link to="/user/join">
        <v-btn flat class="pink--text">회원가입</v-btn>
      </router-link>
    </div>
      <v-navigation-drawer light temporary v-model="drawer" absolute height="300px" hide-overlay>
        <v-list class="pa-1">
          <v-list-tile avatar>
            <v-list-tile-avatar>
              <img src="http://blogfiles9.naver.net/MjAxODA0MTNfMTgz/MDAxNTIzNTkwMjk5OTQx.1c9D6p4qYLkYRs5MGpKx2GqiSSwpiNcplDBrm-8a16wg.d5jVm2d9NQOJnLtXBImKyF4xpflSXQt98M4aEzE0_5cg.PNG.bdh0070/Icon.png">
            </v-list-tile-avatar>
            <v-list-tile-content>
              <!-- nickname -->
              <v-list-tile-title>Sehee</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </v-list>
        <v-list class="pt-0" dense>
          <v-divider></v-divider>
          <v-list-tile v-for="item in items" :key="item.title">
            <v-list-tile-action>
              <v-icon>{{item.icon}}</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <router-link :to="item.link"><v-list-tile-title class="pink--text">{{item.title}}</v-list-tile-title></router-link>
            </v-list-tile-content>
          </v-list-tile>
        </v-list>
      </v-navigation-drawer>
  </v-toolbar>
</template>

<script>
  export default {
    data () {
      return {
        drawer:null,
        items: [
          {title:'코스추천받기', icon:'edit', link:'/user/write'},
          {title:'My코스', icon:'favorite', link:'/user/myroute'}
        ],
        bell:0
      }
    },
    mounted () {
      if(sessionStorage.length != 0) {
        this.bell = 1
      } else {
        this.bell = 0
      }
    }
  }
</script>
