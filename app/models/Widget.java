package models;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class Widget {

    private String name;
    private String description;
    private Integer price;

    public Widget(String name, String description, Integer price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Map<String, AttributeValue> toDynamoMap() {
        Map<String, AttributeValue> map = new HashMap<String, AttributeValue>();
        map.put("name", new AttributeValue(name));
        map.put("description", new AttributeValue(description));
        map.put("price", new AttributeValue().withN(Integer.toString(price)));
        return map;
    }

}
