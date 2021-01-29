import Vue from 'vue';
import App from './App.vue';
import VueRouter from 'vue-router';
import routes from './routes';
import store from './vuex/store';

// bootstrap
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';

// fontawesome
import '@/FontAwesomeIcon.js';

Vue.config.productionTip = false;

Vue.use(VueRouter);
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);

//toast
//https://www.npmjs.com/package/vue-toast-notification
import VueToast from 'vue-toast-notification';
// Import one of the available themes
//import 'vue-toast-notification/dist/theme-default.css';
import 'vue-toast-notification/dist/theme-sugar.css';

Vue.use(VueToast, {
  position: 'bottom-right',
  duration: 1000,
  // duration: 1000,
  // position: 'bottom-right',
  // dismissible: true,
  // onClick: function() {
  //   alert('alert');
  // },
  // onDismiss: function() {
  //   alert('dismissed!');
  // },
  // queue: false,
  // pauseOnHover: true,
});

const router = new VueRouter({
  mode: 'history',
  // base: process.env.BASE_URL,
  routes,
  //앞으로가기 뒤로가기시 해당 스크롤 위치 기억
  //native와 유사하게 동작
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition;
    } else {
      return { x: 0, y: 0 };
    }
  },
});

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app');
