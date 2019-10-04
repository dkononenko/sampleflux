package com.example.sampleflux;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Component
public class Store1 {
    @Autowired
    public Store1(Dispatcher dispatcher) {
        compositeDisposable.add(
                dispatcher.getActions().subscribe(action -> {
                    switch (action.getName()) {
                        case Action.GET_CURRENT_TIME:
                            lastUpdateSubject.onNext(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
                            break;
                        case Action.CLOSE_VIEW1:
                            compositeDisposable.dispose();
                            break;
                        default:
                            break;
                    }
                })
        );
    }

    public Observable<String> getLastUpdate() {
        return lastUpdateSubject;
    }

    private BehaviorSubject<String> lastUpdateSubject = BehaviorSubject.createDefault("expired");
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
}
