<template>
  <div class="container-box">
    <!-- 채팅목록 보여주는 부분 -->
    <div class="chat-list-section">
      <h3 class="chat-title">1:1 대화목록</h3>
      <hr color="black" width="100%">
      <ScrapPost />
      <ScrapPost />
      <ScrapPost />
      <ScrapPost />
      <ScrapPost />
    </div>
    <div class="chat-message">
      <!-- 현재 들어와 있는 채팅방 알려주는 정보 -->
      <div class="info">
        <div class="info-img">
          프사
        </div>
        <div class="info-name">
          닉네임
        </div>
      </div>
      <hr color="black">
      <ChatMessageLeft />
      <ChatMessageRight />
      <ChatMessageLeft />
      <ChatMessageRight />
    </div>
  </div>
</template>

<script>
/* 
일단은 왼쪽, 오른쪽 메세지로 쪼개놨지만 이를 조건문으로 변경해도 될 것 같다
*/
import ChatMessageRight from "./ChatMessageRight.vue"
import ChatMessageLeft from "./ChatMessageLeft.vue"
// 마이페이지내 스크랩한 포스트 컴포넌트가 채팅목록과 정보 유사 - 이를 사용
import ScrapPost from "../user/common/ScrapPost.vue"

export default {
  name: "ChatPage",
  components: {
    ChatMessageLeft,
    ChatMessageRight,
    ScrapPost,
  },
}
</script>

<style scoped>
.container-box {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  border: 2px solid #000000;
  height: 100vh;
  margin: 1% 18%;
  flex-wrap: wrap;
}

/* 채팅목록 화면(왼쪽) */
.container-box .chat-list-section {
  display:flex;
  flex-direction: column;
  align-items: center;
  background-color: pink;
  width: 47%;
}
.container-box .chat-title {
  font-size: 2rem;
  align-self: flex-start;
  margin: 5% 5%;
}

/* 1대1 채팅화면(오른쪽) */
.container-box .chat-message {
  background-color: silver;
  width: 47%;
}
.chat-message .info {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
}
/* 채팅방 타이틀 - 누구와의 대화인지 보여주는 부분 */
.chat-message .info {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  margin: 3%;
}
.chat-message .info-img {
  display: flex;
  justify-content: center;
  align-self: center;
  border: 2px solid;
  border-radius: 50%;
  margin: 2% 5% 2% 1%;
  padding: 4%;
  height: 80%;
  width: 15%;
}

/* 모바일 웹화면 */
@media (max-width: 425px) {
  .container-box {
    height: 100%;
    display: flex;
    flex-direction: column;
    align-content: center;
    margin: 0.5rem 0.5rem;
  }
  .container-box .chat-list-section {
    width: 95%;
  }
  .container-box .chat-message {
    background-color: silver;
    width: 95%;
  }
}
</style>