<template>
  <div id="toast">
    <div id="search-container">
      <div id="filter-container">
        <button
          class="filter-btn l-desc"
          :class="{ newmorphism: active.index == index }"
          v-for="(item, index) in getSearchStateFilters"
          :key="index"
          @click="clickFilter(index)"
        >
          {{ item }}
        </button>
      </div>
      <div id="search-container">
        <div id="search-bar" ref="searchBar">
          <input id="s-input" @keyup.enter="onSearching" v-model="keyword" type="text" placeholder="검색어를 입력하세요" />
          <button id="s-del-btn" @click="clickDeleteBtn" :class="{ visible: keyword != '' }">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
              <path
                d="M12 0c-6.627 0-12 5.373-12 12s5.373 12 12 12 12-5.373 12-12-5.373-12-12-12zm4.151 17.943l-4.143-4.102-4.117 4.159-1.833-1.833 4.104-4.157-4.162-4.119 1.833-1.833 4.155 4.102 4.106-4.16 1.849 1.849-4.1 4.141 4.157 4.104-1.849 1.849z"
              />
            </svg>
          </button>
          <button id="s-btn" ref="searchBtn" @click="onSearching">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
              <path
                d="M23.809 21.646l-6.205-6.205c1.167-1.605 1.857-3.579 1.857-5.711 0-5.365-4.365-9.73-9.731-9.73-5.365 0-9.73 4.365-9.73 9.73 0 5.366 4.365 9.73 9.73 9.73 2.034 0 3.923-.627 5.487-1.698l6.238 6.238 2.354-2.354zm-20.955-11.916c0-3.792 3.085-6.877 6.877-6.877s6.877 3.085 6.877 6.877-3.085 6.877-6.877 6.877c-3.793 0-6.877-3.085-6.877-6.877z"
              />
            </svg>
          </button>
        </div>
      </div>
      <button id="closer" @click="clickCloser">
        <svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd">
          <path
            d="M12 11.293l10.293-10.293.707.707-10.293 10.293 10.293 10.293-.707.707-10.293-10.293-10.293 10.293-.707-.707 10.293-10.293-10.293-10.293.707-.707 10.293 10.293z"
          />
        </svg>
      </button>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  name: 'Dropdown',
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
    ...mapGetters(['getSearchStateFilters']),
  },
  methods: {
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
