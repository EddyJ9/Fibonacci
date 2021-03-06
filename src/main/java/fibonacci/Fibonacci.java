package fibonacci;


/**
 * Created by jeff on 6/28/16.
 */
public class Fibonacci implements Runnable {
    private int number;
    private long fibNumber;

    public Fibonacci(int numberDesired) {
        this.number = numberDesired;
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
        fibNumber = rval;
        return rval;
    }

    @Override
    public void run() {

        fib(number);
        System.out.format("%d is the %dth number in the sequence\n", this.fibNumber, number);

    }

}

