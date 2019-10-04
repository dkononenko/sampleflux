package com.example.sampleflux;

import io.reactivex.Observable;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class TemperatureSensor {
    public TemperatureSensor() {
        Random random = new Random();
        values = Observable.interval(500, TimeUnit.MILLISECONDS)
                .map(i -> random.nextGaussian())
                .publish()
                .refCount();
    }

    public Observable<Double> temperature() {
        return values;
    }

    private Observable<Double> values;
}
