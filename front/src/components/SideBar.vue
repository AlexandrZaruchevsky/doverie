<template>
  <div class="sidebar">
    <div class="sidebar-header">
      <router-link to="/">
        Doverie
      </router-link>
    </div>
    <div class="sidebar-body">
      <router-link to="terrs" class="sidebar-item">
        Terrs
      </router-link>
      <router-link to="clients" class="sidebar-item">
        Clients
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
};
</script>

<style lang="scss">
.sidebar {
  @apply bg-secondary-300;
  .sidebar-header {
    @apply text-2xl py-2 text-white font-bold text-center mb-2 bg-primary-700 bg-opacity-90 hover:text-primary-200 hover:underline;
  }
  .sidebar-body{
    @apply p-2 flex flex-col;
  }
  .sidebar-item{
    @apply text-secondary-200 p-2 rounded mb-1 bg-yellow-700 text-center font-semibold hover:shadow hover:bg-yellow-800 hover:text-secondary-50;
  }
}
</style>
