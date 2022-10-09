package com.eldi.java;

import java.util.ArrayList;

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
     * Crea la lista de instancias Schedule
     *
     * @param listScheduleText recibe el string de texto tipo DAYHOUR,DAYHOUR,...
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
     * Crea una instancia de Schedule y la agrega a la lista
     *
     * @param scheduleText recibe el texto tipo DAYHOUR
     */
    private void addSchedule(String scheduleText) {
        if (scheduleText != null) {
            Schedule newSchedule = new Schedule(scheduleText);
            this.listSchedule.add(newSchedule);
        }
    }

    public void printSchedule() {
        for (Schedule schedule : listSchedule) {
            System.out.println(schedule.getDayHour());
        }
    }
}
