package com.controller.iot;

import com.controller.iot.servce.IOTService;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

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


    @Scheduled(fixedRate = 1000*60*8)
    public synchronized void autoGenerateNumber() throws GeneralSecurityException, IOException {
        System.out.println("Pub data");
        iotService.publicCurrentState();
    }

    @Scheduled(fixedRate = 1000*60*2)
    public synchronized void keepServerAlive() throws GeneralSecurityException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("reset");
        String url =  "https://iotcontroller-1.onrender.com/test";
        //http://localhost:9000
//        https://serveriot-ob37.onrender.com/

        //https://serveriot-1.onrender.com/test
        ResponseEntity<String> response
                = restTemplate.getForEntity(url , String.class);
    }
}
