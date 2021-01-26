<template>
  <div class="container">
    <div id="left-sidebar" class="box">
      <!-- 사용자 정보 보여주는 부분 -->
      <div class="user-profile">
        <div class="hd">
          <h2 class="info">내 정보</h2>
          <button>edit</button>
        </div>
        <div class="img">
          <span>프로필 사진</span>
          <div>edit</div>
        </div>
        <div class="my-info">
          <h3 style="margin: 5% 0 0 0;">사용자 닉네임</h3>
          <!-- <input type="text" placeholder="닉네임"> -->
          <p style="margin: 0;">사용자 이메일</p>
          <!-- <input type="text" placeholder="이메일"> -->
          <p style="margin: 0;">사용자 지역 기수</p>
          <!-- <input type="text" placeholder="지역"> -->
        </div>
      </div>
      <div class="password-change">
        <hr color="black" width="100%">
        <p>비밀번호 변경</p>
      </div>
      <div>
        <h3 style="text-align: center; margin: 1;">구독하는 보드</h3>
        <!-- vue 컴포넌트(subscription board)로 추후에 변경하기 -->
        <div>
          <Subscription />
          <Subscription />
          <Subscription />
        </div>
      </div>
    </div>
    <div class="box">
      <!-- 내가 작성한 글 컴포넌트 -->
      <h1 style="margin: 0;">내 작성글</h1>
      <Mypost />
      <Mypost />
      <Mypost />
      <Mypost />
    </div>
    <div class="box">
      <!-- 내가 작성한 댓글 컴포넌트 -->
      <h1 style="margin: 0;">내 댓글</h1>
      <Mypost />
      <Mypost />
      <Mypost />
    </div>
    <div class="box">
      <!-- 내가 스크랩한 글 컴포넌트 -->
      <h1 style="margin: 0;">스크랩</h1>
      <ScrapPost />
      <ScrapPost />
      <ScrapPost />
      <ScrapPost />
      <ScrapPost />
    </div>
  </div>
</template>

<script>
import Subscription from "../user/common/Subscription.vue"
import Mypost from "../user/common/Mypost.vue"
import ScrapPost from "../user/common/ScrapPost.vue"

export default {
  name: "mypage",
  components: {
    Subscription,
    Mypost,
    ScrapPost,
  }
}
</script>
<style scoped>
/* 마이페이지 전체 컨테이너 속성 */
.container {
	height: 100vh;
  display: flex;
  flex-direction: row;
  justify-content: column;
  margin: 0 10rem 0 10rem;
  }
/* 내 정보 보여줄 부분 */
#left-sidebar {
  display: flex;
  flex-direction: column;
  align-items: stretch;
}

/* 사용자 정보관련 */
.user-profile {
  display: grid;
  grid-template-rows: 1fr 3fr 2fr;
  grid-template-columns: repeat(4, 1fr);
  grid-template-areas: 
    "hd hd hd hd"
    ". img img ."
    "my_info my_info my_info my_info";
  place-content: center;
  align-items: center;
}
/* 내 정보의 header */
.hd {
  grid-area: hd;
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  align-self: flex-start;
  margin: 5%;
}
.hd .info {
  margin: 0;
}
/* 프로필 이미지 부분 */
.img {
  grid-area: img;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  border: 1px solid;
  border-radius: 50%;
  height: 78%;
}
/* 프로필 이미지 편집 버튼 */
.img div {
  z-index: 1;
  position: relative;
  display: table-cell;
  left: 30%;
  top: 25%;
  background-color: antiquewhite;
  width: 30%;
  text-align: center;
}
/* 사용자 입력값 보여줄 부분 */
.my-info {
  grid-area: my_info;
  display: flex;
  flex-direction: column;
}
/* 비밀번호 변경 */
.password-change {
  text-align: end; 
  margin: 0;
}
/* 섹션 */
.box {
    flex-basis: 33.3%;
    border: 4px solid #bcbcbc;
}

/* 모바일 웹 반응형 사이즈 */
@media (max-width: 425px) {
  /* 마이페이지 전체 컨테이너 속성 */
  .container {
    height: 100vh;
    display: flex;
    flex-direction: column;
    justify-content: column;
    margin: 0.5rem 0.5rem;
  }
  /* 사용자 정보관련 */
  .user-profile {
    display: flex;
    justify-content: flex-start;
    box-sizing: border-box;
  }
  .hd {
    display: flex;
    order: 1;
    box-sizing: border-box;
    margin: 0;
    padding-left: 28%;
    padding-top: 2%;
  }
  .info {
    display: none;
  }
  .img {
    display: flex;
    flex-direction: column;
    text-align: center;
    border: 1px solid;
    border-radius: 50%;
    width: 20%;
    height: 60%;
    margin: 0 2%;
    padding: 2%;
  }
  .password-change > p {
    margin: 0;
  }
}

</style>