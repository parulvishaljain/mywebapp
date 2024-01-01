package com.springboot.mywebapp.controller;

import com.springboot.mywebapp.modal.MailRequest;
import com.springboot.mywebapp.modal.MailResponse;
import com.springboot.mywebapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping("/sendemail")
    public MailResponse sendEmail(@RequestBody MailRequest request) {
        Map<String,Object> model = new HashMap<>();
        model.put("Name", "John");
        model.put("location", "Bengaluru, India");
      return service.sendEmail(request,model);
    }
}
