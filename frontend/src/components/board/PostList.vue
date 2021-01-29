<template>
  <div>
    <Post
      v-for="(post,idx) in posts"
      :key="idx"
      :post="post"
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
    posts() {
      return this.$store.state.posts
    },
  }
}
</script>

<style>

</style>