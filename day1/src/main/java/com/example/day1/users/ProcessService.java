package com.example.day1.users;

import com.example.day1.noti.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {

    @Autowired
    private UserCommandService service;

    @Autowired
    private NotificationService notificationService;

    public void doSth() {
        service.process();
        notificationService.send("data");
    }

}
