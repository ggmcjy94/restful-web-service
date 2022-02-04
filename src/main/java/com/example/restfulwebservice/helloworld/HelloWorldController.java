package com.example.restfulwebservice.helloworld;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;


    @GetMapping("/hello-world")
    public String hello() {
        return "hello";
    }


    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloBean() {
        return new HelloWorldBean("hello");
    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean HelloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("hello, %s" , name));
    }

    //다국어
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("greeting.message",null, locale);

    }



}
