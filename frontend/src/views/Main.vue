<template>
  <div>
    <h1>{{nickname}}({{email}})님.</h1>
    <h2>안녕하세요!</h2>
    <button v-on:click="goModify">비밀번호 변경</button>
  </div>
</template>

<script>
export default {
  props: {
    data: {
        type: String,
        default : ''
    }
  }, 
  data() {
    return {
      email: '',
      nickname: ''
    }
  },
  created() {
    var temp = this.$route.params.member.split(',');
    this.email = temp[0];
    this.nickname = temp[1];
  },
  methods: {
    goModify: function(){
      this.$router.push({name: 'Modify', params:{email: this.email}});
    }
  },
}
</script>

<style scoped>

</style>