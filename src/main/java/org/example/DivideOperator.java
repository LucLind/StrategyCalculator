package org.example;

import java.security.InvalidParameterException;

public class DivideOperator implements ICalcOperator{
    public double calculate(double a, double b) {
        if (b == 0){
            throw new InvalidParameterException("You cant divide by 0!");
        }

        return a/b;
    }
}
