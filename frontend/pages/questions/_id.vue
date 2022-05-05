<template>
  <div>
    <h1>Question:</h1>
    <QuestionItem key="question.id" :value="question" />
    <br>
    <v-btn v-show="shouldShowUpvote()" @click="upvote" class="upvote_button">Upvote</v-btn>
    <v-btn v-show="shouldShowDownvote()" @click="downvote" class="downvote_button">Downvote</v-btn>
    <br>
    <br>
    <v-btn v-if="this.question.author.id === this.$store.state.user.id || this.$store.state.user.admin" @click="redirectEdit" class="edit_button">Edit</v-btn>
    <br>
    <p>Author: {{this.question.author.username}}</p>
    <v-btn @click="redirectProfile">View account</v-btn>
    <br>
    <br>
    <v-btn @click="redirectCreateAnswer">Answer question</v-btn>
    <h1>Answers:</h1>
    <AnswerItem v-for="answer in question.answers" :key="answer.id" :value="answer" />
    <v-btn to="/questions">Back</v-btn>
  </div>
</template>

<script>
export default {
  layout: 'auth',

  async asyncData({params, $axios}) {
    const responseQuestion = await $axios.get(`/questions/get?id=${params.id}`);
    const question = responseQuestion.data;
    return { question }
  },

  async mounted() {

  },

  methods: {

    async upvote() {
      const response = await this.$axios.post(`questions/upvote?qid=${this.question.id}&userid=${this.$store.state.user.id}&upvote=true`);
      const responseQuestion = await this.$axios.get(`/questions/get?id=${this.question.id}`);
      this.question = responseQuestion.data;
    },

    async downvote() {
      const response = await this.$axios.post(`questions/upvote?qid=${this.question.id}&userid=${this.$store.state.user.id}&upvote=false`);
      const responseQuestion = await this.$axios.get(`/questions/get?id=${this.question.id}`);
      this.question = responseQuestion.data;
    },

    redirectCreateAnswer() {
      this.$router.push({
        name: 'createanswer',
        params: { id: this.question.id }
      });
    },

    redirectProfile() {
      this.$router.push({
        name: 'profile',
        params: { id: this.question.author.id }
      });
    },

    redirectEdit() {
      this.$router.push({
        name: 'questions-edit',
        params: { id: this.question.id }
      });
    },

    canEdit() {
      return this.question.author.id === this.$store.state.user.id || this.$store.state.user.admin;
    },

    shouldShowUpvote() {
      var vote = this.question.votes.find(element => element.id.userid === this.$store.state.user.id);
      if(typeof vote !== 'undefined') {
        return !vote.upvote;
      } else {
        return true;
      }
    },

    shouldShowDownvote() {
      var vote = this.question.votes.find(element => element.id.userid === this.$store.state.user.id);
      if(typeof vote !== 'undefined') {
        return vote.upvote;
      } else {
        return true;
      }
    }

  }

}
</script>

<style scoped>
.edit_button {
  left: 45%;
}
.upvote_button {
  color: orange;
  left: 40%;
}
.downvote_button {
  color: lightblue;
  left: 41%;
}
</style>
