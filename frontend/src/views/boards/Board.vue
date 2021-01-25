<template>
  <div>
    <nav>
      네브바
    </nav>
    <b-container class="board">
      <b-row>
        <b-col sm="3" class="board-aside">
          <a class="board-modify">설정</a>
          <div class="board-description">
            <div class="board-name-detail">
              <div class="board-name">보드이름</div>
              <div class="board-detail">보드디테일보드디테일보드디테일보드디테일보드디테일보드디테일보드디테일</div>
            </div>
            <div class="board-hashtag">#태그#태그#태그#태그#태그</div>
          </div>
          <hr>
          <div class="board-function">보드특수기능들</div>
          <div class="add-board-function">보드기능 추가</div>
        </b-col>
        <b-col sm="8" class="board-section">
          <div class="post-search">
            <div>찾기</div>
          </div>
          <div class="post-write">
            <b-button variant="light">글쓰기</b-button>
          </div>
          <Post/>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import Post from './Post.vue'

export default {
  name:'Board',
  components: {
    Post
  }
}
</script>

<style>
.board{
  max-width: 1024px !important;
  margin: 0 auto;
}
.board-description{
  display: flex;
  flex-direction: row;
}
.board-name{
  font-weight: bold;
  font-size:1.3rem
}
.post-write button {
  width:100%;
}
.post .header{
  display: flex;
  flex-direction: row;
}
/* .post-search {
  display: inline-block;
  right: -100%;
} */
.post-search{
  display: flex;
  justify-content: flex-end;
}
.post .footer{
  display:flex;
  flex-direction: row;
  justify-content: flex-end
  ;
}
@media screen and (max-width:576px){
  .board-modify{
    display:none;
  }
  .post-search{
    display:none;
  }
  .add-board-function{
    display: none;
  }
}
</style>