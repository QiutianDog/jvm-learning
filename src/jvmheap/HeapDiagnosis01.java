package jvmheap;

/**
 * 模拟堆内存高居不下的情况。进行堆内存诊断。
 *
 * @author Qiutian Dog
 * @date 2022/3/14
 */
public class HeapDiagnosis01 {
    public static void main(String[] args) {
        try {
            System.out.println("init!");
            Thread.sleep(30 * 1000);
            byte[] arr = new byte[1024 * 1024 * 10];
            System.out.println("create over!");
            Thread.sleep(30 * 1000);
            arr = null;
            System.gc();
            System.out.println("gc over!");
            Thread.sleep(3600 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
