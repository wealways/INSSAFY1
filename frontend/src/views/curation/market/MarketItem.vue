<template>
  <div class="container-box-item">
    <div>이미지</div>
    <!-- 게시글 제목 -->
    <div class="post-info">
    가로본능 팔아요!(제목)
    </div>
    <!-- 판매상태 여부 버튼, 작성일 정보 -->
    <div class="item-info">
      <button>판매중</button>
      <div>01.27</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MarketItem",
}
</script>

<style scoped>
.container-box-item {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  border: 1px solid;
}
.container-box-item .post-info {
  display: flex;
  border: 1px dotted;
  flex-basis: 60%;
}
.container-box-item .item-info {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  border: 1px dotted;
}
.item-info div {
  text-align: end;
}
</style>