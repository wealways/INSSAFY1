<template>
  <div>
    <Comment
      v-for="(comment,idx) in comments"
      :key="idx"
      :comment="comment"
    />
  </div>
</template>

<script>
import Comment from "@/components/board/postdetail/Comment.vue"
// import {mapState} from 'vuex'

export default {
  name:"CommentList",
  components:{
    Comment
  },
  computed:{
    comments() {
      return this.$store.state.comments
    },
  }
}
</script>

<style>

</style>