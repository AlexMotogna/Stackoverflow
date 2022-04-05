<template>
  <div>
    <h1>Question:</h1>
    <div class="question_display">
      <QuestionItem key="question.id" :value="question" />
    </div>
    <v-card class="answer_card">
        <v-card-title class="title">Your Answer</v-card-title>
        <v-form>
          <v-textarea class="text-area" v-model="text" placeholder="Enter question" />
          <v-btn @click="submit">Submit Answer</v-btn>
          <v-btn to="/questionview">Back</v-btn>
        </v-form>
      </v-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      question: {
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
      } ,
      text: ''
    }
  },

  methods: {
    submit() {
      console.log({ text: this.text });
    }
  }
}
</script>

<style scoped>
.text-input {
  width: 50%;
  text-align: center;
  padding-left: 30px;
}
.text-area {
  width: 50%;
  text-align: center;
  padding-left: 30px;
}
.answer_card {
  width: 75%;
  left: 10%;
}
</style>
