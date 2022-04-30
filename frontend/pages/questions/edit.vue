<template>
  <div>
    <v-card class="question_card">
      <v-card-title class="title">Question</v-card-title>
      <v-form>
        <v-text-field class="text-input" v-model="question.title" placeholder="Enter title" />
        <v-textarea class="text-area" v-model="question.text" placeholder="Enter question" />
        <v-btn @click="submit">Update Question</v-btn>
        <v-btn to="/mainpage">Back</v-btn>
      </v-form>
    </v-card>

    <v-card class="tag_card">
      <v-card-title class="title">Tags</v-card-title>

      <div class="tag_display">
        <TagItem v-for="tag in questionTags" :key="tag.id" :value="tag" />
      </div>
      <br>

      <Dropdown
        :options="tags"
        v-on:selected="validateSelection"
        placeholder="Add tag" />

      <v-btn @click="addTag">Add Tag</v-btn>
    </v-card>

  </div>
</template>

<script>
import moment from 'moment';
import Dropdown from 'vue-simple-search-dropdown';

export default {
  layout: 'auth',

  components: {
    Dropdown
  },

  data() {
    return {
      questionTags: [],
      selected: null
    }
  },

  async asyncData({params, $axios}) {
    const responseTags = await $axios.get('/tags/getAll');
    const tags = responseTags.data;

    const responseQuestion = await $axios.get(`/questions/get?id=${params.id}`);
    const question = responseQuestion.data;

    return { question, tags}
  },

  async mounted() {
    
  },

  methods: {

    async submit() {
      console.log(this.question);
      console.log(this.questionTags);
      const response = await this.$axios.put('/questions/update', { id: this.question.id,
                                                                    title: this.question.title,
                                                                    text: this.question.text,
                                                                    creationtime: this.question.creationtime,
                                                                    score: this.question.score });
      
      if(response.data === "Update success.") {
        this.$router.push('/questions');
      } else {

      }

    },

    formatDate(date) {
      return moment(date).format();
    },

    validateSelection(selection) {
      this.selected = selection;
    },

    addTag() {
      if(this.selected.name && !this.questionTags.some(item => item.id === this.selected.id)) {
        this.questionTags.push({ id: this.selected.id, name: this.selected.name });
      } else {
        console.log('error');
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
.text-area {
  width: 75%;
  text-align: center;
  padding-left: 30px;
}
.question_card {
  width: 50%;
  position: fixed;
  top: 30%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
.tag_display {
  display: flex;
}
.tag_card {
  width: 50%;
  position: fixed;
  top: 70%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
</style>
