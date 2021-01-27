<template>
  <div class="container-box-group">
    <!-- 그룹 소개 이미지 -->
    <div class="group-img">이미지</div>
    <!-- 그룹 소개 -->
    <div class="group-intro">
      <h4>알고리즘 스터디</h4>
      <p>
        알고싶은 알고리즘 ..<br> 
        갖고싶은 알고리즘
      </p>
    </div>
    <!-- 기타 정보 -->
    <div class="group-tools">
      <button>:</button>
      <p>12명</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "StudyGroup"
}
</script>

<style scoped>
.container-box-group {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  border: 1px dotted;
}
/* 그룹 소개 이미지 */
.container-box-group .group-img {
  border: 1px solid;
  border-radius: 50%;
  align-self: center;
  width: 15%;
  height: 80%;
  padding-top: 5%;
}
/* 그룹 소개글 */
.container-box-group .group-intro {
  flex-basis: 65%;
  border: 1px dotted;
}
.container-box-group .group-intro * {
  font-size: 1rem;
}
.container-box-group .group-tools {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-end;
}
</style>