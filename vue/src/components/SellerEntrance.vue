<template>
  <el-input
    placeholder="请输入内容"
    v-model="input10"
    clearable>
    <el-button slot="append" icon="el-icon-search"></el-button>
  </el-input>
</template>

<script>
  import ElContainer from "element-ui/packages/container/src/main";
  import ElAside from "element-ui/packages/aside/src/main";
    export default {
      components: {
        ElAside,
        ElContainer},
        name: "seller-entrance",
      data () {
        return {
          // msg: 'Welcome to Your Vue.js App'
          activeIndex1: '1',
          input10: '',
          currentDate: new Date()
        };
      },
    }
</script>

<style scoped>

</style>
