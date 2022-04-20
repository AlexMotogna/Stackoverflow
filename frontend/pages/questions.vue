<template>
  <div>
    <h1><Logo />Questions</h1>
    <QuestionItem @click.native="redirectview" v-for="question in questions" :key="question.id" :value="question" />
    <v-btn to="/mainpage">Back</v-btn>
  </div>
</template>

<script>
export default {
  data() {
    return {
      questions: []
    }
  },
  async mounted() {
    this.getPosts();
  },
  methods : {
    redirectview() {
      this.$router.push('/questionview');
    },
    async getPosts() {
      const questions = await this.$axios.get('/questions/getAll');
      this.questions = questions.data;
    }
  }
}
</script>
