<template>
  <div id="nav-container">
    <div id="nav-logo" @click="clickLogo"></div>
    <div id="nav-btn-container">
      <div class="icon-btn" @click="clickBtn1"></div>
      <div class="icon-btn" @click="clickBtn2"></div>
      <div class="icon-btn" @click="clickBtn3"></div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Nav',
  props: {
    msg: String,
  },
  data() {
    return {};
  },
  computed: {},
  methods: {
    clickLogo: function() {
      alert('router.push => Main');
      this.$router.push({ name: 'Main' });
    },
    clickBtn1: function() {
      alert('clicked Btn1');
    },
    clickBtn2: function() {
      alert('clicked Btn2');
    },
    clickBtn3: function() {
      alert('clicked Btn3');
    },
  },
};
</script>

<style scoped>
#nav-container {
  top: 0;
  width: 100%;
  height: 60px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  background-color: #89defe;
}

#nav-logo {
  width: 100px;
  height: 40px;
  margin: 10px;
  background-color: #21b0f5;
}
#nav-btn-container {
  height: 40px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.icon-btn {
  margin: 10px 10px;
}
</style>
