package com.controller.iot.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  Utils {
    public static List<String> activeStation = new ArrayList<>(Arrays.asList("air_0002"));
    public static List<String> inActiveStation = new ArrayList<>();
    public static List<String> activeSensor = new ArrayList<>(Arrays.asList("EC_0002", "humi_0001", "humi_0002", "Kali_0002", "Nito_0002",
            "ph_0002", "Photpho_0002", "Relay_0001","Relay_0002", "Relay_0003", "Relay_0004", "temp_0001", "temp_0002"));
    public static List<String> inActiveSensor = new ArrayList<>();

    public static List<String> defaultSensor = new ArrayList<>(Arrays.asList("EC_0002", "humi_0001", "humi_0002", "Kali_0002", "Nito_0002",
            "ph_0002", "Photpho_0002", "Relay_0001","Relay_0002", "Relay_0003", "Relay_0004", "temp_0001", "temp_0002"));
}
