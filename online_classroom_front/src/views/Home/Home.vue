<template>
  <div>
    <!-- Bind the property of sub-component with data source -->
    <!-- The propery needs to be declared in home_banner(./Component/Banner) -->
    <!-- This is the way in which the parent component(Home.vue) sending data to its child component -->
    <home-banner v-bind:bannersProp = "banners"></home-banner>

    <video-list v-bind:videoListProp = "videoList"></video-list>

    <common-footer></common-footer>
  </div>
</template>


<script>
import HomeBanner from "./Component/Banner";
import VideoList from "./Component/VideoList";
import CommonFooter from "../../components/CommonFooter";
import { getBanner, getVideoList } from "../../api/getData.js";

export default {
  // Register the components
  components: {
    HomeBanner,
    VideoList,
    CommonFooter,
  },

  // Declare the data source
  // Bind the data source with sub-components' properties in <template>
  data() {
    return {
      banners: [],
      videoList: [],
    };
  },

  // Define methods
  methods: {
    async getBannerData() {
      try {
        const result = await getBanner();
        console.log(result);
        console.log(result.data.code == 0);
        if (result.data.code == 0) {
          this.banners = result.data.data;
          console.log(this.banners);
        }
      } catch (error) {
        console.log(error);
      }
    },

    // 不能和 import{ getBanner, getVideoList } 中的重名
    async getVideoListData() {
      try {
        const result = await getVideoList();
        console.log(result);
        if (result.data.code == 0) {
          this.videoList = result.data.data;
        }
      } catch (error) {
        console.log(error);
      }
    },
  },
  // 页面渲染完成后调用方法获取数据
  mounted() {
    this.getBannerData();
    this.getVideoListData();
  },
};
</script>

<style lang="scss" scoped>
</style>
