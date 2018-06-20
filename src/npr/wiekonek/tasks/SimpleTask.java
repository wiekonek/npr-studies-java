package npr.wiekonek.tasks;

import npr.wiekonek.semaphores.Semaphore;

public class SimpleTask implements Runnable {

    private Semaphore _semaphore;
    private final int _id;

    public SimpleTask(Semaphore semaphore, int id) {
        _semaphore = semaphore;
        _id = id;
    }


    public int getId() {
        return _id;
    }


    @Override
    public void run() {
        while(true) {
            try {
                _semaphore.P();
                System.out.print("┌SimpleTask [" + _id + "] in critical section.\n");
                Thread.sleep(500);
                System.out.print("└SimpleTask [" + _id + "] out of critical section.\n");
                _semaphore.V();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
