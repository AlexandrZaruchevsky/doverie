<template>
  <div>
    <span v-if="itemIndex">{{ itemIndex }} : </span>
    <strong class="hover:underline cursor-pointer flex-wrap" @click="$emit('itemClick', item)">
      {{ itemTitle }}
    </strong>
  </div>
</template>
<script>
export default {
  name: "ItemList",
  props: {
    item: {
      type: Object,
    },
    itemIndex: {
      type: [Number, String],
    },
    itemTitle: {
      type: String,
      default: "None",
    },
  },
};
</script>
<style>
strong{
  max-width: 300px;
  flex-wrap: wrap;
}
</style>
