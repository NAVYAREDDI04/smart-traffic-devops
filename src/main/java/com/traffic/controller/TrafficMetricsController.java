package com.traffic.controller;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrafficMetricsController {

    private final MeterRegistry meterRegistry;

    public TrafficMetricsController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/testmetric")
    public String pushTestMetric() {
        // This increments a counter metric
        meterRegistry.counter("traffic.prediction.success").increment();
        return "Test metric sent!";
    }
}
