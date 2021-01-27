<template>
  <div class="post">
    <div class="writer">이미지</div>
    <div class="title">
      <div class="first-line">
        <h4>작성자 이름</h4>
        <div class="right">
          <div class="date">2021-01-25</div>
          <button>X</button>
        </div>
      </div>
      <div class="post-contents">
        <div>게시물 제목</div>
        <div class="non-read">2</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ScrapPost",
}
</script>

<style scoped>
h4 {
  font-size: 1.25rem;
}
div,
p {
  font-size: 1rem;
  font-weight: 100;
}
.post {
  display: flex;
  flex-direction: row;
  border: 4px dotted #797979;
  margin: 2%;
  height: 80px;
  width: 95%;
}
.post .writer {
  border: 2px solid;
  text-align: center;
  border: 1px solid;
  border-radius: 50%;
  height: 80%;
  width: 30%;
  margin: 2% 5% 2% 1%;
}
.post .title {
  display: flex; 
  flex-direction: column;
  justify-content: space-around;
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
/* 날짜 부분 */
.right .date {
  font-size: 0.75rem;
}

/* 채팅방에서 사용하기 위해 알림 부분 추가 */
.title .post-contents {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.title .post-contents .non-read {
  margin-right: 2%;
  background-color: #d91a1a;
  border-radius: 50%;
  width: 10%;
  text-align: center;
}
</style>