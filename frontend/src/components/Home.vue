<template>
  <v-container>
    <v-layout justify-center v-if="validUser">
      <GoogleMap></GoogleMap>
    </v-layout>
    <v-card-title v-else>
      <h1 class="hello">Hello~ We are Daldalcodal</h1>
    </v-card-title>
  </v-container>
</template>

<script>
import GoogleMap from "./GoogleMap.vue"

  export default {
    name:"home",
    components: {
      GoogleMap
    },
    mounted () {
      console.log(sessionStorage)
      if(sessionStorage.length != 0) {
        this.validUser = true;
      } else {
        this.validUser = false;
      }
      this.$eventBus.$on('validUser', function(valid) {
        this.validUser = valid;
      })
    },
    data () {
      return {
        validUser:false
      }
    },
    methods: {
      searchLocation: function() {
        console.log("mapOK")
      }
    }
  }
</script>
