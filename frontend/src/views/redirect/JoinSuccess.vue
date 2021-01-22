<template>
  <div>
    <h1>회원가입 인증 메일이 발송되었습니다.<br/>이메일을 확인해주세요.</h1>
    <a :href="domain">메일 서비스 홈페이지로 이동.</a>
  </div>
</template>

<script>
export default {
  data() {  
    return {
      domain:'',
    }
  },
  created() {
    var email = this.$route.params.email;
    // var email = '1234@naver.com';
    this.domain = 'http://' + email.substring(email.indexOf('@')+1, email.length);
    console.log(this.domain);
  },
}
</script>

<style scoped>
a{
  margin-top: 50px;
}
</style>