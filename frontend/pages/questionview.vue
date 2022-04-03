<template>
  <div>
    <h1>Question:</h1>
    <QuestionItem key="question.id" :value="question" />
    <h1>Answers:</h1>
    <AnswerItem v-for="answer in question.answers" :key="answer.id" :value="answer" />
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
  }
}
</script>

<style scoped>

</style>
