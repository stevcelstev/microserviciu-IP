package com.example.timeConvertor.timeconvertor.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class TimeConvertorResource {

    @RequestMapping("/seconds/{termen1}")
    public String Seconds(@PathVariable("termen1") int seconds){
        if (seconds >= 0 && seconds <= 86400) {
            int s = seconds % 60;
            int h = seconds / 60;
            int m = h % 60;
            h = h / 60;
            String resulth, resultm, results;
            if (h < 10)
                resulth = "0" + h;
            else
                resulth = "" + h;
            if (m < 10)
                resultm = "0" + m;
            else
                resultm = "" + m;
            if (s < 10)
                results = "0" + s;
            else
                results = "" + s;
            return resulth + ":" + resultm + ":" + results;
        }
        return "" + -1;
    }

    @RequestMapping("/hhmmss/{termen1}")
    public long hhmmss(@PathVariable("termen1")  String time) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date reference = dateFormat.parse("00:00:00");
        Date date = dateFormat.parse(time);
        long seconds = (date.getTime() - reference.getTime()) / 1000L;
        if (seconds >= 0 && seconds <= 86400)
            return seconds;
        return -1;
    }
}
