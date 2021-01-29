<template>
  <div class="container-board">
    <p class="subscription-btn">Like</p>
    <p class="board-name">보드명</p>
    <p class="board-description">보드설명</p>
    <p class="board-hashtag">#여행 #강원도 #무주 #스키 #전남 #스노우보드 #리조트</p>
    <p class="scrap-count">구독자수</p>
  </div>
</template>

<script>
export default {
  name: 'Board',
}
</script>

<style>
.container-board {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: flex-start;
  width: 16rem;
  height: 16rem;
}
.subscription-btn {
  align-self: flex-end;
  margin: 1% 1% 0;
}
.board-name {
  align-self: flex-start;
  margin-left: 3%;
}
.board-description {
  align-self: flex-start;
  margin-left: 3%;
}
.board-name {
}
.board-hashtag {
  align-self: center;
  margin: 5%;
}
.scrap-count {
  align-self: flex-end;
  justify-self: flex-end;
  margin: 3% 2%;
}
</style>