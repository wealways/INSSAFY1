<!--
    가입하기는 기본적인 폼만 제공됩니다
    기능명세에 따라 개발을 진행하세요.
    Sub PJT I에서는 UX, 디자인 등을 포함하여 백엔드를 제외하여 개발합니다.
 -->
<template>
  <div>
    <nav>
      네브바
    </nav>
    <div class="modify">
      <h1>비밀번호변경</h1>
      <div class="modify-form">
        <div class="modify-input">
          <div class="input-with-label">
            <label for="nowpassword">현재 비밀번호</label>
            <input
              id="nowpassword"
              placeholder="현재 비밀번호를 입력하세요."
              type="text"
            />
            <div class="error-text">에러메시지</div>
          </div>
          <div class="input-with-label">
            <label for="password">비밀번호</label>
            <input
              id="password"
              placeholder="비밀번호를 입력하세요."
              type="text"
            />
            <div class="error-text">에러메시지</div>
          </div>
          <div class="input-with-label">
            <label for="password-confirm">비밀번호확인</label>
            <input
              id="password-confirm"
              placeholder="비밀번호를 입력하세요."
              type="text"
            />
            <div class="error-text">에러메시지</div>
          </div>
        </div>
        <button class='btn-modify'>변경</button>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  
};
</script>

<style scoped>
.modify {
  display: flex;
  flex-direction: column;
  justify-content: center;
  /* align-items: center; */
  max-width: 580px;
  width: 100%;
  margin: 0 auto;
}
.modify-form {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  /* align-items: center; */
  height: 40vh;
  width: 100%;
}
.modify-input {
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
.etc_option_item a {
  margin: auto 0;
  margin-bottom: 0;
}
</style>
