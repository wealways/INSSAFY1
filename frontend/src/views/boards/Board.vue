<template>
  <div id="board">
    <b-container class="board">
      <b-row>
        <b-col sm="3" class="board-aside">
          <a class="board-modify">설정</a>
          <BoardDescription/>
          <hr>
          <div class="board-function">보드특수기능들</div>
          <div class="add-board-function">보드기능 추가</div>
        </b-col>
        <b-col sm="9" class="board-section">
          <div class="post-search">
            <div>찾기</div>
          </div>
          <div class="post-write">
            <!-- <b-button variant="light">글쓰기</b-button> -->
            <PostWrite/>
          </div>
          <Post/>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import Post from '@/components/board/Post.vue'
import PostWrite from '@/components/board/PostWrite.vue'
import BoardDescription from '@/components/board/BoardDescription.vue'


export default {
  name:'Board',
  components: {
    Post,
    PostWrite,
    BoardDescription
  }
}
</script>

<style scoped>

.board{
  max-width: 1024px !important;
  margin: 0 auto;
}

/* .post-write button {
  width:100%;
} */
.post-search{
  display: flex;
  justify-content: flex-end;
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