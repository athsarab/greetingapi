package com.lab5.greetingapi;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class GreetingController {
    private static final String template = "Hello, %s!";

    private final AtomicLong count = new AtomicLong();
//endpoint for responding
    @GetMapping("/greeting")
    public Greeting greeting() {
        return new Greeting(count.incrementAndGet(), String.format(template, "World"));
    }

    @GetMapping("/greeting/name")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Athsara") String name) {
        return new Greeting(count.incrementAndGet(), String.format(template, "Name"));
    }

        // New endpoint to return today's date along with a greeting
    @GetMapping("/greeting/today")
    public Greeting greetingWithDate() {
        String message = String.format("Hello! Today's date is %s", LocalDate.now());
        return new Greeting(count.incrementAndGet(), message);
    }


}
