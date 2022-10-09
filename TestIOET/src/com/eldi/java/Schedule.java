package com.eldi.java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Schedule {
    private String day;
    private Date hourBegin;
    private String textHourBegin;
    private Date hourEnd;
    private String textHourEnd;

    /**
     * Constructor
     *
     * @param dayHours String like DAYHOUR:MINUTES-HOUR:MINUTES
     */
    public Schedule(String dayHours) {
        this.parseInfo(dayHours);
    }

    /**
     * Get the string like DAYHOUR:MINUTES-HOUR:MINUTES and initialize the properties
     *
     * @param dayHours string like DAYHOUR:MINUTES-HOUR:MINUTES
     */
    private void parseInfo(String dayHours) {
        if (dayHours.length() > 2) {
            this.day = dayHours.substring(0, 2);
            this.textHourBegin = dayHours.substring(2, 7);
            this.textHourEnd = dayHours.substring(8);
        }
        this.parseHours();
    }

    /**
     * Parse the hours text to integer
     */
    private void parseHours() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        if (this.textHourBegin.length() == 5) {
            try {
                this.hourBegin = dateFormat.parse(textHourBegin);
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
        if (this.textHourEnd.length() == 5) {
            try {
                this.hourEnd = dateFormat.parse(textHourEnd);
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }

    /**
     * Check if two Schedule hours coincide in the Office
     *
     * @param otherSchedule Schedule to compare
     * @return True if the Schedules coincide
     */
    public boolean matchWith(Schedule otherSchedule) {
        boolean match = false;
        if (otherSchedule.day.equals(this.day)) {
            int resultMyEnter = this.hourBegin.compareTo(otherSchedule.hourBegin);
            // My enter same time than Other OR My enter is after Other Enter
            if (resultMyEnter >= 0) {
                int resultOtherExit = this.hourBegin.compareTo(otherSchedule.hourEnd);
                // My enter before Other exit
                if (resultOtherExit < 0) {
                    match = true;
                }

                // My enter before the Other
            } else {
                // My exit after Other enter
                int resultMyExit = this.hourEnd.compareTo(otherSchedule.hourBegin);
                if (resultMyExit > 0) {
                    match = true;
                }
            }
        }
        return match;
    }

    /**
     * Show schedule in console
     */
    public void printInfo() {
        StringBuilder info = new StringBuilder();
        info.append(this.day);
        info.append(this.hourBegin.toString());
        info.append("-");
        info.append(this.hourEnd.toString());
        System.out.println(info);
    }
}
