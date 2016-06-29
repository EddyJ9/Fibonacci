package fibonacci;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by EddyJ on 6/28/16.
 */
public class ReadQueue implements Runnable{
    private BlockingQueue<Integer> queue;

    public ReadQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        ExecutorService service = Executors.newFixedThreadPool(100);
        int num = 0;
        boolean done = false;

        while (!done || !queue.isEmpty()) try {
                    num = queue.take();
        } catch (InterruptedException e) {
            done = true;
        }
        Fibonacci executeFib = new Fibonacci(num);
        service.submit(executeFib);




    }


}
