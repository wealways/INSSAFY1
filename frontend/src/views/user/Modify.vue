<!--
    가입하기는 기본적인 폼만 제공됩니다
    기능명세에 따라 개발을 진행하세요.
    Sub PJT I에서는 UX, 디자인 등을 포함하여 백엔드를 제외하여 개발합니다.
 -->
<template>
  <div class="user join wrapC">
    <h1>비밀번호 변경</h1>
    <div class="form-wrap">
      <div class="input-with-label">
        <input v-model="email" id="email" type="text" disabled/>
        <label for="email">이메일*</label>
        <div class="error-text" v-if="error.email">{{error.email}}</div>
        <div class="error-text" v-if="error.emailDuplicate">{{error.emailDuplicate}}</div>
      </div>

      <div class="input-with-label">
        <input v-model="password" id="password" :type="passwordType" placeholder="비밀번호를 입력하세요." 
        :class="{error : error.password, complete:!error.password&&password.length!==0}"
        />
        <label for="password">비밀번호*</label>
        <div class="error-text" v-if="error.password">{{error.password}}</div>
      </div>

      <div class="input-with-label">
        <input v-model="passwordConfirm" :type="passwordConfirmType" id="password-confirm" placeholder="비밀번호를 다시한번 입력하세요."
        :class="{error : error.passwordConfirm, complete : !error.password&&passwordConfirm.length!==0}"
        />
        <label for="password-confirm">비밀번호 확인*</label>
        <div class="error-text" v-if="error.passwordConfirm">{{error.passwordConfirm}}</div>
      </div>
    </div>

    <button class="btn-bottom" v-on:click="onModify" 
    v-bind:disabled="!isSubmit" v-bind:class="{disabled: !isSubmit}">저장</button>
  </div>
</template>

<script>
import "../../components/css/user.scss";
import PV from "password-validator";
import * as EmailValidator from "email-validator";
import LoginVue from './Login.vue';

import * as authApi from '@/api/auth';

export default {
  data() {
    return {
      options: {
        location: ['서울', '대전', '구미', '광주'],
        generation: [4, 3, 2, 1],
      },
      email: '',
      password: '',
      passwordSchema: new PV(),
      passwordConfirm: '',
      isLoading: false,
      error: {
        email: false,
        emailDuplicate : false,
        password: false,
        passwordConfirm: false
      },
      isSubmit: false,
      passwordType: 'password',
      passwordConfirmType: 'password',
      termPopup: false,
    };
  },
  created() {
    this.passwordSchema
      .is()
      .min(8)
      .is()
      .max(100)
      .has()
      .digits()
      .has()
      .letters();
    this.email = this.$route.params.email;
  },
  watch:{
    email: function(){
      this.checkForm();
    },
    password: function(){
      this.checkForm();
    },
    passwordConfirm: function(){
      this.checkForm();
    }
  },
  methods: {
    checkForm() {
      if (this.email.length >= 0 && !EmailValidator.validate(this.email))
        this.error.email = "이메일 형식이 아닙니다.";
      else this.error.email = false;

      if (
        this.password.length >= 0 &&
        !this.passwordSchema.validate(this.password)
      )
        this.error.password = "영문,숫자 포함 8 자리이상이어야 합니다.";
      else this.error.password = false;

      if(this.passwordConfirm.length >= 0 && this.password != this.passwordConfirm)
        this.error.passwordConfirm = "비밀번호가 서로 같지 않습니다."
      else this.error.passwordConfirm = false;
      
      let isSubmit = true;
      Object.values(this.error).map(v => {
        if (v) isSubmit = false;
      });
      this.isSubmit = isSubmit;
    },
    onModify: function(){
        authApi.modify(this.email, this.password).then(response => {
        console.log(response.data);
        alert('비밀번호가 변경되었습니다.\n다시 로그인해주세요.');
        this.$router.push({name: '/', params:{email:this.email}});
      }).catch(error => {
        console.log(error);
        alert("저장에 실패하였습니다.");
        this.password = '';
        this.passwordConfirm = '';
      })
    }
  },
};
</script>

<style scoped>
h1 {
  margin-top: 15px;
}
hr {
  margin-bottom: 10px;
}
.join-style {
  width: 100%;
  height: 50px;
  background-color: #fff;
  float: left;
  line-height: 1;
  padding: 2px 15px 0 105px;
  border: 1px solid #000;
  border-radius: 3px;
}
.btn-bottom {
  margin: 20px 0 !important;
}
.complete {
  border: 2px solid #000 !important;
  border-radius: 3px !important;
}
</style>
