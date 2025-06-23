import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/traffic")
public class TrafficController {

    private final MeterRegistry meterRegistry;

    public TrafficController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/predict")
    public String predict(@RequestParam int hour, @RequestParam int vehicles) {
        meterRegistry.counter("traffic.vehicle.count").increment();

        if (vehicles > 1000 && (hour >= 17 && hour <= 20)) {
            return "Prediction: Heavy Congestion";
        } else if (vehicles > 500) {
            return "Prediction: Moderate Congestion";
        } else {
            return "Prediction: Light Traffic";
        }
    }
}
