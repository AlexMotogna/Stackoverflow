<template>
  <div>
    <v-card class="answer_card">
      <v-card-text>{{value.text}}</v-card-text>
      <v-card-text>
        <p>Answered by: {{value.author.username}}</p>
        <v-btn @click="redirectProfile">View account</v-btn>
        <p>Created at: {{formatDate(value.creationtime)}}</p>
        <p>Score: {{value.score}}</p>
      </v-card-text>
      <v-btn @click="upvote" class="upvote_button">Upvote</v-btn>
      <v-btn @click="downvote" class="downvote_button">Downvote</v-btn>
      <br>
      <v-btn v-if="value.author.id === this.$store.state.user.id || this.$store.state.user.admin" @click="redirectEditAnswer">Edit</v-btn>
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
    },

    upvote() {
      console.log("Upvote");
    },

    downvote() {
      console.log("Downvote");
    },

    redirectProfile() {
      this.$router.push({
        name: 'profile',
        params: { id: this.value.author.id }
      });
    },

    redirectEditAnswer() {
      this.$router.push({
        name: 'editanswer',
        params: { id: this.value.id }
      });
    }
  }
}
</script>

<style scoped>
.answer_card {
  width: 75%;
  left: 10%;
}
.upvote_button {
  color: orange;
}
.downvote_button {
  color: lightblue;
}
</style>
