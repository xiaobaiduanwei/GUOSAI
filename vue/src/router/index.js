import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Home from '@/components/Home'
import Chat from '@/components/Chat'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: 'Login',
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login,
    },
    {
      path: '/Home',
      name: 'Home',
      component: Home,
      hidden: true,
      meta: {
        requireAuth: true
      },
      children: [
        {
          path: '/Chat',
          name: 'Chat',
          component: Chat,
          hidden: true,
        }
      ]
    }
  ]
})
