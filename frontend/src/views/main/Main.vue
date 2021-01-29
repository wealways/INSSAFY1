<!--
  main 페이지 vue
  swiper.js 사용
 -->
<template>
  <div id="main-container">
    <div id="favorite-container" class="m-top-s">
      <p id="" class="main-title pc-only">FAVORITE</p>
      <svg id="f-star" class="mobile-only" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
        <path d="M12 .587l3.668 7.568 8.332 1.151-6.064 5.828 1.48 8.279-7.416-3.967-7.417 3.967 1.481-8.279-6.064-5.828 8.332-1.151z" />
      </svg>
      <swiper id="f-swiper" class="swiper" :options="swiperOption" @clickSlide="clickFavorite">
        <swiper-slide v-for="item in list()" v-bind:key="item.id">
          <div class="frame">
            <p id="f-type" class="r-title">{{ item.type }}</p>
            <div class="bg-image"></div>
            <div class="inner">
              <div id="f-title" class="f-text b-desc">{{ item.title }}</div>
              <p id="f-desc" class="f-text r-desc">{{ item.description }}</p>
              <p id="f-hashtag" class="f-text hashtag l-desc">
                {{ item.hashtag }}
              </p>
            </div>
            <div id="f-option" class="t-desc-e">
              <p>new</p>
              <p>{{ item.count }}</p>
            </div>
          </div>
        </swiper-slide>
        <div class="swiper-pagination" slot="pagination"></div>
      </swiper>
    </div>
    <div id="curation-container">
      <p id="c-title" class="b-title">Curation</p>
      <div id="c-list" class="l-desc">
        <button class="c-btn real-shadow-box" @click="clickCBtn1">스터디</button>
        <button class="c-btn real-shadow-box" @click="clickCBtn2">학습공유</button>
        <button class="c-btn real-shadow-box" @click="clickCBtn3">채용일정</button>
        <button class="c-btn real-shadow-box" @click="clickCBtn4">중고장터</button>
        <button class="c-btn real-shadow-box" @click="clickCBtn5">대나무숲</button>
      </div>
    </div>
    <div id="popular-container" class="m-top">
      <p class="main-title">POPULAR</p>
      <div id="p-item-container">
        <Item class="p-item" v-for="(item, index) in popular" :key="`popular${index}`" :item="item" />
      </div>
      <div id="p-item-container">
        <Item class="p-item" v-for="(item, index) in popular" :key="`popular${index}`" :item="item" />
      </div>
    </div>
  </div>
</template>

<script>
// import "../../components/css/user.scss";
// import * as authApi from '@/api/auth';
import { Swiper, SwiperSlide } from 'vue-awesome-swiper';
import 'swiper/css/swiper.css';
import Item from '../../components/board/popular/item.vue';

//toast nority

export default {
  name: 'Main',
  components: {
    //vue-awesome-swiper
    Swiper,
    SwiperSlide,
    //popular
    Item,
    //
  },
  data() {
    return {
      options: {
        width: '400px',
        position: 'bottom-right',
        padding: '1rem',
      },
      popular: [
        {
          type: 'Custom',
          boardName: '여행',
          follower: '609',
          postTitle: ['겨울에는 역시 스키장!', '겨울에는 호떡', '겨울에는 호빵', '겨울에는 눈썰매', '코로나 ㅠㅠ'],
        },
        {
          type: 'Custom',
          boardName: '여행',
          follower: '609',
          postTitle: ['겨울에는 역시 스키장!', '겨울에는 호떡', '겨울에는 호빵', '겨울에는 눈썰매', '코로나 ㅠㅠ'],
        },
        {
          type: 'Custom',
          boardName: '여행',
          follower: '609',
          postTitle: ['겨울에는 역시 스키장!', '겨울에는 호떡', '겨울에는 호빵', '겨울에는 눈썰매', '코로나 ㅠㅠ'],
        },
      ],
      list: function() {
        var list = [];
        for (let index = 1; index <= 10; index++) {
          var item = {
            id: index,
            type: 'curation',
            title: '보드명',
            description: '보드 설명 보드 설명 보드 설명 보드 설명 보드 설명 보드 설명',
            hashtag: '#싸피 #여행 #바다 #싸피 #여행 #바다 #싸피 #여행 #바다 #싸피 #여행 #바다',
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
      this.$router.push({ name: 'Board' });
    },
    clickCBtn1: function() {
      this.$router.push({ name: 'StudyMain' });
    },
    clickCBtn2: function() {
      this.$router.push({ name: 'LearnShare' });
    },
    clickCBtn3: function() {
      this.$router.push({ name: 'Recruitment' });
    },
    clickCBtn4: function() {
      this.$router.push({ name: 'Market' });
    },
    clickCBtn5: function() {
      this.$router.push({ name: 'BambooForest' });
    },
  },
};
</script>

<style scoped>
/*-------------------------------------------------- */
/* 공통 영역 */
/*-------------------------------------------------- */
p {
  margin: 0;
}
.main-title {
  margin: 0 80px;
  font-family: 'Nunito Sans', sans-serif;
  font-style: italic;
  font-size: 24px;
  font-weight: 200;
}
@media (max-width: 1535px) {
  .main-title {
    margin: 0 40px;
  }
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
  fill: var(--basic-color-new);
}
#f-swiper {
  margin-top: -10px;
  z-index: 0;
}
@media (max-width: 426px) {
  #f-swiper {
    margin-top: 0px;
  }
}
.swiper-slide {
  position: relative;
}
.swiper-slide:after {
  content: '';
  display: block;
  padding-bottom: 130%;
}
.frame {
  position: absolute;
  width: 100%;
  height: 100%;
  background-color: var(--basic-color-fill);
}
.bg-image {
  position: absolute;
  z-index: 0;
  width: 90%;
  height: calc(100% - 80px);
  margin: 0 5%;
  color: #fff;
  background-image: url('../../assets/images/slide.jpg');
  background-size: cover;
  /* box-shadow: var(--basic-shadow-s); */
  /* filter: brightness(0.9); */
}
.inner {
  position: relative;
  z-index: 1;
  width: 90%;
  height: calc(100% - 80px);
  margin: 0 auto;
  background: #00000033;
}

#f-type {
  color: var(--basic-color-fill3);
  text-align: center;
  padding: 11px 0 11px;
  width: 100%;
  font-size: 13px;
}
#f-title {
  font-size: 20px;
  text-align: center;
  /* position: absolute;
  z-index: 0 !important; */
  display: inline-block;
  width: auto;
  padding: 4px 30px;
  margin-top: 15%;
  margin-left: calc(-5% - 1px);
  box-shadow: var(--basic-shadow-b);
  background-color: var(--basic-color-new);
}
#f-desc {
  margin: 5% 20px 10%;
  font-size: 14px;
  line-height: 20px;
  max-height: 40px;
  overflow: hidden;
  display: -webkit-box;
  word-break: break-all;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}
