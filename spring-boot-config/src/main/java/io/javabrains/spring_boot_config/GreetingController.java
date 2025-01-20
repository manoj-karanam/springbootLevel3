package io.javabrains.spring_boot_config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting}")
    private  String greetingMessage;

    @Value("some static message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @Autowired
    private dbSettings dbSettings;

    @Autowired
    private Environment env;

//    @Value("#{${dbValues}}")
//    private Map<String,String> dbValues;


    @GetMapping("/greeting")
    public String greeeting(){
        return greetingMessage;

    }

    @GetMapping("/envdetails")
    public String envDetails(){
        return env.toString();
    }
}
