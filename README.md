# cloud2020

一个微服务架构项目，目前整合了Eureka、Zookeeper、Consul等注册中心，Ribbon、OpenFeign负载均衡调用，Hystrix熔断器、Gateway 网关、SpringCloud Config 分布式配置中心、SpringCloud Bus 消息总线..

写该项目做的笔记：[SpringCloud 01 - 基础理论](https://blog.csdn.net/weixin_44210965/article/details/105800536)









[Java虚拟机（01） - Java 内存区域与内存溢出异常](https://blog.csdn.net/weixin_44210965/article/details/103559356)

[Java虚拟机（02） - 垃圾收集器与内存分配策略](https://blog.csdn.net/weixin_44210965/article/details/104275919)

------

# 1. JVM的基础知识

## 1.1 Java 程序的执行过程

java文件->编译器->class文件（字节码）->JVM->机器码

<img src="https://img-blog.csdnimg.cn/20210105231431566.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70" alt="img" style="zoom: 50%;" />![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

如上图所示，首先 Java 源代码文件(.java后缀)会被 Java 编译器编译为字节码文件(.class后缀)，然后由 JVM 中的类加载器加载各个类的字节码文件，加载完毕之后，交由 JVM 执行引擎执行。在整个程序执行过程中，JVM 会用一段空间来存储程序执行期间需要用到的数据和相关信息，这段空间一般被称作为 Runtime Data Area（运行时数据区），也就是我们常说的 JVM 内存。因此，在 Java 中我们常常说到的内存管理就是针对这段空间进行管理（如何分配和回收内存空间）。 

## 1.2 JVM，JRE，JDK

**JDK > JRE > JVM** 

1）JVM

负责字节码的执行

2）JRE

JVM+基础类库（io，net）

3）JDK

JRE+编译，运行，打包（javac,java,jar）

## 1.3 跨平台，跨语言特性

<img src="https://img-blog.csdnimg.cn/20210102174309222.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70" alt="img" style="zoom:50%;" />![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

## 1.4 Java 虚拟机规范

Java虚拟机规范（相当于一个接口，有实现类去实现它），Hotspot（Java HotSpot(TM)），TaobaoVM（定制化）

接口，实现类

------

# 2. Java程序是如何运行起来的？

<img src="https://img-blog.csdnimg.cn/20210102174605637.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70" alt="img" style="zoom: 50%;" />![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

------

# 3. 类加载的机制 - 加载完整步骤：

加载时机：懒加载的方式，用到了哪个类 才会去加载哪个类。

<img src="https://img-blog.csdnimg.cn/20210102175905369.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70" alt="img" style="zoom:50%;" />![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

## **3.1 加载**

① 通过一个类的全名（包名+类名），获取到这个类的二进制流（可以从 class 文件读取，也可以从 jar 包读取）。

② 将这个字节流所代表的的静态存储结构转换为方法区的运行时数据结构。

③ 在内存中生成一个这个类的 Class 对象，作为访问入口。

整个过程怎么加，程序员有开放的一个控制权，自定义类加载器。

（注意！启用加载后，过程中也会有一部分验证阶段，验证完成后才会加载，保证 class 合法性。）

## **3.2 验证** 

这部分是为了确保 JVM 的安全性。

### **1）文件格式的校验** 
