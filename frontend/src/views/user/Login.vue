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
              id="email"
              placeholder="이메일을 입력하세요."
              type="text"
            />
            <div class="error-text">에러메시지</div>
          </div>
          <div class="input-with-label">
            <label for="email">비밀번호</label>
            <input
              id="email"
              placeholder="비밀번호를 입력하세요."
              type="text"
            />
            <div class="error-text">에러메시지</div>
          </div>
        </div>
        <button class='btn-login'>로그인</button>
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

export default {
  
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
  border: 1px solid #CCCCCC;
  padding: 0 20px;
  -webkit-box-sizing: border-box;
          box-sizing: border-box;
  -webkit-transition: .2s;
  transition: .2s;
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
</style>
