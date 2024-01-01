package com.springboot.mywebapp.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailRequest {

    private  String name;
    private String to;
    private String from;
    private String subject;
}
