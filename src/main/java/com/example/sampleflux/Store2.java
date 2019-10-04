package com.example.sampleflux;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Component
public class Store2 {
    @Autowired
    public Store2(Dispatcher dispatcher, TemperatureSensor temperatureSensor) {
        compositeDisposable.add(
                dispatcher.getActions().subscribe(action -> {
                    switch (action.getName()) {
                        case Action.CLOSE_VIEW2:
                            compositeDisposable.dispose();
                            break;
                        default:
                            break;
                    }
                })
        );

        compositeDisposable.add(
                temperatureSensor.temperature().subscribe(temperature::onNext)
        );
    }

    public Observable<String> values() {
        return temperature.map(d -> String.format("%.2f", d));
    }

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private PublishSubject<Double> temperature = PublishSubject.create();
}
