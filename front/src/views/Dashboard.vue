<template>
  <page header="Dashboard">
    <card header="Statistics">
      <div class="flex flex-col gap-2 p-2">
        <statistic-row
          title="Количество записей в таблице Client"
          class="border-b"
          :getCount="getClientCount"
        />
        <statistic-row
          title="Количество террористов"
          class="border-b"
          :getCount="getTerrCount"
        />
        <statistic-row
          title="Количество найденных террористов"
          class="border-b"
          :getCount="getTerrFindCount"
          warn="true"
        />
      </div>
    </card>
    <card v-if="terrClients.length > 0" header="Terrs">
      <item-list
        v-for="(terr, index) in terrClients"
        :key="index"
        :itemIndex="index + 1"
        :item="terr"
        @itemClick="showDetails(terr)"
        class="p-2 text-warn-700 font-semibold border-b"
        :itemTitle="terr.individual.fio"
      />
    </card>
  </page>
  <template v-if="showDetail">
    <!-- <terr-card :currentTerr="currentTerr" @close="showDetail = false" /> -->
    <div class="w-full">
      <client-terr :currentTerr="clientTerr" @close="showDetail = false" />
    </div>
  </template>
</template>

<script>
import { ref } from "@vue/reactivity";
import { useStore } from "vuex";
import Page from "../components/Page.vue";
import Card from "../components/cards/Card.vue";
import TerrCard from "../components/TerrCard.vue";
import { onMounted } from "@vue/runtime-core";
import ClientTerr from "../components/ClientTerr.vue";
export default {
  components: {
    Page,
    Card,
    TerrCard,
    ClientTerr,
  },
  name,
  TerrCard: "Dashboard",
  setup() {
    const store = useStore();
    const showDetail = ref(false);
    const clientTerr = ref({});
    const currentTerr = ref({});
    const coincidenceTerrs = ref(0);
    const terrClients = ref(0);

    // Current
    const getClientCount = async () => {
      await store.dispatch("countClients");
      return store.state.Clients.count;
    };
    // Current
    const getTerrCount = async () => {
      await store.dispatch("countTerr");
      return store.state.Terr.countT;
    };

    // Current
    // const getTerrFindCount = async () => {
    //   await store.dispatch("coincidenceTerrs");
    //   coincidenceTerrs.value = store.state.Terr.coincidenceTerrs;
    //   return store.state.Terr.coincidenceTerrs.length;
    // };

    // Current
    const getTerrFindCount = async () => {
      await store.dispatch("findTerrClients");
      terrClients.value = store.state.Terr.terrClients;
      return store.state.Terr.terrClients.length;
    };

    onMounted(async () => {
      // await getTerrFindCountQ();
      // console.log(store.state.Terr.terrClients.map(tc=>tc.individual));
    });

    // // Current
    // const getTerrFindCount = async () => {
    //   await store.dispatch("coincidenceTerrs");
    //   coincidenceTerrs.value = store.state.Terr.coincidenceTerrs;
    //   return store.state.Terr.coincidenceTerrs.length;
    // };

    const showDetails = (terr) => {
      clientTerr.value = terr;
      showDetail.value = true;
    };

    return {
      currentTerr,
      coincidenceTerrs,
      showDetail,
      showDetails,
      getTerrCount,
      getClientCount,
      getTerrFindCount,
      terrClients,
      clientTerr,
    };
  },
};
</script>
