package npr.wiekonek;

import npr.wiekonek.barriers.Barrier;
import npr.wiekonek.semaphores.*;
import npr.wiekonek.tasks.BarrierTask;
import npr.wiekonek.tasks.PriorityMutexTask;
import npr.wiekonek.tasks.SimpleTaskN;

// http://th.if.uj.edu.pl/~atg/SO/Semafory.pdf - definitions

public class Main {

    public static void main(String[] args) {
//        Semaphore binarySemaphore = new BinarySemaphore();
//        Semaphore countingSemaphore = new CountingSemaphore(3);
//        SemaphoreN countingNSemaphore = new CountingSemaphoreNThroughput(5);
//        Barrier barrier = new Barrier(5);
        PriorityMutex mutex = new PriorityMutex(6);

        for (int i = 0; i < 6; i++) {
//            Thread thread = new Thread(new SimpleTask(countingSemaphore, i));
//            Thread thread = new Thread(new SimpleTaskN(countingNSemaphore, i, i%4+1));
//            Thread thread = new Thread(new BarrierTask(i, barrier));
            Thread thread = new Thread(new PriorityMutexTask(i, mutex));
            thread.start();
        }
    }
}
