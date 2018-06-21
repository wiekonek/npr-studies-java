package npr.wiekonek.tasks;

import npr.wiekonek.semaphores.SemaphoreN;

public class SimpleTaskN implements Runnable {

    private SemaphoreN _semaphore;
    private final int _id;
    private final int _n;

    public SimpleTaskN(SemaphoreN semaphore, int id, int n) {
        _semaphore = semaphore;
        _id = id;
        _n = n;
    }


    public int getId() {
        return _id;
    }


    @Override
    public void run() {
        while(true) {
            try {
                _semaphore.P(_n);
                System.out.print(">> [" + _id + "]" + " SimpleTaskN (" + _n + ") in critical section.\n");
                Thread.sleep(500);
                System.out.print("<< [" + _id + "]" + " SimpleTaskN (" + _n + ") out of critical section.\n");
                _semaphore.V(_n);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
