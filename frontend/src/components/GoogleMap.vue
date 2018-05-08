<template>
  <div id="google">
    <h1>Top10 Place</h1>
    <div>
      <!-- Search 검색 -->
      <label>
        <gmap-autocomplete style="width:500px;" @place_changed="setPlace"></gmap-autocomplete>
        <v-icon @click="addMarker" class="pointer">search</v-icon>
      </label>
    </div>
    <br></br>
      <!-- Stepper 스테퍼 -->
      <v-stepper v-model="e1">
        <v-stepper-header>
          <v-stepper-step step="1" :complete="e1 > 1">Top1~5</v-stepper-step>
          <v-divider></v-divider>
          <v-stepper-step step="2">Top6~10</v-stepper-step>
        </v-stepper-header>
        <v-stepper-items>
        <!-- Top1~5 -->
        <v-stepper-content step="1">
          <v-layout>
            <v-flex v-for="url in images" :key="url">
              <v-card flat class="transparent mx-3" width="150px">
                <v-card-media src="https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20160330_67%2F1459333746535gsyyk_JPEG%2F176280595924929_0.jpeg&amp;type=f420_312" height="150px">
                </v-card-media>
                <v-card-text>
                  <h4 class="red--text">Top1</h4>
                  <h4 class="black--text">- 마녀주방</h4>
                </v-card-text>
              </v-card>
            </v-flex>
          </v-layout>
          <v-btn color="pink" @click.native="e1 = 2">Next</v-btn>
        </v-stepper-content>
        <!-- Top6~10 -->
        <v-stepper-content step="2">
          <v-layout>
            <v-flex v-for="url in images" :key="url">
              <v-card flat class="transparent mx-3" width="150px">
                <v-card-media src="https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fblogfiles.naver.net%2F20160723_41%2Fmanh0le_146920277460237wF8_JPEG%2F%25BD%25A7%25BD%25A7%25B9%25F6%25B0%25C515.jpg%235455x3317&amp;type=f420_312" height="150px">
                </v-card-media>
                <v-card-text>
                  <h4 class="red--text">Top6</h4>
                  <h4 class="black--text">- 쉐이크쉑 강남점</h4>
                </v-card-text>
              </v-card>
            </v-flex>
          </v-layout>
          <v-btn color="pink" @click.native="e1 = 1">Next</v-btn>
        </v-stepper-content>
      </v-stepper-items>
    </v-stepper>
      <br></br>
      <!-- <v-carousel style="width:1000px; height:600px;" class="elevation-0" light hide-delimiters>
        <v-carousel-item class="transparent" v-for="image in images" :key="image.id" :src="image.imageUrl">
          <div class="title">{{image.title}}</div>
        </v-carousel-item>
      </v-carousel> -->
      <!-- Map 지도 -->
      <gmap-map :center="center" :zoom="17" style="height:500px;">
        <gmap-marker :key="index" v-for="(m, index) in markers" :position="m.position" @click="center=m.position"></gmap-marker>
      </gmap-map>
  </div>
</template>

<script>
  export default {
    name:"googlemap",
    data () {
      return {
        // default to Montreal to keep it simple
        // change this to whatever makes sense
        center:{lat:40.494650, lng:127.027576},
        markers:[],
        places:[],
        currentPlace:null,
        e1:0,
        images: [
          {
            imageUrl:'https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20160330_67%2F1459333746535gsyyk_JPEG%2F176280595924929_0.jpeg&amp;type=f420_312', id:'Top1', title:'Top1 마녀주방 강남점'
          },
          {
            imageUrl:'https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20150901_47%2F1441093708706YsNYn_JPEG%2F166761513648513_11.jpg&amp;type=f420_312', id:'Top2', title:'Top2 바비레드'
          },
          {
            imageUrl:'https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20150901_245%2F14410657870439gpBX_JPEG%2F166761513730125_1.jpg&amp;type=f420_312', id:'Top3', title:'Top3 토끼정 강남본점'
          },
          {
            imageUrl:'https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20160121_34%2F1453345572129kkI5q_JPEG%2F176071523630600_0.jpg&amp;type=f420_312', id:'Top4', title:'Top4 고에몬 강남점'
          },
          {
            imageUrl:'https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20170712_197%2F1499837959510jnkXL_PNG%2F186662546939279_0.png&amp;type=f420_312', id:'Top5', title:'Top5 AY라운지'
          }
        ],
        imagesS: [
          {
            imageUrl:'https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fblogfiles.naver.net%2F20160723_41%2Fmanh0le_146920277460237wF8_JPEG%2F%25BD%25A7%25BD%25A7%25B9%25F6%25B0%25C515.jpg%235455x3317&amp;type=f420_312', id:'Top6', title:'Top6 쉐이크쉑 강남점'
          },
          {
            imageUrl:'https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20150831_6%2F14410043420538iFVL_JPEG%2F156155408520370_0.jpg&amp;type=f420_312', id:'Top7', title:'Top7 마키노차야 역삼점'
          },
          {
            imageUrl:'https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20150831_157%2F1441004365658ntrmq_JPEG%2FSUBMIT_1414717931230_11609540.jpg&amp;type=f420_312', id:'Top8', title:'Top8 봉우화로'
          },
          {
            imageUrl:'https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20171018_89%2F1508316569740SY2Wp_JPEG%2FLaXDGeV6OgWk2v5umrjjaAB9.jpg&amp;type=f420_312', id:'Top9', title:'Top9 땀땀'
          },
          {
            imageUrl:'https://search.pstatic.net/common/?autoRotate=true&amp;quality=95&amp;src=http%3A%2F%2Fldb.phinf.naver.net%2F20150818_182%2F1439869487587xfXya_JPEG%2F166761513666632_9.jpg&amp;type=f420_312', id:'Top10', title:'Top10 어글리스토브 신논현강남역점'
          }
        ]
      }
    },
    mounted () {
      this.geolocate()
    },
    methods: {
      // receives a place object via the autocomplete component
      setPlace(place) {
        this.currentPlace = place
      },
      addMarker () {
        if(this.currentPlace) {
          const marker = {
            lat:this.currentPlace.geometry.location.lat(),
            lng:this.currentPlace.geometry.location.lng()
          }
          this.markers.push({position:marker})
          console.log(this.markers)
          this.places.push(this.currentPlace)
          this.center = marker
          this.currentPlace = null
        }
      },
      geolocate: function() {
        navigator.geolocation.getCurrentPosition(position => {
          this.center = {
            lat:position.coords.latitude,
            lng:position.coords.longitude
          }
        })
      }
    }
  }
</script>

<style>
  .pointer {
    cursor:pointer;
  }
  .title {
    position:absolute;
    top:0px;
    background:#ffffff;
    color:#000000;
    padding:10px;
  }
</style>
