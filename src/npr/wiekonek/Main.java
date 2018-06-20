package npr.wiekonek;

import npr.wiekonek.semaphores.BinarySemaphore;
import npr.wiekonek.semaphores.Semaphore;
import npr.wiekonek.tasks.SimpleTask;


public class Main {

    public static void main(String[] args) {
        Semaphore sem = new BinarySemaphore();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SimpleTask(sem, i));
            thread.start();
        }
    }
}
