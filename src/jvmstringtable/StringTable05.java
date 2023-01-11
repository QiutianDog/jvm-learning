package jvmstringtable;

/**
 * e.g
 *
 * @author langxi.feng
 * @since 2023-01-09 14:38
 */
public class StringTable05 {
    public static void main(String[] args) {
        String x = "ab";
        String s = new String("a") + new String("b");
        String s2 = s.intern();

        System.out.println(s2 == x);
        System.out.println(s == x);
        // System.out.println(s2 == "ab");
    }
}
