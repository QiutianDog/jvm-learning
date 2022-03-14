package jvmheap;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟堆内存高居不下的情况。进行堆内存诊断。
 *
 * @author Qiutian Dog
 * @date 2022/3/14
 */
public class HeapDiagnosis02 {
    public static void main(String[] args) {
        try {
            List<Student> list = new ArrayList<>();
            for (int i = 0; i < 200; i++) {
                list.add(new Student());
            }
            Thread.sleep(3600 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Student{
        private byte[] data = new byte[1024 * 1024];
    }
}
