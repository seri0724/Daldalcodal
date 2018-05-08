<template>
  <v-app>
    <v-container>
      <div id="write" style="width:450px; display:inline-block;">
        <br></br>
          <h1>Write</h1>
        <br></br>
        <v-layout row wrap justify-center>
          <v-flex xs12>
            <v-form v-model="valid" ref="form">
              <!-- 구분 -->
              <v-layout>
                <v-flex>
                  <p>Division</p>
                    <v-btn color="purple" @click="">연인</v-btn>
                    <v-btn color="blue">남남</v-btn>
                    <v-btn color="pink">여여</v-btn>
                    <v-btn color="orange">가족</v-btn>
                    <br></br>
                </v-flex>
              </v-layout>
              <!-- 월 -->
              <v-layout>
                <v-flex>
                  <p>Month</p>
                    <v-select label="Month" :items="m1" v-model="m" max-height="400" hint="Month Choice" persistent-hint></v-select>
                </v-flex>
              </v-layout>
              <!-- 일 -->
              <p>Day</p>
                <v-select label="Day" :items="d1" v-model="d" max-height="400" hint="Day Choice" persistent-hint></v-select>
              <!-- 시작시간 -->
              <p>StartTime</p>
                <v-select label="StartTime" :items="st1" v-model="st" max-height="400" hint="StartTime Choice" persistent-hint></v-select>
              <!-- 종료시간 -->
              <p>EndTime</p>
                <v-select label="EndTime" :items="et1" v-model="et" max-height="400" hint="EndTime Choice" persistent-hint></v-select>
              <!-- 인원수 -->
              <p>PeopleNumber</p>
                <v-select label="PeopleNumber" :items="pn1" v-model="peopleno" max-height="400" hint="PeopleNumber Choice" persistent-hint></v-select>
              <!-- 비용 -->
              <p>Cost</p>
                <v-btn color="yellow">5천원</v-btn>
                <v-btn color="yellow">1만원</v-btn>
                <v-btn color="yellow">5만원</v-btn>
                <v-btn color="yellow">10만원</v-btn>
                <!-- 총비용 -->

                <br></br>
              <!-- 봉사/헌혈 -->
              <p>Volunteer</p>
                <!-- <v-checkbox label="봉사 / 헌혈" v-model="volunteer"></v-checkbox> -->
                <input type="checkbox" id="volunteer" value="volunteer" v-model="volunteer">
                <label for="volunteer">봉사 / 헌혈</label>
              <!-- 지역 -->
              <p>Area</p>
                <gmap-autocomplete style="width:400px;" @place_changed="setPlace"></gmap-autocomplete>
                <v-icon @click="addMarker" class="pointer">search</v-icon>
              <!-- 반경 -->
              <p>Radius</p>
                <v-select label="Radius" :items="r1" v-model="radius" max-height="400" hint="Radius Choice" persistent-hint></v-select>
              <v-btn @click="submit" :disabled="!valid">OK</v-btn>
            </v-form>
          </v-flex>
        </v-layout>
        <pre>{{$data}}</pre>
      </div>
    </v-container>
  </v-app>

</template>

<script>
  export default {
    data () {
      return {
        valid:false,
        division:'',
        weather:'',
        age:'',
        peopleno:'',
        radius:'',
        cost:'',
        lat:'',
        lng:'',
      }
    },
    methods: {
      submit () { // 클릭 : 작성 완료
        if(this.$refs.form.validate()) {
          this.$axios.post('/api/user/write', {
            radius:this.radius
          }).then((response) => {
              console.log('writeOK')
              this.result = response.data
              console.log(this.result)
          })
        }
      },
      setPlace(place) {
        this.currentPlace = place
      },
      addMarker () {

      }
    }
  }
</script>

<style>
  .pointer {
    cursor:pointer;
  }
</style>
