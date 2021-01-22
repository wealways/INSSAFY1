<template>
  <div>
    <nav>
      네브바
    </nav>
    <div class="login">
      <h1>로그인</h1>
      <div class="login__form">
        <div class="login__input">
          <div class="input_with_label">
            <label for="email">이메일</label>
            <input
              id="email"
              placeholder="이메일을 입력하세요."
              type="text"
            />
            <div class="error-text">에러메시지</div>
          </div>
          <div class="input_with_label">
            <label for="email">비밀번호</label>
            <input
              id="email"
              placeholder="비밀번호를 입력하세요."
              type="text"
            />
            <div class="error-text">에러메시지</div>
          </div>
        </div>
        <button class='btn__login'>로그인</button>
      </div>
      
      <div class="etc_options">
        <div class="etc_option_item">
          <p>비밀번호 잊으셨나요?</p>
          <a href="">비밀번호찾기</a>
        </div>
        <div class="etc_option_item">
          <p>아직 회원이 아니신가요?</p>
          <a href="">회원가입</a>
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
.login__form {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  /* align-items: center; */
  height: 40vh;
  width: 100%;
}
.login__input {
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
.etc_options {
  display: flex;
  flex-direction: column;
}
.etc_option_item {
  display: flex;
  justify-content: space-between;
}
.etc_option_item p {
  margin-bottom: 0;
}
.etc_option_item a {
  margin: auto 0;
  margin-bottom: 0;
}
</style>
