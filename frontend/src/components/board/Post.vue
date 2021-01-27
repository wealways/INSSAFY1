<template>
  <div class="post">
    <div class="header">
      <div class="user-profile-img">
        <b-avatar src="https://placekitten.com/300/300" size="4rem">유저프로필</b-avatar>
      </div>
      <div class="user-name-date">
        <div class="user-name">이름</div>
        <div class="post-date">글쓴시간</div>
      </div>
    </div>
    <div class="title">포스트제목포스트제목포스트제목포스트제목</div>
    <div class="main">포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용포스트내용</div>
    <div class="footer">
      <div class="post-like"><b-icon icon="hand-thumbs-up" aria-hidden="true"></b-icon>좋아요: 10</div>
      <div class="post-comment"><b-icon icon="chat" aria-hidden="true"></b-icon>댓글: 20</div>
    </div>
  </div>
</template>

<script>
export default {
  name:"Post"
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
.post .header{
  margin-bottom: 0.5rem;
  display: flex;
  flex-direction: row;
}
.post .footer{
  display:flex;
  flex-direction: row;
  justify-content: flex-end
  ;
}
.post-comment{
  margin-left: 0.5rem;
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
.user-name-date{
  display: flex;
  flex-direction: column;
  justify-content: center;
}
</style>