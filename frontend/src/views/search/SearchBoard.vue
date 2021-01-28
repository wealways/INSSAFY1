<template>
  <div class="container-box">
    <div class="search-hd">
      <!-- 검색결과 타이틀 -->
      <div class="search-title">
        <p>보드 중 '게임'에 대한 검색결과 : 0건</p>
      </div>
      <!-- 검색 관련 버튼 -->
      <div class="search-tool">
        <div class="sort">
        <p>보드 0건</p>
          <select name="sort" class="sort">
            <option value="">정렬기준</option>
            <option value="">최신</option>
            <option value="">인기</option>
          </select>
        </div>
        <button @click="goToCreateBoard" style="background-color: green;">보드생성</button>
      </div>
    </div>
    <div class="search-result">
      <Board 
        class="search-result-board"
      />       
      <Board 
        class="search-result-board"
      />       
      <Board 
        class="search-result-board"
      />       
      <Board 
        class="search-result-board"
      />       
      <Board 
        class="search-result-board"
      />       
      <Board 
        class="search-result-board"
      />       
    </div>
  </div>
</template>

<script>
import Board from './Board.vue'

export default {
  name: 'SearchBoard',
  components: {
    Board,
  },
  methods: {
    goToCreateBoard(){
      return this.$router.push({ name: 'BoardForm' });
    }
  }
}
</script>

<style scoped>
/* 전체 페이지 부분 */
.container-box {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  margin: 2% 3% 0 3%;
  border: 4px solid #000000;
}
/* 검색결과 타이틀 부분 */
.container .search-hd {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  padding-top: 0;
  border: 4px solid #000000;
}
.search-hd .search-title {
  display: flex;
  justify-content: center;
  background-color: bisque;
}
.search-hd .search-tool {
  display: flex;
  justify-content: space-between;
}
.search-tool .sort {
  display: flex;
}
/* 검색결과 나오는 게시글들 부분 */
.search-result {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin: 0;
  padding-top: 0;
  flex-flow: wrap;
  border: 3px solid #000000;
}
.search-result-board {
  flex-basis: 19.5%;
  border: 3px dotted #000000;
}


@media (max-width: 425px) {
  .container-box {
    height: 100%;
  }
  .search-result {
    display: flex;
    flex-direction: column;
    flex-flow: wrap;
    margin-top: 8%;
  }
  .search-result-board {
    flex-basis: 46%;
    margin: 2% 2% 2% 2%;
  }
}
</style>