<template>
  <div>
    <h1>Profile</h1>
    <p>Username: {{this.user.username}}</p>
    <p>Score: {{this.user.score}}</p>
    <h1>Questions asked:</h1>
    <QuestionItem @click.native="redirectquestionview(question.id)" v-for="question in questions" :key="question.id" :value="question" />
    <v-btn v-if="this.$store.state.user.admin" @click="ban" class="ban_button">Ban</v-btn>
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
    const userResponse = await $axios.get(`/users/get?id=${params.id}`);
    const user = userResponse.data;
    
    const questionResponse = await $axios.get(`questions/getAllFromUser?authorid=${params.id}`);
    const questions = questionResponse.data;

    return { user, questions }
  },

  async mounted() {

  },

  methods : {

    redirectquestionview(questionId) {
      this.$router.push({
        name: 'questions-id',
        params: { id: questionId }
      });
    },

    async ban() {
      const response = await this.$axios.put(`users/ban?id=${this.$route.params.id}`);
    }

  }
}
</script>

<style scoped>
.ban_button {
  color: red;
}
</style>
