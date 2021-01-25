<template>
  <div class="post">
    <div class="writer">이미지</div>
    <div class="title">
      <div class="first-line">
        <h4>작성자 이름</h4>
        <div class="right">
          2021-01-25
          <button>X</button>
        </div>
      </div>
      <div>게시물 제목</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "scrappost",
}
</script>

<style scoped>
.post {
  display: flex;
  flex-direction: row;
  border: 4px dotted #797979;
  height: 80px;
}
.post .writer {
  border: 2px solid;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  border: 1px solid;
  border-radius: 50%;
  height: 80%;
  width: 30%;
  margin: 2% 4%;
}
.post .title {
  display: flex; 
  flex-direction: column;
  justify-content: space-evenly;
  box-sizing: border-box;
  width: 100%;
}
.post .title *{
  box-sizing: border-box;
  margin: 0%;
}
.title .first-line {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 100%;
}
.title .first-line .right {
  display: flex;
  justify-content: flex-end;
}
.title h4 {
  align-self: flex-end;
}

</style>