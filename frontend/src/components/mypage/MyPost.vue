<template>
  <div class="post">
    <div class="name">소속보드</div>
    <div class="title">
      <div class="first-line">
        <p>작성한 게시글 제목</p>
        <button>X</button>
      </div>
      <div class="first-line">
        <div>
          <p>2021-01-25</p>
        </div>
        <div style="flex-wrap: no-wrap;">10 5</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MyPost",
}
</script>

<style scoped>
div,
p {
  font-size: 1rem;
}
.post {
  display: flex;
  flex-direction: row;
  border: 4px dotted #797979;
  height: 80px;
}
.post .name {
  border: 2px solid;
  width: 1fr;
  height: 1fr;
  text-align: center;
  padding-top: 5%;
  background-color: #797979;
  box-sizing: border-box;
}
.post .title {
  display: flex; 
  flex-direction: column;
  justify-content: space-between;
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
  border: 1px solid black;
}
.title h4 {
  align-self: flex-end;
}

</style>