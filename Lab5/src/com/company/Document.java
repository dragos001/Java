package com.company;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document  implements Serializable {
    private String id;
    private String name;
    private String location;

    private Map<String, Object> tags = new HashMap<>();

    public Document(String id , String name , String location)
    {
        this.id = id;
        this.name = name;
        this.location = location;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addTag(String key, Object obj)
    {
        tags.put(key , obj);
    }
}
