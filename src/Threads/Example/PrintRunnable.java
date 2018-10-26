package Threads.Example;

public class PrintRunnable implements Runnable {
    Integer counter, n;

    public PrintRunnable(Integer count, int n) {
        this.counter = count;
        this.n = n;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            Thread.sleep(200);
            for (int i = 0; i < n; i++) {
                System.out.println(String.format("%s %d",Thread.currentThread().getName(), counter++));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
