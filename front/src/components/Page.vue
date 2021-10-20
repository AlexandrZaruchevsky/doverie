<template>
  <div class="page">
    <div class="page-header">
      {{ header }}
    </div>
    <div class="page-body">
      <slot />
    </div>
  </div>
</template>

<script>
export default {
  name: "Page",
  props: {
    header: {
      type: String,
      default: "Header",
    },
  },
};
</script>

<style lang="scss" scoped>
.page {
  @apply w-full p-2 bg-secondary-200;
  .page-header {
    @apply font-bold text-2xl text-center mb-4 text-primary-900;
  }
  .page-body {
    @apply bg-secondary-100 rounded shadow-lg flex flex-wrap justify-center gap-4 p-4;
  }
}
</style>
