<template>
  <div>
    <v-chip>{{value.name}}</v-chip>
  </div>
</template>

<script>

export default {
  name: "TagItem",

  props: {
    value: {
      type: Object,
      default: () => {}
    }
  }
}
</script>
