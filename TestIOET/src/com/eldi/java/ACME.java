package com.eldi.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class ACME {
    private final ArrayList<Employee> listEmployees;

    public ACME() {
        this.listEmployees = new ArrayList<Employee>();
    }

    /**
     * Read the txt file in the root folder
     *
     * @param fileName nameFile.txt
     */
    public void readFile(String fileName) {
        try {
            String str = fileName;
            Path dir = Paths.get(str);                       // Defining the path to the file.
            Stream<String> content = Files.lines(dir);       // Storing the data of the file.
            content.forEach(line -> addEmployee(line));

        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    /**
     * Create and add the Employee object to the list
     *
     * @param line String line like Name=Schedule
     */
    private void addEmployee(String line) {
        Employee newEmployee = parseEmployee(line);
        if (newEmployee.getName() != null) {
            this.listEmployees.add(newEmployee);
        }
    }

    /**
     * Convert the string line like Name=Schedule in an Employee object
     *
     * @param line string line like Name=Schedule
     * @return Employee object created
     */
    private Employee parseEmployee(String line) {
        Employee newEmployee = new Employee();
        String scheduleText = setNameEmployee(line, newEmployee);
        if (scheduleText != null) {
            newEmployee.setScheduleEmployee(scheduleText);
        }
        return newEmployee;
    }

    /**
     * Receive the string line Name=Schedule and add the object Employee to the list
     *
     * @param line     string line like Name=Schedule
     * @param employee Employee object
     * @return schedule string text
     */
    private String setNameEmployee(String line, Employee employee) {
        String[] parts = line.split("=");
        if (parts.length == 2) {
            employee.setName(parts[0]);
            return parts[1];
        }
        return null;
    }

    public void compareEmployees() {
        for (int i = 0; i < listEmployees.size(); i++) {
            for (int j = 1; j < listEmployees.size(); j++) {
                Employee currentEmployee = listEmployees.get(i);
                Employee nextEmployee = listEmployees.get(j);
                if (!currentEmployee.getName().equals(nextEmployee.getName())) {
                    System.out.println(currentEmployee.getName() + "-" + nextEmployee.getName());
                    System.out.println("Compared: " + currentEmployee.compareScheduleWith(nextEmployee));
                }

            }
        }
    }
}
