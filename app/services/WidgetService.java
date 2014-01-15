package services;

import java.util.ArrayList;
import java.util.List;

import models.Widget;

public class WidgetService {

    private static final List<Widget> widgets = new ArrayList<Widget>();

    static {
        Widget w1 = new Widget("w1", "widget1", 1);
        widgets.add(w1);
        Widget w2 = new Widget("w2", "widget2", 2);
        widgets.add(w2);
    }

    public static List<Widget> getWidgets() {
        return widgets;
    }

}
