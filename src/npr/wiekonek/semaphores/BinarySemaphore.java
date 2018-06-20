package npr.wiekonek.semaphores;

public class BinarySemaphore implements  Semaphore {

    private Boolean _taken = false;

    @Override
    public void P() throws InterruptedException {
        synchronized (this) {
            while(_taken) {
                wait();
            }
            _taken = true;
        }
    }

    @Override
    public void V() throws InterruptedException {
        synchronized (this) {
            while(!_taken) {
                wait();
            }
            _taken = false;
            notify();
        }
    }
}
