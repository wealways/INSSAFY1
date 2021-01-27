<template>
  <div class="container-box">
    <div class="search-hd">
      <!-- 검색결과 타이틀 -->
      <div class="search-title">
        <p>게시글 중 '게임'에 대한 검색결과 : 0건</p>
      </div>
      <!-- 검색 관련 버튼 -->
      <div class="search-tool">
        <div class="sort">
        <p>게시글 0건</p>
          <select name="sort" class="sort">
            <option value="">정렬기준</option>
            <option value="">최신</option>
            <option value="">인기</option>
          </select>
        </div>
        <button style="background-color: green;">보드생성</button>
      </div>
    </div>
    <div class="search-result">
      <MyPost class="search-result-post"/>    
      <MyPost class="search-result-post"/>    
      <MyPost class="search-result-post"/>        
      <MyPost class="search-result-post"/>        
      <MyPost class="search-result-post"/>        
      <MyPost class="search-result-post"/>        
      <MyPost class="search-result-post"/>        
      <MyPost class="search-result-post"/>        
      <MyPost class="search-result-post"/>        
      <MyPost class="search-result-post"/>        
      <MyPost class="search-result-post"/>        
    </div>
  </div>
</template>

<script>
import MyPost from "@/components/mypage/MyPost.vue"


export default {
  name: "SearchPost",
  components: {
    MyPost,
  },
}
</script>

<style scoped>
/* 전체 페이지 부분 */
.container-box {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  margin: 2% 3% 0 3%;
  border: 4px solid #000000;
}
/* 검색결과 타이틀 부분 */
.container .search-hd {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  padding-top: 0;
  border: 4px solid #000000;
}
.search-hd .search-title {
  display: flex;
  justify-content: center;
  background-color: bisque;
}
.search-hd .search-tool {
  display: flex;
  justify-content: space-between;
}
.search-tool .sort {
  display: flex;
}
/* 검색결과 나오는 게시글들 부분 */
.search-result {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  margin: 0;
  padding-top: 0;
  flex-flow: wrap;
  border: 3px solid #000000;
}
.search-result-post {
  flex-basis: 32.3%;
  /* 위 | 오른쪽 | 아래 | 왼쪽 */
  margin: 0 1% 1% 0;
}


@media (max-width: 425px) {
  .container-box {
    height: 100%;
  }
  .search-result {
    display: flex;
    flex-direction: column;
  }
}
</style>