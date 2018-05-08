<template>
  <v-container>
    <div id="route" style="width:450px; display:inline-block;">
      <br></br>
        <h1>Recommendation Route</h1>
      <br></br>
      <v-layout row wrap justify-center>
        <v-flex>
          <v-layout row justify-center>
            <v-flex v-for="url in images" :key="url">
              <v-card class="transparent mx-4" width="200px">
                <v-card-media src="https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20160330_67%2F1459333746535gsyyk_JPEG%2F176280595924929_0.jpeg&amp;type=f420_312" height="150px">
                </v-card-media>
                  <v-card-text>
                    <h4 class="black--text">- 마녀주방</h4>
                    <h4 class="black--text">- 2만원대(2인기준)</h4>
                  </v-card-text>
              </v-card>
            </v-flex>
          </v-layout>
          <v-form v-model="valid" ref="form">
             <v-checkbox label="마녀주방"></v-checkbox>
             <v-checkbox label="바비레드"></v-checkbox>
             <v-checkbox label="토끼정 강남본점"></v-checkbox>
             <v-checkbox label="고에몬 강남점"></v-checkbox>
          </v-form>
          <v-layout row justify-center>
            <v-flex v-for="url in images" :key="url">
              <v-card class="transparent mx-4" width="200px">
                <v-card-media src="https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20150901_47%2F1441093708706YsNYn_JPEG%2F166761513648513_11.jpg&amp;type=f420_312" height="150px">
                </v-card-media>
                  <v-card-text>
                    <h4 class="black--text">- 바비레드</h4>
                    <h4 class="black--text">- 5만원대(2인기준)</h4>
                  </v-card-text>
              </v-card>
            </v-flex>
          </v-layout>
          <v-form v-model="valid" ref="form">
             <v-checkbox label="마녀주방"></v-checkbox>
             <v-checkbox label="바비레드"></v-checkbox>
             <v-checkbox label="토끼정 강남본점"></v-checkbox>
             <v-checkbox label="고에몬 강남점"></v-checkbox>
            <v-btn @click="submit" :disabled="!valid">확인</v-btn>
          </v-form>
        <pre>{{$data}}</pre>
        </v-flex>
      </v-layout>
    </div>
  </v-container>
</template>

<script>
  export default {
    data: () => ({
      valid:false,
      // url_id : 21037816
      placename1:'21037816',
      placename2:'13480693',
      placename3:'36022489',
      placename4:'19500744'
    }),
    methods: {
      submit () {
        if(this.$refs.form.validate()) {
          this.$axios.post('/api/course/store', {
            placename1:this.placename1,
            placename2:this.placename2,
            placename3:this.placename3,
            placename4:this.placename4
          }) .then((response) => {
              console.log('routeOK')
              this.result = response.data
              console.log(this.result)
          })
        }
      }
    },
    data () {
      return {
        images: [
          {
            imageUrl:'https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20160330_67%2F1459333746535gsyyk_JPEG%2F176280595924929_0.jpeg&amp;type=f420_312', id:'Top1', title:'마녀주방 강남점'
          },
          {
            imageUrl:'https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20150901_47%2F1441093708706YsNYn_JPEG%2F166761513648513_11.jpg&amp;type=f420_312', id:'Top2', title:'바비레드'
          },
          {
            imageUrl:'https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20150901_245%2F14410657870439gpBX_JPEG%2F166761513730125_1.jpg&amp;type=f420_312', id:'Top3', title:'토끼정 강남본점'
          },
          {
            imageUrl:'https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20160121_34%2F1453345572129kkI5q_JPEG%2F176071523630600_0.jpg&amp;type=f420_312', id:'Top4', title:'고에몬 강남점'
          }
        ]
      }
    }
  }
</script>
