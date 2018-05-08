<template>
  <v-container>
    <div id="login" style="width:450px; display:inline-block;">
      <br></br>
        <h1>Login</h1>
      <br></br>
        <v-form v-model="valid" ref="form">
          <v-text-field label="ID (8~14자리(영문,숫자))" v-model="id" :rules="idRules" :counter="14"></v-text-field>
          <v-text-field label="Password (8~14자리(영문,숫자,특수문자))" type="password" v-model="pw" :rules="pwRules" :counter="14"></v-text-field>
          <v-btn @click="login" :disabled="!valid">OK</v-btn>
        </v-form>
      <pre>{{$data}}</pre>
    </div>
  </v-container>
</template>

<script>
  export default {
    data: () => ({
      valid:false,
      id:'',
      idRules: [
        v => !!v || '아이디를 작성해주세요.',
        v => v.length >= 8 || '8자리이상 입력해주세요.',
        v => v.length <= 14 || '14자리이하 입력해주세요.',
        v => /^[A-Za-z0-9]*$/.test(v) || '영문과 숫자만 입력해주세요.'
      ],
      pw:'',
      pwRules: [
        v => !!v || '비밀번호를 작성해주세요.',
        v => v.length >= 8 || '8자리이상 입력해주세요.',
        v => v.length <= 14 || '14자리이하 입력해주세요.',
        v => /^(?=.*[a-zA-Z])(?=.*[`~!@#$%^&*+=-_()])(?=.*[0-9]).{8,14}$/.test(v) || '영문과 숫자와 특수문자를 입력해주세요.'
      ],
      lat:0.0,
      lng:0.0
    }),
    methods: {
      getLocation(callback, id, pw) {
        navigator.geolocation.getCurrentPosition(function(position) {
          var lat  = position.coords.latitude;
          var lng = position.coords.longitude;
          callback(id, pw, lat, lng);
        })
      },
      login () { // 클릭 : 로그인 완료
        this.getLocation(this.doLogin, this.id, this.pw)
      },
      doLogin(p_id, p_pw, p_lat, p_lng) {
        if(this.$refs.form.validate()) {
          this.lat = p_lat;
          this.lng = p_lng;
          this.$axios.post('/api/user/login', {
            id:p_id,
            pw:p_pw,
            lat:p_lat,
            lng:p_lng
          }) .then((response) => {
              console.log('loginOK')
              this.result = response.data
              console.log(this.result)
              if(this.result) {
                this.$router.push('home')
              } else {
                 console.log("error")
              }
            })
          }
        }
      }
    }
</script>
