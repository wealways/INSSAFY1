<template>
  <div id="toast">
    <div id="decoration"></div>
    <Myinfo :class="{ none: !getToastType.myinfo }" />
    <Search :class="{ none: !getToastType.search }" />
    <Email :class="{ none: !getToastType.email }" />
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
import Search from './toast_sub/Search';
import Myinfo from './toast_sub/Myinfo';
import Email from './toast_sub/Email';
export default {
  name: 'Toast',
  components: {
    Search,
    Myinfo,
    Email,
  },
  data() {
    return {
      ////////
      //search
      active: {
        index: 0,
        filter: '',
      },
      keyword: '',
      ///////
    };
  },
  computed: {
    ...mapGetters(['getSearchStateFilters', 'getToastType']),
  },
  methods: {
    //search function
    clickFilter: function(index) {
      this.active.index = index;
      this.active.filter = this.filter;
      var value = 54 * index;
      this.$refs.searchBar.style.marginTop = `${value}px`;
    },
    clickCloser: function() {
      this.$store.commit('setToastTogle');
    },
    onSearching: function() {
      this.$store.commit('setToastTogle');
      this.$store.commit('setSearchKeyword', this.keyword);
      // this.$refs.searchBtn.blur();
    },
    clickDeleteBtn: function() {
      this.keyword = '';
    },
  },
};
</script>

<style scoped>
#toast {
  width: 100%;
  border-bottom-left-radius: 30px;
  border-bottom-right-radius: 30px;
  box-shadow: var(--basic-shadow-b);
}
.none {
  display: none !important;
}
#decoration {
  position: absolute;
  top: 0;
  left: 20px;
  width: 6px;
  height: 70%;
  border-bottom-left-radius: 6px;
  border-bottom-right-radius: 6px;
  background-color: var(--basic-color-key);
  box-shadow: var(--basic-shadow-m);
}
@media (max-width: 426px) {
  #decoration {
    display: none;
  }
}
/* ---------------------------------- */
/* 검색 컴포넌트 */
/* ---------------------------------- */
#search-container {
  display: flex;
  flex-direction: row;
  justify-content: center;
  width: 80%;
  max-width: 500px;
  margin: 0 auto;
  transition: all 0.6s ease;
}
#filter-container {
  display: flex;
  flex-direction: column;
}
.filter-btn {
  padding: 5px;
  margin: 10px 0;
  width: 100px;
  height: 34px;
  font-size: 15px;
  border-radius: 28px;
  border: #00000000 solid 1px;
  transition: box-shadow 0.6s ease;
}
.filter-btn:hover {
  background: #ebebe9;
  box-shadow: 10px 10px 20px #bcbcba, -10px -10px 20px #ffffff;
  transition: 0.3s all ease;
}

#search-bar {
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  width: 100%;
  transition: all 0.6s ease;
}

#s-input {
  margin: 10px 10px;
  padding: 0 30px 0 10px;
  width: calc(100% - 50px);
  height: 34px;
  background-color: inherit;
  border: 1px solid #000;
  border-radius: 17px;
  transition: all 0.6s ease;
}

#s-del-btn {
  position: absolute;
  opacity: 0;
  margin: 13px 49px 0 0;
  fill: #00000040;
  transition: opacity 0.6s, fill 0.3s ease;
}
#s-del-btn:hover,
#s-del-btn:active {
  fill: #000000;
}
.visible {
  opacity: 1 !important;
}

#s-btn {
  margin: 10px 0 10px;
  width: 34px;
  height: 34px;
  border: solid 1px #000;
  border-radius: 64px;
  transition: fill 0.6s, background 0.6s ease;
}
#s-btn:hover,
#s-btn:active {
  background-color: #000 !important;
  fill: var(--basic-color-bg);
}
#s-btn svg {
  margin: -3px -1px 0 0;
  width: 18px;
  height: 18px;
}

#closer {
  position: absolute;
  top: 5px;
  right: 5px;
}
</style>
