<template>
  <page header="Clients">
    <search-by-fio @findByFio="findByFio" />
    <card class="w-full" header="Clients - table">
      <div class="p-2">
        <template v-if="clients.length > 0">
          <item-list
            v-for="(client, index) in clients"
            :key="client.id"
            :itemIndex="index + 1"
            :itemTitle="client.fullName"
            :item="client"
            class="p-1 border-b hover:bg-secondary-200"
            @itemClick="showDetails"
          />
        </template>
        <div v-else class="text-center">No content</div>
      </div>
    </card>
    <client-card
      :client="currentClient"
      v-if="isShowDetail"
      @close="isShowDetail = false"
    />
  </page>
</template>

<script>
import { computed, ref } from "@vue/reactivity";
import { useStore } from "vuex";
import { onMounted } from "@vue/runtime-core";
import Page from "../components/Page.vue";
import OverlayPage from "../components/OverlayPage.vue";
import ClientCard from "../components/ClientCard.vue";
import Card from "../components/cards/Card.vue";
export default {
  name: "Clients",
  components: {
    Page,
    OverlayPage,
    Card,
    ClientCard,
  },
  setup() {
    const store = useStore();
    const isShowDetail = ref(false);
    const currentClient = ref({});
    const clients = computed(() => {
      return store.state.Clients.clients;
    });
    const getAll = async () => {
      await store.dispatch("findAll");
    };
    const findByFio = async (fio) => {
      await store.dispatch("findAllByFio", fio);
    };
    const showDetails = (client) => {
      currentClient.value = { ...client };
      isShowDetail.value = true;
    };
    onMounted(async () => {
      await getAll();
      document.querySelector(".input-search").focus();
    });
    return {
      clients,
      findByFio,
      showDetails,
      isShowDetail,
      currentClient,
    };
  },
};
</script>
