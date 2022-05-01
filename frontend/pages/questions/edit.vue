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

    <v-card class="create_tag_card">
      <v-card-title class="title">Create Tags</v-card-title>
      <v-form>
        <v-text-field class="text-input" v-model="tagText" placeholder="Enter tag" />
        <v-btn @click="createTag">Create Tag</v-btn>
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
        placeholder="Add tag"
        :maxItem="100" />

      <v-btn v-show="!tagInQuestion" @click="addTag">Add Tag</v-btn>
      <v-btn v-show="tagInQuestion" @click="removeTag">Remove Tag</v-btn>
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
      selected: null,
      tagInQuestion: false,
      tagText: ""
    }
  },

  async asyncData({params, $axios}) {
    const responseTags = await $axios.get('/tags/getAll');
    var tags = responseTags.data;

    const responseQuestion = await $axios.get(`/questions/get?id=${params.id}`);
    const question = responseQuestion.data;

    const questionTags = [];

    question.tags.forEach(element => questionTags.push(element));

    return { question, tags, questionTags }
  },

  async mounted() {
    
  },

  methods: {

    async submit() {
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
      this.tagInQuestion = this.questionTags.some(item => item.id === this.selected.id);
    },

    async addTag() {
      if(this.selected !== null && !this.tagInQuestion) {
        this.questionTags.push({ id: this.selected.id, name: this.selected.name });
        const response = await this.$axios.post(`/questions/addTag?qid=${this.question.id}&tagid=${this.selected.id}`);
        this.tagInQuestion = true;
      } else {
        console.log('error');
      }
    }, 

    async removeTag() {
      if(this.selected !== null && this.tagInQuestion) {
        this.questionTags.splice(this.questionTags.findIndex(item => item.id === this.selected.id), 1);
        const response = await this.$axios.delete(`/questions/removeTag?qid=${this.question.id}&tagid=${this.selected.id}`);
        this.tagInQuestion = false;
      } else {
        console.log('error');
      }
    },
    
    async createTag() {
      if(this.tagText !== "") {
        const response = await this.$axios.post(`/tags/create`, {name: this.tagText});
        const responseTags = await this.$axios.get('/tags/getAll');
        this.tags = responseTags.data;
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
.create_tag_card {
  width: 30%;
  position: fixed;
  top: 65%;
  left: 30%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
.tag_card {
  width: 30%;
  position: fixed;
  top: 65%;
  left: 70%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
</style>
