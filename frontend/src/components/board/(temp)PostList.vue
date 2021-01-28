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
import Post from "@/components/board/Post.vue"
// import {mapState} from 'vuex'

export default {
  name:"PostList",
  components:{
    Post
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