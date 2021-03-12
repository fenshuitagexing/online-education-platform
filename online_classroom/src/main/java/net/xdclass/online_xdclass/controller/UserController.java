package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.model.request.SignInRequest;
import net.xdclass.online_xdclass.service.UserService;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * The @RequestBody annotation maps the HttpRequest body to a domain object,
     * enabling automatic deserialization of the inbound HttpRequest body onto a Java object
     *
     * The type annotated with @RequestBody must correspond to the JSON sent from client-side controller
     *
     * The front-end must submit the data through POST
     *
     * The @RequestBody can be used only once in a method, while @RequestParam() can be used multiple tiimes
     */
    @PostMapping("sign_up")
    public JsonData signUp(@RequestBody Map<String, String> userInfo) {

        int rows = userService.addUser(userInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("Failed to sign up, please retry");
    }

    @PostMapping("sign_in")
    // 登录时会传入Json对象，需要映射到这个类中
    public JsonData signIn(@RequestBody SignInRequest signInRequest) {

        String token = userService.getTokenByPhoneAndPwd(signInRequest.getPhone(), signInRequest.getPwd());
        return token == null ? JsonData.buildError("Invalid username or password") : JsonData.buildSuccess(token);
    }
}
