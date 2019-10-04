package com.example.sampleflux;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeLeaveEvent;
import com.vaadin.flow.router.BeforeLeaveObserver;
import com.vaadin.flow.router.Route;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "view2", layout = MainLayout.class)
public class View2 extends VerticalLayout implements BeforeLeaveObserver {
    @Autowired
    public View2(AppActions appActions, Store2 store) {
        this.appActions = appActions;

        setWidth("100%");
        setHeight("100%");

        final UI ui = UI.getCurrent();
        Label label = new Label("werwerwr");
        compositeDisposable.add(
                store.values()
                        .observeOn(Schedulers.from(runnable -> ui.access(runnable::run)))
                        .subscribe(label::setText)
        );

        add(label);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }

    @Override
    public void beforeLeave(BeforeLeaveEvent beforeLeaveEvent) {
        appActions.closeView2();
    }

    private AppActions appActions;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
}
