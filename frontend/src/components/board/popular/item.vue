<template>
  <div id="wrap">
    <div id="popular-item">
      <div id="header">
        <div id="h-bg"></div>
        <div id="h-inner" @click="clickHeader">
          <p id="type" class="l-desc-e">{{ item.type }}</p>
          <p id="board-name" class="b-desc">{{ item.boardName }}</p>
          <p id="follower" class="l-desc-e">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
              <path
                d="M17.997 18h-11.995l-.002-.623c0-1.259.1-1.986 1.588-2.33 1.684-.389 3.344-.736 2.545-2.209-2.366-4.363-.674-6.838 1.866-6.838 2.491 0 4.226 2.383 1.866 6.839-.775 1.464.826 1.812 2.545 2.209 1.49.344 1.589 1.072 1.589 2.333l-.002.619zm4.811-2.214c-1.29-.298-2.49-.559-1.909-1.657 1.769-3.342.469-5.129-1.4-5.129-1.265 0-2.248.817-2.248 2.324 0 3.903 2.268 1.77 2.246 6.676h4.501l.002-.463c0-.946-.074-1.493-1.192-1.751zm-22.806 2.214h4.501c-.021-4.906 2.246-2.772 2.246-6.676 0-1.507-.983-2.324-2.248-2.324-1.869 0-3.169 1.787-1.399 5.129.581 1.099-.619 1.359-1.909 1.657-1.119.258-1.193.805-1.193 1.751l.002.463z"
              />
            </svg>
            {{ item.follower }}
          </p>
        </div>
      </div>
      <div id="posts">
        <div id="p-inner">
          <div id="p-top"></div>
          <swiper v-once class="swiper" :options="swiperOption2" @clickSlide="clickTitle">
            <swiper-slide class="p-slide r-desc">보드 내 게시물 제목1</swiper-slide>
            <swiper-slide class="p-slide r-desc">보드 내 게시물 제목2</swiper-slide>
            <swiper-slide class="p-slide r-desc">보드 내 게시물 제목3</swiper-slide>
            <swiper-slide class="p-slide r-desc">보드 내 게시물 제목4</swiper-slide>
            <swiper-slide class="p-slide r-desc">보드 내 게시물 제목5</swiper-slide>
          </swiper>
          <div id="p-bottom"></div>
        </div>
        <div id="follow-togle">
          <b-icon icon="heart" aria-hidden="true" style="width: 28px; height: 28px; color: #aa2610;" />
          <b-icon
            id="f-icon"
            :class="{ clear: followState }"
            icon="heart-fill"
            @click="clickFollow"
            aria-hidden="true"
            style="width: 28px; height: 28px; color: #aa2610;"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { Swiper, SwiperSlide } from 'vue-awesome-swiper';
import 'swiper/css/swiper.css';

export default {
  name: '',
  props: {
    item: Object,
  },
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      followState: false,
      swiperOption2: {
        effect: 'coverflow',
        coverflowEffect: {
          rotate: 5,
          stretch: -5,
          depth: 100,
          modifier: 1,
          slideShadows: false,
        },
        grabCursor: true,
        freeMode: true,
        // threshold: 20,
        autoplay: {
          delay: 3000,
        },
        on: {
          init: this.init,
          sliderMove: this.stopAutoplay,
          slideChangeTransitionState: this.stopAutoplay,
          transitionEnd: this.startAutoplay,
        },
        direction: 'vertical',
        slidesPerView: 5,
        spaceBetween: 0,
        loop: true,
      },
    };
  },
  mounted() {},
  computed: {},
  methods: {
    clickHeader: function() {
      this.$router.push({ name: 'Board' });
    },
    clickTitle: function() {
      this.$router.push({ name: 'Post' });
    },
    clickFollow: function() {
      this.followState = !this.followState;
      this.$toast.open({
        message: 'follow!',
        type: 'default',
      });
    },
  },
};
</script>

<style scoped>
#wrap {
  display: inline-block;
}
#popular-item {
  display: flex;
  flex-direction: row;
  width: 100%;
  height: 100%;
}
#header {
  position: relative;
  width: 28%;
}
#header:after {
  content: '';
  display: block;
  padding-bottom: 100%;
}
#h-bg {
  width: 100%;
  height: 100%;
  position: absolute;
  z-index: 1;
  background-image: url(../../../assets/images/slide.jpg);
  background-size: cover;
}
#h-inner {
  display: flex;
  flex-direction: column;
  justify-content: center;
  color: #fff;
  position: absolute;
  width: 100%;
  height: 100%;
  z-index: 2;
  box-shadow: var(--basic-shadow-b);
  background-color: #00000055;
}
#h-inner svg {
  margin-top: -5px;
  fill: #fff;
}
#type {
  margin: 0;
  text-align: center;
}
#board-name {
  margin: 20% 0;
  font-size: 24px;
  text-align: center;
}
#follower {
  margin: 0;
  text-align: center;
}
@media (max-width: 426px) {
  #type {
    font-size: 12px;
  }
  #board-name {
    margin: 8% 0;
    font-size: 18px;
  }
  #follower {
    font-size: 12px;
  }
}

#posts {
  position: relative;
  width: 72%;
}
#posts:after {
  content: '';
  display: block;
  padding-bottom: 40%;
}
#p-inner {
  display: flex;
  flex-direction: column;
  justify-content: center;
  position: absolute;
  background-color: #fff;
  width: 100%;
  height: 100%;
}
#p-top {
  width: 100%;
  height: 20%;
  position: absolute;
  top: 0;
  z-index: 2;
  background: #ffffffff; /* fallback for old browsers */
  background: -webkit-linear-gradient(to bottom, #ffffff 20%, #ffffff00); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to bottom, #ffffff 20%, #ffffff00); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}
#p-bottom {
  width: 100%;
  height: 20%;
  position: absolute;
  top: calc(100% - 20%);
  z-index: 1;
  background: #ffffffff; /* fallback for old browsers */
  background: -webkit-linear-gradient(to top, #ffffff 20%, #ffffff00); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to top, #ffffff 20%, #ffffff00); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}
#follow-togle {
  position: absolute;
  z-index: 5;
  top: 10px;
  right: 10px;
}
#f-icon {
  position: absolute;
  left: 0;
  transition: opacity 0.3s ease-in-out;
}
.p-slide {
  font-size: 34px;
}
@media (max-width: 2000px) {
  .p-slide {
    font-size: 12px;
  }
  #type {
    font-size: 12px;
  }
  #board-name {
    margin: 8% 0;
    font-size: 18px;
  }
  #follower {
    font-size: 12px;
  }
}
@media (max-width: 768px) {
  .p-slide {
    font-size: 20px;
  }
}
@media (max-width: 768px) {
  .p-slide {
    font-size: 20px;
  }
}
@media (max-width: 426px) {
  .p-slide {
    font-size: 15px;
  }
}
</style>
