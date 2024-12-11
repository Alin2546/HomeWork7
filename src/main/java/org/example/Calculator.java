package org.example;

public class Calculator {
    private double mm = 1000;
    private double cm = 100;
    private double dm = 10;
    private double m = 1;
    private float km = 0.001f;
    private double result = 0;

    public void calculate(String unitMeasure, String expression) {


        double nr = 0.00;
        String measure = "";
        this.result = 0;
        boolean addValue = true;
        for (int i = 0; i < expression.length(); i++) {
            if (i == expression.length() - 1) {
                measure = measure + expression.charAt(i);
            } else if (Character.isDigit(expression.charAt(i))) {
                nr = nr * 10 + Character.getNumericValue(expression.charAt(i));
                continue;
            } else if (Character.isAlphabetic(expression.charAt(i))) {
                measure = measure + expression.charAt(i);
                continue;
            } else if (expression.charAt(i) == '-') {
                addValue = false;
            }


            if (!addValue) {
                if (measure.equals("mm")) {
                    result = result - (nr / 1000);
                    measure = "";
                    nr = 0;
                    addValue = true;
                } else if (measure.equals("cm")) {
                    System.out.print(nr + " " + measure + " ");
                    result = result - (nr / 100);
                    measure = "";
                    nr = 0;
                    addValue = true;
                } else if (measure.equals("dm")) {
                    System.out.print(nr + " " + measure + " ");
                    result = result - (nr / 10);
                    measure = "";
                    nr = 0;
                    addValue = true;
                } else if (measure.equals("m")) {
                    System.out.print(nr + " " + measure + " ");
                    result -= nr;
                    measure = "";
                    nr = 0;
                    addValue = true;
                } else if (measure.equals("km")) {
                    System.out.print(nr + " " + measure + " ");
                    result = result - (nr * 1000);
                    measure = "";
                    nr = 0;
                    addValue = true;
                }
            }


            if (addValue) {
                if (measure.equals("mm")) {

                    result = result + (nr / 1000);
                    measure = "";
                    nr = 0;
                } else if (measure.equals("cm")) {

                    result = result + (nr / 100);
                    measure = "";
                    nr = 0;
                } else if (measure.equals("dm")) {

                    result = result + (nr / 10);
                    measure = "";
                    nr = 0;
                } else if (measure.equals("m")) {

                    result += nr;
                    measure = "";
                    nr = 0;
                } else if (measure.equals("km")) {

                    result = result + (nr * 1000);
                    measure = "";
                    nr = 0;
                }
            }
        }


        if (unitMeasure.equals("mm")) {
            result *= 1000;
            System.out.print(expression + " = " + (int) result + " mm");
        } else if (unitMeasure.equals("cm")) {
            result *= 100;
            System.out.print(expression + " = " + (int) result + " cm");
        } else if (unitMeasure.equals("dm")) {
            result *= 10;
            System.out.print(expression + " = " + (int) result + " dm");
        } else if (unitMeasure.equals("m")) {
            System.out.print(expression + " = " + (int) result + " m");
        } else if (unitMeasure.equals(km)) {
            result /= 1000;
            System.out.print(expression + " = " + (int) result + " km");
        }
    }
}
