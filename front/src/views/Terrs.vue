<template>
  <page header="Terr">
    <search-by-fio @findByFio="findByFio" />
    <card class="w-full" header="Terrs - table">
      <div class="p-2">
        <template v-if="terrs.length > 0">
          <item-list
            v-for="(terr, index) in terrs"
            :key="index"
            :item="terr"
            :itemIndex="index + 1"
            :itemTitle="terr.fio"
            @itemClick="showDetails(terr)"
            class="p-1 border-b hover:bg-secondary-200"
          />
        </template>
        <div v-else class="text-center">No content</div>
      </div>
    <template v-if="showDetail">
      <terr-card :currentTerr="currentTerr" @close="showDetail = false" />
    </template>
    </card>
  </page>
</template>

<script>
import { computed, ref } from "@vue/reactivity";
import { useStore } from "vuex";
import Page from "../components/Page.vue";
import { onMounted } from "@vue/runtime-core";
import TerrCard from "../components/TerrCard.vue";
import Card from "../components/cards/Card.vue";
export default {
  name: "Terrs",
  components: {
    Page,
    TerrCard,
    Card,
  },
  setup() {
    const store = useStore();
    const showDetail = ref(false);
    const terrs = computed(() => {
      return store.state.Terr.terrs;
    });
    const currentTerr = ref("sss");
    const getAll = async () => {
      await store.dispatch("findAllTerrs");
    };
    const findByFio = async (fio) => {
      await store.dispatch("findAllTerrsByFio", fio);
    };
    const showDetails = (terr) => {
      currentTerr.value = terr;
      showDetail.value = true;
    };

    onMounted(async () => {
      await getAll();
      document.querySelector(".input-search").focus();
    });
    return {
      findByFio,
      terrs,
      showDetail,
      showDetails,
      currentTerr,
    };
  },
};
</script>
