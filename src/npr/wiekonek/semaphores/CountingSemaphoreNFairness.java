package npr.wiekonek.semaphores;

public class CountingSemaphoreNFairness implements SemaphoreN {

    private int _s;

    public CountingSemaphoreNFairness(int s) {
        _s = s;
    }

    @Override
    public void P(int n) throws InterruptedException {
        synchronized (this) {
            while (_s < n) {
                wait();
            }
            _s-=n;
        }
    }

    @Override
    public void V(int n) {
        synchronized (this) {
            _s+=n;
            notify();
        }
    }
}
