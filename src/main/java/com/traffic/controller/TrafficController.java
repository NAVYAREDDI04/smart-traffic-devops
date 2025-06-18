package com.traffic.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/traffic")
public class TrafficController {

    @GetMapping("/predict")
    public String predict(@RequestParam int hour, @RequestParam int vehicles) {
        if (vehicles > 1000 && (hour >= 17 && hour <= 20)) {
            return "Prediction: Heavy Congestion";
        } else if (vehicles > 500) {
            return "Prediction: Moderate Congestion";
        } else {
            return "Prediction: Low Congestion";
        }
    }
}

