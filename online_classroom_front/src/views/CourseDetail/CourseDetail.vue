<template>
  <div>
    <!--顶部返回组件(Header.vue)-->
    <!-- Passing value inside the component -->
    <!-- videoInfo needs to be declared in Header.vue -->
    <details-header :videoInfo="videoInfo"></details-header>

    <!--视频介绍组件-->
    <details-course :videoInfo="videoInfo"></details-course>

    <!--视频tab简介组件-->
    <details-tab
      :videoInfo="videoInfo"
      :chapterList="chapterList"
    ></details-tab>

    <!--底部立刻购买-->
    <footer>
      <router-link
        :to="{ path: '/payment', query: { video_id: this.$route.query.video_id } }"
        class="user_buy"
      >
        <button>Purchase</button>
      </router-link>
    </footer>
  </div>
</template>


<script>
import DetailsHeader from "./Components/Header";
import DetailsCourse from "./Components/Course";
import DetailsTab from "./Components/Tab";

import { getVideoDetails } from "@/api/getData.js";

// Register components, get data from the backend
export default {
  // Register components
  components: {
    DetailsHeader,
    DetailsCourse,
    DetailsTab,
  },

  data() {
    return {
      videoInfo: {},
      chapterList: [],
    };
  },

  methods: {
    async getDetails(videoId) {
      try {
        const result = await getVideoDetails(videoId);
        if (result.data.code == 0) {
          this.videoInfo = result.data.data;
          this.chapterList = result.data.data.chapter_list;
        }
      } catch (error) {
        console.log(error);
      }
    },
  },

  mounted() {
    // Get data after rendering
    this.getDetails(this.$route.query.video_id);
  },
};
</script>

<style lang="scss" scoped>
//底部
footer {
  // fixed固定在底部
  position: fixed;
  bottom: 0;
  width: 50%;
  padding: 8px 0;
  background-color: #fff;
  z-index: 999;
  box-shadow: 0 -2px 4px 0 rgba(0, 0, 0, 0.05);
}
//设置购买按钮样式
button {
  display: block;
  color: #fff;
  margin: 0 auto;
  background-color: #d93f30;
  height: 34px;
  line-height: 34px;
  border-radius: 17px;
  width: 80%;
  border: none;
  font-size: 15px;
  text-align: center;
}
</style>
