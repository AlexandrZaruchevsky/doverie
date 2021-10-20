<template>
  <div class="flex gap-2 justify-between">
    <span>{{ title }}</span>
    <strong
      class="value"
      :class="warn && count > 0 ? 'text-warn-500' : ''"
      v-if="complete"
    >
      {{ count }}
    </strong>
    <span class="value" v-else>
      <i-spin color="red" />
    </span>
  </div>
</template>

<script>
import { onMounted, ref } from "@vue/runtime-core";
export default {
  name: "StatisticRow",
  props: {
    title: {
      type: String,
      default: "title",
    },
    getCount: {
      type: Function,
    },
    warn: {
      type: [String, Boolean],
      default: false,
    },
  },
  setup(props) {
    const complete = ref(false);
    const count = ref(0);
    onMounted(() => {
      props.getCount().then((data) => {
        count.value = data;
        complete.value = true;
      });
    });
    return { complete, count };
  },
};
</script>
