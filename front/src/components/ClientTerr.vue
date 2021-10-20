<template>
  <overlay-page class="flex justify-center pt-10 px-10" @click="$emit('close')">
    <card @click.stop @close="$emit('close')" header="Details">
      <div class="flex justify-around gap-2 text-xs">
        <div class="w-1/2">
          <card header="Terrs">
            <div class="fio">
              <string-terr title="ФИО" :value="currentTerr.individual.fio" />
              <string-terr
                title="ФИО - Латиница"
                :value="currentTerr.individual.fioLat"
              />
              <string-terr
                title="Дата рождения"
                :value="currentTerr.individual.birthday"
              />
              <string-terr
                title="Год рождения"
                :value="currentTerr.individual.yearOfBirth"
              />
              <string-terr
                title="Место рождения"
                :value="currentTerr.individual.placeOfBirth"
              />
              <string-terr
                title="СНИЛС"
                :value="currentTerr.individual.snils"
              />
              <string-terr title="ИНН" :value="currentTerr.individual.inn" />
            </div>
            <div
              v-if="
                currentTerr.individual.documents != null &&
                  currentTerr.individual.documents.length > 0
              "
              class="documents border mt-1 rounded"
            >
              <div
                class="documents-header p-1 border-b bg-gray-200 text-primary-800 font-semibold"
              >
                Документы
              </div>
              <div class="documents-body">
                <div
                  v-for="(document, index) in currentTerr.individual.documents"
                  :key="document"
                  class="border rounded shadow my-2 mx-4 text-sm "
                >
                  <div class="p-1 border-b font-semibold text-primary-800">
                    Документ - {{ index + 1 }}
                  </div>
                  <div>
                    <string-terr
                      title="Тип"
                      widthTitle="w-1/5"
                      widthValue="w-4/5"
                      :value="document.documentType.name"
                    />
                    <string-terr
                      title="Серия"
                      widthTitle="w-1/5"
                      widthValue="w-4/5"
                      :value="document.serial"
                    />
                    <string-terr
                      title="Номер"
                      widthTitle="w-1/5"
                      widthValue="w-4/5"
                      :value="document.number"
                    />
                    <string-terr
                      title="Кем выдан"
                      widthTitle="w-1/5"
                      widthValue="w-4/5"
                      :value="document.issuingAuthority"
                    />
                    <string-terr
                      title="Дата выдачи"
                      widthTitle="w-1/5"
                      widthValue="w-4/5"
                      :value="document.dateOfIssue"
                    />
                  </div>
                </div>
              </div>
            </div>
            <div
              class="documents border mt-1 rounded text-primary-900"
              v-if="
                currentTerr.individual.otherNames != null &&
                  currentTerr.individual.otherNames.length > 0
              "
            >
              <div
                class="documents-header p-1 border-b bg-gray-200 font-semibold"
              >
                Другие ФИО
              </div>
              <div class="documents-body p-1 text-sm">
                <div
                  v-for="nameT in currentTerr.individual.otherNames"
                  :key="nameT"
                  class="p-1 border-b"
                >
                  {{ nameT.name }}
                </div>
              </div>
            </div>
          </card>
        </div>
        <div class="w-1/2">
          <card header="Clients">
            <div>
              <item-list
                class="px-2 py-1"
                itemIndex="Full name"
                :itemTitle="currentTerr.client?.fullName"
              />
              <item-list
                class="px-2 py-1"
                itemIndex="lastName"
                :itemTitle="currentTerr.client?.lastName"
              />
              <item-list
                class="px-2 py-1"
                itemIndex="firstName"
                :itemTitle="currentTerr.client?.firstName"
              />
              <item-list
                class="px-2 py-1"
                itemIndex="middleName"
                :itemTitle="currentTerr.client?.middleName"
              />
              <item-list
                class="px-2 py-1"
                itemIndex="birthday"
                :itemTitle="currentTerr.client?.birthday"
              />
              <item-list
                class="px-2 py-1"
                itemIndex="birthPlace"
                :itemTitle="currentTerr.client?.birthPlace"
              />
              <item-list
                class="px-2 py-1"
                itemIndex="Pasport"
                :itemTitle="currentTerr.client?.serialNumberPasport"
              />
              <item-list
                class="px-2 py-1"
                itemIndex="Pasport"
                :itemTitle="currentTerr.client?.issuedBy"
              />
            </div>
          </card>
        </div>
      </div>
    </card>
  </overlay-page>
</template>

<script>
import { onMounted } from "@vue/runtime-core";
import Card from "./cards/Card.vue";
import OverlayPage from "./OverlayPage.vue";

export default {
  name: "TerrCard",
  props: {
    currentTerr: {
      type: Object,
    },
  },
  components: {
    Card,
    OverlayPage,
  },
  setup(props) {
    onMounted(() => {
      console.log(props.currentTerr);
    });
  },
};
</script>
