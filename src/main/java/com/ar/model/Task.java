package com.ar.model;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

//@Component
public class Task {

    private String name;
    private Duration duration;

    public static Task createTask(String name, long duration) {
        return new Task(name, Duration.of(duration, ChronoUnit.SECONDS));
    }

    public Task(String name, Duration duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public Duration getDuration() {
        return duration;
    }

    public long getSeconds() {
        return duration.toSeconds();
    }
}
