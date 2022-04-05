<template>
  <div>
    <h1>Profile</h1>
    <p>Username: {{username}}</p>
    <h1>Your Questions:</h1>
    <QuestionItem @click.native="redirectquestionview" v-for="question in questions" :key="question.id" :value="question" />
    <h1>Your Answers:</h1>
    <AnswerItem @click.native="redirectanswerview" v-for="answer in answers" :key="answer.id" :value="answer" />
    <v-btn to="/mainpage">Back</v-btn>
  </div>
</template>

<script>
export default {
  data() {
    return {
      "id": 1,
      "username": "Alexandru Motogna",
      "email": "alexmotogna@gmail.com",
      "password": "123",
      "score": 22,
      "admin": false,
      "banned": false,
      "questions": [
          {
              "id": 1,
              "title": "Java Question",
              "text": "Why it don't work?",
              "creationtime": "2022-03-16T12:36:21.000+00:00",
              "score": 0,
              "answers": [
                  {
                      "id": 1,
                      "text": "This is how",
                      "creationtime": "2022-03-16T12:36:21.000+00:00",
                      "score": 0
                  }
              ],
              "tags": [
                  {
                      "id": 1,
                      "name": "Java"
                  }
              ]
          }
      ],
      "answers": [
          {
              "id": 2,
              "text": "This is how it's done",
              "creationtime": "2022-03-16T12:36:21.000+00:00",
              "score": 0
          },
          {
              "id": 3,
              "text": "Correction: This is how",
              "creationtime": "2022-03-16T12:36:21.000+00:00",
              "score": 0
          },
          {
              "id": 4,
              "text": "CORRECT ANSWER",
              "creationtime": "2022-03-16T12:36:21.000+00:00",
              "score": 0
          }
      ]
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
