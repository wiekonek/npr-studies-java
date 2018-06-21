package npr.wiekonek.semaphores;

public class PriorityMutex {

    private final int _processesNo;

    private int[] _priorities;
    private boolean _prioritiesLocked = false;
    private int _maxPriority = -1;
    private boolean _locked = false;

    public PriorityMutex(int processesNo) {
        _priorities = new int[processesNo];
        _processesNo = processesNo;
    }

    public synchronized void Wait(int processId, int priority) throws InterruptedException {
        synchronized (_priorities) {
            while (_prioritiesLocked) {
                _priorities.wait();
            }
            _prioritiesLocked = true;

            _priorities[processId] = priority;
            for (int i = 0; i < _processesNo; i++) {
                if (_priorities[i] > _maxPriority) {
                    _maxPriority = _priorities[i];
                }
            }

            _prioritiesLocked = false;
            _priorities.notifyAll();
        }
        while (_locked || _maxPriority > priority) {
            wait();
        }
        _locked = true;
    }

    public synchronized void Signal(int processId) throws InterruptedException {
        _maxPriority = 0;
        synchronized (_priorities) {
            while (_prioritiesLocked) {
                _priorities.wait();
            }
            _prioritiesLocked = true;
            _priorities[processId] = -1;

            for (int i = 0; i < _processesNo; i++) {
                if (_priorities[i] > _maxPriority) {
                    _maxPriority = _priorities[i];
                }
            }

            _prioritiesLocked = false;
            _priorities.notifyAll();
        }

        _locked = false;
        notifyAll();

    }
}
