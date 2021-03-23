<template>
  <div class="main">
    <cube-form :model="model" @submit="submitHandler">
      <cube-form-group>
        <!--user name-->
        <cube-form-item :field="fields[0]"></cube-form-item>
        <!--phone number-->
        <cube-form-item :field="fields[1]"></cube-form-item>
        <!--password-->
        <cube-form-item :field="fields[2]"></cube-form-item>
      </cube-form-group>

      <cube-form-group>
        <cube-button type="submit">Sign Up</cube-button>
      </cube-form-group>
    </cube-form>

    <router-link to="/sign_in" class="sign-in">Sign In</router-link>
  </div>
</template>

<script>
import { signUpApi } from "@/api/getData.js";
export default {
  data() {
    return {
      model: {
        phoneValue: "",
        pwdValue: "",
        nameValue: "",
      },

      fields: [
        {
          type: "input",
          modelKey: "nameValue",
          label: "Name",
          props: {
            placeHolder: "An username",
          },
          rules: {
            require: true,
          },
          messages: {
            require: "User name is required",
          },
        },

        {
          type: "input",
          modelKey: "phoneValue",
          label: "Phone",
          props: {
            placeHolder: "Please input your phone number",
          },
          rules: {
            require: true,
          },
          messages: {
            require: "A phone number is required",
          },
        },

        {
          type: "input",
          modelKey: "pwdValue",
          label: "Password",
          props: {
            placeHolder: "Set your Password",
            type: "password",
            eye: {
              open: false,
            },
          },
          rules: {
            require: true,
          },
          messages: {
            require: "Password is required",
          },
        },
      ],
    };
  },

  methods: {
    submitHandler(e, model) {
      e.preventDefault();

      signUpApi(model.phoneValue, model.pwdValue, model.nameValue).then(
        // response
        (res) => {
          if (res.data.code === 0) {
            //didi.github.io/cube-ui/#/en-US/docs/toast
            const toast = this.$createToast({
              txt: "Sigu up successfully",
              type: "correct",
              time: 1500,
            });
            toast.show();
          }
          
        }
      );
    },
  },
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

.sign-in {
  display: inline-block;
  margin-top: 30px;
  font-size: 18px;
}
</style>