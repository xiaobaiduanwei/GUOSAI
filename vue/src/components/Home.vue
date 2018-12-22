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
          <el-button type="primary" icon="el-icon-star-off" style=" margin-top: 20px;margin-left: 20px"></el-button>
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
  input: ''
};
}
}
</script>
