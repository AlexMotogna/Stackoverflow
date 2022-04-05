<template>
  <div>
    <Logo />
    <v-card class="card">
      <v-btn to="/questions">View Questions</v-btn>
      <br>
      <v-btn to="/createquestion">Ask Question</v-btn>
      <br>
      <v-btn to="/profile">View Profile</v-btn>
    </v-card>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.card {
  width: 50%;
  position: fixed;
  top: 30%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
</style>
