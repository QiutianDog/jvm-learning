package jvmstacks;

/**
 * 模拟虚拟机栈，模拟栈帧的压入和弹出
 *
 * @author Qiutian Dog
 * @date 2022/3/11
 */
public class StackSimulation {
    /**
     * main 方法也是一个方法，调用时会创建栈帧
     * @param args 参数
     */
    public static void main(String[] args) {
        // 局部变量
        int mainData = 1;

        // 调用其他方法，为该方法生成一个栈帧
        method(mainData);
    }

    /**
     * 普通方法
     * @param parameter 方法的参数
     */
    public static void method(int parameter) {
        // 局部变量
        int innerData = 2;
    }
}
