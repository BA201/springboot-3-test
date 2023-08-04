package spring.boot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


    @ResponseBody
    @GetMapping("/hello")
    public String index()
    {
      return "hello word";
    }

}
