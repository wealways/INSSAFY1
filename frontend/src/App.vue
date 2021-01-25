<template>
  <div id="app">
    <Nav />
    <router-view></router-view>
  </div>
</template>
<script>
import './components/css/style.scss';
import './components/css/static/style.css';

import Nav from './components/header/Nav.vue';
export default {
  name: 'app',
  components: {
    Nav,
  },
};
</script>

<style scoped></style>
