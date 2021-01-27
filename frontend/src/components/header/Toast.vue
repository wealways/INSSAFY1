<template>
  <div id="toast">
    <div id="search-container">
      <div id="filter-container">
        <button
          class="filter-btn l-desc"
          :class="{ newmorphism: active.index == index }"
          v-for="(item, index) in filter"
          :key="index"
          @click="clickFilter(index)"
        >
          {{ item }}
        </button>
      </div>
      <div id="search-container">
        <div id="search-bar" ref="searchBar">
          <input id="search-input" type="text" />
          <button>
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
              <path
                d="M23.809 21.646l-6.205-6.205c1.167-1.605 1.857-3.579 1.857-5.711 0-5.365-4.365-9.73-9.731-9.73-5.365 0-9.73 4.365-9.73 9.73 0 5.366 4.365 9.73 9.73 9.73 2.034 0 3.923-.627 5.487-1.698l6.238 6.238 2.354-2.354zm-20.955-11.916c0-3.792 3.085-6.877 6.877-6.877s6.877 3.085 6.877 6.877-3.085 6.877-6.877 6.877c-3.793 0-6.877-3.085-6.877-6.877z"
              />
            </svg>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Dropdown',
  props: {},
  data() {
    return {
      ////////
      //search
      filter: ['보드', '게시물 제목', '게시물 내용'],
      active: {
        index: 0,
        filter: '보드',
      },
      ///////
    };
  },
  computed: {},
  methods: {
    clickFilter: function(index) {
      this.active.index = index;
      this.active.filter = this.filter;
      var value = 54 * index;
      this.$refs.searchBar.style.marginTop = `${value}px`;
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
  width: 500px;
  margin: 0 auto;
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
  transition: box-shadow 0.6s ease-in-out;
}
.filter-btn:hover {
  background: #ebebe9;
  box-shadow: 10px 10px 20px #bcbcba, -10px -10px 20px #ffffff;
  transition: 0.3s all ease;
}
#search-container {
}
#search-bar {
  width: 80%;
  transition: all 0.6s ease;
}
#search-input {
  margin: 10px 0;
  padding: 0 20px;
  width: 70%;
  height: 34px;
  background-color: inherit;
  border: 1px solid #000;
  border-radius: 17px;
  transition: all 0.6s ease;
}
#search-input {
}
</style>
