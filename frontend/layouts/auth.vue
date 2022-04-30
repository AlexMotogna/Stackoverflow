<template>
  <div>
    <Nuxt />
  </div>
</template>

<script>
export default {
  name: 'auth',
  
  mounted() {
    if(this.$store.state.user == null) {
      this.$router.push('/login');
    } else {
      if(this.$store.state.user.banned) {
        this.$router.push('/forbidden');
      }
    }
  }

}
</script>
