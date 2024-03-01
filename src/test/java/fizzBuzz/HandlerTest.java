package fizzBuzz;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandlerTest {
    @Test
    public void BaseHandler_setNext(){
        BaseHandler base = new NumberHandler();
        BaseHandler next = new FizzHandler();

        base.setNext(next);

        assertThat(base.getNext(), is(next));
    }

    @Test
    public void numberHandler_process(){
        BaseHandler handler = new NumberHandler();

        for (int i = 0; i <= 15; i++) {
            assertEquals(handler.process(i), i+"\n");
        }
    }

    @Test
    public void fizzHandler_process(){
        BaseHandler handler = new FizzHandler();

        for (int i = 0; i <= 15; i++) {
            String expected = null;
            if (i%3 == 0){
                expected = "Fizz\n";
            }

            assertEquals(handler.getNext(), null);
            assertEquals(handler.process(i), expected);
        }
    }
    @Test
    public void buzzHandler_process(){
        BaseHandler handler = new BuzzHandler();

        for (int i = 0; i <= 15; i++) {
            String expected = null;
            if (i%5 == 0){
                expected = "Buzz\n";
            }

            assertEquals(handler.getNext(), null);
            assertEquals(handler.process(i), expected);
        }
    }

    @Test
    public void fizzBuzzHandler_process(){
        BaseHandler handler = new FizzBuzzHandler();

        for (int i = 0; i <= 15; i++) {
            String expected = null;
            if (i%15 == 0){
                expected = "FizzBuzz\n";
            }

            assertEquals(handler.getNext(), null);
            assertEquals(handler.process(i), expected);
        }
    }

    @Test
    public void test_process_chained(){
        BaseHandler start = createChain();
        String expectedResult = "1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n11\nFizz\n13\n14\nFizzBuzz\n";
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= 15 ; i++) {
            result.append(start.process(i));
        }

        assertEquals(result.toString(), expectedResult);


    }

    public BaseHandler createChain(){
        BaseHandler h1 = new FizzBuzzHandler();
        BaseHandler h2 = new FizzHandler();
        BaseHandler h3 = new BuzzHandler();
        BaseHandler h4 = new NumberHandler();

        h1.setNext(h2)
                .setNext(h3)
                .setNext(h4);


        return h1;
    }
}
