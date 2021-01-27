<template>
  <div>
    <b-button v-b-modal.modal-prevent-closing variant="light" class="btn-write">글쓰기</b-button>

    <!-- <div class="mt-3">
      Submitted Names:
      <div v-if="submittedNames.length === 0">--</div>
      <ul v-else class="mb-0 pl-3">
        <li v-for="(name,idx) in submittedNames" :key="idx">{{ name }}</li>
      </ul>
    </div> -->

    <b-modal
      id="modal-prevent-closing"
      ref="modal"
      size="xl"
      title="Post"
      no-close-on-backdrop
      ok-only
      @show="resetModal"
      @hidden="resetModal"
      @ok="handleOk"
    >
      <form ref="form" @submit.stop.prevent="handleSubmit">
        <b-form-group
          label-for="title-input"
          invalid-feedback="title is required"
          :state="nameState"
        >
          <b-form-input
            id="title-input"
            placeholder="제목"
            v-model="name"
            :state="nameState"
            required
          ></b-form-input>
        </b-form-group>
        <b-form-group
          label-for="description-input"
          invalid-feedback="description is required"
          :state="nameState"
        >
          <b-form-textarea
            id="description-input"
            placeholder="무슨생각하고 있음?"
            style="height:300px"
            v-model="description"
            :state="nameState"
            required
          ></b-form-textarea>
        </b-form-group>
        <b-form-group
          label-for="multiple-media"
        >
          <b-form-file 
            multiple
            id="multiple-media"
            placeholder="Choose a file or drop it here..."
            browse-text='🖼'
          >
          <!--card-image-->
            <template slot="file-name" slot-scope="{ names }">
              <b-badge variant="dark">{{ names[0] }}</b-badge>
              <b-badge v-if="names.length > 1" variant="dark" class="ml-1">
                + {{ names.length - 1 }} More files
              </b-badge>
            </template>
          </b-form-file>
        </b-form-group>
      </form>
      <template #modal-footer="{ok}">
        <!-- Emulate built in modal footer ok and cancel button actions -->
        <b-button variant="submit" @click="ok()">
          게시
        </b-button>
      </template>
    </b-modal>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        name: '',
        description:'',
        nameState: null,
        submittedNames: []
      }
    },
    methods: {
      checkFormValidity() {
        const valid = this.$refs.form.checkValidity()
        this.nameState = valid
        return valid
      },
      resetModal() {
        this.name = ''
        this.nameState = null
      },
      handleOk(bvModalEvt) {
        // Prevent modal from closing
        bvModalEvt.preventDefault()
        // Trigger submit handler
        this.handleSubmit()
      },
      handleSubmit() {
        // Exit when the form isn't valid
        if (!this.checkFormValidity()) {
          return
        }
        // Push the name to submitted names
        this.submittedNames.push(this.name)
        // Hide the modal manually
        this.$nextTick(() => {
          this.$bvModal.hide('modal-prevent-closing')
        })
      }
    }
  }
</script>

<style scoped>
.btn-write {
  width:100%;
  position: sticky;
}
.btn-submit {
  width: 100%;
  height: 40px;
  
  font-size: 20px;
  transition: color 0.3s, background-color 0.3s ease;
}
.btn-submit:hover,
.btn-submit:active {
  background-color: #000 !important;
  color: #fff;
}
@media screen and (max-width:576px) {
  .btn-submit{
    width: 100%;
    background-color: #000 !important;
    color: #fff;
  }
}
</style>