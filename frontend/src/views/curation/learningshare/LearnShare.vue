<template>
  <div class="container-box">
    <!-- 왼쪽 메뉴 부분 -->
    <div class="left-info">
        <!-- Curation -->
        <div class="title">
          <h4>curation</h4>
        </div>
        <!-- 해당 큐레이션 description -->
        <div class="description">
          <h4>학습공유</h4>
          <p>
            오늘의 학습내용<br>
            함께 나누고픈 내용 공유
          </p>
        </div>
        <!-- 랭킹 -->
        <div class="ranking">
          <h4>RANK</h4>
          <p>오늘의 1등: 멍청한 소라게</p>
          <p>오늘의 2등: 왈왈한 소라게</p>
          <p>오늘의 3등: 냥냥한 소라게</p>
        </div>
        <!-- 워드 클라우드 부분 -->
        <div class="word-cloud">
          워드 크라우드 부분
        </div>
    </div>
    <div class="center-post">
      <!-- 검색 돋보기 아이콘 -->
      <div class="search-bar">
      🔍검색창 들어갈 부분
      </div>
      <!-- 게시글 작성 -->
      <div class="create-post">
      <button>게시글 작성 버튼</button>
      </div>
      <!-- 각각의 게시글 들어갈 부분 -->
      <Post 
        class="post-list"
      />
      <Post 
        class="post-list"
      />
      <Post 
        class="post-list"
      />
    </div>
  </div>
</template>

<script>
import Post from "@/components/board/Post.vue"

export default {
  name:'LearnShare',
  components: {
    Post,
  },
}
</script>

<style scoped>
.container-box {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin: auto;
  border: 2px solid #000000;
  height: 100vh;
  margin: 1% 7%;
}
/* 왼쪽 메뉴바 부분 */
.container-box .left-info {
  display: flex;
  flex-direction: column;
  /* justify-content: space-between; */
  background-color: bisque;
  flex-basis: 32%;
}
/* 학습공유 보드 설명 */
.left-info .description {
  border: 2px dotted;
  padding-top: 2%;
  padding-left: 4%;
  flex-basis: 20%;
}
/* 학습공유 랭킹시스템 */
.left-info .ranking {
  border: 2px dotted;
  padding-top: 2%;
  padding-left: 5%;
  margin-top: 5%;
}
/* 워드 클라우드 부분 */
.left-info .word-cloud {
  display: flex;
  justify-content: center;
  flex-basis: 32%;
  border: 2px inset #000000;
  margin-top: 5%;
}

/* 가운데 게시글 부분 */
.container-box .center-post {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  background-color: pink;
  flex-basis: 63%;
  border: 4px solid;
}

/* 검색창 */
.center-post .search-bar {
  align-self: flex-end;
}

/* 각각의 게시글들 */
.center-post .post-list {
  border: 2px dotted;
  margin: 2% 2%;
}

/* 모바일 웹화면 */
@media (max-width: 425px) {
  .container-box {
    flex-direction: column;
  }
}
</style>