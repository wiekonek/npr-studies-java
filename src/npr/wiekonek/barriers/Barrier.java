package npr.wiekonek.barriers;

public class Barrier {


    private final int _threadNumber;
    private int _currentCount = 0;

    public Barrier(int threadNumber) {
        _threadNumber = threadNumber;
    }

    public void await() throws InterruptedException {
        synchronized (this) {
            _currentCount++;
            while(_currentCount < _threadNumber) {
                wait();
            }
            notifyAll();
        }
    }
}
