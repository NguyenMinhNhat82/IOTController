package com.controller.iot.servce;

import com.controller.iot.Utils.Utils;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class IOTService {
    String broker = "tcp://mqttserver.tk:1883";
    String clientId = "publisher";
    String topic = "/innovation/airmonitoring/Controller";
    String username = "innovation";
    String password = "Innovation_RgPQAZoA5N";

    public String PublicStatus(String response) {
        try {
            MqttClient client = new MqttClient(broker, clientId);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);

            // Set username and password
            options.setUserName(username);
            options.setPassword(password.toCharArray());

            client.connect(options);

            MqttMessage mqttMessage = new MqttMessage(response.getBytes());
            mqttMessage.setQos(0);
            client.publish(topic, mqttMessage);
            client.disconnect();
            return "Success";
        } catch (MqttException e) {
            return e.getMessage();
        }
    }

    public String publicCurrentState() {
        Random random = new Random();
        DecimalFormat df = new DecimalFormat("#.##");
        String topicMain = "/innovation/airmonitoring/NBIOS_Copy";
        String String1 = df.format(random.nextFloat(3) + 20); // temp_0001
        String String2 = df.format(random.nextFloat(5) + 60); // humi_0001
        String String3 = df.format(random.nextFloat(4) + 20); // temp_0002
        String String4 = df.format(random.nextFloat(3) + 60); // humi_0002
        String String5 = df.format(random.nextFloat(7) + 4); // ph_0002
        String String6 = df.format(random.nextFloat(3) + 2); // EC_0002
        String String7 = df.format(random.nextFloat(3) + 4); // Nito_0002
        String String8 = df.format(random.nextFloat(30) + 20); // Photpho_0002
        String String9 = df.format(random.nextFloat(15) + 5); // Kali_0002
        String String10 = Utils.activeSensor.contains("Relay_0001") ? "true" : "false";
        String String11 = Utils.activeSensor.contains("Relay_0002") ? "true" : "false";
        String String12 = Utils.activeSensor.contains("Relay_0003") ? "true" : "false";
        String String13 = Utils.activeSensor.contains("Relay_0004") ? "true" : "false";
        Map<String, String> map = new HashMap<>();
        map.put("temp_0001", String1);
        map.put("humi_0001", String2);
        map.put("temp_0002", String3);
        map.put("humi_0002", String4);
        map.put("ph_0002", String5);
        map.put("EC_0002", String6);
        map.put("Nito_0002", String7);
        map.put("Photpho_0002", String8);
        map.put("Kali_0002", String9);
        map.put("Relay_0001", String10);
        map.put("Relay_0002", String11);
        map.put("Relay_0003", String12);
        map.put("Relay_0004", String13);
        String res = "{\"station_id\":\"air_0002\",\"station_name\":\"NBIOT 0002\",\"sensors\":[";
        if (Utils.activeStation.contains("air_0002")) {
            int index = 0;
            for (String s : Utils.defaultSensor) {
                if (index != 0) {
                    res += ",";
                }
                if (Utils.activeSensor.contains(s)) {
                    res += "{\"id\":\"" + s + "\",\"value\":" + map.get(s) + ",\"isActive\":\"1\"}";
                } else
                    res += "{\"id\":\"" + s + "\",\"value\":" + 0 + ",\"isActive\":\"0\"}";

                index++;
            }
            res += "]}";
        } else {
            int index = 0;
            for (String s : Utils.defaultSensor) {
                if (index != 0) {
                    res += ",";
                }
                res += "{\"id\":\"" + s + "\",\"value\":" + 0 + ",\"isActive\":\"0\"}";
                index++;
            }
            res += "]}";

        }
        try {
            MqttClient client = new MqttClient(broker, clientId);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);

            // Set username and password
            options.setUserName(username);
            options.setPassword(password.toCharArray());

            client.connect(options);

            MqttMessage mqttMessage = new MqttMessage(res.getBytes());
            mqttMessage.setQos(0);
            client.publish(topicMain, mqttMessage);
            client.disconnect();
            return "Success";
        } catch (MqttException e) {
            return e.getMessage();
        }
    }
}
