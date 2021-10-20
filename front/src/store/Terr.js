import axios from "axios";

let apiServer = window.apiRest || "localhost:8088";

export const Terr = {
  state: () => ({
    terrs: [],
    countT: 0,
    coincidenceCount: 0,
    coincidenceTerrs: [],
    terrClients: [],
    countTC: 0,
  }),
  getters: {},
  mutations: {
    setTerrs(state, payload) {
      state.terrs = [...payload];
    },
    setCountT(state, payload) {
      state.countT = payload;
    },
    setCoincidenceCount(state, payload) {
      state.coincidenceCount = payload;
    },
    setCoincidenceTerrs(state, payload) {
      state.coincidenceTerrs = [...payload];
    },
    setTerrClients(state, payload) {
      state.terrClients = [...payload];
    },
    setCountTC(state, payload) {
      state.countTC = payload;
    },
  },
  actions: {
    async findAllTerrs({ commit }) {
      const terrs = await axios.get(`http://${apiServer}/api/rest/terrs`);
      commit("setTerrs", terrs.data);
    },

    async findAllTerrsByFio({ commit, dispatch }, payload) {
      if (payload && payload.trim() != "") {
        const terrs = await axios.get(`http://${apiServer}/api/rest/terrs`, {
          params: {
            fio: payload,
          },
        });
        commit("setTerrs", terrs.data);
      } else {
        await dispatch("findAllTerrs");
      }
    },

    async countTerr({ commit }) {
      const count = await axios.get(`http://${apiServer}/api/rest/terrs/count`);
      commit("setCountT", count.data);
    },

    async coincidenceCount({ commit }) {
      const count = await axios.get(
        `http://${apiServer}/api/rest/terrs/findTerrCount`
      );
      commit("setCoincidenceCount", count.data);
    },

    async coincidenceTerrs({ commit }) {
      const terrs = await axios.get(
        `http://${apiServer}/api/rest/terrs/findTerr`
      );
      commit("setCoincidenceTerrs", terrs.data);
    },

    async findTerrClients({ commit }) {
      const terrClients = await axios.get(
        `http://${apiServer}/api/rest/terrs/clientTerr`
      );
      commit("setTerrClients", terrClients.data);
      commit("setCountTC", terrClients.data.length);
    },
  },
};
