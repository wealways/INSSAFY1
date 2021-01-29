<template>
  <div class="message-box">
    <!-- 채팅상대 프로필 이미지 -->
    <div class="profile-img">
    </div>
    <!-- 채팅상대의 메세지 -->
    <div class="contents">
      채팅 시작했다asdddddddddddddddddddddddddddddddddsss
    </div>

  </div>
</template>

<script>
export default {
  name: "ChatMessageLeft",
}
</script>

<style scoped>
.message-box {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-content: center;
  flex-flow: nowrap;
}
.profile-img {
  display: flex;
  justify-content: center;
  align-self: flex-start;
  border: 2px solid;
  border-radius: 50%;
  margin: 2% 1% 2% 1%;
  padding: 4%;
  height: 10%;
  width: 7.5%;
}
.contents {
  align-self: flex-end;
  border: 2px solid;
  border-radius: 5%;
  margin-top: 5%;
  width: 70%;
  word-break: break-all;
}
</style>