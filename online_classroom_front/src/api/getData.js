import axios from "../request"



export const signUpApi = (phone, pwd, name) => axios.post("/api/v1/pri/user/sign_up", {
    "phone" : phone,
    "pwd" : pwd,
    "name" : name
})

export const signInApi = (phone, pwd) => axios.post("/api/v1/pri/user/sign_in", {
    phone,
    pwd
})

export const getBanner = () => axios.get("/api/v1/pub/video/video_banner")

export const getVideoList = () => axios.get("/api/v1/pub/video/video_list")

export const getVideoDetails = (videoId) => axios.get("/api/v1/pub/video/video_details", {
    params : {
        video_id : videoId
    }
})

export const saveOrder = (token, videoId) => axios.post("/api/v1/pri/order/save", {
    "video_id" : videoId
}, {
    headers : {
        "token" : token
    }
})

export const getOrderList = (token) => axios.post("/api/v1/pri/order/order_list", {
    params : {
        "token" : token
    }
})

export const getUserInfo = (token) => axios.get("/api/v1/pri/user/get_by_token", {
    params : {
        token
    }
})