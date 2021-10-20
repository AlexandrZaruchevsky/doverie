<template>
  <div class="h-screen">
    <div class="app-bar">
      <nav-bar />
    </div>
    <div class="flex flex-col">
      <div class="flex flex-row justify-between">
        <side-bar class="app-sidebar h-screen" />
        <div class="flex justify-center w-full">
          <router-view class="container" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import NavBar from "./components/NavBar.vue";
import SideBar from "./components/SideBar.vue";

export default {
  components: { SideBar, NavBar },
  name: "App",
};
</script>

<style lang="scss">
body {
  @apply text-primary-800 bg-gray-200;
}
.app-sidebar {
  @apply h-full border-r;
  min-width: 200px;
}
.container {
  @apply w-full p-2;
}

@media screen and(max-width: 750px) {
  .app-sidebar {
    display: none;
  }
  .app-bar {
    display: block;
  }
}

@media screen and(min-width: 750px) {
  .app-sidebar {
    display: block;
  }
  .app-bar {
    display: none;
  }
}

</style>
