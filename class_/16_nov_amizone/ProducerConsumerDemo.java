class SharedBuffer {
    private int data;
    private boolean hasData = false;

    // Producer produces data
    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait(); // Wait until the buffer is empty
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + data);
        notify(); // Notify the consumer
    }

    // Consumer consumes data
    public synchronized int consume() {
        while (!hasData) {
            try {
                wait(); // Wait until the buffer is filled
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify(); // Notify the producer
        return data;
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.produce(i); // Produce values
            try {
                Thread.sleep(500); // Simulate production delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.consume(); // Consume values
            try {
                Thread.sleep(1000); // Simulate consumption delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        // Create producer and consumer threads
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        // Start threads
        producer.start();
        consumer.start();
    }
}
