<template>

  <div>

    <div style="width: 300px;height: 400px;background-color: rgba(0,0,0,0.45);margin:100px auto;text-align: center;border-radius: 10px">
      <p style="font-size: 28px;font-family: '楷体';padding-top: 20px">注册登陆</p>
      <hr style="width: 90%;height: 0.01px"/>
      <div v-if="!changeType">

        <div style="margin-top: 40px"  @keyup.enter="login">
          <el-input v-model="inputName" placeholder="请输入用户名" style="width: 70%"></el-input>
          <el-input v-model="inputPassword" type="password" placeholder="请输入密码" style="width: 70%;margin-top: 20px"></el-input>
          <el-input v-model="inputRole" placeholder="请输入角色" style="width: 70%;margin-top: 20px"></el-input>
        </div>

        <el-button plain style="margin-top: 40px;width: 100px" size="small" @click="login">登录</el-button>

        <p style="font-size: 13px;cursor: pointer;" @click="changePage">注册</p>
      </div>

      <div v-if="changeType">

        <div style="margin-top: 20px">
          <el-input v-model="RegisterInputName" placeholder="请输入用户名" style="width: 70%"></el-input>
          <el-input v-model="RegisterInputPassword" type="password" placeholder="请设置输入密码" style="width: 70%;margin-top: 10px"></el-input>
          <el-input v-model="ReInputPassword" type="password" placeholder="请确认密码" style="width: 70%;margin-top: 10px"></el-input>
          <template>
            <el-select v-model="value4" clearable placeholder="请选择">
              <el-option
                      v-for="item in options"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
              </el-option>
            </el-select>
          </template>



                      }
                  }
              }

        </div>

        <el-button plain style="margin-top: 20px;width: 100px" size="small" @click="register()">立即注册</el-button>

        <p style="font-size: 13px;cursor: pointer;" @click="changePage">返回登录</p>

      </div>

    </div>

  </div>

</template>

<script>

    export default {
        name: "login",

      data() {
        return {
          inputName:'',
          inputPassword:'',
          inputRole:'',
          ReInputPassword:'',
          RegisterInputName:'',
          RegisterInputPassword:'',
          changeType:false,
            options: [{
                value: '选项1',
                label: '黄金糕'
            }, {
                value: '选项2',
                label: '双皮奶'
            }, {
                value: '选项3',
                label: '蚵仔煎'
            }, {
                value: '选项4',
                label: '龙须面'
            }, {
                value: '选项5',
                label: '北京烤鸭'
            }],
            value4: ''
        }
      },
      watch:{

      },
      methods:{
        register(){
          if(this.RegisterInputName=="" || this.RegisterInputPassword==""){
            this.$notify({
              title: '警告',
              message: '请填写注册信息',
              type: 'warning',
              duration:2000
            });
          }
          if(this.ReInputPassword!=this.RegisterInputPassword){
            this.$notify.error({
              title: '错误',
              message: '两次输入的密码不同',
              type: 'warning',
              duration:3000
            });
          }else{
            axios.post('/public/register',{
              username : this.RegisterInputName,
              password : this.RegisterInputPassword
            }).then((response) => {
              if(response.data.code=0){
                this.$notify.error({
                  title: '错误',
                  message: response.data.message,
                  type: 'warning',
                  duration:0
                });
            }else{
              this.$notify({
                title: '成功',
                message: '注册成功',
                type: 'success',
                duration:1000
              });
              this.changePage()
            }
          }).catch((response)=>{

            })
          }

        },
        changePage(){
          this.changeType = ! this.changeType
        },
        login(){
          axios.post('/user/login',{
            userName : this.inputName,
            password : this.inputPassword,
            role : this.inputRole
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
