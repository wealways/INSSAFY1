<!--
  main 페이지 vue
  swiper.js 사용
 -->
<template>
  <div id="main-container">
    <div id="favorite-container" class="m-top">
      <p class="main-title pc-only">즐겨찾기</p>
      <svg id="f-star" class="mobile-only" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
        <path d="M12 .587l3.668 7.568 8.332 1.151-6.064 5.828 1.48 8.279-7.416-3.967-7.417 3.967 1.481-8.279-6.064-5.828 8.332-1.151z" />
      </svg>
      <swiper id="f-swiper" class="swiper" :options="swiperOption" @clickSlide="clickFavorite">
        <swiper-slide v-for="item in list()" v-bind:key="item.id">
          <div class="inner">
            <p id="f-title">{{ item.type }}</p>
            <p id="f-title">{{ item.title }}</p>
            <p id="f-title">{{ item.description }}</p>
            <p id="f-hashtag" class="text-hashtag">
              #싸피 #싸피 #싸피
            </p>
            <div id="f-option">
              <p>new</p>
              <p>{{ item.count }}</p>
            </div>
          </div>
        </swiper-slide>
        <!-- <div class="swiper-button-prev" slot="button-prev"></div>
        <div class="swiper-button-next" slot="button-next"></div> -->
        <div class="swiper-pagination" slot="pagination"></div>
      </swiper>
    </div>
    <div id="curation-container">
      <p id="c-title" class="b-title real-shadow-text">Curation</p>
      <div id="c-list">
        <button class="c-btn real-shadow-box" @click="clickCBtn1">스터디</button>
        <button class="c-btn real-shadow-box" @click="clickCBtn2">학습공유</button>
        <button class="c-btn real-shadow-box" @click="clickCBtn3">채용일정</button>
        <button class="c-btn real-shadow-box" @click="clickCBtn4">중고장터</button>
        <button class="c-btn real-shadow-box" @click="clickCBtn5">대나무숲</button>
      </div>
    </div>
    <div id="popular-container" class="m-top">
      <p class="main-title">인기보드</p>
    </div>
  </div>
</template>

<script>
// import "../../components/css/user.scss";
// import * as authApi from '@/api/auth';

import { Swiper, SwiperSlide } from 'vue-awesome-swiper';
import 'swiper/css/swiper.css';

export default {
  name: 'Main',
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      list: function() {
        var list = [];
        for (let index = 1; index <= 10; index++) {
          var item = {
            id: index,
            type: 'curation',
            title: '보드명',
            description: '보드 설명',
            count: 100,
          };
          list.push(item);
        }
        return list;
      },
      favorite: [
        { id: 1, name: 'slide - 1' },
        { id: 2, name: 'slide - 2' },
        { id: 3, name: 'slide - 3' },
      ],
      swiperOption: {
        effect: 'coverflow',
        grabCursor: true,
        // centeredSlides: true,
        // speed: 300,
        slidesPerView: 5,
        freeMode: true,
        initialSlide: 1,
        coverflowEffect: {
          rotate: 5,
          stretch: -5,
          depth: 50,
          modifier: 1,
          slideShadows: true,
        },
        // navigation: {
        //   nextEl: '.swiper-button-next',
        //   prevEl: '.swiper-button-prev',
        // },
        pagination: {
          el: '.swiper-pagination',
          clickable: true,
        },
        breakpoints: {
          //pc big size
          1536: {
            slidesPerView: 7,
          },
          //pc small size
          769: {
            slidesPerView: 5,
          },
          //tablet
          426: {
            slidesPerView: 3,
          },
          //mobile
          320: {
            slidesPerView: 2,
          },
        },
      },
    };
  },
  methods: {
    clickFavorite: function(index) {
      alert(index + ' slide clicked!');
    },
    clickCBtn1: function() {},
    clickCBtn2: function() {},
    clickCBtn3: function() {},
    clickCBtn4: function() {},
    clickCBtn5: function() {},
  },
};
</script>

<style scoped>
/*-------------------------------------------------- */
/* 공통 영역 */
/*-------------------------------------------------- */
.main-title {
  margin: 0 20px;
  font-family: 'Noto Sans KR', sans-serif;
  font-size: 24px;
  font-weight: 300;
}
@media (max-width: 768px) {
  .main-title {
    margin: 0 15px;
  }
}
@media (max-width: 640px) {
  .main-title {
    margin: 0 10px;
  }
}

.m-top {
  margin-top: 30px;
}

@media (max-width: 426px) {
  .m-top {
    margin-top: 0px;
  }
}
/*-------------------------------------------------- */
/* 즐겨찾기 영역 */
/*-------------------------------------------------- */
#favorite-container {
  width: 100%;
}
#f-star {
  position: absolute;
  z-index: 1;
  margin: 12px;
  fill: #fff;
}
#f-swiper {
  z-index: 0;
}
.swiper-slide {
  position: relative;
}
.swiper-slide:after {
  content: '';
  display: block;
  padding-bottom: 100%;
}
.inner {
  position: absolute;
  width: 100%;
  height: 100%;
  background-color: #ff7d5d;
}
#f-title {
  padding: 10px;
}

.text-hashtag {
  display: -webkit-box;
  display: -ms-flexbox;
  display: box;
  margin: 10px 20px;
  max-height: 80px;
  overflow: hidden;
  vertical-align: top;
  text-align: center;
  text-overflow: ellipsis;
  word-break: break-all;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3;
}
#f-option {
  margin-left: -10px;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  width: 100%;
}

/*-------------------------------------------------- */
/* curation 영역 */
/*-------------------------------------------------- */
#curation-container {
  margin: 0 auto;
  max-width: 780px;
  padding: 0 30px;
  white-space: nowrap;
  overflow-x: auto;
  overflow-y: hidden;
}
@media (max-width: 1023px) {
  #curation-container {
    margin-top: 20px;
    padding: 0px 15px;
  }
}
#c-title {
  position: absolute;
  font-size: 20px;
  padding-top: 30px;
  margin-top: 15px;
  width: 200px;
  text-align: center;
  z-index: 0;
}
@media (max-width: 426px) {
  #c-title {
    display: block;
    margin-left: calc(50% - 115px);
    margin-top: -34px;
    margin-bottom: 5px;
    z-index: 2;
  }
}
#c-list {
  position: relative;
  display: inline-block;
  padding-top: 30px;
  padding-bottom: 30px;
  margin-right: auto;
  margin-left: 0;
  z-index: 1;
  background: #fff; /* fallback for old browsers */
  background: -webkit-linear-gradient(to left, #ffffff00 150px, #ffffffff 200px); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #ffffff00 150px, #ffffffff 200px); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}
#c-list button:first-child {
  margin-left: 200px;
}
@media (max-width: 426px) {
  #c-list {
    background: #fff;
  }
  #c-list button:first-child {
    margin-left: 0;
  }
}
.c-btn {
  width: 100px;
  height: 50px;
  margin-left: 15px;
  border-radius: 10px;
  background-color: rgb(152, 205, 236);
}

/*-------------------------------------------------- */
/* 인기보드 영역 */
/*-------------------------------------------------- */
#popular-container {
  background-color: rgb(105, 194, 253);
  width: 80%;
  height: 600px;
  margin-left: 10%;
  margin-right: 10%;
}
</style>