#f-hashtag {
  font-size: 12px;
  line-height: 14px;
  margin: 15px 20px 0px;
  max-height: 28px;
  text-align: center;
  overflow: hidden;
  display: -webkit-box;
  word-break: break-all;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}
.f-text {
  color: #fff;
}
.hashtag {
}
#f-option {
  font-size: 13px;
  color: var(--basic-color-bg);
  margin-top: 8px;
  margin-left: -15px;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  width: 100%;
}
#f-option p:first-child {
  transform: translate(10px, -8px);
  letter-spacing: -1px;
  font-weight: 900;
  color: #ff0000cc;
}

/*-------------------------------------------------- */
/* curation 영역 */
/*-------------------------------------------------- */
#curation-container {
  margin: 0 auto;
  max-width: 820px;
  padding: 0 30px;
  white-space: nowrap;
  overflow-x: auto;
  overflow-y: hidden;
}
/* @media (max-width: 1023px) {
  #curation-container {
    margin-top: 20px;
    padding: 0px 15px;
  }
} */
#c-title {
  position: absolute;
  font-size: 20px;
  padding-top: 48px;
  margin-top: 15px;
  width: 200px;
  text-align: center;
  z-index: 0;
}
@media (max-width: 426px) {
  #c-title {
    display: block;
    margin-left: calc(50% - 115px);
    font-size: 16px;
    padding-top: 0;
    z-index: 2;
  }
}
#c-list {
  position: relative;
  display: inline-block;
  padding-top: 50px;
  padding-bottom: 30px;
  margin-right: auto;
  margin-left: 0;
  z-index: 1;
  background: var(--basic-color-bg); /* fallback for old browsers */
  background: -webkit-linear-gradient(to left, #ebebe900 150px, #ebebe9ff 200px); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #ebebe900 150px, #ebebe9ff 200px); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}
#c-list button:first-child {
  margin-left: 200px;
}
@media (max-width: 426px) {
  #c-list {
    padding-top: 40px;
    padding-bottom: 30px;
  }
  #c-list button:first-child {
    margin-left: 0;
  }
}
.c-btn {
  width: 100px;
  height: 50px;
  font-weight: 700;
  color: var(--basic-color-fill3);
  text-shadow: 0 0px 1px var(--basic-color-fill3);
  margin-left: 15px;
  border: none;
  border-radius: 30px;
  background: #ebebe9;
  box-shadow: 10px 10px 20px #bcbcba, -10px -10px 20px #ffffff;
  transition: 0.3s all ease;
}
.c-btn:hover,
c-btn:active {
  background: linear-gradient(145deg, #d4d4d2, #fbfbf9);
  box-shadow: 10px 10px 20px #b3b3b1, -10px -10px 20px #ffffff;
}

/*-------------------------------------------------- */
/* 인기보드 영역 */
/*-------------------------------------------------- */
#popular-container {
  width: 90%;
  height: 600px;
  margin: 0 5%;
}

.p-item-container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.p-item {
  width: 30% !important;
  margin: 10px 1.65%;
  box-shadow: var(--basic-shadow-s);
}
@media (max-width: 768px) {
  .p-item-container {
    display: relative;
    flex-direction: column;
  }
  .p-item {
    width: 100% !important;
  }
}
</style>
