<template>
  <div>
    <h1>Profile</h1>
    <p>Username: {{username}}</p>
    <h1>Your Questions:</h1>
    <QuestionItem @click.native="redirectquestionview" v-for="question in user.questions" :key="question.id" :value="question" />
    <h1>Your Answers:</h1>
    <AnswerItem @click.native="redirectanswerview" v-for="answer in user.answers" :key="answer.id" :value="answer" />
    <v-btn to="/mainpage">Back</v-btn>
  </div>
</template>

<script>
import { userJson } from '../constants';

export default {
  data() {
    return {
      user: userJson
    }
  },
  methods : {
    redirectquestionview() {
      this.$router.push('/questionview');
    },
    redirectanswerview() {
      this.$router.push('/questionview');
    }
  }
}
</script>

<style scoped>

</style>
