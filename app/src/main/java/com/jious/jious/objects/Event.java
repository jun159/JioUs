package com.jious.jious.objects;

/**
 * Created by BAOJUN on 24/6/16.
 */
public class Event {

    private int drawable;
    private String title;
    private String location;
    private String km;
    private String dateTime;
    private String host;
    private int minPax;
    private int maxPax;
    private int currentCount;
    private int currentDay;
    private boolean isLiked;

    public Event(int drawable, String title, String location, String km, String dateTime,
                 String host, int minPax, int maxPax, int currentCount,
                 int currentDay, boolean isLiked) {
        this.drawable = drawable;
        this.title = title;
        this.location = location;
        this.km = km;
        this.dateTime = dateTime;
        this.host = host;
        this.minPax = minPax;
        this.maxPax = maxPax;
        this.currentCount = currentCount;
        this.currentDay = currentDay;
        this.isLiked = isLiked;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getMinPax() {
        return minPax;
    }

    public void setMinPax(int minPax) {
        this.minPax = minPax;
    }

    public int getMaxPax() {
        return maxPax;
    }

    public void setMaxPax(int maxPax) {
        this.maxPax = maxPax;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }
}
