package lesson4DZ;

public class PrintABC {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';
    private final int COUNT = 5;

    public static void main(String[] args) {
//        version1();
        version2(); // TODO: 06.06.2020 "Этот вариант мне больше нравится, какой лучше?

    }

    private static void version1() {
        PrintABC p = new PrintABC();
        Thread t1 = new Thread(p::printA);
        Thread t2 = new Thread(p::printB);
        Thread t3 = new Thread(p::printC);
        t1.start();
        t2.start();
        t3.start();
    }

    private static void version2() {
        PrintABC p = new PrintABC();
        Thread t1 = new Thread(p::printA2);
        Thread t2 = new Thread(p::printB2);
        Thread t3 = new Thread(p::printC2);
        t1.start();
        t2.start();
        t3.start();
    }

    public void printA() {
        synchronized (mon) {
            for (int i = 0; i < COUNT; i++) {
                while (currentLetter != 'A') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                currentLetter = 'B';
                mon.notifyAll();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            for (int i = 0; i < COUNT; i++) {
                while (currentLetter != 'B') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                currentLetter = 'C';
                mon.notifyAll();
            }
        }
    }

    private void printC() {
        synchronized (mon) {
            for (int i = 0; i < COUNT; i++) {
                while (currentLetter != 'C') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("C ");
                currentLetter = 'A';
                mon.notifyAll();
            }
        }
    }

    public void printA2() {
        int x = 0;
        while (x != COUNT) {
            while (currentLetter != 'A')
                Thread.yield();
            System.out.print("A");
            x++;
            currentLetter = 'B';
        }

    }

    public void printB2() {
        int x = 0;
        while (x != COUNT) {
            while (currentLetter != 'B') Thread.yield();
            System.out.print("B");
            x++;
            currentLetter = 'C';
        }

    }

    private void printC2() {
        int x = 0;
        while (x != COUNT) {
            while (currentLetter != 'C') Thread.yield();
            System.out.print("C ");
            x++;
            currentLetter = 'A';
        }

    }
}
