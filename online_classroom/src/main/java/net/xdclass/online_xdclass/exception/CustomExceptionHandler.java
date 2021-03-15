package net.xdclass.online_xdclass.exception;

import net.xdclass.online_xdclass.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handle(Exception e) {

        logger.error("[ Exception ] {}", e.getMessage());

        if (e instanceof CustomException) {
            CustomException customException = (CustomException) e;
            return JsonData.buildError(customException.getCode(), customException.getMsg());
        } else {
            return JsonData.buildError("Unknown error");
        }
    }
}
