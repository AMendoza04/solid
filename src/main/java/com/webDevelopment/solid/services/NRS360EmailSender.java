package com.webDevelopment.solid.services;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NRS360EmailSender implements Sender{

    @Override
    public Boolean sender(String message) {
        //TODO: Lógica para NRS360
        return true;
    }

//    @Override
//    public Boolean senderSlack(String notification, List<String> emails) {
//        return false;
//    }
}
