import { createWebHistory, createRouter } from "vue-router";
import Stores from './components/Stores.vue'
import Store from './components/Store.vue'

const routes = [
  {
    path: "/",
    alias: "/stores",
    name: "stores",
    component: Stores
  },
  {
    path: "/store/:id",
    alias: "/store",
    name: "store",
    component: Store
  },

];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;