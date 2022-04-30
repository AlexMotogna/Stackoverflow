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
          <v-btn to="/questions">Back</v-btn>
        </v-form>
      </v-card>
  </div>
</template>

<script>
import moment from 'moment';

export default {
  layout: 'auth',

  data() {
    return {
      text: ''
    }
  },

  async asyncData({params, $axios}) {
    const response = await $axios.get(`/questions/get?id=${params.id}`);
    const question = response.data;
    return { question }
  },

  async mounted() {

  },

  methods: {

    async submit() {
      console.log({ text: this.text });

      const response = await this.$axios.post(`/answers/create/?authorid=${this.$store.state.user.id}&qid=${this.question.id}`,
                                              { text: this.text,
                                                creationtime: this.formatDate(new Date()),
                                                score: 0});

      if(response.data === "Creation success.") {
        this.$router.push({
          name: 'questions-id',
          params: { id: this.question.id }
        });
      } else {

      }

    },

    formatDate(date) {
      return moment(date).format();
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
