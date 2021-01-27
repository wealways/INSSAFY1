<template>
  <div class="container-box">
    <div class="post-hd">
      <div class="img"></div>
      <div>익명의 고라니</div>
      <div>2021-01-27</div>
    </div>
    <div class="bamboo-title">제목입니다</div>
    <div class="bamboo-contents">내용을 적어주세요</div>
    <div>

    </div>
    <div>

    </div>
  </div>
</template>

<script>
export default {
  name: "BambooPost",
}
</script>

<style scoped>
.container-box {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 0.5%;
}
.container-box .post-hd {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  margin-bottom: 4%;
}
.container-box .img {
  border: 2px solid;
  background-color: burlywood;
  border: none;
  border-radius: 50%;
  height: 90%;
  width: 8%;
  margin: 2% 0.5% 2% 1%;
}
</style>