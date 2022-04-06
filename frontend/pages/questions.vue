<template>
  <div>
    <h1><Logo />Questions</h1>
    <QuestionItem @click.native="redirectview" v-for="question in questions" :key="question.id" :value="question" />
    <v-btn to="/mainpage">Back</v-btn>
  </div>
</template>

<script>
import { questionsJson } from '../constants'

export default {
  data() {
    return {
      questions: questionsJson
    }
  },
  methods : {
    redirectview() {
      this.$router.push('/questionview');
    }
  }
}
</script>
