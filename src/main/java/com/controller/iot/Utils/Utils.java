package com.controller.iot.Utils;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static java.util.Map.entry;

@Component
public class  Utils {
    static DecimalFormat df = new DecimalFormat("#.##");
    static Random random = new Random();
    public static LocalDateTime lastTimeUpdate = LocalDateTime.now(ZoneId.of("Asia/Saigon"));
    public static List<String> activeStation = new ArrayList<>(Arrays.asList("air_0002"));
    public static List<String> inActiveStation = new ArrayList<>();
    public static List<String> activeSensor = new ArrayList<>(Arrays.asList("EC_0002", "humi_0001", "humi_0002", "Kali_0002", "Nito_0002",
            "ph_0002", "Photpho_0002", "Relay_0001","Relay_0002", "Relay_0003", "Relay_0004", "temp_0001", "temp_0002"));
    public static List<String> inActiveSensor = new ArrayList<>();

    public static List<String> defaultSensor = new ArrayList<>(Arrays.asList("EC_0002", "humi_0001", "humi_0002", "Kali_0002", "Nito_0002",
            "ph_0002", "Photpho_0002", "Relay_0001","Relay_0002", "Relay_0003", "Relay_0004", "temp_0001", "temp_0002"));
    public static Map<String,String> dataRandom1 = Map.ofEntries(
            entry("temp_0001", df.format(random.nextFloat(4) + 20)),
            entry("humi_0001", df.format(random.nextFloat(12) + 5)),// 8-15
            entry("temp_0002", df.format(random.nextFloat(4) + 20)),
            entry("humi_0002", df.format(random.nextFloat(12) + 5)),
            entry("ph_0002", df.format(random.nextFloat(5) + 4)),// 5.5 - 7.5
            entry("EC_0002", df.format(random.nextFloat(1) + 0.1)),
            entry("Nito_0002", df.format(random.nextFloat(4) + 60)),
            entry("Photpho_0002", df.format(random.nextFloat(30) + 20)),
            entry("Kali_0002", df.format(random.nextFloat(15) + 5)),
            entry("Relay_0001", activeSensor.contains("Relay_0001") ? "true" : "false"),
            entry("Relay_0002", activeSensor.contains("Relay_0002") ? "true" : "false"),
            entry("Relay_0003", activeSensor.contains("Relay_0003") ? "true" : "false"),
            entry("Relay_0004", activeSensor.contains("Relay_0004") ? "true" : "false")
    );


