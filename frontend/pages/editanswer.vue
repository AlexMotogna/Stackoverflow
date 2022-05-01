<template>
  <div>
    <h1>Original Answer:</h1>
    <div class="question_display">
      <AnswerItem :key="answer.id" :value="answer" />
    </div>
    <v-card class="answer_card">
        <v-card-title class="title">Your Answer</v-card-title>
        <v-form>
          <v-textarea class="text-area" v-model="answer.text" placeholder="Enter question" />
          <v-btn @click="submit">Update Answer</v-btn>
          <v-btn to="/questions">Back</v-btn>
        </v-form>
      </v-card>
  </div>
</template>

<script>
export default {
  layout: 'auth',

  async asyncData({params, $axios}) {
    const response = await $axios.get(`/answers/get?id=${params.id}`);
    const answer = response.data;
    return { answer }
  },

  async mounted() {

  },

  methods: {

    async submit() {
      console.log(this.answer);

      const response = await this.$axios.put('/answers/update', { id: this.answer.id,
                                                                  text: this.answer.text,
                                                                  creationtime: this.answer.creationtime,
                                                                  score: this.answer.score });

      if(response.data === "Update success.") {
        this.$router.push('/questions');
      } else {

      }

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
