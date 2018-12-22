<template>

  <div>

    <div style="width: 300px;height: 500px;background-color: rgba(0,0,0,0.45);margin:100px auto;text-align: center;border-radius: 10px">
      <p style="font-size: 28px;font-family: '楷体';padding-top: 20px">登陆</p>
      <hr style="width: 90%;height: 0.01px"/>


      <div style="margin-top: 40px"  @keyup.enter="login">
        <el-input v-model="inputName" placeholder="请输入账号" style="width: 70%"></el-input>
        <el-input v-model="inputPassword" type="password" placeholder="请输入密码" style="width: 70%;margin-top: 20px"></el-input>
        <template>
          <el-select v-model="value4" clearable placeholder="请选择"style="margin-top: 20px">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </template>
      </div>

      <el-button plain style="margin-top: 40px;width: 100px" size="small" @click="login">登录</el-button>

      <p style="font-size: 13px;cursor: pointer;" >注册</p>



    </div>

  </div>

</template>





<script>

  export default {
    name: "signin",

    data() {
      return {
        inputName:'',
        inputPassword:'',
        value4: '',
        options: [{
          value: 'admin',
          label: 'admin'
        }, {
          value: 'factory',
          label: 'factory'
        }, {
          value: 'daili',
          label: 'daili'
        }, {
          value: 'user',
          label: 'user'
        }]


      }
    },
    watch:{

    },
    methods:{

      login(){
        axios.post('/user/login',{
          userName : this.inputName,
          password : this.inputPassword,
          role : this. value4
        }).then((response) => {
          console.log(response);

          if( response.data.states === 2400){
            this.$notify({
              title: '成功',
              message: '登录成功',
              type: 'success',
              duration:2000
            });
            window.sessionStorage.setItem("user", JSON.stringify(response.data.user));
            var token= window.localStorage.getItem("token");
            var user= JSON.parse(window.sessionStorage.getItem("user"));
            console.log(token);
            console.log(user);
            this.$router.replace('/Home');


          }
          else{
            this.$notify({
              title: '失败',
              message: '密码错误',
              type: 'warning',
              duration:2000
            });
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
