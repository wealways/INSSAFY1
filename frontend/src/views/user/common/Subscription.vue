<template>
  <div class="scrap">
    <div class="icon">구독 아이콘</div>
    <h3 class="name">보드명</h3>
  </div>
</template>

<script>
export default {
  name: "subscription",
}
</script>

<style scoped>
.scrap {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  border: 4px dotted #797979;
  height: 80px;
}
.scrap .icon {
  border: 2px solid;
  width: 1fr;
  height: 1fr;
  text-align: center;
  padding-top: 10%;
  background-color: #797979;
}
.scrap .name {
  padding: 5%;
}
</style>