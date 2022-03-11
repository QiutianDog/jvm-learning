# JVM Stacks

JVM Stacks 虚拟机栈，他属于 JVM 内存结构的范畴，既然他叫栈，那么就跟数据结构中的栈是一样的，遵循**后进先出**的原则。我们要弄清楚几个词。

- JVM 虚拟机栈：是**线程**运行时所需要的内存空间，每个线程都有自己独立的栈空间。随着线程的创建而创建，随着线程的销毁而销毁。
- 栈帧：JVM 虚拟机栈中的元素，java程序每调用一个方法，就会生成一个栈帧，并且压入虚拟机栈，栈帧也是一个内存空间，存放了每个方法所需要**参数，局部变量，返回地址**等等。当方法调用完成时，会自动弹出当前栈帧，释放空间。
- 活动栈帧：每个**线程**只能有一个活动栈帧。

## 虚拟机栈演示

我们可以用代码模拟一下 虚拟机栈的运行过程。

```java
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
```

1. 首先，我们在main里面打上断点，开始调试。

![image-20220311194916548](https://github.com/QiutianDog/jvm-learning/blob/main/images/jvm-stacks-01.png)

- 左边：虚拟机中已经有了一个栈帧，是main方法的栈帧。
- 右边：main方法栈帧内部的变量，可以看到不仅有方法参数还有方法内局部变量。

2. 单点调试，进入method方法。

![image-20220311195347612](https://github.com/QiutianDog/jvm-learning/blob/main/images/jvm-stacks-02.png)

- 左边：虚拟机栈中压入了新的栈帧，method方法栈帧，并且在main方法栈帧之上，符合栈的逻辑结构。
- 右边：method方法的方法参数和局部变量。

3. 继续调试，到执行完method方法。

![image-20220311195650067](https://github.com/QiutianDog/jvm-learning/blob/main/images/jvm-stacks-03.png)

- 注意已经到了main:20，而不是之前main:19，这代表的是执行到的代码行数。



wait for update！（2022.3.11）

## 常见问题

1. 垃圾回收是否涉及栈内存？

## 内存溢出

## 运行诊断