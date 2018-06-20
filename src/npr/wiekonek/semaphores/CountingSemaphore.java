package npr.wiekonek.semaphores;

public class CountingSemaphore implements Semaphore {

    private int _s;

    public CountingSemaphore(int s) {
        _s = s;
    }

    @Override
    public void P() throws InterruptedException {
        synchronized (this) {
            while (_s <= 0) {
                wait();
            }
            _s--;
        }
    }

    @Override
    public void V() {
        synchronized (this) {
            _s++;
            notify();
        }
    }
}
