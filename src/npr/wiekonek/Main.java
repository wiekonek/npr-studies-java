package npr.wiekonek;

import npr.wiekonek.semaphores.BinarySemaphore;
import npr.wiekonek.semaphores.CountingSemaphore;
import npr.wiekonek.semaphores.Semaphore;
import npr.wiekonek.tasks.SimpleTask;

// http://th.if.uj.edu.pl/~atg/SO/Semafory.pdf - definitions

public class Main {

    public static void main(String[] args) {
        Semaphore binarySemaphore = new BinarySemaphore();
        Semaphore countingSemaphore = new CountingSemaphore(3);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SimpleTask(countingSemaphore, i));
            thread.start();
        }
    }
}
