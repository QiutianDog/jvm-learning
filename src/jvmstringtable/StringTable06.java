package jvmstringtable;

import java.util.ArrayList;
import java.util.List;

/**
 * 展示StringTable是在堆中，不停的创建字符串对象，放入堆中，设置堆的最大内存。看看报错信息
 * -Xmx2m -Xms0m
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 *
 * @author langxi.feng
 * @since 2023-01-09 14:38
 */
public class StringTable06 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        long max = 26000L;
        long index = 0;
        try {
            for (index = 0; index < max; index++) {
                list.add(String.valueOf(index).intern());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(index);
        }
    }
}
