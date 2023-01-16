package jvmdirectmemory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.WildcardType;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 对比 NIO和普通IO的区别
 *
 * @author langxi.feng
 * @since 2023-01-13 15:47
 */
public class DirectMemory01 {

    public static final String FROM = "/Users/qiutian/Downloads/lib.zip";

    public static final String TO = "/Users/qiutian/workspace/lib.zip";

    public static final int SIZE_1M = 1024 * 1024;

    public static void main(String[] args) {
        // IO 用时：49.418916
        io();
        // DirectIO 用时：32.811541
        directIo();
    }

    public static void io() {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(FROM);
             FileOutputStream fos = new FileOutputStream(TO)) {
            byte[] bytes = new byte[SIZE_1M];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.nanoTime();
        System.out.println("IO 用时：" + (endTime - startTime) / 1000_000.0);
    }

    public static void directIo() {
        long startTime = System.nanoTime();
        try (FileChannel from = new FileInputStream(FROM).getChannel();
             FileChannel to = new FileOutputStream(TO).getChannel()) {
            ByteBuffer bb = ByteBuffer.allocateDirect(SIZE_1M);
            int len = 0;
            while ((len = from.read(bb)) != -1) {
                bb.flip();
                to.write(bb);
                bb.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.nanoTime();
        System.out.println("DirectIO 用时：" + (endTime - startTime) / 1000_000.0);
    }

}
