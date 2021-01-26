<template>
  <div>
    <nav>
      네브바
    </nav>
    <div class="join">
      <h1>회원가입</h1>
      <div class="join-form">
        <div class="join-input">
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
          <div class="input-with-label">
            <label for="email">비밀번호확인</label>
            <input
              id="email"
              placeholder="비밀번호를 입력하세요."
              type="text"
            />
            <div class="error-text">에러메시지</div>
          </div>
          <div class="input-with-label">
            <label for="email">닉네임</label>
            <input
              id="email"
              placeholder="닉네임을 입력하세요."
              type="text"
            />
            <div class="error-text">에러메시지</div>
          </div>
          <div class="input-with-label">
            <label for="location">지역*</label>
            <select ref="select0" class="join-style" name="location" id="location">
              <option value="" disabled selected>지역을 선택하세요.</option>
              <option v-for="location in options.location" :key="location" :value="location">
                {{ location }}
              </option>
            </select>
          </div>
          <div class="input-with-label">
            <label for="location">기수*</label>
            <select ref="select1" class="join-style" name="location" id="location">
              <option value="" disabled selected>기수를 선택하세요.</option>
              <option v-for="generation in options.generation" :key="generation" :value="generation">
                {{ generation }}
              </option>
            </select>
          </div>

          <div class="input-with-label">
            <label for="email">반</label>
            <input
              id="email"
              placeholder="반을 입력하세요."
              type="text"
            />
            <div class="error-text">에러메시지</div>
          </div>
        </div>
        <button class="btn-join">로그인</button>
      </div>
      
      
    </div>
  </div>
</template>

<script>

export default {
  name:'Join',
  data(){
    return {
      options: {
        location: ['서울', '대전', '구미', '광주'],
        generation: [4, 3, 2, 1],
      },
    }
  }
  
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
}
.join-form {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  /* align-items: center; */
  height: 40vh;
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
  position: fixed;
  bottom: 17px;
  
  text-align: center;
}
@media screen and (max-width:576px) {
  .btn-join{
    width: 100%;
  }
}
</style>
