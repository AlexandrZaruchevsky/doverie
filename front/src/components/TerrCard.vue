<template>
  <overlay-page class="flex justify-center pt-20" @click="$emit('close')">
    <card @click.stop @close="$emit('close')" header="Details">
      <div class="fio">
        <string-terr title="ФИО" :value="currentTerr.fio" />
        <string-terr title="ФИО - Латиница" :value="currentTerr.fioLat" />
        <string-terr title="Дата рождения" :value="currentTerr.birthday" />
        <string-terr title="Год рождения" :value="currentTerr.yearOfBirth" />
        <string-terr title="Место рождения" :value="currentTerr.placeOfBirth" />
        <string-terr title="СНИЛС" :value="currentTerr.snils" />
        <string-terr title="ИНН" :value="currentTerr.inn" />
      </div>
      <div
        v-if="currentTerr.documents != null && currentTerr.documents.length > 0"
        class="documents border mt-1 rounded"
      >
        <div
          class="documents-header p-1 border-b bg-gray-200 text-primary-800 font-semibold"
        >
          Документы
        </div>
        <div class="documents-body">
          <div
            v-for="(document, index) in currentTerr.documents"
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
          currentTerr.otherNames != null && currentTerr.otherNames.length > 0
        "
      >
        <div class="documents-header p-1 border-b bg-gray-200 font-semibold">
          Другие ФИО
        </div>
        <div class="documents-body p-1 text-sm">
          <div
            v-for="nameT in currentTerr.otherNames"
            :key="nameT"
            class="p-1 border-b"
          >
            {{ nameT.name }}
          </div>
        </div>
      </div>
    </card>
  </overlay-page>
</template>

<script>
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
};
</script>
