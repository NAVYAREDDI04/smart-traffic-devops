
package com.traffic.controller;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.io.OutputStream;
import java.net.Socket;
@RestController
@RequestMapping("/traffic")
public class TrafficController {

    @Autowired
    private MeterRegistry registry;  // ✅ Inject Micrometer

    @GetMapping("/predict")
    public String predict(@RequestParam int hour, @RequestParam int vehicles) {

        // ✅ Increment a custom counter metric
        registry.counter("traffic.vehicle.count").increment();

        if (vehicles > 1000 && (hour >= 17 && hour <= 20)) {
            return "Prediction: Heavy Congestion";
        } else if (vehicles > 500) {
            return "Prediction: Moderate Congestion";
        } else {
            return "Prediction: Light Traffic";
        }
    }
     
   private void sendMetric(String key, int value){
    try (Socket socket = new Socket("localhost", 2003);
          OutputStream out = socket.getOutputStream()) {
             long timestamp = System.currentTimeMillis() / 1000;
             String metric = key + " " + value + " " + timestamp + "\n";
             out.write(metric.getBytes());
             out.flush();
         }catch (Exception e) {
             e.printStackTrace();
        }
}
}
