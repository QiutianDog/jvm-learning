package jvmstacks;

/**
 * 线程诊断示例01
 *  CPU 高居不下
 *
 * @author Qiutian Dog
 * @date 2022/3/12
 */
public class ThreadDiagnosis01 {
    public static void main(String[] args) {
        // 建立3个线程，让其中一个线程持续使用cpu
        new Thread(null, () -> {
            while (true) {
                // 不断占用CPU
            }
        }, "Thread-1").start();

        new Thread(null, () -> {
            try {
                // 沉睡
                Thread.sleep(3600000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-2").start();

        new Thread(null, () -> {
            try {
                // 沉睡
                Thread.sleep(3600000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-3").start();
    }
}
