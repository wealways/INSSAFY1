<template>
  <div>
    <b-container>
      <b-row>
        <b-col cols="6" class="banner">
          <div>
            <img src="@/assets/images/login-img.jpg" alt="" width="100%">
          </div>
          <!-- <h2 class="b-title">for SSAFY</h2> -->
          
        </b-col>
        <b-col class="login">
          <h2 class="b-title">로그인</h2>
          <p class="b-title">In SSAFY 하시려면 로그인해주세요</p>
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
            <button id="login-btn" class="b-title" @click="onLogin" :disabled="!isSubmit" :class="{ disabled: !isSubmit }">Login</button>
          </div>
          <div class="etc-options">
            <div class="etc-option-item">
              <!-- <p>아직 회원이 아니신가요?</p> -->
              <router-link to="/join" class="btn-text">회원가입</router-link>
            </div>
            <div class="etc-option-item">
              <!-- <p>비밀번호 잊으셨나요?</p> -->
              <router-link to="" class="btn-text">비밀번호 찾기</router-link>
            </div>
          </div>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import PV from 'password-validator';
import * as EmailValidator from 'email-validator';
export default {
  components: {},
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
  computed: {
    nextRoute() {
      // return this.$route.params.nextRoute ? this.$route.params.nextRoute : '';
      return '';
    },
  },
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
  mounted() {},
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
            this.$router.replace(`/${this.nextRoute}`);
            // this.$router.push({ name: 'Main' });
            // console.log(this.$store.state.auth.token);
            // console.log(this.$store.state.auth.email);
          }
        });
    },
  },
};
</script>

<style scoped>
.row {
  margin-top:50px;
}
.banner{
  display: flex;
  flex-direction: column;
  justify-content: center;
  /* align-items: flex-end; */
  background-color: #fff;
}
.banner h2{
  text-align: end;
}
.login {
  display: flex;
  flex-direction: column;
  justify-content: center;
  max-width: 580px;
  width: 100%;
  padding-top: 30px;
  padding-bottom: 30px;
  background-color: #fff;
}
h2{
  margin-bottom: 30px;
}
.login p {
  color:#949590;
  font-weight:300;
  margin-bottom: 3rem;
}
.login-form {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  /* align-items: center; */
  /* height: 30vh; */
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
  flex-direction: row;
  justify-content: space-between;
  /* margin-top: 10px; */
}
.etc-option-item {
  display: flex;
  justify-content: space-between;
}
.etc-option-item p {
  margin-bottom: 0;
  color:#949590;
}
.etc-option-item a {
  margin: auto 0;
  margin-bottom: 0;
}
.error-text {
  font-size: 0.8rem;
  color: #ff0404;
}
.btn-text{
  color:#949590;
  font-weight: 800;
  text-decoration:none
}
#login-btn {
  width: 100%;
  height: 40px;
  margin-top: 100px; 
  margin-bottom: 20px;
  
  
  font-size: 24px;
  transition: color 0.3s, background-color 0.3s ease;
}
#login-btn:hover,
#login-btn:active {
  background-color: #000 !important;
  color: #fff;
}
@media screen and (min-width:576px) {
  .login {
  display: flex;
  flex-direction: column;
  justify-content: center;
  /* align-items: center; */
  max-width: 580px;
  width: 100%;
  padding: 60px 70px;
  border-width:0.5px;
  }
  .row{
    border:1px #949590 solid;
  }
}
@media screen and (max-width:576px) {

  #login-btn{
    background-color: #000 !important;
    color: #fff;
  }
  .banner{
    display: none;
  }
}

/* 스켈레톤에서 가져온거 */
.input-with-label {
  width: 100%;
  float: left;
  position: relative;
  margin-bottom: 10px;
}

.input-with-label input[type="text"],
.input-with-label input[type="password"] {
  width: 100%;
  float: left;
  height: 50px;
  line-height: 1;
  padding: 2px 15px 0 105px;
  -webkit-box-sizing: border-box;
          box-sizing: border-box;
  color: #000;
  border: 1px solid #000;
  border-radius: 3px;
}

.input-with-label input[type="text"]:hover, .input-with-label input[type="text"]:focus,
.input-with-label input[type="password"]:hover,
.input-with-label input[type="password"]:focus {
  border: 2px solid #000;
}

.input-with-label input[type="text"].error,
.input-with-label input[type="password"].error {
  border-radius: 0;
  border: none;
  border-bottom: 1px solid #EE4B55;
}

.input-with-label input[type="text"].complete,
.input-with-label input[type="password"].complete {
  border-radius: 0;
  border: none;
  border-bottom: 1px solid #3893A8;
}

.input-with-label input[type="text"].disabled,
.input-with-label input[type="password"].disabled {
  background: #eee;
  color: #333;
  font-weight: 600;
}

.input-with-label input[type="text"].disabled:hover, .input-with-label input[type="text"].disabled:focus,
.input-with-label input[type="password"].disabled:hover,
.input-with-label input[type="password"].disabled:focus {
  border: 1px solid #000;
}

.input-with-label label {
  position: absolute;
  left: 15px;
  top: 19px;
  color: #000;
  font-weight: 600;
  font-size: 0.857em;
}

.input-with-label h4 {
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
  word-wrap: normal;
}

.input-with-label .error-text {
  width: 100%;
  float: left;
  color: #EE4B55;
  margin-top: 3px;
}

.label-with-input {
  width: 100%;
  float: left;
  margin-bottom: 15px;
}

.label-with-input label {
  font-size: 1em;
  font-weight: 600;
  margin-bottom: 10px;
  display: block;
}

.label-with-input input[type="text"] {
  width: 100%;
  float: left;
}

.label-with-input input[type="text"].error {
  border-color: #EE4B55;
}

.label-with-input:last-of-type {
  margin-bottom: 0;
}

.label-with-input .error-text {
  width: 100%;
  float: left;
  color: #EE4B55;
  margin-top: 3px;
}
</style>
