# 常量池
二进制字节码文件：类的基本信息，常量池，类方法定义（其中还包含虚拟机指令）

反编译 .class 文件：
```
javap -v HelloWorld.class
```
-v 表示显示详细信息

结果分析：

```
// 类的基本信息
Classfile /Users/qiutian/IdeaProjects/jvm-learning/out/production/jvm-learning/jvmconstpool/HelloWorld.class
  Last modified 2023-1-9; size 559 bytes
  MD5 checksum d40b06f94d7a7a99858b2438674c388d
  Compiled from "HelloWorld.java"
public class jvmconstpool.HelloWorld
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER

// 常量池
Constant pool:
   #1 = Methodref          #6.#20         // java/lang/Object."<init>":()V
   #2 = Fieldref           #21.#22        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = String             #23            // Hello World
   #4 = Methodref          #24.#25        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #5 = Class              #26            // jvmconstpool/HelloWorld
   #6 = Class              #27            // java/lang/Object
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               LocalVariableTable
  #12 = Utf8               this
  #13 = Utf8               Ljvmconstpool/HelloWorld;
  #14 = Utf8               main
  #15 = Utf8               ([Ljava/lang/String;)V
  #16 = Utf8               args
  #17 = Utf8               [Ljava/lang/String;
  #18 = Utf8               SourceFile
  #19 = Utf8               HelloWorld.java
  #20 = NameAndType        #7:#8          // "<init>":()V
  #21 = Class              #28            // java/lang/System
  #22 = NameAndType        #29:#30        // out:Ljava/io/PrintStream;
  #23 = Utf8               Hello World
  #24 = Class              #31            // java/io/PrintStream
  #25 = NameAndType        #32:#33        // println:(Ljava/lang/String;)V
  #26 = Utf8               jvmconstpool/HelloWorld
  #27 = Utf8               java/lang/Object
  #28 = Utf8               java/lang/System
  #29 = Utf8               out
  #30 = Utf8               Ljava/io/PrintStream;
  #31 = Utf8               java/io/PrintStream
  #32 = Utf8               println
  #33 = Utf8               (Ljava/lang/String;)V

// 类的方法定义
{
  public jvmconstpool.HelloWorld();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      // 虚拟机指令
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 9: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Ljvmconstpool/HelloWorld;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      // 虚拟机指令
      stack=2, locals=1, args_size=1
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #3                  // String Hello World
         5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: return
      LineNumberTable:
        line 11: 0
        line 12: 8
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       9     0  args   [Ljava/lang/String;
}
SourceFile: "HelloWorld.java"
```

# 运行时常量池

* 常量池：就是一张表，虚拟机指令根据这张常量表找到要执行的类名，方法名，参数类型，字面量（String，bool）等信息。
* 运行时常量池：常量池是 *.class 文件中的，当该类被加载时，它的 常量池 信息会被加载到 运行时常量池 ，并且会把里面的符号地址（#1，#2，#3，...）转换为真实地址。

