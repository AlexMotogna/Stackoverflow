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
export default {
  data () {
    return {
      question: {
        "id": 2,
        "title": "Python Question",
        "text": "Why it don't work?",
        "creationtime": "2022-03-16T12:36:21.000+00:00",
        "score": 0,
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
          ],
        "tags": [
            {
                "id": 2,
                "name": "Python"
            }
          ]
      }
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
