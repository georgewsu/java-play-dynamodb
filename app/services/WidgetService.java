package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Widget;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

public class WidgetService {

    private static final String TABLE_NAME = "widgets";
    
    private static final List<Widget> widgets = new ArrayList<Widget>();

    static {
        // TODO: check for pre-existing table instead of generic exception handling
        try {
            DynamoDBService.createTable("widgets", "name");
        }
        catch (Exception e) {
        }

        // Wait for it to become active
        DynamoDBService.waitForTableToBecomeAvailable(TABLE_NAME);

        // Describe our new table
        DynamoDBService.describeTable(TABLE_NAME);

        Widget w1 = new Widget("w1", "widget1", 1);
        widgets.add(w1);
        Map<String, AttributeValue> item = w1.toDynamoMap();
        DynamoDBService.putItem(TABLE_NAME, item);

        Widget w2 = new Widget("w2", "widget2", 2);
        widgets.add(w2);
        item = w2.toDynamoMap();
        DynamoDBService.putItem(TABLE_NAME, item);
    }

    public static List<Widget> getWidgets() {
        List<Widget> widgets = new ArrayList<Widget>();
        ScanResult scanResult = DynamoDBService.scan(TABLE_NAME);
        List<Map<String, AttributeValue>> items = scanResult.getItems();
        for (Map<String, AttributeValue> item : items) {
            Widget widget = Widget.fromDynamoMap(item);
            widgets.add(widget);
        }
        return widgets;
    }

}
