<template>
  <div>
    <div v-show="error">
      <v-card class="error_card">
        <v-card-title class="error">INCORRECT LOGIN</v-card-title>
      </v-card>
    </div>
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
      password: '',
      error: false
    }
  },

  methods: {
    async login() {
      const users = await this.$axios.get('/users/getAll');

      var result = users.data.filter(x => x.username === this.username && x.password === this.password);
      console.log(result)

      if(Object.keys(result).length == 1) {
        this.$router.push('/mainpage');
      } else {
        this.error = true
        console.log("Bad login");
      }

    }
  }
}
</script>

<style scoped>
.title {
  font-size: large;
}
.error {
  font-size: large;
  color: red;
}
.text-input {
  width: 50%;
  text-align: center;
  padding-left: 30px;
}
.error_card {
  width: 30%;
  position: fixed;
  top: 10%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
.login_card {
  width: 50%;
  position: fixed;
  top: 40%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
.create_account_card {
  width: 50%;
  position: fixed;
  top: 80%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
</style>
