package com.litbo.hospitalzj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BaseController {
    @RequestMapping("/")
    public String index(){
        return "forward:login.html";
    }
}
