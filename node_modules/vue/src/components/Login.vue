<template>

  <div>

    <!--hone hone lock人体时钟-->
    <div>
      <object id="honehoneclock" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" width="100%" height="70" align="middle">
        <param name="allowScriptAccess" value="always">
        <param name="movie" value="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_tr.swf">
        <param name="quality" value="high">
        <param name="bgcolor" value="#ffffff">
        <param name="wmode" value="transparent">
        <embed wmode="transparent" src="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_tr.swf" quality="high" bgcolor="#ffffff" name="honehoneclock" allowscriptaccess="always" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" width="100%" height="70" align="middle">
      </object>
    </div>
    <!--仓鼠动画-->
    <!--<div id="bobo">-->
      <!--<object type="application/x-shockwave-flash" style="outline:none;" data="http://cdn.abowman.com/widgets/hamster/hamster.swf?" width="288" height="225">-->
        <!--<param name="movie" value="http://cdn.abowman.com/widgets/hamster/hamster.swf?">-->
        <!--<param name="AllowScriptAccess" value="always">-->
        <!--<param name="wmode" value="opaque">-->
      <!--</object>-->
    <!--</div>-->
    <!--蜘蛛-->
    <!--<object type="application/x-shockwave-flash" style="outline:none;" data="http://cdn.abowman.com/widgets/spider/spider.swf?" width="300" height="200">-->
      <!--<param name="movie" value="http://cdn.abowman.com/widgets/spider/spider.swf?">-->
      <!--<param name="AllowScriptAccess" value="always">-->
      <!--<param name="wmode" value="opaque">-->
      <!--<param name="scale" value="noscale"/>-->
      <!--<param name="salign" value="tl"/>-->
      <!--<param name="bgcolor" value=""/></object>-->
    <!--狗-->
    <!--<object type="application/x-shockwave-flash" style="outline:none;" data="http://cdn.abowman.com/widgets/dog/dog.swf?3?" width="300" height="225">-->
      <!--<param name="movie" value="http://cdn.abowman.com/widgets/dog/dog.swf?3?">-->
      <!--<param name="AllowScriptAccess" value="always">-->
      <!--<param name="wmode" value="opaque">-->
      <!--<param name="bgcolor" value="FFFFFF"/></object>-->

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
          <el-input v-model="RegisterInputName" placeholder="请输入账号" style="width: 70%"></el-input>
          <el-input v-model="RegisterInputPassword" type="password" placeholder="请输入密码" style="width: 70%;margin-top: 10px"></el-input>
          <el-input v-model="ReInputPassword" type="password" placeholder="请确认密码" style="width: 70%;margin-top: 10px"></el-input>
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
          changeType:false
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
