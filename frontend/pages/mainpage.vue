<template>
  <div>
    <Logo />
    <v-card class="card">
      <v-btn to="/questions">View Questions</v-btn>
      <br>
      <v-btn @click="redirectProfile">View Profile</v-btn>
      <br>
      <v-btn to="/createquestion">Ask Question</v-btn>
    </v-card>
    <LogoutButton />
  </div>
</template>

<script>
export default {
  layout: 'auth',

  methods: {

    redirectProfile() {
      this.$router.push({
        name: 'profile',
        params: { id: this.$store.state.user.id }
      });
    }

  }

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
