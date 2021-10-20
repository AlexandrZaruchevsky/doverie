<template>
  <div class="card">
    <div class="card-header">
      <div class="card-header-title">
        {{ header }}
      </div>
      <div class="card-header-buttons">
        <button-header @click="$emit('close')">
          <i-x color="#bbb" colorHover="#eee" />
        </button-header>
      </div>
    </div>
    <div class="card-body">
      <div>
        <slot />
      </div>
    </div>
    <div class="card-footer" v-if="footer">{{ footer }}</div>
  </div>
</template>

<script>
export default {
  name: "Card",
  props: {
    header: {
      type: String,
      default: "Header",
    },
    footer: {
      type: String,
    },
  },
};
</script>
<style lang="scss">
.card {
  @apply bg-opacity-100 border bg-gray-100 shadow-lg;
  .card-header {
    @apply text-white font-semibold text-xl py-1 px-2 bg-primary-800  flex flex-row flex-nowrap justify-between items-center;
  }
  .card-body {
    @apply p-1;
  }
  .card-footer {
    @apply p-1 text-sm border-t;
  }
}
</style>
