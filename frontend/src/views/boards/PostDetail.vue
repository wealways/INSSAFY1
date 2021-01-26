<template>
  <div>
    <!-- chevron-left -->
    <b-container class="board">
      <b-row>
        <header>
          <div>
            <router-link to="/boards"><b-icon icon="chevron-compact-left" aria-hidden="true"></b-icon>Board</router-link>
          </div>
        </header>
        <section>
          <Post/>
          <hr>
          <input type="text" placeholder="댓글을 입력해주세요" id="comment">
          <CommentList/>
        </section>
      </b-row>
    </b-container>
    
  </div>
</template>

<script>
import Post from '@/components/board/Post.vue'
import CommentList from '@/components/board/CommentList.vue'
export default {
  name:'PostDetail',
  components:{
    Post,
    CommentList,
  },
}
</script>

<style scoped>
.board{
  max-width: 1024px !important;
  margin: 0 auto;
}
header{
  display:flex !important;
  width: 100%;
  flex-direction: column;
}
header >:nth-child(1){
  font-size:2rem;
}
section {
  margin:0 2%;
  width:96%;
}
#comment {
  width:100%;
  margin-bottom: 1rem;
}
</style>