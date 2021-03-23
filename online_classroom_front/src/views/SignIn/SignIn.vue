<template>
    <div class="main">
        <cube-form :model="model" @submit="submitHandler">
        
        <cube-form-group>

            <cube-form-item :field="fields[0]"></cube-form-item>
            <cube-form-item :field="fields[1]"></cube-form-item>
        </cube-form-group>

        <cube-form-group>
            <cube-button type="submit">Sign in</cube-button>
        </cube-form-group>

        </cube-form>
        <router-link to="/sign_up" class="sign-up">Sign up</router-link> 
  </div>
</template>

<script>

import { signInApi } from "@/api/getData.js";
export default {
  data() {
    return {
      model: {
        phoneValue: "",
        pwdValue: ""
      },
      fields: [
        {
          type: "input",
          modelKey: "phoneValue",
          label: "Phone",
          props: {
            placeholder: "Please input your phone number"
          },
          rules: {
            required: true
          },
          messages: {
            required: "A phone number is required"
          }
        },
        {
          type: "input",
          modelKey: "pwdValue",
          label: "Password",
          props: {
            placeholder: "Input the Password",
            type: "password",
            eye: {
              open: false
            }
          },
          rules: {
            required: true
          },
          messages: {
            required: "Password is required"
          }
        }
      ]
    };
  },
  methods: {
    submitHandler(e, model) {
      e.preventDefault();

      signInApi(model.phoneValue, model.pwdValue).then(
        res => {
          if (res.data.code === 0) {
            // Sign in successfully, go to personal profile
            // The data  in localStorage can still be stored after the browser is closed,
            // but sessionStorage doesn't
            localStorage.setItem('token',res.data.data)

            // this.$store.commit(‘the_method_name_in_mutations’, value)
            // this.$store.dispatch('the_method_name_in_actions', value)
            this.$store.dispatch('setToken', res.data.data)
            
            //go to another page (depends on the bussiness)
            this.$router.push({path:'/'})

          }else{
             const toast = this.$createToast({
              txt: "Failed to sign in",
              type: "error",
              time: 1500
            });
            toast.show();
          }
        }
      );
    }
  }
};
</script>

<style lang="scss" scoped>
.main {
  padding: 50px 5% 0;
  text-align: center;
}

.cube-btn {
  margin-top: 20px;
}

.sign-up {
  display: inline-block;
  margin-top: 30px;
  font-size: 18px;
}
</style>