package jvmstringtable;

/**
 * e.g
 *
 * @author langxi.feng
 * @since 2023-01-09 14:06
 */
public class StringTable01 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b";
        String s4 = s1 + s2;
        String s5 = "ab";
        String s6 = s4.intern();

        // 问
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);

        String x2 = new String("c") + new String("d");
        String x1 = "cd";
        x2 = x2.intern();

        // 如果调换最后两行的位置 情况如何
        System.out.println(x1 == x2);
    }
}
