package patterns.chain.of.responsibility;

public abstract class ProcessingObject<T> {
    private ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T r = handleWork(input);
        if (successor != null) {
          return  successor.handle(r);
        }
        return r;
    }

    public abstract T handleWork(T input);
}
