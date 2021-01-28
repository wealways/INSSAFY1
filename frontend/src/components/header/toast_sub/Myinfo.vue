<template>
  <div id="info-container">
    <button v-for="(item, index) in infoList" :key="`info${index}`" class="b-desc-e filter-btn" @click="clickInfoBtn(index)">
      {{ item }}
    </button>
    <div class="line"></div>
    <button v-for="(item, index) in linkList" :key="`link${index}`" class="b-desc-e filter-btn" @click="clickLinkBtn(index)">
      {{ item }}
    </button>
    <button id="closer" @click="clickCloser">
      <svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd">
        <path
          d="M12 11.293l10.293-10.293.707.707-10.293 10.293 10.293 10.293-.707.707-10.293-10.293-10.293 10.293-.707-.707 10.293-10.293-10.293-10.293.707-.707 10.293 10.293z"
        />
      </svg>
    </button>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  name: 'Info',
  data() {
    return {
      infoList: ['My Info', 'Notify', 'Logout'],
      linkList: ['edu.ssafy↗', 'lab.ssafy↗', 'project.ssafy↗'],
    };
  },
  computed: {
    ...mapGetters(['getSearchStateFilters']),
    isLoginRoute: function() {
      return this.$route.name == 'Login';
    },
  },
  methods: {
    clickCloser: function() {
      this.$store.commit('setToastTogle');
    },
    // Myinfo
    clickInfoBtn: function(index) {
      switch (index) {
        case 0:
          this.$router.push({ name: 'Mypage' });
          break;
        case 1:
          alert('clicked notify');
          break;
        case 2: //로그아웃
          // this.$store.dispatch('auth/logout');
          this.$store.commit('auth/setLogoutState');
          break;
        default:
          break;
      }
      this.clickCloser();
    },
    clickLinkBtn: function(index) {
      switch (index) {
        case 0:
          window.open('http://edu.ssafy.com/');
          break;
        case 1:
          window.open('https://lab.ssafy.com/');
          break;
        case 2:
          window.open('https://lab.ssafy.com/');
          break;
        default:
          break;
      }
      this.clickCloser();
    },
  },
};
</script>

<style scoped>
#info-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 80%;
  max-width: 500px;
  margin: 0 auto;
  transition: all 0.6s ease;
}

.filter-btn {
  padding: 5px;
  margin: 10px auto;
  width: 120px;
  height: 34px;
  font-size: 14px;
  border-radius: 28px;
  border: #00000000 solid 1px;
  transition: color 0.6s, box-shadow 0.6s ease;
}
.filter-btn:hover,
.filter-btn:active {
  color: var(--basic-color-fill3);
  background: #ebebe9;
  box-shadow: 10px 10px 20px #bcbcba, -10px -10px 20px #ffffff;
  transition: 0.3s all ease;
}

.visible {
  opacity: 1 !important;
}
#closer {
  position: absolute;
  top: 5px;
  right: 5px;
}
</style>
