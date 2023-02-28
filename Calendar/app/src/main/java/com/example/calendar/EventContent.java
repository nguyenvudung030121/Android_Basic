package com.example.calendar;

public class EventContent {
    private String nameEvent;
    private String eventDescription;
    private String time;

    public EventContent(String nameEvent, String eventDescription, String time) {
        this.nameEvent = nameEvent;
        this.eventDescription = eventDescription;
        this.time = time;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

