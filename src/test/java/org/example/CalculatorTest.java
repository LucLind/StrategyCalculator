package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * Unit test for simple App.
 */
public class CalculatorTest
{
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }


    @Test
    public void testCalculator(){
        ICalcOperator strategy = mock(ICalcOperator.class);
        calculator.setOperator(strategy);
        when(strategy.calculate(1d,1d)).thenReturn(2d);

        calculator.calculate(1d,1d);
        verify(strategy).calculate(1d,1d);
        assert(calculator.getResult() == 2);
    }
    @Test
    public void testSetStrategy(){
        ICalcOperator strategy = mock(ICalcOperator.class);
        calculator.setOperator(strategy);
        assertThat(calculator.getOperator(), is(strategy));
    }
    @Test
    public void testAdd()
    {
        calculator.setOperator(new AddOperator());
        calculator.calculate(1, 2);
        assert(calculator.getOperator() instanceof AddOperator);
        assert(calculator.getResult() == 3);
    }

    @Test
    public void testSubtract(){
        calculator.setOperator(new SubtractOperator());
        calculator.calculate(2,1);
        assert(calculator.getOperator() instanceof SubtractOperator);
        assert(calculator.getResult() == 1);
    }
    @Test
    public void testMultiply(){
        calculator.setOperator(new MultiplyOperator());
        calculator.calculate(2,2);
        assert(calculator.getOperator() instanceof MultiplyOperator);
        assert(calculator.getResult() == 4);
    }
    @Test
    public void testDivide(){
        calculator.setOperator(new DivideOperator());
        calculator.calculate(10,2);
        assert(calculator.getOperator() instanceof DivideOperator);
        assert(calculator.getResult() == 5);
    }

    @Test
    public void testDivideInvalidParamException(){
        calculator.setOperator(new DivideOperator());

        assertThrows(InvalidParameterException.class, () -> calculator.calculate(2, 0));
    }
}
