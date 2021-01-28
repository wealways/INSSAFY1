<template>
  <div class="post">
    <div class="post-header">
      <div class="user-profile-img">
        <b-avatar src="https://placekitten.com/300/300" size="4rem">유저프로필</b-avatar>
      </div>
      <div class="user-name-date">
        <div>
          <b-dropdown id="dropdown-left" class="user-name" text="이름" variant="link" toggle-class="text-decoration-none" no-caret>
            <b-dropdown-item href="#">Profile</b-dropdown-item>
            <b-dropdown-item href="#">메시지 보내기</b-dropdown-item>
            <!-- <b-dropdown-item href="#">Something else here</b-dropdown-item> -->
          </b-dropdown>
        </div>
        <div class="post-date">글쓴시간</div>
      </div>
    </div>
    <div class="post-body">
      <div class="title f-text b-desc">포스트제목포스트제목포스트제목포스트제목</div>
      <div class="description r-desc">포스트내용 포스트내용 포스트내용 포스트내용 포스트내용 포스트내용 포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용</div>
    </div>
    <div class="post-footer">
      <div class="post-like" @click="postLike" v-if="flagLike"  style="z-index: 1; position:relative; left:37.64px"><b-icon icon="emoji-smile" aria-hidden="true"></b-icon> 10</div>
      <div class="post-like" @click="postLike" v-if="flagLike"><b-icon icon="emoji-smile-fill" aria-hidden="true" color="#AA2610"></b-icon> 10</div>
      <div class="post-like" @click="postLike" v-if="!flagLike"><b-icon icon="emoji-smile" aria-hidden="true"></b-icon> 10</div>
      <div class="post-comment"><b-icon icon="chat" aria-hidden="true"></b-icon> 2</div>
      <div class="post-bookmark" @click="postBookmark" v-if="flagBookmark"><b-icon icon="bookmark-fill" aria-hidden="true"></b-icon></div>
      <div class="post-bookmark" @click="postBookmark" v-if="!flagBookmark"><b-icon icon="bookmark" aria-hidden="true"></b-icon></div>
    </div>
  </div>
</template>

<script>
export default {
  name:"Post",
  data() {
    return {
      flagLike:false,
      flagBookmark:false
    }
  },
  methods:{
    postLike(e){
      this.flagLike = !this.flagLike
      console.log(this.flagLike)
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