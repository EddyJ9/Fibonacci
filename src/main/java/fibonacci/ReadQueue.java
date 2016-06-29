package fibonacci;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by EddyJ on 6/28/16.
 */
public class ReadQueue implements Runnable{
    private BlockingQueue<Integer> queue;
    private ExecutorService service = Executors.newFixedThreadPool(100);

    public ReadQueue(BlockingQueue<Integer> queue, ExecutorService service) {
        this.queue = queue;
        this.service = service;
    }


    @Override
    public void run() {
        int num = 0;
        boolean done = false;

        while (!done || !queue.isEmpty()) {
            try {
                num = queue.take();
            } catch (InterruptedException e) {
                done = true;
            }

            Fibonacci executeFib = new Fibonacci(num);
            service.submit(executeFib);
        }
    }
}
