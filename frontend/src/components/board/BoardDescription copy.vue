<template>
  <div class="board-description">
    <div class="board-name-detail">
      <div class="board-name">보드이름</div>
      <div class="board-detail">보드디테일보드디테일보드디테일보드디테일보드디테일보드디테일보드디테일</div>
    </div>
    <div class="board-hashtag">#태그#태그#태그#태그#태그</div>
  </div>
</template>

<script>
export default {
  name:"BoardDescription"
}
</script>

<style>
.board-description{
  display: flex;
  flex-direction: row;
}
.board-name{
  font-weight: bold;
  font-size:1.3rem
}
</style>