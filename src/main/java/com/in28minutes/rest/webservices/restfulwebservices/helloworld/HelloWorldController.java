package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// REST api
@RestController
public class HelloWorldController {


    @GetMapping("/")
    public String home() {
        return "Home Page";
    }

    //   /hello-world  should return "Hello World"
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    // /hello-world/path-variable/{name}
    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    // /hello-world/request-params
    @GetMapping("/hello-world/request-param")
    public HelloWorldBean helloRequestParam(@RequestParam String name) {
        return new HelloWorldBean(String.format("Hello %s!", name));
    }

    // Path parameters
    // /users/{id}/todos/{id}   /users/1/todos/101
    // /hello-world/path-variable/{name}

}
