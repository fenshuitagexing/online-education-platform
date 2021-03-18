import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home/Home.vue'
import CourseDetail from '../views/CourseDetail/CourseDetail.vue'
import Order from '../views/Order/Order.vue'
import Payment from '../views/Payment/Payment.vue'
import Personal from '../views/Personal/Personal.vue'
import SignIn from '../views/SignIn/SignIn.vue'
import SignUp from '../views/SignUp/SignUp.vue'

Vue.use(VueRouter)

const routes = [
  {
    path : "/",
    name : "Home",
    component : Home
  },

  {
    path : "/CourseDetail",
    name : "CourseDetail",
    component : CourseDetail
  },

  {
    path : "/Order",
    name : "Order",
    component : () => import("../views/Order/Order.vue")
    // component : Order
  },

  {
    path : "/Payment",
    name : "Payment",
    component : Payment
  },

  {
    path : "/Personal",
    name : "Personal",
    component : Personal
  },

  {
    path : "/SignIn",
    name : "SignIn",
    component : SignIn
  },
  
  {
    path : "/SignUp",
    name : "SignUp",
    component : SignUp
  }
]

const router = new VueRouter({
  routes
})

export default router
