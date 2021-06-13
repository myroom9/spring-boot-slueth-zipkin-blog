package com.example.sszb;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.contrib.json.classic.JsonLayout;
import java.net.Inet4Address;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class LogFormatterConverter extends JsonLayout {

    @Override
    protected void addCustomDataToJsonMap(Map<String, Object> map, ILoggingEvent event) {
        try {
            map.clear();
            Map data = new HashMap();
            map.put("traceId", event.getMDCPropertyMap().get("traceId"));
            map.put("spanId", event.getMDCPropertyMap().get("spanId"));
            map.put("log_time", convertToHeaderDateFormat(event.getTimeStamp()));
            map.put("hostname", Inet4Address.getLocalHost().getHostName());
            map.put("request_id", (event.getMDCPropertyMap().get("requestId") == null) ? "system" : event.getMDCPropertyMap().get("requestId"));
            map.put("log_type", event.getLevel().toString());

            data.remove("index_name");
            data.put("log_thread", event.getThreadName());
            data.put("log_logger", event.getLoggerName());
            data.put("message", event.getFormattedMessage());
            map.put("data", data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        super.addCustomDataToJsonMap(map, event);

    }

    private String convertToHeaderDateFormat(Long timeMillis) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return simpleDateFormat.format(timeMillis);
    }
}
