package com.eldi.java;

public class Main {
    public static void main(String[] args) {
        ACME acme = new ACME();
        acme.readFile("input1.txt");
        acme.compareEmployees();
    }
}
