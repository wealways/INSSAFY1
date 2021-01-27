<template>
  <div>
    <div class="join">
      <h2>회원가입</h2>
      <div class="join-form">
        <div class="join-input">
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
            <label for="password">비밀번호</label>
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
          <div class="input-with-label">
            <label for="email">닉네임</label>
            <input
              id="email"
              placeholder="닉네임을 입력하세요."
              type="text"
              v-model="nickname"
            />
          </div>
          <div class="input-with-label">
            <label for="location">지역*</label>
            <select ref="select0" class="join-style" name="location" id="location"  v-model="location">
              <option value="" disabled selected>지역을 선택하세요.</option>
              <option v-for="location in options.location" :key="location" :value="location">
                {{ location }}
              </option>
            </select>
          </div>
          <div class="input-with-label">
            <label for="location">기수*</label>
            <select ref="select1" class="join-style" name="location" id="location"  v-model="generation">
              <option value="" disabled selected>기수를 선택하세요.</option>
              <option v-for="generation in options.generation" :key="generation" :value="generation">
                {{ generation }}
              </option>
            </select>
          </div>

        </div>
        <!-- <button class="btn-join">로그인</button> -->
        <button
        class="btn-join b-title"
        @click="onJoin"
        :disabled="!isSubmit"
        :class="{disabled : !isSubmit}"
        >Join</button>
      </div>
      
      
    </div>
  </div>
</template>

<script>
import PV from "password-validator";
import * as EmailValidator from "email-validator";
import * as authApi from '@/api/auth';

export default {
  name: 'Join',
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
      isLoading: false,
      error: {
        email: false,
        emailDuplicate : false,
        password: false,
        passwordConfirm: false,
        nickname: true,
        location: true,
        generation: true,
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
    email: function(){
      this.checkForm();
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
    // isTerm: function(){
    //   this.checkForm();
    // }
  },
  methods: {
    checkForm() {
      this.email = this.email.toLowerCase()
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

      // if(!this.isTerm) this.error.term = true;
      // else this.error.term = false;

      let isSubmit = true;
      Object.values(this.error).map(v => {
        if (v) isSubmit = false;
      });
      this.isSubmit = isSubmit;
    },
    onJoin: function(){
      var member={
        user_email: this.email,
        user_password: this.password,
        user_nickname: this.nickname,
        user_location: this.location,
        user_generation: this.generation,
      };
      authApi.join(member).then(response => {
        console.log(response.data);
        alert(this.nickname+'님 환영합니다!\n이메일 인증을 완료해주세요.');
        // this.$router.push({name: 'JoinSuccess', params:{email:this.email}});
        this.$router.push({name: 'Main'});
      }).catch(error => {
        console.log(error);
        alert("가입에 실패하였습니다.");
        this.password = '';
      })
    },
    onDuplicate: function(){
      console.log(this.email);
      authApi.duplicate(this.email).then(response => {
        console.log(response);
        if(response.data.message==="success"){
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
.join {
  display: flex;
  flex-direction: column;
  justify-content: center;
  /* align-items: center; */
  max-width: 580px;
  width: 100%;
  margin: 0 auto;
  padding: 0 15px;
}

h2{
  margin-bottom: 30px;
}

.join-form {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  /* align-items: center; */
  /* height: 40vh; */
  width: 100%;
}
.join-input {
  width: 100%;
  float: left;
  position: relative;
  margin-bottom: 10px;
}
input, select {
  background: transparent;
  font-size: 1em;
  width: 100%;
  height: 50px;
  line-height: 1em;
  border: 1px solid #CCCCCC;
  padding: 0 20px;
  -webkit-box-sizing: border-box;
          box-sizing: border-box;
  -webkit-transition: .2s;
  transition: .2s;
  outline: none;
}
.error-text {
  font-size: 0.8rem;
  color: #ff0404;
}

.btn-join{
  /* position: inherit;  */
  height: 50px;
  margin-top: 30px; 
  margin-bottom: 20px;
  text-align: center;
}
.btn-join:hover,
.btn-join:active {
  background-color: #000 !important;
  color: #fff;
}

@media screen and (max-width:576px) {
  .btn-join{
    width: 100%;
    background-color: #000 !important;
    color: #fff;
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
.input-with-label select,
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

.input-with-label input[type="text"]:hover, 
.input-with-label input[type="text"]:focus,
.input-with-label select:hover, 
.input-with-label select:focus,
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
