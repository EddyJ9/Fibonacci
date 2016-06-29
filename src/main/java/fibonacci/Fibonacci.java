package fibonacci;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jeff on 6/28/16.
 */
public class Fibonacci implements Runnable {
    private int fibNumber;

    public Fibonacci(int number) {
        this.fibNumber = fibNumber;
    }

    /**
     * Recursive fibonacci algorithm.  Majorly inefficient
     * @param number The nth number in the series to find
     * @return the long of the found number
     */
    public long fib(int number){

        long rval = 0;
        if(number < 1){
            rval = 0;
        }
        else if(number == 1){
            rval = 1;
        }
        else{
            rval = fib(number - 1) + fib(number - 2);
        }

        return rval;
    }

    @Override
    public void run() {
        long number = fib(fibNumber);
        System.out.format("%d is the %d number in the sequence\n", fibNumber, number);

    }

}

