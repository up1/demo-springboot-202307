package com.example.day1.noti;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @EventListener
    public void send(String message){
        // TODO
        System.out.println("Call noti service :: " + message);
        System.out.println("Done");

    }

}
