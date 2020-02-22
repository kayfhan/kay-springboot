package me.kay.controller;

import me.kay.entities.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @RequestMapping(value = {"/", "/index"})
//    private String index() {
//        return "login";
//    }

    @PostMapping(value = "/user/login")
    private String login(HttpSession session, Login login, Map<String, String> map){
        System.out.println(login.toString());
        if (login.getUsername().equals("kay") && login.getPassword().equals("a")){
            session.setAttribute("loginUser", login.getUsername());
            return "redirect:/dashboard.html";
        }
        map.put("msg", "username or password error.");
        return "login";
    }
}
