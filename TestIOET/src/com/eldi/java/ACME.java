package com.eldi.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class ACME {
    private ArrayList<Employee> listEmployees;

    public void readFile(String fileName) {
        try {
            String str = fileName;
            Path dir = Paths.get(str);                       // Defining the path to the file.
            System.out.println(dir);
            Stream<String> content = Files.lines(dir);       // Storing the data of the file.
            content.forEach(line -> parseEmployee(line));

        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    /**
     * Encargado de convertir la linea Name=Schedule en una instancia de Employee
     *
     * @param line linea de texto tipo Name=Schedule
     * @return instancia de Employee creada con la linea de texto
     */
    private Employee parseEmployee(String line) {
        Employee newEmployee = new Employee();
        String scheduleText = setNameEmployee(line, newEmployee);
        if (scheduleText != null) {
            newEmployee.setScheduleEmployee(scheduleText);
        }
        System.out.println(newEmployee.getName());
        newEmployee.printSchedule();
        return newEmployee;
    }

    /**
     * Recibe la linea del archivo de texto Name=Schedule y lo ingresa a la instancia Employee
     *
     * @param line     linea de texto tipo Name=Schedule
     * @param employee instancia de la clase Employee
     * @return string del schedule
     */
    private String setNameEmployee(String line, Employee employee) {
        String[] parts = line.split("=");
        if (parts.length == 2) {
            employee.setName(parts[0]);
            return parts[1];
        }
        return null;
    }
}
