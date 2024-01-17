package Java;

public class print_num_2_threads {
    // create two threads, one thread prints odd numbers, the other thread prints
    // even numbers
    public void printNum(int n) {
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 1; i <= n; i += 2) {
                        System.out.print(i);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 2; i <= n; i += 2) {
                        System.out.print(i);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        print_num_2_threads obj = new print_num_2_threads();
        obj.printNum(10);
    }

}
