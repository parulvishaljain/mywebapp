package com.springboot.mywebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/home")
    public ResponseEntity<List<Customers>> home() {

        String query = "select * from customers";
        System.out.println("hi");
        List<Customers> customers =  jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Customers.class));
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
