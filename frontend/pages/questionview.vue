<template>
  <div>
    <h1>Question:</h1>
    <QuestionItem key="question.id" :value="question" />
    <br>
    <v-btn @click="upvote" class="upvote_button">Upvote</v-btn>
    <v-btn @click="downvote" class="downvote_button">Downvote</v-btn>
    <br>
    <v-btn to="/createanswer">Answer question</v-btn>
    <h1>Answers:</h1>
    <AnswerItem v-for="answer in question.answers" :key="answer.id" :value="answer" />
    <v-btn to="/questions">Back</v-btn>
  </div>
</template>

<script>
import { questionJson } from '../constants'

export default {
  layout: 'auth',
  data () {
    return {
      question: questionJson
    }
  }, 
  methods: {
    upvote() {
      console.log("Upvote");
    },
    downvote() {
      console.log("Downvote");
    }
  }
}
</script>

<style scoped>
.upvote_button {
  color: orange;
  left: 40%;
}
.downvote_button {
  color: lightblue;
  left: 41%;
}
</style>
