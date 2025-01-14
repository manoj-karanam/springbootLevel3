package io.javabrains.spring_boot_config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

//    @Value("#{${dbValues}}")
//    private Map<String,String> dbValues;

    @GetMapping("/greeting")
    public String greeeting(){
        return dbSettings.getConnection() + dbSettings.getHost() + dbSettings.getPort();

    }
}
