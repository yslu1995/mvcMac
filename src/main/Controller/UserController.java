package main.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 常用类
 */
//@RestController
@Controller
public class UserController {

    @RequestMapping("/hello")
    public String doHello() {

        System.out.println("执行业务++++++++++++++++++++++");
        return "index.jsp";
    }
}
