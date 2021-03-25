<template>
    <div>
    <div class="info">
      <p class="info_title">My Courses</p>
      <div class="box">
        <div class="imgdiv">
          <img alt="course preview" :src="videoInfo.cover_img" />
        </div>
        <div class="textdiv">
          <p class="c_title">{{videoInfo.title}}</p>
          <p class="price">Original Price: ￥ &nbsp;&nbsp; {{(videoInfo.price / 100).toFixed(2)}}</p>
        </div>
      </div>
    </div>

    <div class="footer">
      <p class="money">Actual Price: ￥ &nbsp;&nbsp; {{(videoInfo.price / 100).toFixed(2)}}</p>
      <p class="submit" @click="pay">Purchase Now</p>
    </div>
  </div>
</template>

<script>
import {getVideoDetails, saveOrder} from '@/api/getData.js'
export default {
    data() {
        return {
            videoInfo : {}
        }
    },

    methods : {
        async getDetails(videoId) {
            try {
                const result = await getVideoDetails(videoId);
                if (result.data.code == 0) {
                    this.videoInfo = result.data.data;
                }
            } catch (error) {
                console.log(error);
            }
        },

        async pay() {
            try {
                const result = await saveOrder(this.$store.state.token, this.$route.query.video_id);
                if (result.data.code == 0) {
                    const toast = this.$createToast({
                    txt: "Purchase successfully",
                    type: "correct",
                    time: 2000,
                    onTimeout : () => {
                        this.$router.push({path : 'order'})
                    }
                });
                    toast.show();
                } else {
                        const toast = this.$createToast({
                        txt: "Cannot purchase",
                        type: "error",
                        time: 1500
                    });
                        toast.show();
                }

            } catch (error) {
                console.log(error);
            }
        }
    },
    
    mounted() {
        this.getDetails(this.$route.query.video_id)
    }
}
</script>

<style lang="scss" scoped>

.info_title {
  padding: 10px 20px;
  background-color: #fff;
  border-bottom: 1px solid #d9dde1;
}

.box {
  background-color: #fff;
  box-sizing: border-box;
  padding: 20px;
  display: flex;
  margin-bottom: 15px;
  .imgdiv {
    width: 105px;
    height: 59px;
    flex-shrink: 0;
    img {
      width: 100%;
      height: 100%;
    }
  }

  .textdiv {
    margin-left: 20px;
    height: 59px;
    flex-grow: 1;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    .price {
      flex-shrink: 0;
    }
  }
}

.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
  height: 50px;
  background-color: #fff;
  display: flex;
  justify-content: space-between;
  box-shadow: 0 -2px 4px 0 rgba(0, 0, 0, 0.1);
  font-size: 16px;
  .money {
    height: 50px;
    line-height: 50px;
    flex: 2;
    text-align: center;
    background-color: #fff;
  }
  .submit {
    height: 50px;
    line-height: 50px;
    flex: 1;
    text-align: center;
    background-color: #ff2d50;
    color: #fff;
  }
}
</style>