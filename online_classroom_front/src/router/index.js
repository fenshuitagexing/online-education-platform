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
    path : "/course_detail",
    name : "CourseDetail",
    component : CourseDetail
  },

  {
    path : "/order",
    name : "Order",
    // component : () => import("../views/Order/Order.vue"),
    component : Order,

    // Intercepting the route in main.js
    meta : {requiresAuth : true}
  },

  {
    path : "/payment",
    name : "Payment",
    component : Payment,
    meta : {requiresAuth : true}
  },

  {
    path : "/personal",
    name : "Personal",
    component : Personal,
    meta : {requiresAuth : true}
  },

  {
    path : "/sign_in",
    name : "SignIn",
    component : SignIn
  },
  
  {
    path : "/sign_up",
    name : "SignUp",
    component : SignUp
  }
]

const router = new VueRouter({
  routes
})

export default router
