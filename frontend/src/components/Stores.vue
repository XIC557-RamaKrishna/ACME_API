<template>
  <div class="container">
    <div class="navbar-header">
      <h2>
        <a class="navbar-brand" href="#">ACME stores Details</a><br /><br />
      </h2>
    </div>
    <div v-if="message" class="alert alert-success">{{ this.message }}</div>
    <div class="container">
      <table class="table">
        <thead class="thead-dark">
          <div class="row">
            <div class="search-wrapper panel-heading col-sm-12">
                   
        <div class="form-control form-control-sm">
          <input class="form-control" type="text"  size="20" v-model="searchQuery" placeholder="Search Store Name" />
        </div>
            </div>
          </div>
          <br />
          <button
            type="button"
            class="btn btn-info action_btn"
            style="float: left; text-align: left"
            v-on:click="downloadCSVData">Download</button><br/><br />
          <tr>
            <th scope="col">Code</th>
            <th scope="col">Description</th>
            <th scope="col">Name</th>
            <th scope="col">OpeningDate</th>
            <th scope="col">StoreType</th>
            <th scope="col">Update</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="store in resultQuery" v-bind:key="store.id">
            <td>{{ store.code }} </td>
            <td>{{ store.description }} </td>
            <td>{{ store.name }}</td>
            <td>{{ store.openingDate }} </td>
            <td>{{ store.storeType }} </td>
            <td>
              <button
                class="btn btn-warning"
                v-on:click="updateStore(store.id)"> Update
              </button>
            </td>
          </tr>
        </tbody>
      </table>
      <div class="row"></div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
 
export default {
  name: "Stores",
  data() {
    return {
      searchQuery: null,
      stores: [],
      message: "",
    };
  },
  beforeCreate() {
    const getAllstores = "http://localhost:8999/v1/stores";
    const getStoresAndSeasons =
      "http://localhost:8999/other/stores_and_seasons";
    axios
      .get(getAllstores)
      .then((response) => {
        console.log(response);
        this.stores = response.data;
      })
      .catch((error) => {
        console.log(error);
        this.errorMsg = "Error in retrieving Stores Data";
      });

    axios
      .get(getStoresAndSeasons)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
        this.errorMsg = "Error in retrieving Stores And Seasons  Data";
      });
  },
  methods: {
    downloadCSVData() {
      let csv = "Id,Code,Description,Name,OpeningDate,StoreType\n";
      let arr = [];
      this.stores.forEach((store) => {
        arr.push(Object.values(store));
      });
      arr.forEach((row) => {
        csv += row.join(",");
        csv += "\n";
      });
      const anchor = document.createElement("a");
      anchor.href = "data:text/csv;charset=utf-8," + encodeURIComponent(csv);
      anchor.target = "_blank";
      anchor.download = "nameYourFileHere.csv";
      anchor.click();
    },
    updateStore(id) {
      this.$router.push(`/store/${id}`);
    },
  },
  computed: {
   resultQuery(){
      if(this.searchQuery){
      return this.stores.filter((store)=>{      
        console.log(JSON.stringify(store))
        return this.searchQuery.toLowerCase().
        split(' ').every(v => store.name?.toLowerCase().includes(v))
      })
      }else{
        return this.stores;
      }
    }
  },
};
</script>

<style scoped>
   th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}

td, th {
  border: 1px solid #ddd;
  padding: 8px;
}

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

button {
 display: inline-block;
  /* optionnal*/
}

input[type="text"] {
    width: 200px;
}
</style>