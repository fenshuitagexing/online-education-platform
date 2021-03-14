package net.xdclass.online_xdclass.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import net.xdclass.online_xdclass.utils.JsonData;
import net.xdclass.online_xdclass.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class SignInInterceptor implements HandlerInterceptor {

    // Invoked before entering a controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            // The token is normally saved in the header, otherwise, probably in the parameter
            String accessToken = request.getHeader("token");
            if (null == accessToken) {
                accessToken = request.getParameter("token");
            }

            if (StringUtils.isNotBlank(accessToken)) {
                Claims claims = JwtUtils.verifyToken(accessToken);
                if (null == claims) {
                    sendJsonMessages(response, JsonData.buildError("Failed to sign in, please retry"));
                    return false;
                }

                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");

                // These two attributes can be retrieved in controllers
                request.setAttribute("user_id", id);
                request.setAttribute("name", name);

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        sendJsonMessages(response, JsonData.buildError("Failed to sign in, please retry"));
        return false;
    }

    // Respond to front-end with JSON data
    public static void sendJsonMessages(HttpServletResponse response, Object obj) {

        // Generate a JSON from a Java object and return the generated JSON as a String
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // For producing a JSON response, the content type should be application/json
            response.setContentType("application/json; charset=utf-8");
            PrintWriter printWriter = response.getWriter();

            // print any thing on the browser's page as a response
            printWriter.print(objectMapper.writeValueAsString(obj));
            printWriter.close();

            // Forces any content in the buffer to be written to the client/browser,
            // automatically commits the response, meaning the status code and headers will be written,
            // functionally equivalent to printWriter.flush()
            response.flushBuffer();

            // Calling flush() on the PrintWriter commits the response
            // printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
