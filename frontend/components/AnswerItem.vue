<template>
  <div>
    <v-card class="answer_card">
      <v-card-text>{{value.text}}</v-card-text>
      <v-card-text>
        <p>Created at: {{formatDate(value.creationtime)}}</p>
        <p>Score: {{value.score}}</p>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
import moment from 'moment';

export default {
  name: "AnswerItem",

  props: {
    value: {
      type: Object,
      default: () => {}
    }
  },

  methods: {
    formatDate(date) {
      return moment(date).format('DD.MM.YYYY');
    }
  }
}
</script>

<style scoped>
.answer_card {
  width: 75%;
  left: 10%;
}
</style>
