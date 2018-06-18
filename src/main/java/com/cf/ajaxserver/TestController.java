package com.cf.ajaxserver;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/get1")
    public ResultBean get1(){
        System.out.println("TestController.get1");
        return new ResultBean("get1 ok");
    }

    @PostMapping("/postJson")
    public ResultBean postJson(@RequestBody User user){
        System.out.println("TestController.postJson");
        return new ResultBean("postJson " + user.getName());
    }

    @GetMapping("/getCookie")
    public ResultBean getCookie(@CookieValue("cookie1") String cookie1){
        System.out.println("TestController.getCookie");
        return new ResultBean("getCookie "+cookie1);
    }

    @GetMapping("/getHeader")
    public ResultBean getHeader(@RequestHeader("x-header1") String header1,
                                @RequestHeader("x-header2") String header2){
        return new ResultBean("getHeader "+header1+" "+header2);
    }

}
