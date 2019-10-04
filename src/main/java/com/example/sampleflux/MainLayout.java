package com.example.sampleflux;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.RouterLayout;
import org.springframework.beans.factory.annotation.Autowired;

@Push
public class MainLayout extends VerticalLayout implements RouterLayout {
    @Autowired
    public MainLayout(AppActions appActions) {
        setWidth("100%");
        setHeight("100%");

        Button b1 = new Button("Show 1", ignore -> appActions.show1());
        Button b2 = new Button("Show 2", ignore -> appActions.show2());

        HorizontalLayout hl = new HorizontalLayout(b1, b2);
        hl.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        viewContainer = new FlexLayout();
        viewContainer.setWidth("100%");
        viewContainer.setHeight("100%");

        add(hl, viewContainer);
        setHorizontalComponentAlignment(Alignment.CENTER, hl);
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        viewContainer.getElement().appendChild(content.getElement());
    }

    private FlexLayout viewContainer;

}
