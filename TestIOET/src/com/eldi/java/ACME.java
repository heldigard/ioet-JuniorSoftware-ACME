package com.eldi.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * This is the Company Class that handles the list of Employees and
 * list of pairs of Schedules
 */
public class ACME {
    private final ArrayList<Employee> listEmployees;
    private final ArrayList<Duple> listDuples;

    public ACME() {
        this.listEmployees = new ArrayList<Employee>();
        this.listDuples = new ArrayList<Duple>();
    }

    public ArrayList<Duple> getListDuples() {
        return listDuples;
    }

    /**
     * Read the txt file in the root folder
     *
     * @param fileName nameFile.txt
     */
    public void readFile(String fileName) {
        try {
            Path pathFile = Paths.get(fileName);
            boolean exists = Files.exists(pathFile);
            if (exists) {
                Stream<String> content = Files.lines(pathFile);       // Storing the data of the file.
                content.forEach(line -> {
                    addEmployee(line);
                });
            } else {
                System.out.println("File: " + fileName + " not found");
            }
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

    /**
     * Compare the Schedule of all the Employees and create the Duple list
     */
    public void compareEmployees() {
        for (int i = 0; i < listEmployees.size(); i++) {
            for (int j = 1; j < listEmployees.size(); j++) {
                Employee currentEmployee = listEmployees.get(i);
                Employee nextEmployee = listEmployees.get(j);
                if (!currentEmployee.getName().equals(nextEmployee.getName())) {
                    this.addDuple(currentEmployee, nextEmployee);
                }
            }
        }
    }

    /**
     * Add one Duple to the list
     *
     * @param employee1 Employee object
     * @param employee2 Employee object
     */
    private void addDuple(Employee employee1, Employee employee2) {
        boolean exist = false;
        for (Duple currentDuple : this.listDuples) {
            if (currentDuple.equals(employee1, employee2)) {
                exist = true;
            }
        }
        if (!exist) {
            Duple duple = new Duple();
            duple.setEmployee1(employee1);
            duple.setEmployee2(employee2);
            int count = employee1.compareScheduleWith(employee2);
            duple.setCount(count);
            this.listDuples.add(duple);
        }
    }
}
