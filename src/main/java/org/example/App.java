package org.example;

import java.util.*;


public class App {

    /**
     * Starting point of the program
     * @param args They are not used here!
     */
    public static void main(String[] args) {
        //Making a calculator instance
        Calculator calculator = new Calculator();

        //Calling the calculate method and evaluating a generic expression
        calculator.calculate("mm", "10 cm + 1 m - 10 mm");



    }
}
