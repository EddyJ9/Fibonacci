package fibonacci;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeff on 6/28/16.
 */
public class FibonacciTest {
    Fibonacci fib;

    @Before
    public void setup(){
        fib = new Fibonacci(0);
    }

    @Test
    public void whenFibZeroThenReturnZero(){
        assertEquals(0, fib.fib(0));
    }

    @Test
    public void whenFibOneThenReturnOne(){
        assertEquals(1, fib.fib(1));
    }

    @Test
    public void whenFibThreeThenReturn2(){
        assertEquals(2, fib.fib(3));
    }

    @Test
    public void whenFibSevenThenReturn13(){
        assertEquals(13, fib.fib(7));
    }

}
