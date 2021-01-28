<template>
  <div>
    <b-container class="board">
      <b-row>
        <b-col sm="12" class="header">
          <router-link to="/board/search"><b-icon icon="chevron-compact-left" aria-hidden="true"></b-icon>Board</router-link>
        </b-col>
        <b-col sm="8" class="board-aside">
          <div class="input-with-label">
            <label for="board-title">게시판 이름</label>
            <input
              id="board-title"
              placeholder=""
              type="text"
            />
            <div class="error-text">에러메시지</div>
          </div>
          <div class="input-with-label">
            <label for="board-description">게시판 설명</label>
            <textarea id="board-description" cols="30" rows="10"></textarea>
            <div class="error-text">에러메시지</div>
          </div>
          
        </b-col>
        
        <b-col sm="4" class="board-section">
          <div class="hashtag">
            <label for="board-description">해쉬태그</label>
            <input 
              type="text" 
              id="board-description" 
              v-model.trim="hashtag" 
              @keypress.enter="addHashtag"
            />
            <ul class="hashtag-list">
              <li 
                v-for="(hashtag,idx) in hashtags"
                :key="idx"
              ><p class="hashtag">{{hashtag}}</p></li>
            </ul>
          </div>
          <div class="check-select">
            <b-form-checkbox v-model="options.ikmyeong" name="check-button" switch>
              <p v-if="!options.ikmyeong" style="margin:0; text-decoration:line-through;">익명</p>
              <b v-if="options.ikmyeong">익명</b>
            </b-form-checkbox>
            <div class="input-with-label">
              <select ref="select1" class="join-style" name="location" id="location">
                <option value="" disabled selected>지역을 선택하세요.</option>
                <option v-for="location in options.location" :key="location" :value="location">
                  {{ location }}
                </option>
              </select>
            </div>
          </div>
          <hr>
          <b-form-group label="추가기능(optional)" v-slot="{ ariaDescribedby }">
            <b-form-checkbox-group
              id="checkbox-group-1"
              v-model="selected"
              :options="options.f"
              :aria-describedby="ariaDescribedby"
              name="flavour-1"
            ></b-form-checkbox-group>
          </b-form-group>
        </b-col>
      </b-row>
      <button
        class="btn-createboard b-title"
        @click="onCreate"
      >Create</button>
    </b-container>
    
  </div>
</template>

<script>
export default {
  name:"BoardForm",
  data() {
    return {
      hashtag:'',
      hashtags:[],
      selected: [],
      options: {
        f:[
          {text:'인기글',value:'popular',disabled:false},
          {text:'랭킹',value:'rank',disabled:false},
          {text:'체크리스트',value:'checklist',disabled:true},
          {text:'달력',value:'calender',disabled:true},
          {text:'투표',value:'vate',disabled:true},
        ],
        location: ['전체','서울', '대전', '구미', '광주'],
        generation: [5, 4, 3, 2, 1],
        ikmyeong:false,
      },
    }
  },
  methods: {
    addHashtag() {
      if(this.hashtags.length===5){
        alert('해쉬태그는 5개 이하만 가능합니다.')
        return
      }
      this.hashtags.push(`#${this.hashtag}`)
      this.hashtag=''
    },
    onCreate(){
      alert('게시판 보드 생성')
    }
  }
}
</script>

<style scoped>
.header{
  font-size:2rem;
  padding:0;
}
.header a{
  text-decoration: none;
}
#board-description{
  resize: none;
}
/* .check-group{
  display: grid;
  
}
.check-group .input-with-label{
  display: flex;
  grid-row: 1;
} */
/* @media screen and (max-width:576px) {
  .check-group .input-with-label{
  display: -webkit-box;
  grid-row: 1;
  }
} */

.check-select{
  display: flex;
  justify-content:space-between;
}
.check-select .input-with-label{
  display: flex;
  
}
.check-select .input-with-label label {
  margin:0;
}

input[type="text"] {
  background: transparent;
  font-size: 1em;
  width: 100%;
  height: 40px;
  line-height: 1em;
  border: 1px solid #CCCCCC;
  padding: 0 20px;
  -webkit-box-sizing: border-box;
          box-sizing: border-box;
  -webkit-transition: .2s;
  transition: .2s;
  outline: none;
}
input[type="checkbox"] {
  background: transparent;
  /* font-size: 1em; */
  /* width: 100%; */
  height: 25px;
  line-height: 1em;
  border: 1px solid #CCCCCC;
  margin:0 0.9rem;
  -webkit-box-sizing: border-box;
          box-sizing: border-box;
  -webkit-transition: .2s;
  transition: .2s;
  outline: none;
}
.error-text {
  font-size: 0.8rem;
  color: #ff0404;
}

/* label.custom-control-input:checked~label.custom-control-label:after{
  border-color: #e4606d !important;
  background-color: #e4606d !important;
} */


textarea{
  background: transparent;
  font-size: 1em;
  width: 100%;
  height: 300px;
  line-height: 1em;
  border: 1px solid #CCCCCC;
  padding: 8px 20px;
  -webkit-box-sizing: border-box;
          box-sizing: border-box;
  -webkit-transition: .2s;
  transition: .2s;
  outline: none;
}
label{
  display: inline-block;
}

@media screen and (min-width:576px) {
  li .hashtag{
  display:inline;
  background-color: #0B2945;
  border-radius: 0.5rem;
  color:#f9f9f9;
  padding-left:0.2rem;
  padding-right:0.2rem;
  margin: 0.3rem;
  }
  .hashtag-list {
  height: 150px;
  margin: 1rem 0;
}
}
@media screen and (max-width:576px) {
  li {
    display:inline-block;
  }
  li .hashtag{
  display:inline-block;
  background-color: #0B2945;
  border-radius: 0.5rem;
  color:#f9f9f9;
  padding-left:0.2rem;
  padding-right:0.2rem;
  margin: 0.3rem;
  }
  .hashtag-list {
  margin: 1rem 0;
  }
  .btn-createboard{
    width: 100%;
    background-color: #000 !important;
    color: #fff;
  }
}
.btn-createboard{
  /* position: inherit;  */
  height: 50px;
  width:100%;
  font-size: 24px;
  margin-top: 10px; 
  margin-bottom: 10px;
  text-align: center;
}
.btn-createboard:hover,
.btn-createboard:active {
  background-color: #000 !important;
  color: #fff;
}
</style>