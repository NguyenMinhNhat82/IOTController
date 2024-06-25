package com.controller.iot.controller;


import com.controller.iot.Utils.Utils;
import com.controller.iot.servce.IOTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IOTController {
    @Autowired
    IOTService iotService;
    @GetMapping("/api/turn-off/{station}")
    public String  turnOffStation(@PathVariable("station") String station) {
        if(Utils.activeStation.contains(station)){
            Utils.activeStation.remove(station);
            if(!Utils.inActiveStation.contains(station)) {
                Utils.inActiveStation.add(station);
            }
        }
        List<String> copyOfActiveSensor = new ArrayList<>(Utils.activeSensor);
        for (String s : copyOfActiveSensor) {
            System.out.println(s);
            Utils.inActiveSensor.add(s);
            Utils.activeSensor.remove(s); // Removes the current element from the original list
        }


        String json = "{\"station_id\":\"" +  station +",\"type\":\"station\",\"sensors\":[{\"id\":\"temp_0001\",\"status\":0},{\"id\":\"humi_0001\",\"status\":0},{\"id\":\"temp_0002\",\"status\":0},{\"id\":\"humi_0002\",\"status\":0},{\"id\":\"ph_0002\",\"status\":0},{\"id\":\"EC_0002\",\"status\":0},{\"id\":\"Nito_0002\",\"status\":0},{\"id\":\"Photpho_0002\",\"status\":0},{\"id\":\"Kali_0002\",\"status\":0},{\"id\":\"Relay_0001\",\"status\":0},{\"id\":\"Relay_0002\",\"status\":0},{\"id\":\"Relay_0003\",\"status\":0},{\"id\":\"Relay_0004\",\"status\":0}]}";
        return  iotService.PublicStatus(json);
    }

    @GetMapping("/api/turn-on-only/{station}")
    public String  turnONStationOnly(@PathVariable("station") String station) {
        if(Utils.inActiveStation.contains(station)){
            Utils.inActiveStation.remove(station);

            if(!Utils.activeStation.contains(station)) {
                Utils.activeStation.add(station);
            }
        }
        iotService.publicCurrentState();
        String json = "{\"station_id\":\"" +  station +",\"type\":\"station\",\"sensors\":[{\"id\":\"temp_0001\",\"status\":1},{\"id\":\"humi_0001\",\"status\":1},{\"id\":\"temp_0002\",\"status\":1},{\"id\":\"humi_0002\",\"status\":1},{\"id\":\"ph_0002\",\"status\":1},{\"id\":\"EC_0002\",\"status\":1},{\"id\":\"Nito_0002\",\"status\":1},{\"id\":\"Photpho_0002\",\"status\":1},{\"id\":\"Kali_0002\",\"status\":1},{\"id\":\"Relay_0001\",\"status\":1},{\"id\":\"Relay_0002\",\"status\":1},{\"id\":\"Relay_0003\",\"status\":1},{\"id\":\"Relay_0004\",\"status\":1}]}";
        return  iotService.PublicStatus(json);

    }

    @GetMapping("/api/turn-on/{station}")
    public String  turnONStation(@PathVariable("station") String station) {
        if(Utils.inActiveStation.contains(station)){
            Utils.inActiveStation.remove(station);

            if(!Utils.activeStation.contains(station)) {
                Utils.activeStation.add(station);
            }
        }

        List<String> copyOfInActiveSensor = new ArrayList<>(Utils.inActiveSensor);
        for (String s : copyOfInActiveSensor) {
            Utils.activeSensor.add(s);
            Utils.inActiveSensor.remove(s); // Removes the current element from the original list
        }
        iotService.publicCurrentState();
        String json = "{\"station_id\":\"" +  station +",\"type\":\"station\",\"sensors\":[{\"id\":\"temp_0001\",\"status\":1},{\"id\":\"humi_0001\",\"status\":1},{\"id\":\"temp_0002\",\"status\":1},{\"id\":\"humi_0002\",\"status\":1},{\"id\":\"ph_0002\",\"status\":1},{\"id\":\"EC_0002\",\"status\":1},{\"id\":\"Nito_0002\",\"status\":1},{\"id\":\"Photpho_0002\",\"status\":1},{\"id\":\"Kali_0002\",\"status\":1},{\"id\":\"Relay_0001\",\"status\":1},{\"id\":\"Relay_0002\",\"status\":1},{\"id\":\"Relay_0003\",\"status\":1},{\"id\":\"Relay_0004\",\"status\":1}]}";
        return  iotService.PublicStatus(json);
    }

    @GetMapping("/api/turn-on/{station}/{idSensor}")
    public String  turnON(@PathVariable("station") String station, @PathVariable("idSensor") String idSensor) {
        if(Utils.inActiveSensor.contains(idSensor)){
            Utils.inActiveSensor.remove(idSensor);
            if(!Utils.activeSensor.contains(idSensor)) {
                Utils.activeSensor.add(idSensor);
            }
        }
        iotService.publicCurrentState();
        String json = "{\"station_id\":\"" +  station +",\"type\":\"sensor-turn-on\",\"sensor\":\""+idSensor +"\"";
        return  iotService.PublicStatus(json);
    }
    @GetMapping("/api/turn-off/{station}/{idSensor}")
    public String  turnOFFStation(@PathVariable("station") String station, @PathVariable("idSensor") String idSensor) {
        if(Utils.activeSensor.contains(idSensor)){
            Utils.activeSensor.remove(idSensor);
            if(!Utils.inActiveSensor.contains(idSensor)) {
                Utils.inActiveSensor.add(idSensor);
            }
        }
        String json = "{\"station_id\":\"" +  station +",\"type\":\"sensor-turn-off\",\"sensor\":\""+idSensor +"\"";
        System.out.println(Utils.inActiveSensor);
        return  iotService.PublicStatus(json);
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}