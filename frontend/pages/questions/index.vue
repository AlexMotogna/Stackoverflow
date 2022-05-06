<template>
  <div>
    <h1><Logo />Questions</h1>
    <v-btn to="/mainpage">Back</v-btn>
    <LogoutButton />
    <br>
    <br>
    <v-card class="filter_card">
      <v-card-title>Filters</v-card-title>
      <div>
        <v-text-field class="text-input" v-model="titleFilter" placeholder="Enter title" />
        <v-btn @click="filterByTitle">Search by title</v-btn>
      </div>
      <div>
        <v-text-field class="text-input" v-model="tagFilter" placeholder="Enter tag" />
        <v-btn @click="filterByTag">Search by tag</v-btn>
      </div>
    </v-card>
    <br>
    <br>
    <QuestionItem @click.native="redirectview(question.id)" v-for="question in filteredQuestions" :key="question.id" :value="question" />
    <br>
  </div>
</template>

<script>
export default {
  layout: 'auth',

  data() {
    return {
      titleFilter: '',
      tagFilter: ''
    }
  },

  async asyncData({params, $axios}) {
    const response = await $axios.get('/questions/getAll');
    var questions = response.data;
    var filteredQuestions = response.data;
    return { questions, filteredQuestions }
  },

  async mounted() {

  },

  methods : {

    redirectview(questionId) {
      this.$router.push({
        name: 'questions-id',
        params: { id: questionId }
      });
    },

    filterByTitle() {
      this.filteredQuestions = this.questions.filter(question => question.title.includes(this.titleFilter));
    },

    filterByTag() {
      if(this.tagFilter === "") {
        this.filteredQuestions = this.questions;
      } else {
        this.filteredQuestions = this.questions.filter(question => question.tags.some(tag => tag.name.includes(this.tagFilter)));
      }
    }

  }
  
}
</script>

<style scoped>
.text-input {
  width: 75%;
  text-align: center;
  padding-left: 30px;
}
.filter_card {
  width: 50%;
  left: 15%;
}
</style>
