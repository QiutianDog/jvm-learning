package jvmheap;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示堆溢出的情况
 * 注：可以用 -Xmx 来控制堆内存的大小
 *     如 -Xmx8m
 *
 * @author Qiutian Dog
 * @date 2022/3/14
 */
public class HeapOver {
    public static void main(String[] args) {
        try {
            List<String> list = new ArrayList<>();
            String s = "QiutianDog";
            while (true) {
                // 用巨大的对象实例撑爆堆
                list.add(s);
            }
        } catch (Exception e) {
            // java.lang.OutOfMemoryError: Java heap space
            e.printStackTrace();
        }
    }
}
