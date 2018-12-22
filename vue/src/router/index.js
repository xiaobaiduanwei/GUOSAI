import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'

const CustomerService = resolve => require(['@/components/CustomerService'], resolve)
const FactoryEntrance = resolve => require(['@/components/FactoryEntrance'], resolve)
const SellerEntrance = resolve => require(['@/components/SellerEntrance'], resolve)
const SignIn = resolve => require(['@/components/SignIn'], resolve)
const SignUp = resolve => require(['@/components/SignUp'], resolve)

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index,
      children:[
        {
          path: '/SignIn',
          name:'SignIn',
          component: SignIn,
        },
        {
          path: '/SignUp',
          name:'SignUp',
          component: SignUp,
        },
        {
          path: '/CustomerService',
          name:'CustomerService',
          component: CustomerService,
        },
        {
          path: '/FactoryEntrance',
          name:'FactoryEntrance',
          component: FactoryEntrance,
        },
        {
          path: '/SellerEntrance',
          name:'SellerEntrance',
          component: SellerEntrance,
        },
      ]
    },
  ]
})
