<template>
  <div>
    <h1>Question:</h1>
    <QuestionItem key="question.id" :value="question" />
    <br>
    <v-btn @click="upvote" class="upvote_button">Upvote</v-btn>
    <v-btn @click="downvote" class="downvote_button">Downvote</v-btn>
    <br>
    <p>Author: {{this.author.username}}</p>
    <br>
    <v-btn @click="redirectCreateAnswer">Answer question</v-btn>
    <h1>Answers:</h1>
    <AnswerItem v-for="answer in question.answers" :key="answer.id" :value="answer" />
    <v-btn @click="redirectBack">Back</v-btn>
  </div>
</template>

<script>
export default {
  layout: 'auth',

  data() {
    return {
      question: [],
      author: null
    }
  },

  async mounted() {
    const responseQuestion = await this.$axios.get(`/questions/get?id=${this.$route.params.id}`);
    this.question = responseQuestion.data;

    const responseAuthor = await this.$axios.get(`/questions/getAuthor?qid=${this.$route.params.id}`);
    this.author = responseAuthor.data;
  },

  methods: {

    upvote() {
      console.log("Upvote");
    },

    downvote() {
      console.log("Downvote");
    },

    redirectCreateAnswer() {
      this.$router.push({
        name: 'createanswer',
        params: { id: this.question.id }
      });
    },

    redirectBack() {
      if(this.$route.params.fromProfile) {
        this.$router.push('/profile');
      } else {
        this.$router.push('/questions');
      }
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
