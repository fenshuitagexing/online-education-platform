<template>
  <div>
      <!-- The data here needs to be declared in <script> -->
    <cube-slide :data="bannersProp">
      <cube-slide-item
        v-for="(item, index) in bannersProp"
        :key="index">

        <a :href="item.url">
          <img :src="item.img" style="width:100%"/>
        </a>

      </cube-slide-item>
    </cube-slide>
  </div>
</template>

<script>
export default {
    // Get value from parent component(Home.vue)
    props : {
        bannersProp : {
            type : Array,
            // required ?
            require : true
        }
    }
};
</script>

<style lang="scss" scoped>
</style>


