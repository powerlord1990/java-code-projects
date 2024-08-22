package javacode.projects.concurrency.task3;

import java.util.concurrent.*;

public class ComplexTaskExecutor {
    private final int numberOfThreads;
    private final CyclicBarrier barrier;

    public ComplexTaskExecutor(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        this.barrier = new CyclicBarrier(numberOfThreads, () -> {
            System.out.println("All tasks completed. Barrier released.");
        });
    }

    public void executeTasks(int numberOfTasks) {
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfTasks; i++) {
            final int taskId = i + 1;
            executorService.submit(() -> {
                ComplexTask task = new ComplexTask("Task-" + taskId);
                try {
                    task.run();
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executorService.shutdown();
    }
}