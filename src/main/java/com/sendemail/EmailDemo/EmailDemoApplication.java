package com.sendemail.EmailDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailDemoApplication {
    private String name;
    @Autowired
    private EmailSenderService senderService;
    public static void main(String[] args) {
        SpringApplication.run(EmailDemoApplication.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void sendMail(){
        Customer customerInfo = new Customer();
        name = customerInfo.getName();
        System.out.println(name);
        senderService.sendEmail("anthony.carreon.696@my.csun.edu", "The Subject",
                "this is body of Email " + name);
    }

}