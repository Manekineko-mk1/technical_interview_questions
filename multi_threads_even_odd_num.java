public class multi_threads_even_odd_num {
    private int max;
    private boolean oddTurn = true;

    public multi_threads_even_odd_num(int max) {
        this.max = max;
    }

    public void printOdd() {
        synchronized (this) {
            for (int i = 1; i <= max; i += 2) {
                while (!oddTurn) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print(i + " ");
                oddTurn = false;
                notify();
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            for (int i = 2; i <= max; i += 2) {
                while (oddTurn) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print(i + " ");
                oddTurn = true;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        int num = 20;
        multi_threads_even_odd_num printNumbers = new multi_threads_even_odd_num(num);

        Thread t1 = new Thread(printNumbers::printOdd);
        Thread t2 = new Thread(printNumbers::printEven);

        t1.start();
        t2.start();
    }
}