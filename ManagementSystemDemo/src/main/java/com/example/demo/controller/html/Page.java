package com.example.demo.controller.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("html")
public class Page {
    @RequestMapping("/index")
    public  String welcome(HttpServletResponse response) {
        response.addHeader("x-frame-options", "SAMEORIGIN");
        return "html/index";
    }
}
