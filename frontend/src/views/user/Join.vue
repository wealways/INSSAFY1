<!--
    가입하기는 기본적인 폼만 제공됩니다
    기능명세에 따라 개발을 진행하세요.
    Sub PJT I에서는 UX, 디자인 등을 포함하여 백엔드를 제외하여 개발합니다.
 -->
<template>
  <div class="user">

    <div class="join wrapC">
      <h1>가입하기</h1>
      <div class="form-wrap">
        <div class="input-with-label">
          <input v-model="email" id="email" placeholder="이메일을 입력하세요." type="text" 
          :class="{error : error.email&&email.length!==0, complete:!error.email&&email.length!==0}"
          @blur="onDuplicate"
          @focus="waitDuplicate"
          autocapitalize="off"
          />
          <label for="email">이메일*</label>
          <div class="error-text" v-if="error.email&&email.length!==0">{{error.email}}</div>
          <div class="error-text" v-if="error.emailDuplicate">{{error.emailDuplicate}}</div>
        </div>

        <div class="input-with-label">
          <input v-model="password" id="password" :type="passwordType" placeholder="비밀번호를 입력하세요." 
          :class="{error : error.password&&password.length!==0, complete:!error.password&&password.length!==0}"
          />
          <label for="password">비밀번호*</label>
          <div class="error-text" v-if="error.password&&password.length!==0">{{error.password}}</div>
        </div>

        <div class="input-with-label">
          <input v-model="passwordConfirm" :type="passwordConfirmType" id="password-confirm" placeholder="비밀번호를 다시한번 입력하세요."
          :class="{error : error.passwordConfirm&&passwordConfirm.length!==0, complete : !error.password&&passwordConfirm.length!==0}"
          />
          <label for="password-confirm">비밀번호 확인*</label>
          <div class="error-text" v-if="error.passwordConfirm&&passwordConfirm.length!==0">{{error.passwordConfirm}}</div>
        </div>

        <div calss="input-with-label">
          <hr />
        </div>
        <div class="input-with-label">
          <input v-model="nickname" id="nickname" placeholder="닉네임을 입력하세요." type="text" />
          <label for="nickname">닉네임*</label>
        </div>

        <div class="input-with-label">
          <select ref="select0" class="join-style" name="location" id="location" v-model="location">
            <option value="" disabled selected>지역을 선택하세요.</option>
            <option v-for="location in options.location" :key="location" :value="location">
              {{ location }}
            </option>
          </select>
          <label for="nickname">지역*</label>
        </div>

        <div class="input-with-label">
          <select ref="select1" class="join-style" name="generation" id="generation" v-model="generation">
            <option value="" disabled selected>기수을 선택하세요.</option>
            <option v-for="generation in options.generation" :key="generation" :value="generation">
              {{ generation }}
            </option>
          </select>
          <label for="nickname">기수*</label>
        </div>

        <div class="input-with-label">
          <input v-model="classNum" id="classNum" class="join-style" placeholder="반을 입력하세요." type="number" min="1" max="20"/>
          <label for="nickname">반</label>
        </div>
      </div>

      <label>
        <input v-model="isTerm" type="checkbox" id="term" />
        <span>약관을 동의합니다.</span>
      </label>

      <span @click="termPopup = true">약관보기</span>

      <button class="btn btn--back btn--login" v-on:click="onJoin" 
      v-bind:disabled="!isSubmit" v-bind:class="{disabled: !isSubmit}">가입하기</button>
    </div>
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
      nickname: '',
      location: '',
      generation: '',
      classNum: '',
      isTerm: false,
      isLoading: false,
      error: {
        email: false,
        emailDuplicate : false,
        password: false,
        passwordConfirm: false,
        nickname: true,
        location: true,
        generation: true,
        classNum: false,
        term: true,
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
  },
  watch:{
    email: function(v){
      this.checkForm();
      this.email = v.toLowerCase();
    },
    password: function(){
      this.checkForm();
    },
    passwordConfirm: function(){
      this.checkForm();
    },
    nickname: function(){
      this.checkForm();
    },
    location: function(){
      this.checkForm();
    },
    generation: function(){
      this.checkForm();
    },
    isTerm: function(){
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
      
      if(this.nickname.length == 0) this.error.nickname = true;
      else this.error.nickname = false;

      if(this.location.length == 0) this.error.location = true;
      else this.error.location = false;

      if(this.generation.length == 0) this.error.generation = true;
      else this.error.generation = false;

      if(!this.isTerm) this.error.term = true;
      else this.error.term = false;

      let isSubmit = true;
      Object.values(this.error).map(v => {
        if (v) isSubmit = false;
      });
      this.isSubmit = isSubmit;
    },
    onJoin: function(){
      var member={
        email: this.email,
        password: this.password,
        nickname: this.nickname,
        location: this.location,
        generation: this.generation,
        classNum: this.classNum
      };
      authApi.join(member).then(response => {
        console.log(response.data);
        alert(this.nickname+'님 환영합니다!\n이메일 인증을 완료해주세요.');
        this.$router.push({name: 'JoinSuccess', params:{email:this.email}});
      }).catch(error => {
        console.log(error);
        alert("가입에 실패하였습니다.");
        this.password = '';
      })
    },
    onDuplicate: function(){
      authApi.duplicate(this.email).then(response => {
        console.log(response);
        if(response.data.status){
          this.error.emailDuplicate = false;
        } else {
          this.error.email = "이미 가입되어 있는 이메일입니다."
        }
      }).catch(error =>{
        console.log(error);
      })
    },
    waitDuplicate: function(){
      this.emailDuplicate = false;
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
button{
  transition: 0.3s background-color ease-in-out;
}
.disabled {
  background-color: #00000033;
}
</style>
