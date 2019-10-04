package com.example.sampleflux;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.BeforeLeaveEvent;
import com.vaadin.flow.router.BeforeLeaveObserver;
import com.vaadin.flow.router.Route;
import io.reactivex.disposables.CompositeDisposable;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "", layout = MainLayout.class)
public class View1 extends FlexLayout implements BeforeLeaveObserver {
    @Autowired
    public View1(AppActions appActions, Store1 store) {
        this.appActions = appActions;

        setWidth("100%");
        setHeight("100%");

        getStyle().set("flex-direction", "column");

        Button btn = new Button("Click me", e -> appActions.getCurrentTime());

        Label label = new Label();
        compositeDisposable.add(
                store.getLastUpdate().subscribe(label::setText)
        );

        add(btn, label);

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }

    @Override
    public void beforeLeave(BeforeLeaveEvent beforeLeaveEvent) {
        appActions.closeView1();
    }

    private AppActions appActions;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
}