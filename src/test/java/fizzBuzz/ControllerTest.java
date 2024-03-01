package fizzBuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ControllerTest {
    private Controller _controller;

    @BeforeEach
    public void setup(){
        _controller = new Controller();
    }

    @Test
    public void ControllerSetHandler(){
        BaseHandler handler = mock(BaseHandler.class);
        _controller.setHandler(handler);

        assertThat(_controller.getHandler(), is(handler));
    }
    @Test
    public void ControllerProcess(){
        BaseHandler handler = mock(BaseHandler.class);
        when(handler.process(1)).thenReturn("1\n");
        when(handler.process(2)).thenReturn("2\n");
        when(handler.process(3)).thenReturn("Fizz\n");
        when(handler.process(4)).thenReturn("4\n");
        when(handler.process(5)).thenReturn("Buzz\n");
        when(handler.process(6)).thenReturn("Fizz\n");
        when(handler.process(7)).thenReturn("7\n");
        when(handler.process(8)).thenReturn("8\n");
        when(handler.process(9)).thenReturn("Fizz\n");
        when(handler.process(10)).thenReturn("Buzz\n");
        when(handler.process(11)).thenReturn("11\n");
        when(handler.process(12)).thenReturn("Fizz\n");
        when(handler.process(13)).thenReturn("13\n");
        when(handler.process(14)).thenReturn("14\n");
        when(handler.process(15)).thenReturn("FizzBuzz\n");

        String expectedResult = "1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n11\nFizz\n13\n14\nFizzBuzz\n";

        _controller.setHandler(handler);

        assertEquals(_controller.process(15), expectedResult);
        verify(handler, times(15)).process(anyInt());

    }
}
