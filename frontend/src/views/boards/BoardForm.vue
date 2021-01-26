<template>
  <div>
    <b-container class="board">
      <b-row>
        <b-col sm="12">
          <router-link to="/boards"><b-icon icon="chevron-compact-left" aria-hidden="true"></b-icon>보드생성</router-link>
        </b-col>
        <b-col sm="8" class="board-aside">
          보드생성
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
          <h4>추가 기능</h4>
          <div class="check-group">
            <div class="input-with-label">
              <input type="checkbox" name="" id="checklist">
              <label for="checklist">체크리스트</label>
            </div>
            <div class="input-with-label">
              <input type="checkbox" name="" id="calender">
              <label for="calender">달력</label>
            </div>
            <div class="input-with-label">
              <input type="checkbox" name="" id="popular">
              <label for="popular">인기글</label>
            </div>
            <div class="input-with-label">
              <input type="checkbox" name="" id="rank">
              <label for="rank">랭킹</label>
            </div>
            <div class="input-with-label">
              <input type="checkbox" name="" id="vote">
              <label for="vote">투표</label>
            </div>
          </div>
        </b-col>
        
        <b-col sm="4" class="board-section">
          <hr>
          추가
          <div class="check-select">
            <div class="input-with-label">
              <input type="checkbox" name="" id="igmyeong">
              <label for="igmyeong">익명</label>
            </div>
            <div class="input-with-label">
              <select ref="select1" class="join-style" name="location" id="location">
              <option value="" disabled selected>지역을 선택하세요.</option>
              <option v-for="location in options.location" :key="location" :value="location">
                {{ location }}
              </option>
            </select>
            </div>
          </div>
          <div class="hashtag">
            <label for="board-description">해쉬태그</label>
            <textarea id="board-description" cols="30" rows="10"></textarea>
            <div class="error-text">에러메시지</div>
          </div>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
export default {
  name:"BoardForm",
  data() {
    return {
      options: {
        location: ['서울', '대전', '구미', '광주'],
        generation: [4, 3, 2, 1],
      },
    }
  }
}
</script>

<style scoped>
.check-group{
  display: grid;
  /*  */
  /* align-items: center; */
  /* justify-content:flex-start; */
  
}
.check-group .input-with-label{
  display: flex;
  grid-row: 1;
}
@media screen and (max-width:576px) {
  .check-group .input-with-label{
  display: -webkit-box;
  grid-row: 1;
  }
}

@media screen and (min-width:576px) {
  hr {
    display: none;
  }
}

.check-select{
  display: flex;
  justify-content:space-around;
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
.error-text {
  font-size: 0.8rem;
  color: #ff0404;
}
</style>