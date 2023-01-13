package jvmstringtable;

import java.util.ArrayList;
import java.util.List;

/**
 * 展示StringTable会存在垃圾回收，不停的创建字符串对象，放入堆中，设置堆的最大内存。
 * -Xmx4m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 * PrintStringTableStatistics 启动打印StringTable信息
 * PrintGCDetails 打印 GC 回收信息
 *
 * @author langxi.feng
 * @since 2023-01-09 14:38
 */
public class StringTable07 {
    public static void main(String[] args) {
        long max = 10000L;
        long index = 0;
        try {
            for (index = 0; index < max; index++) {
                String.valueOf(index).intern();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(index);
        }
    }
}
