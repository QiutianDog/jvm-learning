package jvmmethodarea;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 演示元空间内存溢出
 * -XX:MaxMetaspaceSize=8m
 * <p>
 * ClassLoader 可以用来加载类的二进制字节码
 *
 * @author langxi.feng
 * @since 2023-01-09 10:08
 */
public class MethodOutMemory extends ClassLoader {
    public static void main(String[] args) {
        int j = 0;
        try {
            MethodOutMemory methodOutMemory = new MethodOutMemory();
            for (int i = 0; i < 10000; i++, j++) {
                // ClassWriter 用代码的方式生成类的字节码
                ClassWriter cw = new ClassWriter(0);
                // Opcodes.V1_8 代表类的版本号，Opcodes.ACC_PUBLIC 类的访问修饰符， 类的名字， null 包名， java/lang/Object 父类， null 实现的接口名称
                cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                byte[] code = cw.toByteArray();
                // 加载类
                methodOutMemory.defineClass("Class" + i, code, 0, code.length);
            }
        } finally {
            System.out.println(j);
        }
    }
}
