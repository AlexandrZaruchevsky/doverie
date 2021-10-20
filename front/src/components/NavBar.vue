<template>
  <div class="navbar">
    <div class="navbar-header">
      <router-link to="/">
        Doverie
      </router-link>
    </div>
    <div class="navbar-body">
      <router-link to="terrs" class="navbar-item">
        Terrs
      </router-link>
      <router-link to="clients" class="navbar-item">
        Clients
      </router-link>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style lang="scss" scoped>
.navbar {
  @apply bg-secondary-100;
  @apply border flex justify-between items-center shadow mb-2 py-1 px-2;
  .navbar-header {
    @apply text-2xl font-semibold;
  }
  .navbar-body {
    @apply flex gap-2;
    .navbar-item {
      @apply font-semibold hover:underline hover:text-warn-800;
    }
  }
}
</style>
