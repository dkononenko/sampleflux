package com.example.sampleflux;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import org.springframework.stereotype.Component;

@Component
public class Dispatcher {
    public Observable<Action> getActions() {
        return actions;
    }

    void post(Action action) {
        actions.onNext(action);
    }

    private PublishSubject<Action> actions = PublishSubject.create();
}
