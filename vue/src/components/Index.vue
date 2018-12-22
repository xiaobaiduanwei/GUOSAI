<template>
  <div class="hello" style="padding-left: 20%;padding-right: 20%;">
    <el-container>
      <el-header>
        <el-row>
          <el-menu
            :default-active="activeIndex1"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">
            <el-menu-item index="SignIn"><i class="el-icon-info"></i>Sign&nbsp;In</el-menu-item>
            <el-menu-item index="SignUp">Sign&nbsp;Up</el-menu-item>
            <el-submenu index="SellerEntrance">
              <template slot="title">卖家入口</template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
              <el-menu-item index="2-3">选项3</el-menu-item>
              <el-submenu index="2-4">
                <template slot="title">选项4</template>
                <el-menu-item index="2-4-1">选项1</el-menu-item>
                <el-menu-item index="2-4-2">选项2</el-menu-item>
                <el-menu-item index="2-4-3">选项3</el-menu-item>
              </el-submenu>
            </el-submenu>
            <el-menu-item index="FactoryEntrance" disabled>产家入口</el-menu-item>
            <el-menu-item index="4" style="margin-left: 50%">客服</el-menu-item>
          </el-menu>
          </el-menu>
        </el-row>
      </el-header>
      <el-main>
        <el-input
          placeholder="请输入内容"
          v-model="input10"
          clearable>
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
        <el-container>
          <el-aside>
            <el-col :span="12">
              <el-menu
                default-active="2"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose"
                background-color="#545c64"
                text-color="#fff"
                active-text-color="#ffd04b">
                <el-submenu index="1">
                  <template slot="title">
                    <i class="el-icon-location"></i>
                    <span>导航一</span>
                  </template>
                  <el-menu-item-group>
                    <template slot="title">分组一</template>
                    <el-menu-item index="1-1">选项1</el-menu-item>
                    <el-menu-item index="1-2">选项2</el-menu-item>
                  </el-menu-item-group>
                  <el-menu-item-group title="分组2">
                    <el-menu-item index="1-3">选项3</el-menu-item>
                  </el-menu-item-group>
                  <el-submenu index="1-4">
                    <template slot="title">选项4</template>
                    <el-menu-item index="1-4-1">选项1</el-menu-item>
                  </el-submenu>
                </el-submenu>
                <el-menu-item index="2">
                  <i class="el-icon-menu"></i>
                  <span slot="title">导航二</span>
                </el-menu-item>
                <el-menu-item index="3" disabled>
                  <i class="el-icon-document"></i>
                  <span slot="title">导航三</span>
                </el-menu-item>
                <el-menu-item index="4">
                  <i class="el-icon-setting"></i>
                  <span slot="title">导航四</span>
                </el-menu-item>
              </el-menu>
            </el-col>
          </el-aside>
          <el-main>
            <el-carousel height="300px" >
              <el-carousel-item v-for="item in 4" :key="item">
                <h3>{{ item }}</h3>
              </el-carousel-item>
            </el-carousel>
          </el-main>
        </el-container>
        <el-row>
          <el-col :span="8" v-for="(o, index) in 2" :key="o" :offset="index > 0 ? 2 : 0">
            <el-card :body-style="{ padding: '0px' }" shadow="hover">
              <img src="..\assets\logo.png" class="image">
              <div style="padding: 14px;">
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
      <el-footer></el-footer>
    </el-container>
  </div>
</template>

<script>
import ElContainer from "element-ui/packages/container/src/main";
import ElAside from "element-ui/packages/aside/src/main";

export default {
  components: {
    ElAside,
    ElContainer},
  name: 'Index',
  // components:{
  //   'SellerEntrance':SellerEntrance,
  //   'FactoryEntrance':FactoryEntrance,
  //   'CustomerService':CustomerService,
  // },
  data () {
    return {
      // msg: 'Welcome to Your Vue.js App'
      activeIndex1: '1',
      input10: '',
      currentDate: new Date()
    };
  },
  methods:{
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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .el-header {
    background-color: #B3C0D1;
    color: gainsboro;
    padding:0;
  }
  .el-main{

  }
  .el-footer{
    background-color: #B3C0D1;
    color: gainsboro;
  }
  .el-carousel__item h3 {
    color: #475669;
    font-size: 20px;
    opacity: 0.75;
    line-height: 300px;
    margin-left          : 49%;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
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
