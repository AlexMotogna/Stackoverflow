<template>
  <div>
    <v-btn @click="logout">Log-out</v-btn>
  </div>
</template>

<script>
export default {
  methods: {
    logout() {
      this.$store.commit('remove');
      this.$router.replace('/login');
    }
  }
}
</script>

<style scoped>
.logout_button {
  position: fixed;
  top: 90%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
</style>
