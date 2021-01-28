<template>
  <b-container>
    <b-row class="comment">
      <b-col sm="2" class="comment-header">
        <div class="user-profile-img">
          <b-avatar src="https://placekitten.com/300/300" size="3rem">유저프로필</b-avatar>
        </div>
        <div class="header-detail">
          <div class="user-name-date">
            <b-dropdown id="dropdown-left" class="user-name" variant="link" toggle-class="text-decoration-none" no-caret>
              <template #button-content>
                {{comment.user}}
              </template>
              <b-dropdown-item href="#">Profile</b-dropdown-item>
              <b-dropdown-item href="#">메시지 보내기</b-dropdown-item>
              <!-- <b-dropdown-item href="#">Something else here</b-dropdown-item> -->
            </b-dropdown>
            <div class="post-date">{{comment.date}}</div>
          </div>
          <div @click="btnComment" id="btnCommentMobile">
            <b-icon icon="three-dots-vertical" aria-hidden="true"></b-icon>
          </div>
        </div>
      </b-col>
      <b-col class="main">
        <div>
          {{comment.comment}}
        </div>
        <div @click="btnComment" id="btnComment">
          <b-icon icon="three-dots-vertical" aria-hidden="true"></b-icon>
        </div>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  name:"Comment",
  props:{
    comment:Object
  },
  methods:{
    btnComment() {
      alert(`comment ! `);
    }
  }
}
</script>

<style scoped>
.comment{
  display:flex;
  /* margin-bottom: 1rem; */
  padding:0.8rem;
}
.comment .comment-header{
  display: flex;
  /* margin-bottom: 0.5rem; */
  padding-left:0;
  padding-right:0;
}
.comment .comment-header .header-detail{
  display:flex;
  justify-content:space-between;
  width: 100%;
}
.user-name{
  display: inline-block;
  font-size:1fr;
}
.post-date{
  font-size:0.5em;
}
.main{
  display: flex;
  justify-content: space-between;
  padding: 0;
  /* width:100%; */
}
@media screen and (max-width:576px){
  #btnComment{
    display: none;
  }
}
@media screen and (min-width:576px){
  #btnCommentMobile{
    display: none;
  }
}
</style>