<template>
  <button class="flex items-center" @click="$emit('clickButton')">
    <slot/>
  </button>
</template>

<script>
export default {
  name:'ButtonHeader',
};
</script>

<style></style>