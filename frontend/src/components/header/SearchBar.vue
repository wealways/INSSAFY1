<template>
  <div id="search-bar" v-if="getSearchState.active">
    <input type="text" name="keyword" id="keyword" />
    <button>
      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
        <path
          d="M23.954 21.03l-9.184-9.095 9.092-9.174-2.832-2.807-9.09 9.179-9.176-9.088-2.81 2.81 9.186 9.105-9.095 9.184 2.81 2.81 9.112-9.192 9.18 9.1z"
        />
      </svg>
    </button>
  </div>
</template>

<script>
import { mapState, mapGetters } from 'vuex';

export default {
  name: 'Nav',
  data() {
    return {};
  },
  computed: {
    ...mapGetters(['getSearchState']),
  },
  methods: {
    clickLogo: function() {
      alert('router.push => Main');
      this.$router.push({ name: 'Main' });
    },
    clickNBtn1: function() {
      alert('clicked Btn1');
    },
    clickNBtn2: function() {
      alert('clicked Btn2');
    },
    clickNBtn3: function() {
      alert('clicked Btn3');
    },
    //moblie
    clickHanberger: function() {
      alert('clicked hamberger');
    },
    clickSearch: function() {
      alert('click Search');
    },
    clickLoginBtn: function() {
      this.$router.push({ name: 'Login' });
    },
  },
};
</script>

<style scoped>
#search-bar {
  position: absolute;
  top: 0;
  width: 100%;
  transition: 0.3s all;
}

svg {
  fill: #000;
  width: 24px;
  height: 24px;
}

input {
  width: 0px;
  height: 40px;
  margin: 5px 10px;
  background-color: inherit;
  border: #000 1px solid;
}
#search-bar {
  /* transform: translateX(-100px); */
}
</style>
