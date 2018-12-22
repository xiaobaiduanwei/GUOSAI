<template>
  <el-container>
    <el-aside width="200px">


    </el-aside>
    <el-container>
      <el-header style="height: 120px">
        <div id="lll"style=" width: 70%; margin-top:0px; float: left" >
          <el-input v-model="input" placeholder="请输入内容" style="width:30%; margin-top: 20px"></el-input><el-button type="primary" icon="el-icon-search">搜索</el-button>
        </div>
        <div id="nnn" style=" width: 30%; margin-top: 0px; float: left">
          <el-button  slot="title" type="primary" icon=""  ></el-button>

          <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-star-off"></i>
                <span slot="title">导航一</span>
              </template>
              <el-menu-item-group>
                <span slot="title">分组一</span>
                <el-menu-item index="1-1">选项1</el-menu-item>
                <el-menu-item index="1-2">选项2</el-menu-item>
                <el-menu-item index="1-3">选项3</el-menu-item>
                <el-submenu index="1-4">
                  <span slot="title">选项4</span>
                  <el-menu-item index="1-4-1">选项1</el-menu-item>
                </el-submenu>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>

        </div>
      </el-header>
      <el-main>
        <el-row  >
          <el-col :span="4" v-for="(o, index) in 20" :key="o" :offset="index > 0 ? 1: 1" style="margin-top: 50px" >
            <el-card :body-style="{ padding: '0px' }" >
              <img src="~vue/build/logo.png" class="image">
              <div style="padding: 1px;">
                <span>好吃的汉堡</span>
                <div class="bottom clearfix">
                  <time class="time">{{ currentDate }}</time>
                  <el-button type="text" class="button">操作按钮</el-button>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>

      </el-main>
      <el-footer>Footer</el-footer>
    </el-container>
  </el-container>
</template>
<style>
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
  }
  .el-header, .el-footer {
    background-color: #409EFF;
    color: #909399;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #409EFF;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color:#E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }
</style>

<script>
export default {
data() {

return {
  currentDate: new Date(),
  input: '',
  activeIndex: '1',
  activeIndex2: '1',
  isCollapse: true
};
},
methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
  handleOpen(key, keyPath) {
    console.log(key, keyPath);
  },
  handleClose(key, keyPath) {
    console.log(key, keyPath);
  }
}
}
</script>
