package javacode.projects.concurrency.task3;


public class ComplexTask implements Runnable{

    private final String taskName;

    public ComplexTask(String taskName) {
        this.taskName = taskName;
    }

    public void execute() {
        try {
            System.out.println(Thread.currentThread().getName() + " is executing " + taskName);
            Thread.sleep((long) (Math.random() * 1000)); // Симулируем работу
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " completed " + taskName);
    }


    @Override
    public void run() {
        execute();
    }
}
