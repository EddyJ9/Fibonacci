package fibonacci;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by EddyJ on 6/28/16.
 */
public class ReadFile implements Runnable {
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1000);
    private File file = new File("fibdata.txt");

    public ReadFile(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return;
        }
        while(scanner.hasNextInt()){
            try {
                queue.put(scanner.nextInt());
            } catch (InterruptedException e) {
                return;
            }
        }

    }

}
