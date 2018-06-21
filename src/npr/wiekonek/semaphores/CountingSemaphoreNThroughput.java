package npr.wiekonek.semaphores;

public class CountingSemaphoreNThroughput implements SemaphoreN {

    private int _s;

    public CountingSemaphoreNThroughput(int s) {
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
            System.out.println("s: " + _s);
            notify();
        }
    }
}
