package com.eldi.java;

import java.util.ArrayList;

/**
 * This Class handles the Employee Info
 */
public class Employee {
    private String name;
    private ArrayList<Schedule> listSchedule;

    public Employee() {
        this.listSchedule = new ArrayList<Schedule>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Create and fill the Schedule list
     *
     * @param listScheduleText string text like DAYHOUR,DAYHOUR,...
     */
    public void setScheduleEmployee(String listScheduleText) {
        String[] parts = listScheduleText.split(",");
        if (parts.length > 0) {
            for (String scheduleText : parts) {
                addSchedule(scheduleText);
            }
        }
    }

    /**
     * Create an Schedule object and add to the list
     *
     * @param scheduleText string text like DAYHOUR
     */
    private void addSchedule(String scheduleText) {
        if (scheduleText != null) {
            Schedule newSchedule = new Schedule(scheduleText);
            this.listSchedule.add(newSchedule);
        }
    }

    /**
     * Print on console the Employee Schedule list
     */
    public void printSchedule() {
        for (Schedule schedule : listSchedule) {
            schedule.printInfo();
        }
    }

    /**
     * Compare the current schedule with other Employee schedule
     *
     * @param otherEmployee Employee object to compare with
     * @return the count of matches in schedule
     */
    public int compareScheduleWith(Employee otherEmployee) {
        int countRepeated = 0;
        for (Schedule mySchedule : this.listSchedule) {
            for (Schedule otherSchedule : otherEmployee.listSchedule) {
                if (mySchedule.matchWith(otherSchedule)) {
                    countRepeated = countRepeated + 1;
                    break;
                }
            }
        }
        return countRepeated;
    }
}
