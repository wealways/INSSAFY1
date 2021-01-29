<template>
  <div class="post">
    <div class="post-header">
      <div class="user-profile-img">
        <b-avatar src="https://placekitten.com/300/300" size="4rem">유저프로필</b-avatar>
      </div>
      <div class="user-name-date">
        <div>
          <b-dropdown id="dropdown-left" class="user-name" variant="link" toggle-class="text-decoration-none" no-caret>
            <template #button-content>
              {{post.user}}
            </template>
            <b-dropdown-item href="#">Profile</b-dropdown-item>
            <b-dropdown-item href="#">메시지 보내기</b-dropdown-item>
            <!-- <b-dropdown-item href="#">Something else here</b-dropdown-item> -->
          </b-dropdown>
        </div>
        <div class="post-date">{{post.post_date}}</div>
      </div>
    </div>
    <div class="post-body" @click="goToDetail">
      <div class="title f-text b-desc">{{post.post_title}}</div>
      <div class="description r-desc">{{post.post_description}}</div>
    </div>
    <div class="post-footer">
      <div v-if="post.post_like>=10">
        <div class="post-like" @click="postLike" v-if="flagLike"  style="z-index: 1; position:relative; left:37.64px"><b-icon icon="emoji-smile" aria-hidden="true"></b-icon> {{post.post_like}}</div>
      </div>
      <div v-else>
        <div class="post-like" @click="postLike" v-if="flagLike"  style="z-index: 1; position:relative; left:28.64px"><b-icon icon="emoji-smile" aria-hidden="true"></b-icon> {{post.post_like}}</div>
      </div>
      <div class="post-like" @click="postLike" v-if="flagLike"><b-icon icon="emoji-smile-fill" aria-hidden="true" color="#AA2610"></b-icon> {{post.post_like}}</div>
      <div class="post-like" @click="postLike" v-if="!flagLike"><b-icon icon="emoji-smile" aria-hidden="true"></b-icon> {{post.post_like}}</div>
      <div class="post-comment"><b-icon icon="chat" aria-hidden="true"></b-icon> {{post.comment_count}}</div>
      <div class="post-bookmark" @click="postBookmark" v-if="flagBookmark"><b-icon icon="bookmark-fill" aria-hidden="true"></b-icon></div>
      <div class="post-bookmark" @click="postBookmark" v-if="!flagBookmark"><b-icon icon="bookmark" aria-hidden="true"></b-icon></div>
    </div>
  </div>
</template>

<script>
export default {
  name:"Post",
  props:{
    post:Object
  },
  data() {
    return {
      flagLike:false,
      flagBookmark:false,
    }
  },
  
  methods:{
    goToDetail() {
      console.log(this.post)
      // params를 이용해서 데이터를 넘겨줄 수 있다.
      this.$router.push({ name: 'Post', params: {post:this.post} });
    },
    postLike(e){
      this.flagLike = !this.flagLike
      console.log(this.flagLike)

      // 포스트좋아하는거 카운트 바꾸기 위한 지금 이 방식은 bug가 존재합니다. (유저와 연동이 안되어 있기 때문) 
      const flagLikeItem={
        flagLike:this.flagLike,
        post_id:this.post.post_id
      }
      this.$store.dispatch('postLike',flagLikeItem)
    },
    postBookmark(e){
      this.flagBookmark = !this.flagBookmark
      console.log(this.flagBookmark)
    }
  }
}
</script>

<style>
.post{
  margin:1rem 0;
  background-color: #fff;
  padding: 1rem;
  border:1px #949590 solid;
  border-radius:10px;
}
.post .post-header{
  margin-bottom: 0.5rem;
  display: flex;
  flex-direction: row;
}
.post .post-body{
  min-height: 150px;
}
.post .post-footer{
  display:flex;
  flex-direction: row;
  justify-content: flex-end;
  margin-top:1rem;
}
.post-comment{
  margin-left: 0.5rem;
}
.post-bookmark{
  margin-left:0.5rem;
}
.post .title{
  font-weight: bold;
  font-size:1.5rem;
  margin-top: 0.5rem;
  margin-bottom: 1rem;
}
.user-profile-img{
  margin-right: 0.5rem;
}
.user-name button{
  padding:0;
  color:black;
}
.user-name button:hover{
  color:black;
  text-decoration: none;
}
.dropdown-item{
  padding:0 0.3rem !important;
}
.user-name-date{
  display: flex;
  flex-direction: column;
  justify-content: center;
}
</style>