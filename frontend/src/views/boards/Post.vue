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
    <div class="title">포스트제목</div>
    <div class="main">포스트내용</div>
    <div class="footer">
      <div class="post-like">좋아요수</div>
      <div class="post-comment">댓글수</div>
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
}
.post .header{
  margin-bottom: 0.5rem;
}
.post .title{
  font-weight: bold;
  font-size:1.5rem;
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