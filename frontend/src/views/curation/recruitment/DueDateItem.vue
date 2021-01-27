<template>
  <div class="container-box-item">
    <!-- 채용일정 제목 -->
    <div class="post-info">
    SSAFY 실습코치(FE)(제목)
    </div>
    <!-- D-day, 마감일시 -->
    <div class="date-info">
      <button>D-20</button>
      <div>21.02.27</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "DueDateItem",
}
</script>

<style scoped>
.container-box-item {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  border: 1px solid;
}
.container-box-item .post-info {
  display: flex;
  border: 1px dotted;
  flex-basis: 60%;
}
.container-box-item .date-info {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  border: 1px dotted;
}
</style>