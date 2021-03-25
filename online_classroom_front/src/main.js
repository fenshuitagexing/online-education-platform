import Vue from 'vue'
import './cube-ui'
import App from './App.vue'
import router from './router'
import store from './store'
import { Toast } from 'cube-ui'

Vue.config.productionTip = false

// to: the target Route Object being navigated to
//
// Route Object: represents the state of the current active route.
//               It contains parsed information of the current URL 
//               and the route records matched by the URL
//
// from: the current route being navigated away from
//
router.beforeEach((to, from, next) => {

  const token = localStorage.getItem("token");


  // Filter the route which needs to be passed a token, namely, needs to sign in
  if ( to.matched.some(routeInfo => routeInfo.meta.requiresAuth) ) {
    if (token) {
      next()
    } else {
      next({path : '/sign_in'})
    }
  } else {
    next()
  }



})


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
