package com.dreamshopbackend.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/demo")
public class demoController {

    @GetMapping
    public ResponseEntity<String>sayHello(){
        return ResponseEntity.ok("Hello From Restricated Api");
    }

}
