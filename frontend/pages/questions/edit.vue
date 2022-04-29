<template>
  <div>
    <v-card class="question_card">
      <v-card-title class="title">Question</v-card-title>
      <v-form>
        <v-text-field class="text-input" v-model="question.title" placeholder="Enter title" />
        <v-textarea class="text-area" v-model="question.text" placeholder="Enter question" />
        <v-btn @click="submit">Create Question</v-btn>
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
      question: null,
      tags: [],
      questionTags: [],
      selected: null
    }
  },

  async mounted() {
    const response = await this.$axios.get('/tags/getAll');
    this.tags = response.data;
  },

  methods: {

    async submit() {
      console.log({ title: this.title,text: this.text, creationtime: this.formatDate(new Date()), score: 0});
      // const response = await this.$axios.post('/questions/create/?authorid=' + this.$store.state.user.id, { title: this.title,
      //                                                                                                       text: this.text,
      //                                                                                                       creationtime: this.formatDate(new Date()),
      //                                                                                                       score: 0});
      
      if(response.data === "Creation success.") {
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
        // const response = await this.$axios.post(`localhost:8081/questions/addTag?qid=${1}&tagid=${tag.id}`)
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
  top: 60%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
</style>
