package com.controller.iot;

import com.controller.iot.servce.IOTService;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.security.GeneralSecurityException;

@SpringBootApplication
@EnableScheduling
public class IOTControllerApplication {
    @Autowired
    IOTService iotService;
    public static void main(String[] args) throws IOException, GeneralSecurityException {
        SpringApplication.run(IOTControllerApplication.class, args);
    }


    @Scheduled(fixedRate = 1000*60*3)
    public synchronized void autoGenerateNumber() throws GeneralSecurityException, IOException {
        iotService.publicCurrentState();
    }
}
