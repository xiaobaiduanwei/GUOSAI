<template>

  <div>

    <div style="width: 300px;height: 470px;background-color: rgba(0,0,0,0.45);margin:100px auto;text-align: center;border-radius: 10px">
      <p style="font-size: 28px;font-family: '楷体';padding-top: 20px">注册</p>
      <hr style="width: 90%;height: 0.01px"/>
      <div style="margin-top: 20px">
        <el-input v-model="RegisterInputName" placeholder="请输入用户名" style="width: 70%"></el-input>
        <el-input v-model="RegisterInputPassword" type="password" placeholder="请设置输入密码" style="width: 70%;margin-top: 10px"></el-input>
        <el-input v-model="RegisterInputAddress" placeholder="请输入地址" style="width: 70%;margin-top: 10px"></el-input>
        <el-input v-model="RegisterInputPhone" placeholder="请输入手机号" style="width: 70%;margin-top: 10px"></el-input>
        <el-radio-group v-model="sex" style="width: 70%;margin-top: 20px">
          <el-radio :label="1">男</el-radio>
          <el-radio :label="2">女</el-radio>
        </el-radio-group>
        <el-button plain style="margin-top: 20px;width: 100px" size="small" @click="register()">立即注册</el-button>

        <p style="font-size: 13px;cursor: pointer;" @click="changePage">返回登录</p>

      </div>

    </div>

  </div>

</template>





<script>

  export default {
    name: "sign-up-d",

    data() {
      return {
        RegisterInputName:'',
        RegisterInputPassword:'',
        RegisterInputAddress:'',
        RegisterInputPhone:'',
        sex:''

      }
    },
    watch:{

    },
    methods:{
      register(){
        if(this.RegisterInputName=="" || this.RegisterInputPassword=="" || this.RegisterInputAddress=="" || this.RegisterInputPhone==""||this.sex==""){
          this.$notify({
            title: '警告',
            message: '请填写注册信息',
            type: 'warning',
            duration:2000
          });

        }else{
          axios.post('/user/registf',{
            userName : this.RegisterInputName,
            password : this.RegisterInputPassword,
            role :"daili",
            phone:this.RegisterInputPhone,
            sex:this.sex,
            address:this.RegisterInputAddress
          }).then((response) => {

            if(response.data.states==800){
              console.log(response)
              this.$notify({
                title: '成功',
                message: '注册成功',
                type: 'success',
                duration:2000
              });
              this.$router.replace('/SignIn');
            } else if(response.data.states==300){
              this.$notify.error({
                title: '错误',
                message: response.data.message,
                type: 'warning',
                duration:0
              });

            } else{
              this.$notify.error({
                title: '错误',
                message: '错误',
                type: 'warning',
                duration:0
              });
            }
          }).catch((response)=>{

          })
        }

      },
      changePage(){
        this.changeType = ! this.changeType
      },
    }
  }
</script>

<style scoped>

</style>
