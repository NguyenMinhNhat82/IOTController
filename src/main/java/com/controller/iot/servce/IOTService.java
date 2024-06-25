package com.controller.iot.servce;

import com.controller.iot.Utils.Utils;
import jakarta.annotation.PostConstruct;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

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
        ZoneId zid = ZoneId.of("Asia/Saigon");
        LocalDateTime now = LocalDateTime.now(zid);
        String topicMain = "/innovation/airmonitoring/NBIOS_Copy";
        List<Long> tg = new ArrayList<>(Arrays.asList(900000L,2100000L,3000000L,3600000L, 9000000L));
        Integer randomMangTG = random.nextInt(4);
        Duration duration = Duration.between(Utils.lastTimeUpdate,now) ;
        long millis = duration.toMillis();
        String res = "";
        Map<String, String> dataToPub= null;
        if(millis >= tg.get(randomMangTG)){

            Integer hour = now.getHour();
            if(hour >= 0 && hour <= 3)
                dataToPub = Utils.dataRandom1;
            else if(hour >=4 && hour <= 7 )
                dataToPub = Utils.dataRandom2;
            else if(hour >=8 && hour <= 11 )
                dataToPub = Utils.dataRandom3;
            else if(hour >=12 && hour <= 15 )
                dataToPub = Utils.dataRandom4;
            else if(hour >=16 && hour <= 19 )
                dataToPub = Utils.dataRandom5;
            else if(hour >=20 && hour <= 23 )
                dataToPub = Utils.dataRandom6;
            Utils.lastTimeUpdate = now;
            Utils.updateLastDataUpdate(dataToPub);
            if (Utils.activeStation.contains("air_0002")) {
                res = "{\"station_id\":\"air_0002\",\"station_name\":\"NBIOT 0002\",\"active\":\"1\",\"sensors\":[";
                int index = 0;
                for (String s : Utils.defaultSensor) {
                    if (index != 0) {
                        res += ",";
                    }
                    if (Utils.activeSensor.contains(s)) {
                        res += "{\"id\":\"" + s + "\",\"value\":" + dataToPub.get(s) + ",\"isActive\":\"1\"}";
                    } else
                        res += "{\"id\":\"" + s + "\",\"value\":" + 0 + ",\"isActive\":\"0\"}";

                    index++;
                }
                res += "]}";
            } else {
                res = "{\"station_id\":\"air_0002\",\"station_name\":\"NBIOT 0002\",\"active\":\"0\",\"sensors\":[";
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
        }
        else {
            dataToPub = Utils.lastDataUpdate;
            if (Utils.activeStation.contains("air_0002")) {
                res = "{\"station_id\":\"air_0002\",\"station_name\":\"NBIOT 0002\",\"active\":\"1\",\"sensors\":[";
                int index = 0;
                for (String s : Utils.defaultSensor) {
                    if (index != 0) {
                        res += ",";
                    }
                    if (Utils.activeSensor.contains(s)) {
                        res += "{\"id\":\"" + s + "\",\"value\":" + dataToPub.get(s) + ",\"isActive\":\"1\"}";
                    } else
                        res += "{\"id\":\"" + s + "\",\"value\":" + 0 + ",\"isActive\":\"0\"}";

                    index++;
                }
                res += "]}";
            } else {
                res = "{\"station_id\":\"air_0002\",\"station_name\":\"NBIOT 0002\",\"active\":\"0\",\"sensors\":[";
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
