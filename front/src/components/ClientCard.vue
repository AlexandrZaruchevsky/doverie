<template>
  <overlay-page class="flex justify-center pt-40" @click="$emit('close')">
    <card @click.stop @close="$emit('close')" header="Details">
      <div>
        <item-list
          class="px-2 py-1"
          itemIndex="Full name"
          :itemTitle="client?.fullName"
        />
        <item-list
          class="px-2 py-1"
          itemIndex="lastName"
          :itemTitle="client?.lastName"
        />
        <item-list
          class="px-2 py-1"
          itemIndex="firstName"
          :itemTitle="client?.firstName"
        />
        <item-list
          class="px-2 py-1"
          itemIndex="middleName"
          :itemTitle="client?.middleName"
        />
        <item-list
          class="px-2 py-1"
          itemIndex="birthday"
          :itemTitle="client?.birthday"
        />
      </div>
    </card>
  </overlay-page>
</template>
<script>
import Card from "./cards/Card.vue";
import OverlayPage from "./OverlayPage.vue";

export default {
  name: "ClientCard",
  components: { OverlayPage, Card },
  props: {
    client: {
      type: Object,
    },
  },
};
</script>

<style></style>
