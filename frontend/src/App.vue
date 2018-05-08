<template>
  <div id="app">
    <app-toolbar></app-toolbar>
      <div class="visual">
        <router-link :to="{name:'home'}"><img style="width:250px" class="logo" src="./assets/logo.png"></router-link>
      </div>
      <v-app>
        <router-view></router-view>
      </v-app>
  </div>
</template>

<script>
import AppToolbar from './components/AppToolbar'

  export default {
    name:'app',
    components: {
      AppToolbar
    }
  }
</script>

<style>
/* font */
/* @import url('https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Poor+Story'); */

/* reset */
/* html, body {width:100%; height:100%}
body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,form,fieldset,p,button {margin:0;padding:0}
a {text-decoration:none; cursor:default}
img {vertical-align:top}
i,em,address {font-style:normal}
label,button {cursor:pointer}
button {margin:0;padding:0}
img,fieldset,iframe {border:0 none}
li {list-style:none}
input,select,button {vertical-align:middle}
hr{display:none}
legend{*width:0}
table{border-collapse:collapse;border-spacing:0}
input {outline-style:none}
input::-ms-clear{display:none}
.clf:after {content:""; display:block; clear:both} */

/* userArea */
/* html {font-family:'Poor Story' !important}
body {background:#ffffff; font-family:'Poor Story' !important}
.userArea {position:absolute; top:50px; right:100px}
.userArea li {float:left; margin-right:50px}
.userArea li > a {padding:10px 30px; border-radius:20px; color:#ffffff !important; text-decoration:none !important; display:block; cursor:pointer; font:20px 'Poor Story', sans-serif}
.userArea li:first-child > a {background:#f09e9e}
.userArea li:last-child {margin-right:0}
.userArea li:last-child > a {background:#c688e4} */

/* contents */
.visual {background:#FCE4EC; width:100% !important; margin-top:-20px; padding:0 0 15px 0}

/* registerform size */
/* .inputForm {width:20%; margin:0 auto} */

/* serif sans-serif monospace cursive fantasy */
#app {
  font-family:fantasy;
  -webkit-font-smoothing:antialiased;
  -moz-osx-font-smoothing:grayscale;
  text-align:center;
  color:#f40747;
}
</style>
