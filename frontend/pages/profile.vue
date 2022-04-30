<template>
  <div>
    <h1>Profile</h1>
    <p>Username: {{this.user.username}}</p>
    <p>Score: {{this.user.score}}</p>
    <h1>Your Questions:</h1>
    <QuestionItem @click.native="redirectquestionview(question.id)" v-for="question in questions" :key="question.id" :value="question" />
    <!-- <h1>Your Answers:</h1>
    <AnswerItem @click.native="redirectanswerview" v-for="answer in answers" :key="answer.id" :value="answer" /> -->
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
        params: { id: questionId, fromProfile: true, profileUserId: this.$route.params.id }
      });
    },

    redirectanswerview() {
      // this.$router.push('/questionview');
    }

  }
}
</script>

<style scoped>

</style>
