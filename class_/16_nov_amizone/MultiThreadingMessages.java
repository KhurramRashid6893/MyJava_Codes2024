class MessageThread extends Thread {
    private String message;
    private int interval;

    public MessageThread(String message, int interval) {
        this.message = message;
        this.interval = interval;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(message);
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + message);
        }
    }
}

public class MultiThreadingMessages {
    public static void main(String[] args) {
        // Create threads with different messages and intervals
        Thread thread1 = new MessageThread("Good Morning everyone", 1000);
        Thread thread2 = new MessageThread("Hello", 2000);
        Thread thread3 = new MessageThread("Welcome", 3000);

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