    public static Map<String,String> dataRandom2 = Map.ofEntries(
            entry("temp_0001", df.format(random.nextFloat(4) + 23)),
            entry("humi_0001", df.format(random.nextFloat(12) + 5)),// 8-15
            entry("temp_0002", df.format(random.nextFloat(4) + 23)),
            entry("humi_0002", df.format(random.nextFloat(12) + 5)),
            entry("ph_0002", df.format(random.nextFloat(5) + 4)),// 5.5 - 7.5
            entry("EC_0002", df.format(random.nextFloat(1) + 0.1)),
            entry("Nito_0002", df.format(random.nextFloat(4) + 60)),
            entry("Photpho_0002", df.format(random.nextFloat(30) + 20)),
            entry("Kali_0002", df.format(random.nextFloat(15) + 5)),
            entry("Relay_0001", activeSensor.contains("Relay_0001") ? "true" : "false"),
            entry("Relay_0002", activeSensor.contains("Relay_0002") ? "true" : "false"),
            entry("Relay_0003", activeSensor.contains("Relay_0003") ? "true" : "false"),
            entry("Relay_0004", activeSensor.contains("Relay_0004") ? "true" : "false")
    );
    public static Map<String,String> dataRandom3 = Map.ofEntries(
            entry("temp_0001", df.format(random.nextFloat(6) + 26)),
            entry("humi_0001", df.format(random.nextFloat(12) + 5)),// 8-15
            entry("temp_0002", df.format(random.nextFloat(6) + 26)),
            entry("humi_0002", df.format(random.nextFloat(12) + 5)),
            entry("ph_0002", df.format(random.nextFloat(5) + 4)),// 5.5 - 7.5
            entry("EC_0002", df.format(random.nextFloat(1) + 0.1)),
            entry("Nito_0002", df.format(random.nextFloat(4) + 60)),
            entry("Photpho_0002", df.format(random.nextFloat(30) + 20)),
            entry("Kali_0002", df.format(random.nextFloat(15) + 5)),
            entry("Relay_0001", activeSensor.contains("Relay_0001") ? "true" : "false"),
            entry("Relay_0002", activeSensor.contains("Relay_0002") ? "true" : "false"),
            entry("Relay_0003", activeSensor.contains("Relay_0003") ? "true" : "false"),
            entry("Relay_0004", activeSensor.contains("Relay_0004") ? "true" : "false")
    );
    public static Map<String,String> dataRandom4 = Map.ofEntries(
            entry("temp_0001", df.format(random.nextFloat(8) + 29)),
            entry("humi_0001", df.format(random.nextFloat(12) + 5)),// 8-15
            entry("temp_0002", df.format(random.nextFloat(8) + 29)),
            entry("humi_0002", df.format(random.nextFloat(12) + 5)),
            entry("ph_0002", df.format(random.nextFloat(5) + 4)),// 5.5 - 7.5
            entry("EC_0002", df.format(random.nextFloat(1) + 0.1)),
            entry("Nito_0002", df.format(random.nextFloat(4) + 60)),
            entry("Photpho_0002", df.format(random.nextFloat(29) + 20)),
            entry("Kali_0002", df.format(random.nextFloat(14) + 5)),
            entry("Relay_0001", activeSensor.contains("Relay_0001") ? "true" : "false"),
            entry("Relay_0002", activeSensor.contains("Relay_0002") ? "true" : "false"),
            entry("Relay_0003", activeSensor.contains("Relay_0003") ? "true" : "false"),
            entry("Relay_0004", activeSensor.contains("Relay_0004") ? "true" : "false")
    );
    public static Map<String,String> dataRandom5 = Map.ofEntries(
            entry("temp_0001", df.format(random.nextFloat(4) + 25)),
            entry("humi_0001", df.format(random.nextFloat(13) + 5)),// 8-15
            entry("temp_0002", df.format(random.nextFloat(4) + 25)),
            entry("humi_0002", df.format(random.nextFloat(13) + 5)),
            entry("ph_0002", df.format(random.nextFloat(6) + 4)),// 5.5 - 7.5
            entry("EC_0002", df.format(random.nextFloat(2) + 0.1)),
            entry("Nito_0002", df.format(random.nextFloat(5) + 60)),
            entry("Photpho_0002", df.format(random.nextFloat(30) + 20)),
            entry("Kali_0002", df.format(random.nextFloat(15) + 5)),
            entry("Relay_0001", activeSensor.contains("Relay_0001") ? "true" : "false"),
            entry("Relay_0002", activeSensor.contains("Relay_0002") ? "true" : "false"),
            entry("Relay_0003", activeSensor.contains("Relay_0003") ? "true" : "false"),
            entry("Relay_0004", activeSensor.contains("Relay_0004") ? "true" : "false")
    );
    public static Map<String, String> lastDataUpdate;
    public static void updateLastDataUpdate(Map<String,String> data) {
        lastDataUpdate = data;
    }
    public static void defineLastDataUpdate() {
        int hour = lastTimeUpdate.getHour();

        if (hour >= 0 && hour <= 3) {
            lastDataUpdate =  dataRandom1;
        } else if (hour >= 4 && hour <= 7) {
            lastDataUpdate =  dataRandom2;
        } else if (hour >= 8 && hour <= 11) {
            lastDataUpdate =  dataRandom3;
        } else if (hour >= 12 && hour <= 15) {
            lastDataUpdate =  dataRandom4;
        } else if (hour >= 16 && hour <= 19) {
            lastDataUpdate =  dataRandom5;
        } else if (hour >= 20 && hour <= 23) {
            lastDataUpdate =  dataRandom6;
        }
    }

    public static Map<String,String> dataRandom6 = Map.ofEntries(
            entry("temp_0001", df.format(random.nextFloat(4) + 21)),
            entry("humi_0001", df.format(random.nextFloat(12) + 5)),// 8-15
            entry("temp_0002", df.format(random.nextFloat(4) + 21)),
            entry("humi_0002", df.format(random.nextFloat(12) + 5)),
            entry("ph_0002", df.format(random.nextFloat(5) + 4)),// 5.5 - 7.5
            entry("EC_0002", df.format(random.nextFloat(1) + 0.1)),
            entry("Nito_0002", df.format(random.nextFloat(4) + 60)),
            entry("Photpho_0002", df.format(random.nextFloat(30) + 20)),
            entry("Kali_0002", df.format(random.nextFloat(15) + 5)),
            entry("Relay_0001", activeSensor.contains("Relay_0001") ? "true" : "false"),
            entry("Relay_0002", activeSensor.contains("Relay_0002") ? "true" : "false"),
            entry("Relay_0003", activeSensor.contains("Relay_0003") ? "true" : "false"),
            entry("Relay_0004", activeSensor.contains("Relay_0004") ? "true" : "false")
    );

    @PostConstruct
    public void initialize() {
       defineLastDataUpdate();
    }
}
