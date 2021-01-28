<template>
  <div class="container-box">
    <div id="left-sidebar" class="column">
      <!-- 사용자 정보 보여주는 부분 -->
      <div class="user-profile">
        <div class="hd">
          <h2 class="info">내 정보</h2>
          <button>edit</button>
        </div>
        <div class="img">
          <span>프로필 사진</span>
          <div>edit</div>
        </div>
        <div class="my-info">
          <h3 style="margin: 5% 0 0 0;">사용자 닉네임</h3>
          <!-- <input type="text" placeholder="닉네임"> -->
          <p style="margin: 0;">사용자 이메일</p>
          <!-- <input type="text" placeholder="이메일"> -->
          <p style="margin: 0;">사용자 지역 기수</p>
          <!-- <input type="text" placeholder="지역"> -->
        </div>
      </div>
      <div class="password-change">
        <hr color="black" width="100%">
        <p>비밀번호 변경</p>
      </div>
    </div>
    <!-- 모바일 화면에서 보여줄 이동탭(구독/내글/내댓글/스크랩) -->
    <div class="mobile-tap">
      <!-- 구독보드 탭 -->
      <div 
        @click="clickMyBoard"
      >
        <font-awesome-icon 
          icon="folder" 
          :class="{focustap : mobileTap[0]}"
        />
      </div>
      <!-- 내 작성글 -->
      <div
        @click="clickMyPost"
      >
        <font-awesome-icon 
          icon="th-list"
          :class="{focustap : mobileTap[1]}"
        />
      </div>
      <!-- 내 작성댓글 -->
      <div
        @click="clickMyComment"
      >
        <font-awesome-icon 
          icon="comment-alt"
          :class="{focustap : mobileTap[2]}"
        />
      </div>
      <!-- 내 스크랩 게시글 -->
      <div
        @click="clickMyScrap"
      >
        <font-awesome-icon 
          icon="bookmark"
          :class="{focustap : mobileTap[3]}"
        />
      </div>
    </div>
    <div 
      class="my-board column z-index-forward" 
      :class="{focuslist : mobileTap[0]}"
    >
      <h2>내 보드</h2>
      <Subscription />
      <Subscription />
      <Subscription />
    </div>
    <div 
      class="my-post column z-index-back"
      :class="{focuslist : mobileTap[1]}"
    >
      <!-- 내가 작성한 글 컴포넌트 -->
      <h2>내 작성글</h2>
      <MyPost />
      <MyPost />
      <MyPost />
      <MyPost />
    </div>
    <div 
      class="my-comment column z-index-back"
      :class="{focuslist : mobileTap[2]}"
    >
      <!-- 내가 작성한 댓글 컴포넌트 -->
      <h2>내 댓글</h2>
      <MyPost />
      <MyPost />
      <MyPost />
    </div>
    <div 
      class="my-scrap column z-index-back"
      :class="{focuslist : mobileTap[3]}"
    >
      <!-- 내가 스크랩한 글 컴포넌트 -->
      <h2 style="margin: 0;">스크랩</h2>
      <ScrapPost />
      <ScrapPost />
      <ScrapPost />
      <ScrapPost />
      <ScrapPost />
    </div> 
  </div>
</template>

<script>
import Subscription from "@/components/mypage/Subscription.vue"
import MyPost from "@/components/mypage/MyPost.vue"
import ScrapPost from "@/components/mypage/ScrapPost.vue"

export default {
  name: "mypage",
  components: {
    Subscription,
    MyPost,
    ScrapPost,
  },
  data() {
    return {
      mobileTap: [true, false, false, false],
    }
  },
  methods: {
    clickMyBoard: function() {
      // 전체 false로 초기화
      this.mobileTap = this.mobileTap.map(function (el) {
        return false
      })
      // 클릭하게 되면 index를 가장 높게 만들겠다
      this.mobileTap[0] = true;
    },
    clickMyPost: function() {
      // 전체 false로 초기화
      this.mobileTap = this.mobileTap.map(function (el) {
        return false
      })
      // 클릭하게 되면 index를 가장 높게 만들겠다
      this.mobileTap[1] = true;
    },
    clickMyComment: function() {
      // 전체 false로 초기화
      this.mobileTap = this.mobileTap.map(function (el) {
        return false
      })
      // 클릭하게 되면 index를 가장 높게 만들겠다
      this.mobileTap[2] = true;
    },
    clickMyScrap: function() {
      // 전체 false로 초기화
      this.mobileTap = this.mobileTap.map(function (el) {
        return false
      })
      // 클릭하게 되면 index를 가장 높게 만들겠다
      this.mobileTap[3] = true;
    },
  },
}
</script>
<style scoped>
/* 마이페이지 전체 컨테이너 속성 */
.container-box {
  font-family: sans-serif;
  display: grid;
  grid-template-rows: 1fr 2fr;
  grid-template-columns: repeat(4, 1fr);
  grid-template-areas: 
    "info mypost mycomment scrap"
    "myboard mypost mycomment scrap";
  margin: 0 5% 0 5%;
  height: 100vh;
  }
