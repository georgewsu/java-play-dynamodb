package services;

import java.util.ArrayList;
import java.util.List;

import models.Widget;

public class WidgetService {

    private static final List<Widget> widgets = new ArrayList<Widget>();

    static {
        Widget w1 = new Widget();
        w1.setName("w1");
        w1.setDescription("widget1");
        w1.setPrice(1);
        widgets.add(w1);
        Widget w2 = new Widget();
        w2.setName("w2");
        w2.setDescription("widget2");
        w2.setPrice(2);
        widgets.add(w2);
    }

    public static List<Widget> getWidgets() {
        return widgets;
    }

}
