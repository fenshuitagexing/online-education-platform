<template>
  <div class="tab">
    <cube-tab-bar v-model="selectedLabelSlots" @click="changeHandler">
      <cube-tab
        v-for="item in tabs"
        :icon="item.icon"
        :label="item.label"
        :key="item.path"
        :value="item.path"
      >
      </cube-tab>
    </cube-tab-bar>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedLabelSlots: "/",
      tabs: [
        {
          label: "Home",
          icon: "cubeic-home",
          path: "/",
        },
        {
          label: "Order",
          icon: "cubeic-like",
          path: "/order",
        },
        {
          label: "Me",
          icon: "cubeic-person",
          path: "/personal",
        },
      ],
    };
  },

  methods: {
    changeHandler(path) {
      // this.$route.path is the current path
      if (path !== this.$route.path) {
        this.$router.push(path);
      }
    },

    // one of the lifecycle stages of a Vue instance
    created() {
      // default router selector
      // when the current page is reloaded,
      // reentering the current route
      this.selectedLabelSlots = this.$route.path;
    },
  },
};
</script>

<style lang="scss" scoped>
.tab {
  position: fixed;
  bottom: 0;
  z-index: 999;
  background-color: #fff;
  width: 100%;
  border-top: 1px solid rgba($color: #000000, $alpha: 0.1);
}
.cube-tab_active {
  color: #3bb149;
}
</style>