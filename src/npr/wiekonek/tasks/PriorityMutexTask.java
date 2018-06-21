package npr.wiekonek.tasks;

import npr.wiekonek.semaphores.PriorityMutex;
import java.time.LocalDateTime;

public class PriorityMutexTask implements Runnable {

    private final int _id;
    private final PriorityMutex _mutex;

    public PriorityMutexTask(int id, PriorityMutex mutex) {
        _id = id;
        _mutex = mutex;
    }

    @Override
    public void run() {
        while(true) {
            try {
//                Thread.sleep(500);
                System.out.println("[" + _id + "] waiting");
                _mutex.Wait(_id, _id == 5 ? 3 : _id);
                System.out.println("[" + _id + "] in critical section");
//                Thread.sleep(1000);
                System.out.println("[" + _id + "] out of critical section");
                _mutex.Signal(_id);
//                if(_id == 3) {
//                    Thread.sleep(200000);
//                }
//                if(_id == 4) {
//                    Thread.sleep(200000);
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
