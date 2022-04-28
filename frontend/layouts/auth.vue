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
    }
  }

}
</script>
