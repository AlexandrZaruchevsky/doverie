import axios from "axios";

let apiServer = window.apiRest||'localhost:8088';

export const Clients = {
  state: () => ({
    clients: [],
    count: 0,
  }),
  getters: {},
  mutations: {
    setClients(state, payload) {
      state.clients = [...payload];
    },
    setCount(state, payload) {
      state.count = payload;
    },
  },
  actions: {
    async findAll({ commit }) {
      const clients = await axios.get(`http://${apiServer}/api/rest/clients`);
      commit("setClients", clients.data);
    },
    async findAllByFio({ commit, dispatch }, payload) {
      if (payload && payload.trim() != "") {
        const clients = await axios.get(
          `http://${apiServer}/api/rest/clients`,
          {
            params: {
              fio: payload,
            },
          }
        );
        commit("setClients", clients.data);
      } else {
        await dispatch("findAll");
      }
    },
    async countClients({ commit }) {
      const count = await axios.get(
        `http://${apiServer}/api/rest/clients/count`
      );
      commit("setCount", count.data);
    },
  },
};
