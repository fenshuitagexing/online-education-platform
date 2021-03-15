package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.model.entity.VideoOrder;
import net.xdclass.online_xdclass.model.request.VideoOrderRequest;
import net.xdclass.online_xdclass.service.VideoOrderService;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {

    private final VideoOrderService videoOrderService;

    public VideoOrderController(VideoOrderService videoOrderService) {
        this.videoOrderService = videoOrderService;
    }

    // The front-end side sends the properties about the video, the data is in JSON format
    @RequestMapping("save")
    public JsonData saveOrder(@RequestBody VideoOrderRequest videoOrderRequest,
                              // Get user properties from HttpServletRequest through decrypting the token
                              HttpServletRequest httpServletRequest) {

        Integer userId = (Integer) httpServletRequest.getAttribute("user_id");
        int videoId = videoOrderRequest.getVideoId();
        int rows = videoOrderService.save(userId, videoId);

        return rows == 0 ? JsonData.buildError("Purchase failed") : JsonData.buildSuccess();
    }

    @GetMapping("order_list")
    public JsonData getOrderList(HttpServletRequest request) {

        Integer userId = (Integer) request.getAttribute("user_id");
        List<VideoOrder> orderList = videoOrderService.getOrderListByUserId(userId);
        return JsonData.buildSuccess(orderList);
    }
}
