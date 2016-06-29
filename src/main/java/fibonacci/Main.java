package fibonacci;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by EddyJ on 6/28/16.
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000);

        Thread producer = new Thread(new ReadFile(queue));
        Thread consumer = new Thread(new ReadQueue(queue));
        producer.start();
        consumer.start();

    }


    // main has que, readfile class, executor class, fib class
    //textfile to que, que to excutor, excutor runs it
    //exc is running fib sequence, exc.submit (object)
    //main creat a thread(open scanner put in que)
    //main creat an object from que to exc
    //main creat exc, creat que, 2nd thread needs exc,
    //consum take num out of que, creat new runnable (class), submit to exc
    // new fib for every number called out in class
    //takes que and exc in construct or 2nd thread
    //4 classes, run is what package does
}
