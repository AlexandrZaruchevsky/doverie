<template>
  <form class="w-full" @submit.prevent>
    <input
      class="input-search"
      placeholder="Search by fio"
      type="text"
      v-model="fio"
      @keydown="$event.keyCode==13 ? $emit('findByFio', fio):''"
    />
  </form>
</template>

<script>
import { ref } from "@vue/reactivity";
export default {
  name: "SearchByFio",
  emits: ["findByFio"],
  setup() {
    const fio = ref("");
    return {
      fio,
    };
  },
};
</script>
<style lang="scss" scoped>
.input-search {
  @apply text-primary-900 border-2 rounded w-full px-2 py-1 focus:outline-none focus:border-primary-600 hover:shadow-sm focus:shadow;
}
</style>
