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
          <h4>중고장터</h4>
          <p>
            내겐 필요없는게<br>
            누군가에겐 꼭 필요하다면?
          </p>
        </div>
        <!-- 관심품목 목록보기 -->
        <div class="prefer-item-list">
          <h4>관심 품목</h4>
          <MarketItem />
          <MarketItem />
          <MarketItem />
          <MarketItem />
          <MarketItem />
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
    </div>
  </div>
</template>

<script>
// 게시물
import Post from "@/components/board/Post.vue"
// 관심 품목 등록 리스트
import MarketItem from "@/views/curation/market/MarketItem.vue"

export default {
  name:'Study',
  components: {
    Post,
    MarketItem,
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
  background-color: bisque;
  flex-basis: 32%;
}
/* 스터디 보드 설명 */
.left-info .description {
  border: 2px dotted;
  padding-top: 2%;
  padding-left: 4%;
  flex-basis: 20%;
}
/* 관심품목 리스트 */
.left-info .prefer-item-list {
  display: flex;
  flex-direction: column;
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