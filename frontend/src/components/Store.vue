<template>
  <div>
    <div class="container">
      <form @submit="validateAndSubmit">
        <div v-if="errors.length">
          <div
            class="alert alert-danger"
            v-bind:key="index"
            v-for="(error, index) in errors"
          >
            {{ error }}
          </div>
        </div>
        <fieldset class="form-group">
          <label>Code</label>
          <input type="text" class="form-control" v-model="code" readonly />
        </fieldset>
        <fieldset class="form-group">
          <label>Description</label>
          <input type="text" class="form-control" v-model="description" readonly />
        </fieldset>
        <fieldset class="form-group">
          <label>Name</label>
          <input type="text" class="form-control" v-model="name" />
        </fieldset>
        <fieldset class="form-group">
          <label>Opening Date </label>
          <input type="text" class="form-control" v-model="openingDate" readonly />
        </fieldset>
        <fieldset class="form-group">
          <label>Store Type</label>
          <input type="text" class="form-control" v-model="storeType" readonly/>
        </fieldset>
        <button class="btn btn-success" type="submit">Save</button>
      </form>
    </div>
  </div>
</template>
<script>
import StoreService from "../service/StoreService";
export default {
  name: "Store",
  data() {
    return {
      code: "",
      description: "",
      name: "",
      openingDate: "",
      storeType: "",
      errors: [],
    };
  },
  computed: {
    id() {
      return this.$route.params.id;
    },
  },
  methods: {
    refreshStoreDetails() {
      StoreService.retrieveStore(this.id).then((res) => {
        this.code = res.data.code;
        this.description = res.data.description;
        this.name = res.data.name;
        this.openingDate = res.data.openingDate;
        this.storeType = res.data.storeType;
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
      if (!this.code) {
        this.errors.push("Enter valid code");
      } 
      // else if (this.description.length < 1) {
      //   this.errors.push("Enter atleast 5 characters in Description");
      // }
      if (!this.name) {
        this.errors.push("Enter valid values");
      } else if (this.name.length < 1) {
        this.errors.push("Enter atleast 5 characters in Name");
      } else if (this.openingDate.length < 1) {
        this.errors.push("Enter atleast 5 characters in Opening Date");
      } else if (this.storeType.length < 1) {
        this.errors.push("Enter atleast 5 characters in Store Type");
      }
      if (this.errors.length === 0) {
     //   if (this.id == -1) {
          // StoreService.createStore({
          //   code: this.code,
          //   description: this.description,
          //   name: this.name,
          //   openingDate: this.openingDate,
          //   storeType: this.storeType,
          // }).then(() => {
          //   this.$router.push("/stores");
          // });
        // } else
        
        // {
          StoreService.updateStore(this.id, {
            id: this.id,
            code: this.code,
            description: this.description,
            name: this.name,
            openingDate: this.openingDate,
            storeType: this.storeType,
          }).then(() => {
            this.$router.push("/stores");
          });
      //  }
      }
    },
  },
  created() {
    this.refreshStoreDetails();
  },
};
</script>