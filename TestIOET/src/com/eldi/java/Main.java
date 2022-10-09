package com.eldi.java;

/**
 * Main Class that run the program
 */
public class Main {
    public static void main(String[] args) {
        ACME acme = new ACME();
        if (args.length > 0 && args[0] != null) {
            acme.readFile(args[0]);
            acme.compareEmployees();
            for (Duple duple : acme.getListDuples()) {
                duple.printInfo();
            }
        } else {
            System.out.println("You must pass the fileName text as firts argument");
        }
    }
}
