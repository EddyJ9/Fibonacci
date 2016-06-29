package fibonacci;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by EddyJ on 6/28/16.
 */
public class ReadFile implements Runnable {
    private BlockingQueue<Integer> queue;

    public ReadFile(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        boolean done = false;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000);
        Scanner scanner = new Scanner("fibdata.txt");

        while(!done || !queue.isEmpty())
            scanner.hasNextInt();
            try {
                queue.put(scanner.nextInt());
            } catch (InterruptedException e) {
                done = true;
            }
    }

}
