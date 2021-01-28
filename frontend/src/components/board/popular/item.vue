<template>
  <div id="popular-item">
    <div id="header">
      <div class="inner">
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
      <swiper class="swiper" :options="swiperOption">
        <swiper-slide>Slide 1</swiper-slide>
        <swiper-slide>Slide 2</swiper-slide>
      </swiper>
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
      swiperOption: {
        direction: 'vertical',
        slidesPerView: 1,
        spaceBetween: 30,
        mousewheel: true,
        // loop: true,
        pagination: {
          el: '.swiper-pagination',
          clickable: true,
        },
      },
    };
  },
  mounted() {
    console.log(this.item);
  },
  computed: {},
  methods: {},
};
</script>

<style scoped>
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
.inner {
  display: flex;
  flex-direction: column;
  justify-content: center;
  position: absolute;
  width: 100%;
  height: 100%;
  background-color: var(--basic-color-fill3);
  box-shadow: var(--basic-shadow-s);
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
  align-items: inherit;
  width: 72%;
  height: 10%;
  background-color: var(--basic-color-fill2);
}
</style>
