package com.eldi.java;

public class Schedule {
    private String day;
    private int hourBegin;
    private int hourEnd;

    public Schedule(String dayHours) {
        this.extractInfo(dayHours);
    }

    private void extractInfo(String dayHours) {
        System.out.println(dayHours);
    }

    public void printInfo() {
        StringBuilder info = new StringBuilder();
        info.append(this.day);
        info.append(this.hourBegin);
        info.append("-");
        info.append(this.hourEnd);
    }
}
