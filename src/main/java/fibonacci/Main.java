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

        //create producer thread and run it
        Thread producer = new Thread(new ReadFile(queue));
        producer.start();
        //create consumer thread and run it as well
        Thread consumer = new Thread(new ReadQueue(queue, service));
        consumer.start();

    }

}
