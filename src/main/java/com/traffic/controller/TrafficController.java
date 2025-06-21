package com.traffic.controller;

import org.springframework.web.bind.annotation.*;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/traffic")
public class TrafficController {

    @GetMapping("/predict")
    public String predict(@RequestParam int hour, @RequestParam int vehicles) {
        if (vehicles > 1000 || (hour >= 17 && hour <= 20))
            return "Prediction: Heavy Congestion";
        return "Prediction: Moderate/Low Congestion";
    }
}
