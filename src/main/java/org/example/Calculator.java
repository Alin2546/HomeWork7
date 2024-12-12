package org.example;

/**
 * Calculator class which computes a distance value from different unit measures.
 */
public class Calculator {
    private double mm = 1000;
    private double cm = 100;
    private double dm = 10;
    private double m = 1;
    private double km = 0.001;
    private double result = 0;

    /**
     * <p>
     * The method is computing the expression into meters then converting into the specified unit measure
     * </p>
     *
     * @param unitMeasure the unit measure in which the result is computed and returned
     * @param expression  the expression from which we calculate
     * @return result of the computed expression in the unit measure specified by the user
     */
    public double calculate(String unitMeasure, String expression) {

        //Implementation
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
            //Implementation for subtraction
            if (!addValue) {
                if (measure.equals("mm")) {
                    result = result - (nr / 1000);
                    measure = "";
                    nr = 0;
                    addValue = true;
                } else if (measure.equals("cm")) {
                    result = result - (nr / 100);
                    measure = "";
                    nr = 0;
                    addValue = true;
                } else if (measure.equals("dm")) {
                    result = result - (nr / 10);
                    measure = "";
                    nr = 0;
                    addValue = true;
                } else if (measure.equals("m")) {
                    result -= nr;
                    measure = "";
                    nr = 0;
                    addValue = true;
                } else if (measure.equals("km")) {
                    result = result - (nr * 1000);
                    measure = "";
                    nr = 0;
                    addValue = true;
                }
            }
            // Implementation for adding
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
        // The conversion from meters to any other unit measure ex. 'mm','dm','km'.
        if (unitMeasure.equals("mm")) {
            result *= 1000;
            System.out.print(expression + " = " + result + " mm");
            return result;
        } else if (unitMeasure.equals("cm")) {
            result *= 100;
            System.out.print(expression + " = " + result + " cm");
            return result;
        } else if (unitMeasure.equals("dm")) {
            result *= 10;
            System.out.print(expression + " = " + result + " dm");
            return result;
        } else if (unitMeasure.equals("m")) {
            System.out.print(expression + " = " + result + " m");
            return result;
        } else if (unitMeasure.equals("km")) {
            result /= 1000;
            System.out.print(expression + " = " + result + " km");
            return result;
        } else {
            result *= 1000;
            System.out.print(expression + " = " + result + " mm");
        }
        return result;
    }
}
