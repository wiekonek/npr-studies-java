package npr.wiekonek.tasks;

import npr.wiekonek.barriers.Barrier;

public class BarrierTask implements Runnable {

    private final int _id;
    private final Barrier _barrier;

    public BarrierTask(int id, Barrier barrier) {
        _id = id;
        _barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println("[" + _id + "] started");
        try {
            Thread.sleep(500 * _id);
            System.out.println("[" + _id + "] waiting");
            _barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + _id + "] synchronized");

    }
}
