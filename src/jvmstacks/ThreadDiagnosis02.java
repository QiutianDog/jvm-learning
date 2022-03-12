package jvmstacks;

/**
 * 模拟一个死锁，进行线程诊断
 *
 * @author Qiutian Dog
 * @date 2022/3/12
 */
public class ThreadDiagnosis02 {
    static Object objA = new Object();
    static Object objB = new Object();

    public static void main(String[] args) {
        new Thread(null, () -> {
            synchronized (objA) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(objB) {
                    System.out.println(Thread.currentThread().getName() + " Get A and B!");
                }
            }
        }, "Thread-1").start();

        new Thread(null, () -> {
            synchronized (objB) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(objA) {
                    System.out.println(Thread.currentThread().getName() + " Get A and B!");
                }
            }
        }, "Thread-2").start();
    }
}
