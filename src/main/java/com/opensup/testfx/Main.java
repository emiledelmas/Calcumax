package com.opensup.testfx;// Import scanner

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome to Calcumax!");

        // Create a new instance of the class Modele
        Modele modele = new Modele();

        while (true) {
            System.out.println("give a number:");

            // Create an input for the user
            Scanner sc = new Scanner(System.in);
            //if it's a double
            if (sc.hasNextDouble()) {
                // Add the double to the deque
                modele.push(sc.nextDouble());
            }
            //else if it's a string
            else {
                // if it's a +
                if (sc.hasNext("\\+")) {
                    modele.add();
                }
                // if it's a -
                else if (sc.hasNext("-")) {
                    modele.substract();
                }
                // if it's a *
                else if (sc.hasNext("\\*")) {
                    modele.multiply();
                }
                // if it's a /
                else if (sc.hasNext("/")) {
                    modele.divide();
                } else {
                    System.out.println("Not a valid input");
                }
            }
            System.out.println(modele.result());
        }
    }
}
