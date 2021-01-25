<template>
  <div>
    <nav>
      네브바
    </nav>
    <!-- chevron-left -->
    <b-container class="board">
      <b-row>
        <header>
          <div>
            <router-link to="/boards"><b-icon icon="chevron-compact-left" aria-hidden="true"></b-icon>Board</router-link>
          </div>
        </header>
      </b-row>
    </b-container>
    
  </div>
</template>

<script>

export default {
  name:'PostDetail',
  components:{

  },
}
</script>

<style>
header{
  display:flex !important;
  width: 100%;
}
header >:nth-child(1){
  font-size:2rem;
}
</style>