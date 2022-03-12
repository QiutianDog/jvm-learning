package jvmstacks;


/**
 * 演示栈内存溢出的情况
 * 注: 使用 -Xss 可手动设置栈的内存大小
 * 例: -Xss1m    -Xss256k
 *
 * @author Qiutian Dog
 * @date 2022/3/12
 */
public class StackOver {
    public static void main(String[] args) {
        try {
            recursion();
            // overElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 递归调用 不设置终止条件，导致栈帧过多，超出栈的内存范围，最终导致栈内存溢出
     * java.lang.StackOverflowError
     */
    public static void recursion() {
        // 不设置终止条件
        recursion();
    }

    /**
     * 栈帧过大 超出栈的内存范围 导致栈内存溢出
     * java.lang.StackOverflowError
     */
    public static void overElement() {
        int var1 = 0;
        // -- 若干个变量, 不可以是对象，对象的话就会放在堆内存而不是栈内存。
        int varn = 0;
    }
}
