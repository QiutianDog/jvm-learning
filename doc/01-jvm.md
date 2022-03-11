# What is JVM？

JVM 是 Java Virtual Machine 的缩写，他是 java 程序的虚拟运行环境，准确来讲是 java 的二进制字节码的运行环境。我们的写的 java 程序，在经过编译之后会变成后缀为 .class 的二进制字节码文件，通过 JVM 可以把字节码文件转换成操作系统看得懂的**机器码**，这时CPU就可以直接执行我们的 java 程序了。然而不同的操作系统，他们的机器码编码方式也不同，JVM 的优势在在于可以把字节码转换成对应操作系统的机器码。也就是说我们只需要有 JVM ，就可以在不同的操作系统上运行我们的 java 程序。

## 1. 好处

- 一次编写，到处运行。java 源代码编译的字节码文件是固定的，无论是什么操作系统，只要装上 JVM ，就可以把字节码文件翻译成对应操作系统的 机器码，执行 java 程序。
- 自动内存管理，垃圾回收。JVM 提供了自动的内存管理，和垃圾回收机制。不需要程序员手动回收空间。
- 提供数组下标越界检查，一旦下标发生越界，就会抛出异常，避免操作了未知的内存空间，造成严重的后果。
- 提供多态，JVM 中使用虚方法调用的方式实现多态。

## 2. java 程序执行过程

1. 程序员编写**源代码**文件 （.java）。
2. 编译源代码文件，生成二进制字节码文件（.class）。
3. JVM 解释器将二进制字节码文件逐行解释成**机器码**。
4. CPU 直接读取机器码，执行指令。
