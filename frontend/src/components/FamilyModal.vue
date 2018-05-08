<!-- 쓸일없음 -->
<template>
  <v-layout row>
    <v-dialog v-model="dialog" persistent max-width="300px">
      <v-btn color="orange" slot="activator">가족</v-btn>
      <v-card>
        <h1 class="pink--text">Family</h1>
        <h4 icon>
          <v-icon>mood</v-icon>
          나이대를 선택해주세요
          <v-icon>mood</v-icon>
        </h4>
          <v-container>
            <v-layout wrap>
              <v-flex xs12 sm6>
                <v-select label="부모" :items="['미동행', '20대', '30대', '40대', '50대', '60대', '70대', '80대']"></v-select>
              </v-flex>
              <v-flex xs12 sm6>
                <v-select label="자녀" :items="['미동행', '0~9세', '10대', '20대', '30대', '40대', '50대']"></v-select>
              </v-flex>
            </v-layout>
          </v-container>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="red" flat @click.native="dialog=false">CANCEL</v-btn>
          <v-btn color="blue" flat @click.native="dialog=false">OK</v-btn>
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
      }
    }
  }
</script>
