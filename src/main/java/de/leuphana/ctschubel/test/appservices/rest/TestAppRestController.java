package de.leuphana.ctschubel.test.appservices.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestAppRestController {

    @GetMapping("/get")
    public String HelloWorld(){
        return "helloWorld";
    }
}
