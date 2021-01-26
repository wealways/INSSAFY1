<template>
  <div>
    <nav>
      네브바
    </nav>
    <div class="login">
      <h1>로그인</h1>
      <div class="login-form">
        <div class="login-input">
          <div class="input-with-label">
            <label for="email">이메일</label>
            <input
              v-model="email"
              v-bind:class="{ error: error.email && email.length !== 0, complete: !error.email && email.length !== 0 }"
              @keyup.enter="Login"
              id="email"
              placeholder="이메일을 입력하세요."
              type="text"
              autocapitalize="off"
            />
            <div class="error-text" v-if="error.email && email.length !== 0">{{ error.email }}</div>
          </div>
          <div class="input-with-label">
            <label for="email">비밀번호</label>
            <input
              v-model="password"
              type="password"
              v-bind:class="{ error: error.password && password.length !== 0, complete: !error.password && password.length !== 0 }"
              id="password"
              @keyup.enter="onLogin"
              placeholder="비밀번호를 입력하세요."
            />
            <div class="error-text" v-if="error.password && password.length !== 0">{{ error.password }}</div>
          </div>
        </div>
        <button class="tn-login" @click="onLogin" :disabled="!isSubmit" :class="{ disabled: !isSubmit }">로그인</button>
      </div>

      <div class="etc-options">
        <div class="etc-option-item">
          <p>비밀번호 잊으셨나요?</p>
          <a href="">비밀번호찾기</a>
        </div>
        <div class="etc-option-item">
          <p>아직 회원이 아니신가요?</p>
          <router-link to="/user/join" class="btn-text">가입하기</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PV from 'password-validator';
import * as EmailValidator from 'email-validator';
import * as authApi from '@/api/auth';
export default {
  components: {},
  computed: {},
  created() {
    this.component = this;

    this.passwordSchema
      .is()
      .min(8)
      .is()
      .max(100)
      .has()
      .digits()
      .has()
      .letters();
  },
  mounted() {
    let tempEmail = this.$route.params.email;
    if (tempEmail) {
      this.email = tempEmail;
    }
  },
  watch: {
    password: function(v) {
      this.checkForm();
    },
    email: function(v) {
      this.checkForm();
    },
  },
  methods: {
    checkForm() {
      this.email = this.email.toLowerCase();
      if (this.email.length >= 0 && !EmailValidator.validate(this.email)) this.error.email = '이메일 형식이 아닙니다.';
      else this.error.email = false;

      if (this.password.length >= 0 && !this.passwordSchema.validate(this.password)) this.error.password = '영문,숫자 포함 8 자리이상이어야 합니다.';
      else this.error.password = false;

      let isSubmit = true;
      Object.values(this.error).map((v) => {
        if (v) isSubmit = false;
      });
      this.isSubmit = isSubmit;
    },
    onLogin: function() {
      this.$store
        .dispatch('auth/login', {
          email: this.email,
          password: this.password,
        })
        .then((res) => {
          console.log(res);
          if (res.data.message === 'fail') {
            alert('이메일 또는 비밀번호를 다시 확인하여 주십시오.');
            this.password = '';
          } else {
            this.$router.push({ name: 'Main' });
            console.log(this.$store.state.auth.token);
            console.log(this.$store.state.auth.email);
          }
        });
    },
  },
  data: () => {
    return {
      email: '',
      password: '',
      passwordSchema: new PV(),
      error: {
        email: false,
        password: false,
      },
      isSubmit: false,
      component: this,
    };
  },
};
</script>

<style scoped>
.login {
  display: flex;
  flex-direction: column;
  justify-content: center;
  /* align-items: center; */
  max-width: 580px;
  width: 100%;
  margin: 0 auto;
}
.login-form {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  /* align-items: center; */
  height: 40vh;
  width: 100%;
}
.login-input {
  width: 100%;
  float: left;
  position: relative;
  margin-bottom: 10px;
}
input {
  background: transparent;
  font-size: 1em;
  width: 100%;
  height: 50px;
  line-height: 1em;
  border: 1px solid #cccccc;
  padding: 0 20px;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: 0.2s;
  transition: 0.2s;
  outline: none;
}
.etc-options {
  display: flex;
  flex-direction: column;
}
.etc-option-item {
  display: flex;
  justify-content: space-between;
}
.etc-option-item p {
  margin-bottom: 0;
}
.etc-option-item a {
  margin: auto 0;
  margin-bottom: 0;
}
.error-text {
  font-size: 0.8rem;
  color: #ff0404;
}
</style>
