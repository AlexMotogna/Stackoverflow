<template>
  <div>
    <div>
      <v-card class="login_card">
        <v-card-title class="title">LOGIN<Logo /></v-card-title>
        <v-form>
          <v-text-field class="text-input" v-model="username" placeholder="Enter your username" />
          <v-text-field class="text-input" type="password" v-model="password" placeholder="Enter your password" />
          <v-btn @click="login">Login!</v-btn>
        </v-form>
      </v-card>
    </div>
    <div>
      <v-card class="create_account_card">
        <v-card-title class="title">Don't have an account?</v-card-title>
        <v-btn to="/register">Create account</v-btn>
      </v-card>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: ''
    }
  },

  methods: {
    login() {
      console.log({ username: this.username, password: this.password });
    }
  }
}
</script>

<style scoped>
.title {
  font-size: large;
}
.text-input {
  width: 50%;
  text-align: center;
  padding-left: 30px;
}
.login_card {
  width: 50%;
  position: fixed;
  top: 30%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
.create_account_card {
  width: 50%;
  position: fixed;
  top: 70%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
</style>