/* 전체 페이지의 컬럼 */
.container-box .column {
  flex-basis: 24%;
}
/* 각 컬럼들 - 내정보&구독 / 작성글 / 작성 댓글/ 스크랩한 글 */
div > div {
  padding-top: 0;
}
/* 내 정보 보여줄 부분 */
#left-sidebar {
  grid-area: info;
  display: flex;
  flex-direction: column;
  align-items: stretch;
}

.my-board {
  grid-area: myboard;
}
.my-post {
  grid-area: mypost;
}
.my-comment {
  grid-area: mycomment;
}
.my-scrap {
  grid-area: scrap;
}

/* 사용자 정보관련 */
.user-profile {
  display: grid;
  grid-template-rows: 1fr 3fr 2fr 1fr;
  grid-template-columns: repeat(4, 1fr);
  grid-template-areas: 
    "hd hd hd hd"
    ". img img ."
    "myinfo myinfo myinfo myinfo"
    "pw pw pw pw";
  place-content: center;
  align-items: center;
}
/* 내 정보의 header */
.hd {
  grid-area: hd;
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  align-self: flex-start;
  margin: 5%;
}
.hd .info {
  margin: 0;
}
/* 프로필 이미지 부분 */
.img {
  grid-area: img;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  border: 1px solid;
  border-radius: 50%;
  height: 78%;
}
/* 프로필 이미지 편집 버튼 */
.img div {
  z-index: 1;
  position: relative;
  display: table-cell;
  left: 30%;
  top: 25%;
  background-color: antiquewhite;
  width: 30%;
  text-align: center;
}
/* 사용자 입력값 보여줄 부분 */
.my-info {
  grid-area: myinfo;
  display: flex;
  flex-direction: column;
}
/* 비밀번호 변경 */
.password-change {
  grid-area: pw;
  text-align: end; 
  margin: 0;
}
/* 모바일 이동 탭 */
.mobile-tap {
  grid-area: tap;
  display: none;
}

/* 모바일 웹 반응형 사이즈 */
@media (max-width: 425px) {
  /* 마이페이지 전체 컨테이너 속성 */
  .container-box {
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: column;
    margin: 0.5rem 0.5rem;
  }
  /* 사용자 정보관련 */
  .user-profile {
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    box-sizing: border-box;
  }
  .hd {
    display: flex;
    order: 1;
    box-sizing: border-box;
    margin: 0;
    padding-left: 28%;
    padding-top: 2%;
  }
  .info {
    display: none;
  }
  .img {
    display: flex;
    flex-direction: column;
    text-align: center;
    border: 1px solid;
    border-radius: 50%;
    width: 20%;
    height: 60%;
    margin: 0 2%;
    padding: 2%;
  }
  .my-info {
    flex-basis: 60%;
  }
  .password-change > p {
    margin: 0;
  }
  /* 모바일 이동 탭 */
  .mobile-tap {
    display: flex;
    justify-content: center;
    align-content: center;
    background-color: #695C4C;
  }
  .mobile-tap div {
    margin: 4% auto;
    color: #ffffff;
    font-size: 30px;
  }
  /* 첫 모바일 화면에서 진입시 */
  .z-index-forward {
    border: 5px solid;
    background-color: #ebebe9;
    position: absolute;
    width: 96%;
    height: 70%;
    top: 34%;
    z-index: 1;
  }
  .z-index-back {
    background-color: #ebebe9;
    position: absolute;
    width: 96%;
    height: 70%;
    z-index: 0;
    top: 34%;
  }
  /* 화면 탭 클릭시 탭 강조 */
  .focustap {
    color:#0B2945;
  }
  /* 화면 탭 클릭시 보여줄 리스트 옵션 - 최상위로 */
  .focuslist {
    z-index: 10;
  }
}

</style>