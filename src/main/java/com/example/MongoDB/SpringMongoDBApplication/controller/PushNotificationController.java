package com.example.MongoDB.SpringMongoDBApplication.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MongoDB.SpringMongoDBApplication.model.PushNotificationRequest;
import com.example.MongoDB.SpringMongoDBApplication.model.PushNotificationResponse;
import com.example.MongoDB.SpringMongoDBApplication.serviceimpl.PushNotificationService;


@RestController
public class PushNotificationController {
	private static final Logger Logger=LoggerFactory.getLogger(PushNotificationController .class);
	
	@Autowired
    private PushNotificationService pushNotificationService;
    
    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }
    
    @PostMapping("/notification/token")
    public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request) {
        pushNotificationService.sendPushNotificationToToken(request);
       Logger.info("princr");
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), 
        		HttpStatus.OK);
    }
    
}
