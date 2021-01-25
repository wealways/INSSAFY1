<template>
  <div id="app">
    <div class="navbar">
      <h1>nav bar</h1>
      </div>
    <router-view></router-view>
  </div>
</template>
<script>

export default {
  name: "app"
};
</script>

<style scoped>
.navbar {
  background-color: blanchedalmond;
}

h1 {
  margin: 0;
}
</style>