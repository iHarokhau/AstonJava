package Module4;


public class Main {
    public static final Object object1 = new Object();
    public static final Object object2 = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            synchronized (object1) {
                System.out.println("Stream 1, captured Object 1");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 1 is trying to capture Object 2");
                synchronized (object2) {
                    System.out.println("Stream 1 captured both Objects");
                }
            }
        }
        );
        Thread thread2 = new Thread(() -> {
            synchronized (object2) {
                System.out.println("Stream 2, captured Object 2");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 2 is trying to capture Object 1");
                synchronized (object1) {
                    System.out.println("Stream 1 captured both Objects");
                }
            }
        });

        //DeadLock
        //thread1.start();
        //thread2.start();


        //LiveLock
       /* final LiveLock lock1 = new LiveLock("Поток 1", true);
        final LiveLock lock2 = new LiveLock("Поток 2", true);

        new Thread(()->lock1.tryToGo(lock2)).start();
        new Thread(()-> lock2.tryToGo(lock1)).start();*/


        //infinite output to console 1 and 2
        /*Counting count1 = new Counting("1");
        Counting count2 = new Counting("2");

        new Thread(()-> count1.letPrint1()).start();
        new Thread(()->count2.letPrint2()).start();*/
    }
}
