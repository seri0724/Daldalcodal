<template>
  <v-container>
    <div id="myroute" style="width:450px; display:inline-block;">
      <br></br>
        <h1>My코스</h1>
        <br></br>
        <h4>- Today Myroute -</h4>
      <br></br>
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
          <br></br>
          <v-progress-linear color="red"></v-progress-linear>
          <br></br>
        </v-flex>
      </v-layout>
      <h1>My목록</h1>
      <br></br>
      <v-layout row justify-center>
        <v-spacer></v-spacer>
        <v-btn flat class="transparent">2018-04-27</v-btn>
        <v-flex v-for="url in images" :key="url">
          <v-card class="transparent mx-4" width="150px">
            <v-card-media src="https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20150901_47%2F1441093708706YsNYn_JPEG%2F166761513648513_11.jpg&amp;type=f420_312" height="150px">
            </v-card-media>
            <v-card-text>
              <h4 class="black--text">- 바비레드</h4>
              <h4 class="black--text">- 5만원대(2인기준)</h4>
            </v-card-text>
          </v-card>
        </v-flex>
        <v-spacer></v-spacer>
        <!-- 평가 모달창 -->
        <EvaluationModal></EvaluationModal>
      </v-layout>
      <v-divider></v-divider>
      <v-layout row justify-center>
        <v-spacer></v-spacer>
        <v-btn flat class="transparent">2018-04-26</v-btn>
        <v-flex v-for="url in images" :key="url">
          <v-card class="transparent mx-4" width="150px">
            <v-card-media src="https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20150901_245%2F14410657870439gpBX_JPEG%2F166761513730125_1.jpg&amp;type=f420_312" height="150px">
            </v-card-media>
            <v-card-text>
              <h4 class="black--text">- 토끼정 강남본점</h4>
              <h4 class="black--text">- 2만원대(2인기준)</h4>
            </v-card-text>
          </v-card>
        </v-flex>
        <v-spacer></v-spacer>
        <!-- 평가 모달창 -->
        <EvaluationModal></EvaluationModal>
      </v-layout>
      <v-divider></v-divider>
      <v-layout row justify-center>
        <v-spacer></v-spacer>
        <v-btn flat class="transparent">2018-04-25</v-btn>
        <v-flex v-for="url in images" :key="url">
          <v-card class="transparent mx-4" width="150px">
            <v-card-media src="https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20160121_34%2F1453345572129kkI5q_JPEG%2F176071523630600_0.jpg&amp;type=f420_312" height="150px">
            </v-card-media>
            <v-card-text>
              <h4 class="black--text">- 고에몬 강남점</h4>
              <h4 class="black--text">- 2만원대(2인기준)</h4>
            </v-card-text>
          </v-card>
        </v-flex>
        <!-- 평가 모달창 -->
        <EvaluationModal></EvaluationModal>
      </v-layout>
    </div>
  </v-container>
</template>

<script>
import EvaluationModal from './EvaluationModal.vue'

  export default {
    components: {
      EvaluationModal
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
