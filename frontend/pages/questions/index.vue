<template>
  <div>
    <h1><Logo />Questions</h1>
    <QuestionItem @click.native="redirectview(question.id)" v-for="question in questions" :key="question.id" :value="question" />
    <v-btn to="/mainpage">Back</v-btn>
    <br>
    <br>
    <LogoutButton />
  </div>
</template>

<script>
export default {
  layout: 'auth',

  async asyncData({params, $axios}) {
    const response = await $axios.get('/questions/getAll');
    const questions = response.data;
    return { questions }
  },

  async mounted() {

  },

  methods : {

    redirectview(questionId) {
      this.$router.push({
        name: 'questions-id',
        params: { id: questionId, fromProfile: false }
      });

    }

  }
  
}
</script>
