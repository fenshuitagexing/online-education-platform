package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.model.entity.User;
import net.xdclass.online_xdclass.model.request.SignInRequest;
import net.xdclass.online_xdclass.service.UserService;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * The @RequestBody annotation maps the HttpRequest body to a domain object,
     * enabling automatic deserialization of the inbound HttpRequest body onto a Java object,
     * in other words, to convert the body of the HTTP request with Java class object
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
    public JsonData signIn(@RequestBody SignInRequest signInRequest) {

        String token = userService.getTokenByPhoneAndPwd(signInRequest.getPhone(), signInRequest.getPwd());
        return token == null ? JsonData.buildError("Invalid username or password") : JsonData.buildSuccess(token);
    }

    @GetMapping("get_by_token")
    public JsonData getUserInfoByToken(HttpServletRequest request) {

        // The attribute was set in the SignInInterceptor, preHandle method
        Integer userId = (Integer) request.getAttribute("user_id");
        if (null == userId){
            return JsonData.buildError("Failed to get user info");
        }

        User user = userService.getUserInfoById(userId);
        return JsonData.buildSuccess(user);
    }
}
