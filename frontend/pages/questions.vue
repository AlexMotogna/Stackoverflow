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
      questions: [
        {
            "id": 1,
            "title": "Java Question",
            "text": "Why it don't work?",
            "creationtime": "2022-03-16T12:36:21.000+00:00",
            "score": 0,
            "tags": [
                {
                    "id": 1,
                    "name": "Java"
                },
                {
                    "id": 3,
                    "name": "OOP"
                }
            ]
        },
        {
            "id": 2,
            "title": "Python Question",
            "text": "Why it don't work py?",
            "creationtime": "2022-03-16T12:36:21.000+00:00",
            "score": 0,
            "tags": [
                {
                    "id": 2,
                    "name": "Python"
                }
            ]
        }
      ]
    }
  },
  methods : {
    redirectview() {
      this.$router.push('/questionview');
    }
  }
}
</script>
