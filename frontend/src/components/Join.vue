<template>
  <v-container>
    <div id="join" style="width:450px; display:inline-block;">
      <br></br>
        <h1>Join</h1>
      <br></br>
        <v-form v-model="valid" ref="form">
          <v-text-field label="Email (example@gmail.com)" v-model="email" :rules="emailRules"></v-text-field>
          <v-text-field label="ID (8~14자리(영문,숫자))" ref= "id" v-model="id" :rules="idRules" :counter="14"></v-text-field>
          <v-btn outline @click="checkid">Overlap Check</v-btn>
          <v-text-field label="Nickname (2~8자리(영문 OR 한글))" v-model="nickname" :rules="nicknameRules" :counter="8"></v-text-field>
          <v-text-field label="Password (8~14자리(영문,숫자,특수문자))" type="password" v-model="pw" :rules="pwRules" :counter="14"></v-text-field>
          <v-text-field label="Password Check" type="password" v-model="validpw" :rules="pwConfirmRule" :counter="14"></v-text-field>
          <v-slider label="Age" min="1930" max="2020" track-color="pink lighten-2" thumb-label thumb-color="pink lighten-2" v-model="age" :value="age"></v-slider>
          <v-btn @click="join" :disabled="!valid">OK</v-btn>
        </v-form>
      <pre>{{$data}}</pre>
    </div>
  </v-container>
</template>

<script>
  export default {
    data: () => ({
         valid:false,
         email:'',
         emailRules: [
           v => !!v || '이메일을 작성해주세요.',
           v => /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/.test(v) || '이메일형식에 맞게 입력해주세요.'
         ],
         id:'',
         idRules: [
            v => !!v || '아이디를 작성해주세요.',
            v => v.length >= 8 || '8자리이상 입력해주세요.',
            v => v.length <= 14 || '14자리이하 입력해주세요.',
            v => /^[A-Za-z0-9]*$/.test(v) || '영문과 숫자만 입력해주세요.'
         ],
         nickname:'',
         nicknameRules: [
           v => !!v || '닉네임을 작성해주세요.',
           v => v.length >= 2 || '2자리이상 입력해주세요.',
           v => v.length <= 8 || '8자리이하 입력해주세요.',
           v => /^[가-힣a-zA-Z]+$/.test(v) || '영문 또는 한글만 입력해주세요.'
         ],
         pw:'',
         pwRules: [
           v => !!v || '비밀번호를 작성해주세요.',
           v => v.length >= 8 || '8자리이상 입력해주세요.',
           v => v.length <= 14 || '14자리이하 입력해주세요.',
           v => /^(?=.*[a-zA-Z])(?=.*[`~!@#$%^&*+=-_()])(?=.*[0-9]).{8,14}$/.test(v) || '영문과 숫자와 특수문자를 입력해주세요.'
         ],
         validpw:'',
         pwConfirmRule: [
           v => !!v || '비밀번호를 확인해주세요.',
           v => v.length >= 8 || '8자리이상 입력해주세요.',
           v => v.length <= 14 || '14자리이하 입력해주세요.',
           v => v == document.forms[0][5]._value || '비밀번호가 다릅니다.'
         ],
         age:0
       }),
        methods: {
          checkid () { // 아이디 중복체크
            if(this.$refs.id.validate()) {
              this.$axios.post('/api/user/overlap', {
                joinidcheck:this.id
              }).then((response) => {
                  console.log('joinidcheckOK')
                  this.result = response.data
                  console.log(this.result)
                  if(this.result) {
                    alert("사용할 수 있는 아이디입니다.")
                  } else {
                    alert("사용할 수 없는 아이디입니다.")
                  }
              })
            }
          },
          join () { // 클릭 : 회원가입 완료
            if (this.$refs.form.validate()) {
              this.$axios.post('/api/user/join', {
                email:this.email,
                id:this.id,
                nickname:this.nickname,
                pw:this.pw,
                age:this.age
              }).then((response) => {
                  console.log('joinOK')
                  this.result = response.data
                  console.log(this.result)
                  if(this.result) {
                    this.$router.push("login")
                  } else {
                    console.log('error')
                  }
              })
            }
          }
        }
      }
</script>
