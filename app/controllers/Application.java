package controllers;

import java.util.List;

import models.Widget;
import play.mvc.Controller;
import play.mvc.Result;
import services.WidgetService;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result widgets() {
        List<Widget> widgets = WidgetService.getWidgets();
        return ok(views.html.widgets.render(widgets));
    }

}
