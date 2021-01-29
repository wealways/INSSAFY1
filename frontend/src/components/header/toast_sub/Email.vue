<template>
  <div id="email-container">
    <p class="r-desc">로그인하기 위해서는 이메일 인증이 필요합니다.</p>
    <p class="r-desc">이메일로 전송된 <span class="b-desc">인증메일</span>을 확인하고 <span class="b-desc">인증절차</span>를 완료해주세요.</p>
    <button class="filter-btn r-desc" @click="clickDomain">
      <span class="b-desc">{{ getDomain }}</span
      >으로 이동↗
    </button>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  name: 'Email',
  data() {
    return {};
  },
  computed: {
    ...mapGetters(['getDomain']),
  },
  methods: {
    clickCloser: function() {
      this.$store.commit('setToastTogle');
    },
    // Email
    clickDomain: function() {
      window.open(`http://${this.getDomain}`);
      this.clickCloser();
    },
  },
};
</script>

<style scoped>
#email-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 80%;
  max-width: 500px;
  margin: 0 auto;
  transition: all 0.6s ease;
}

.filter-btn {
  padding: 5px 10px;
  margin: 10px auto;
  height: 34px;
  font-size: 14px;
  border-radius: 28px;
  border: #000000 solid 1px;
  transition: color 0.6s, box-shadow 0.6s ease;
}
.filter-btn:hover,
.filter-btn:active {
  color: var(--basic-color-fill3);
  background: #ebebe9;
  border: #00000000 solid 1px;
  box-shadow: 10px 10px 20px #bcbcba, -10px -10px 20px #ffffff;
  transition: 0.3s all ease;
}

#closer {
  position: absolute;
  top: 5px;
  right: 5px;
}

.b-desc {
  color: var(--basic-color-key) !important;
  text-shadow: var(--basic-shadow-s);
}
</style>
