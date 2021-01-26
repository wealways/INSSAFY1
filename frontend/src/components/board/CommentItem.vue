<template>
  <b-container>
    <b-row class="comment">
      <b-col sm="2" class="header">
        <div class="user-profile-img">
          <b-avatar src="https://placekitten.com/300/300" size="3rem">유저프로필</b-avatar>
        </div>
        <div class="header-detail">
          <div class="user-name-date">
            <div class="user-name">이름</div>
            <div class="post-date">글쓴시간</div>
          </div>
          <div @click="btnComment" id="btnCommentMobile">
            <b-icon icon="three-dots-vertical" aria-hidden="true"></b-icon>
          </div>
        </div>
      </b-col>
      <b-col class="main">
        <div>
        댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓댓글댓글댓글댓글댓글댓글댓글댓글
        댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글글댓글댓글댓글
        </div>
        <div @click="btnComment" id="btnComment">
          <b-icon icon="three-dots-vertical" aria-hidden="true"></b-icon>
        </div>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  name:"CommentItem",
  methods:{
    btnComment() {
      alert(`comment ! `);
    }
  }
}
</script>

<style scoped>
.comment{
  display:flex;
  margin-bottom: 1rem;
}
.comment .header{
  display: flex;
}
.comment .header .header-detail{
  display:flex;
  justify-content:space-between;
  width: 100%;
}
.user-name{
  display: inline-block;
  font-size:1fr;
}
.post-date{
  font-size:0.5em;
}
.main{
  display: flex;
  padding: 0;
  /* width:100%; */
}
@media screen and (max-width:576px){
  #btnComment{
    display: none;
  }
}
@media screen and (min-width:576px){
  #btnCommentMobile{
    display: none;
  }
}
</style>