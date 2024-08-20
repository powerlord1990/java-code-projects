package javacode.projects.concurrency.task1;


public class Main {
    public static void main(String[] args) {


        BlockingQueue<Integer> blockingQueue = new BlockingQueue(10);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    blockingQueue.enqueue(i);
                    System.out.println("Producer- " + i);
                Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    Integer item = blockingQueue.dequeue();
                    System.out.println("Consumer- " + item);
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        consumer.start();

    }
}