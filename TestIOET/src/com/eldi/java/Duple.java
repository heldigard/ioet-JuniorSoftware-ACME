package com.eldi.java;

public class Duple {
    private Employee employee1;
    private Employee employee2;
    private int count;

    public Duple() {
    }

    public Employee getEmployee1() {
        return employee1;
    }

    public void setEmployee1(Employee employee1) {
        this.employee1 = employee1;
    }

    public Employee getEmployee2() {
        return employee2;
    }

    public void setEmployee2(Employee employee2) {
        this.employee2 = employee2;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Compare two Employee object if they are the same as the in the Duple
     *
     * @param employee1 First Employee object to compare
     * @param employee2 Second Employee object to compare
     * @return If the two Employee objects are the same as the Duple
     */
    public boolean equals(Employee employee1, Employee employee2) {
        boolean existEmployee1 = false;
        boolean existEmployee2 = false;
        if (employee1.getName().equals(this.employee1.getName())
                || employee2.getName().equals(this.employee1.getName())) {
            existEmployee1 = true;
        }
        if (employee1.getName().equals(this.employee2.getName())
                || employee2.getName().equals(this.employee2.getName())) {
            existEmployee2 = true;
        }
        return (existEmployee1 && existEmployee2);
    }

    /**
     * Print the Duple data in console
     */
    public void printInfo() {
        if (this.count > 0) {
            StringBuilder info = new StringBuilder();
            info.append(this.employee1.getName());
            info.append("-");
            info.append(this.employee2.getName());
            info.append(": " + this.count);
            System.out.println(info);
        }
    }

}
