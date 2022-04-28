<template>
  <div>
    <v-card class="question_card">
        <v-card-title class="title">Question</v-card-title>
        <v-form>
          <v-text-field class="text-input" v-model="title" placeholder="Enter title" />
          <v-textarea class="text-area" v-model="text" placeholder="Enter question" />
          <v-btn @click="submit">Create Question</v-btn>
          <v-btn to="/mainpage">Back</v-btn>
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
      title: '',
      text: ''
    }
  },

  methods: {

    async submit() {
      console.log({ title: this.title,text: this.text, creationtime: this.formatDate(new Date()), score: 0});
      const response = await this.$axios.post('/questions/create/?authorid=' + this.$store.state.user.id, { title: this.title,
                                                                                                            text: this.text,
                                                                                                            creationtime: this.formatDate(new Date()),
                                                                                                            score: 0});
      
      if(response.data === "Creation success.") {
        this.$router.push('/questions');
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
  width: 75%;
  text-align: center;
  padding-left: 30px;
}
.text-area {
  width: 75%;
  text-align: center;
  padding-left: 30px;
  /* border-style: solid; */
}
.question_card {
  width: 50%;
  position: fixed;
  top: 30%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
</style>
