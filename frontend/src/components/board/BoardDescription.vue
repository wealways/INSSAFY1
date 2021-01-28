<template>
  <div class="board-description">
    <div class="board-name-detail">
      <div class="board-name">보드이름</div>
      <div class="board-detail">보드디테일보드디테일보드디테일보드디테일보드디테일보드디테일보드디테일</div>
    </div>
    <div class="board-hash-people">
      <div class="board-hashtag">#태그#태그#태그#태그#태그</div>
      <div class="board-people"><b-icon icon="person-fill" aria-hidden="true"></b-icon> 50</div>
    </div>
  </div>
</template>

<script>
export default {
  name:"BoardDescription"
}
</script>

<style scoped>
.board-description{
  display: flex;
  flex-direction: column;
}
.board-name{
  font-weight: bold;
  font-size:1.3rem
}
.board-hash-people{
  display: grid;
  place-items: center;
  grid-template-columns: 70% 30%
}
.board-hashtag{
  /* grid:8; */
}
</style>