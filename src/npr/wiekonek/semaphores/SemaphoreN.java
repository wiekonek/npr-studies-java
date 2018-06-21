package npr.wiekonek.semaphores;

public interface SemaphoreN {
    void P(int n) throws InterruptedException;
    void V(int n) throws InterruptedException;
}
