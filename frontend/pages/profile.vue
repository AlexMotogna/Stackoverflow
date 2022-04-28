<template>
  <div>
    <h1>Profile</h1>
    <p>Username: {{this.user.username}}</p>
    <p>Score: {{this.user.score}}</p>
    <h1>Your Questions:</h1>
    <QuestionItem @click.native="redirectquestionview" v-for="question in user.questions" :key="question.id" :value="question" />
    <h1>Your Answers:</h1>
    <AnswerItem @click.native="redirectanswerview" v-for="answer in user.answers" :key="answer.id" :value="answer" />
    <v-btn to="/mainpage">Back</v-btn>
    <br>
    <br>
    <LogoutButton />
  </div>
</template>

<script>

export default {
  layout: 'auth',
  data() {
    return {
      user: this.$store.state.user
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
