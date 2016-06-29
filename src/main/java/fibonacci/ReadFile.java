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
    private BlockingQueue<Integer> queue;

    public ReadFile(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        File file = new File("fibdata.txt");
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return;
        }
        while(scanner.hasNextInt()){
            int nextNum = scanner.nextInt();
            try {
                queue.put(nextNum);
            } catch (InterruptedException e) {
                return;
            }
        }

    }

}
