package facade.workerexample;

public class AbstractWorker implements Worker{

    protected String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void startWork() {
        System.out.println("Start working");

    }
}
