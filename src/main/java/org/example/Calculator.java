package org.example;

/**
 * Hello world!
 *
 */
public class Calculator
{
    private double result;
    private ICalcOperator operator;

    public void setOperator(ICalcOperator operator) {
        this.operator = operator;
    }

    public ICalcOperator getOperator(){
        return operator;
    }

    public double getResult() {
        return result;
    }

    public void calculate(double a, double b) {
        result = operator.calculate(a, b);
    }
}
