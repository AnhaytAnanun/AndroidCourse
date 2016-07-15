package com.flycode.aclesson6;

/**
 * Created by anhaytananun on 13.07.16.
 */
public class Thing {
    private String name;
    private String info;

    public Thing(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
