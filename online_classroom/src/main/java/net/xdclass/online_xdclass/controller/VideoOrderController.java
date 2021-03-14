package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.model.request.VideoOrderRequest;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {

    @RequestMapping("save")
    // The front-end side sends the properties about the video, the data is in JSON format
    public JsonData saveOrder(@RequestBody VideoOrderRequest videoOrderRequest,
                              // Get user properties from HttpServletRequest through decrypting the token
                              HttpServletRequest httpServletRequest) {

        (Integer) httpServletRequest.getAttribute("user_id")


        return JsonData.buildSuccess();
    }
}
