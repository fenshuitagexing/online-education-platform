<template>
    <div>
        <div class="container">
            <div class="p_top">
                <div>
                    <img :src='userInfo.headshot || defaultHeadshot' alt="headshot"/>
                    <router-link to="/sign_in" v-if = "getToken === ''"> 
                    <p>Please Sign In</p>
                    </router-link>
                    <p v-else>{{userInfo.name}} </p>
                </div>
            </div>
            <button v-if="getToken !== ''" class="sign_out" @click="signOut">
                Sign Out
            </button>
        </div>
        <common-footer></common-footer>
  </div>
</template>

<script>

import CommonFooter from '@/components/CommonFooter.vue'
import {getUserInfo} from '@/api/getData.js'
import defaultHeadshot from '@/assets/logo.png'

export default {

    // Register the components
    components : {
        CommonFooter
    },

    data() {
        return {
            userInfo : {},
            defaultHeadshot : defaultHeadshot
        }
    },

    // The computed property and methods property 
    // are exactly the same for the end result
    //
    // However, the difference is that computed property
    // is cached, based on their reactive dependencies
    //
    // A computed property will only re-evaluate when some of 
    // its reactive dependencies have changed.
    // 
    // This means if the dependencies have not changed, 
    // it will immediately return the previously computed value
    // without having to run the functions again
    //
    // In comparison, a method invocation will always run the function 
    // whenever a re-render happens
    computed : {
        getToken() {
            return this.$store.state.token
        }
    },

    methods : {
        async getUserInfoByToken() {

            try {
                const result = await getUserInfo(this.getToken)
                if (result.data.code === 0) {
                    this.userInfo = result.data.data
                }
            } catch (error) {
                Console.log(error)
            }
            
        },

        async signOut() {
            
            await this.$store.dispatch('clearToken')
            localStorage.removeItem("token")
            
            location.reload()
        }
    },

    mounted() {
        if (this.getToken) {
            this.getUserInfoByToken()
        }
    },
}
</script>

<style lang="scss" scoped>
.container {

  .p_top {
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px 0;
    background-color: #2c3f54;
    div {
      text-align: center;
      img {
        width: 60px;
        height: 60px;
        border-radius: 50px;
      }
      p {
        font-size: 16px;
        color: #fff;
        margin-top: 10px;
      }
    }
  }
}

.sign_out {
  display: block;
  background-color: #3bb149;
  border: none;
  outline: none;
  width: 80%;
  height: 40px;
  margin: 20px auto 0;
  color: #fff;
  border-radius: 20px;
}
</style>