<template>
  <div>
    <v-card class="question_card">
      <v-card-title>{{value.title}}</v-card-title>
      <div class="tag_display">
        <TagItem v-for="tag in value.tags" :key="tag.id" :value="tag" />
      </div>
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
  name: "QuestionItem",

  props: {
    value: {
      type: Object,
      default: () => {}
    }
  },

  mounted() {
    console.log(this.value);
  },

  methods: {
    formatDate(date) {
      return moment(date).format('DD.MM.YYYY');
    }
  }
}
</script>

<style scoped>
.question_card {
  width: 75%;
  left: 10%;
}
.tag_display {
  display: flex;
}
</style>
