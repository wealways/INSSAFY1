<template>
  <div>
    <!-- chevron-left -->
    <b-container class="board">
      <b-row>
        <header>
          <router-link to="/board"><b-icon icon="chevron-compact-left" aria-hidden="true"></b-icon>Board</router-link>
          
        </header>
        <section>
          <Post :post="$attrs"/>
          <hr>
          <input 
            type="text" 
            placeholder="댓글을 입력해주세요" 
            id="comment"
            v-model="comment"
            @keypress.enter="createComment"
          >
          <CommentList/>
        </section>
      </b-row>
    </b-container>
    
  </div>
</template>

<script>
import Post from '@/components/board/postdetail/PostForDetail.vue'
import CommentList from '@/components/board/postdetail/CommentList.vue'
export default {
  name:'PostDetail',
  data() {
    return {
      comment: '',
    }
  },
  components:{
    Post,
    CommentList,
  },
  methods:{
    createComment(){
      let today = new Date();  
      const commentItem ={
        user:'이름',
        comment:this.comment,
        date:`${today.getFullYear()}-${today.getMonth()+1}-${today.getDate()}`
      }
      console.log(commentItem)
      if(commentItem && commentItem.comment.trim())
        this.$store.dispatch('createComment',commentItem)
      this.comment=''
    }
  }
  
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
header a{
  font-size:2rem;
  text-decoration: none;
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
