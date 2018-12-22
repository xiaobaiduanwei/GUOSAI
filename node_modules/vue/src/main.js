// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
axios.defaults.baseURL='http://localhost:8085';

Vue.use(ElementUI);
Vue.use(VueAxios,axios)
Vue.config.productionTip = false

window.bus  = new Vue();
window.bus  = new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})

router.beforeEach((to, from, next) => {
  if (to.matched.some(res => res.meta.requireAuth)) { // 验证是否需要登陆
  var data = JSON.parse(window.sessionStorage.getItem("user"));
  if (data!=null) { // 查询本地存储信息是否已经登陆
    next();
  } else {
    next({
      path: '/Login', // 未登录则跳转至login页面
    });
  }
} else {
  next();
}
});

// 请求拦截器
axios.interceptors.request.use(config => {
  config.headers.token = window.localStorage.getItem("token")
console.log(config);
return config
}, error => {
  console.log('加载超时');
  return Promise.reject(error)
});

// http响应拦截器
axios.interceptors.response.use(response => {
//没有token重新登陆
  if(response.data.status==1000){
  window.localStorage.removeItem("user")
  window.bus.$router.replace({ name: 'Login'})
}else if(response.data.status==2400){
  window.localStorage.setItem("token",response.data.detail)
  return response
}else{
  return response
}
}, error => {
  console.log('加载失败')
  return (error)
})

export default axios
window.axios = require('axios');

