package me.kay.controller;

import me.kay.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public String handleException(Exception e, HttpServletRequest request){
        request.setAttribute("javax.servlet.error.status_code",500);

        Map<String, Object> map = new HashMap<>();
        map.put("code", "888");
        map.put("message", "用户走丢了。。。");
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
