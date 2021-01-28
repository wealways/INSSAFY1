<template>
  <div class="scrap">
    <!-- 보드 아이콘 -->
    <div class="icon">
      <font-awesome-icon icon="folder"/>
    </div>
    <!-- 보드 이름 -->
    <div>

    </div>
  </div>
</template>

<script>
export default {
  name: "Subscription",
}
</script>

<style scoped>
.scrap {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  border: 4px dotted #797979;
  margin: 3% 1%;
}
.scrap .icon {
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin: 5%;
}
.icon :nth-child(1) {
  font-size: 45px;
  color: #0B2945;
}
.scrap .name {
  padding: 5%;
}
</style>