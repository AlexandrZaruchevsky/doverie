import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/",
    name: "Dashboard",
    component: () => import("../views/Dashboard.vue"),
  },
  {
    path: "/clients",
    name: "Clients",
    component: () => import("../views/Clients.vue"),
  },
  {
    path: "/terrs",
    name: "Terrs",
    component: () => import("../views/Terrs.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
