<template>
  <v-layout row justify-center>
      <v-dialog v-model="dialog" persistent max-width="1000">
        <v-btn color="pink lighten-3" slot="activator">평가</v-btn>
        <v-card>
          <h1 class="pink--text">My코스</h1>
          <h4 icon>
            <v-icon>mood</v-icon>
            각각의 장소에 투표해주세요
            <v-icon>mood</v-icon>
          </h4>
            <v-layout>
              <v-flex v-for="url in images" :key="url">
                <v-card class="transparent mx-4" flat width="200px">
                  <v-card-media src="https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20150901_47%2F1441093708706YsNYn_JPEG%2F166761513648513_11.jpg&amp;type=f420_312" height="150px">
                  </v-card-media>
                    <v-card-text>
                      <h4 class="black--text">- 바비레드</h4>
                      <h4 class="black--text">- 5만원대(2인기준)</h4>
                    </v-card-text>
                    <v-card-text>
                      <v-btn flat icon color="blue darken-3">좋아요
                        <v-icon>sentiment_very_satisfied</v-icon>
                      </v-btn>
                      <br></br>
                      <v-btn flat icon color="yellow darken-3">보통
                        <v-icon>sentiment_neutral</v-icon>
                      </v-btn>
                      <br></br>
                      <v-btn flat icon color="red darken-3">싫어요
                        <v-icon>sentiment_very_dissatisfied</v-icon>
                      </v-btn>
                    </v-card-text>
                </v-card>
              </v-flex>
            </v-layout>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="red" @click.native="dialog=false">CANCEL</v-btn>
            <v-btn color="blue" @click.native="dialog=false">OK</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-layout>
</template>

<script>
  export default {
    data () {
      return {
        dialog:false,
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
