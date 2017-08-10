package com.iongeger.radiostreaming;

import java.io.Serializable;

/**
 * Created by facu on 9/6/2016.
 */
public class RadioInfo implements Serializable{
    private String name;
    private String url;
    private String gender;
    private String location;

    RadioInfo(String name, String url){
        setName(name);
        setUrl(url);
    }

    RadioInfo(String name, String url, String gender){
        this(name, url);
        this.setGender(gender);
    }

    RadioInfo(String name, String url, String gender, String location){
        this(name, url, gender);
        this.setLocation(location);
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getGender() {
        return gender;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
