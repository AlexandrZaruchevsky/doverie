<template>
  <div v-if="value != null" class="flex gap-2 p-1 border-b">
    <span :class="widthTitle" class="flex-nowrap">
      {{ title }}
    </span>
    <strong :class="widthValue">{{ value }}</strong>
  </div>
</template>

<script>
export default {
  name: "StringTerr",
  props: {
    title: {
      type: String,
      default: "title",
    },
    value: {
      type: String,
    },
    widthTitle: {
      type: String,
      default: "w-1/4",
    },
    widthValue: {
      type: String,
      default: "w-3/4",
    },
  },
};
</script>

<style></style>
