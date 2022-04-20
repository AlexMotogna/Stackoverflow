<template>
  <div>
    <div v-show="error">
      <v-card class="error_card">
        <v-card-title class="error">INCORRECT ACCOUNT</v-card-title>
      </v-card>
    </div>
    <div>
      <v-card class="login_card">
        <v-card-title class="title">Create Account<Logo /></v-card-title>
        <v-form>
          <v-text-field class="text-input" v-model="username" placeholder="Enter your username" />
          <v-text-field class="text-input" v-model="email" placeholder="Enter your email" />
          <v-text-field class="text-input" type="password" v-model="password" placeholder="Enter your password" />
          <v-btn @click="register">Create Account!</v-btn>
        </v-form>
      </v-card>
    </div>
    <div>
      <v-card class="create_account_card">
        <v-card-title class="title">Already have an account?</v-card-title>
        <v-btn to="/login">Login</v-btn>
      </v-card>
    </div>
  </div>
</template>

<script>
export default {

  data() {
    return {
      username: '',
      email: '',
      password: '',
      error: false
    }
  },

  methods: {
    async register() {
      const response = await this.$axios.post('/users/create', { username: this.username,
                                               email: this.email,
                                               password: this.password,
                                               score: 0,
                                               admin: false,
                                               banned: false });

      if(response.data === "Creation success.") {
        this.$router.push('/mainpage');
      } else {
        this.error = true;
      }
    }
  }
}
</script>

<style scoped>
.error_card {
  width: 30%;
  position: fixed;
  top: 10%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
.error {
  font-size: large;
  color: red;
}
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
