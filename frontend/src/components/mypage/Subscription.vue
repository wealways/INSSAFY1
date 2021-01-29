<template>
  <!-- 배경화면 어둡게 하기 위해 넣은 div -->
  <div>
    <div class="scrap">
      <!-- 보드 아이콘 - 즐겨찾기 -->
      <div class="favorite">
        <font-awesome-icon icon="star"/>
      </div>
      <!-- 보드 이름 -->
      <div class="board-title">
        💻밤새 코딩 lover🤜🤛
      </div>
      <!-- 보드 목록에서 삭제 버튼 -->
      <div class="board-end">
        <button class="delete-btn">
          <font-awesome-icon icon="times"
          class="delete"
          />
        </button>
      </div>
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
  align-content: center;
  margin: 3% 1%;
  background-image: 
    linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.4)),
    url('../../assets/images/slide.jpg');
  background-position: center center;
  background-size: cover;
}
.scrap .favorite {
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin: 5%;
}
/* 내 보드 아이콘 */
.favorite :nth-child(1) {
  font-size: 35px;
  color: #AA2610;
}
.scrap :nth-child(2) {
  color: #EBEBE9;
  display: flex;
  font-size: 1.2rem;
  font-weight: 600;
  align-items: center;
  width: 60%;
}
.board-end {
  width: 20%;
  display: flex;
  justify-content: flex-end;
}
/* 삭제버튼 */
.delete-btn {
  display: flex;
  justify-self: flex-end;
  margin: 10%;
  height: 25%;
}
.delete {
  font-size: 25px;
  color: #fff;
}
</style>