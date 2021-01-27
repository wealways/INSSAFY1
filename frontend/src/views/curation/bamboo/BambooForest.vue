<template>
  <div class="container-box">
    <!-- 대나무숲 해더 -->
    <div class="bamboo-hd">
      <div class="bamboo-title">Curation</div>
      <input type="text">
    </div>
    <!-- 대나무숲 설명과 게시글 나오는 부분 -->
    <div class="bamboo-post-list">
      <div class="bamboo-description">
        <h3>대나무숲</h3>
        <p>마음 터놓고 이야기 해요.<br>
          내 마음을 편하게 이야기하는 공간입니다
        </p>
      </div>
      <BambooPost 
        class="bamboo-post"
      />
      <BambooPost 
        class="bamboo-post"
      />
      <BambooPost 
        class="bamboo-post"
      />
      <BambooPost 
        class="bamboo-post"
      />
      <BambooPost 
        class="bamboo-post"
      />
      <BambooPost 
        class="bamboo-post"
      />
      <BambooPost 
        class="bamboo-post"
      />
      <BambooPost 
        class="bamboo-post"
      />
      <BambooPost 
        class="bamboo-post"
      />
    </div>
  </div>
</template>

<script>
import BambooPost from '@/views/curation/bamboo/BambooPost.vue'

export default {
  name: "BambooForest",
  components: {
    BambooPost,
  }
}
</script>

<style scoped>
.container-box {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  margin: 2% 5% 1% 5%;
  border: 4px solid;
}

/* 해더부분 */
.bamboo-hd {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  border: 2px dotted;
}

.bamboo-title {
  font-size: 2rem;
  border: 1px solid;
  background-color: bisque;
  flex-basis: 33.3%;
}

/* 게시글 리스트 부분 */
.bamboo-post-list {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  flex-basis: 32.3%;
  flex-flow: wrap;
}
.bamboo-post-list .bamboo-description {
  border: 2px outset;
  background-color: azure;
  margin: 0.5%;
  flex-basis: 32.3%;
}
.bamboo-post-list .bamboo-post {
  border: 2px inset #000000;
  margin: 0.5%;
  flex-basis: 32.3%;
}

/* 모바일 웹화면 */
@media (max-width: 425px) {
  .bamboo-post-list {
    flex-direction: column;
  }
  /* 입력하는 창 고정시키고 밑으로 나오게하기 - 구현하기 */
}
</style>