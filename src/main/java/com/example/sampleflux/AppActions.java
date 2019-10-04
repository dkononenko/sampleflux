package com.example.sampleflux;

import com.vaadin.flow.component.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppActions {
    @Autowired
    public AppActions(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void show1() {
        UI.getCurrent().navigate("");
    }

    public void getCurrentTime() {
        dispatcher.post(new Action(Action.GET_CURRENT_TIME));
    }

    public void closeView1() {
        dispatcher.post(new Action(Action.CLOSE_VIEW1));
    }


    public void show2() {
        UI.getCurrent().navigate("view2");
    }

    public void closeView2() {
        dispatcher.post(new Action(Action.CLOSE_VIEW2));
    }

    private Dispatcher dispatcher;

}
