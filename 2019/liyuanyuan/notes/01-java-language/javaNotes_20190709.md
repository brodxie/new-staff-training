# 《Java核心技术卷一》chapter 1-3

## 1.Java程序设计概述

关键术语：简单性、面向对象、分布式、健壮性、安全性、体系结构中立、可移植性、高性能、多线程、动态性。

applet：在网页中运行的Java程序。

## 2.Java程序设计环境

Java术语：JDK、JRE、Server JRE、SE、EE、ME、Java FX、OpenJDK、J2、SDK、u、NetBeans。

集成开发环境：Eclipse、NetBeans、IntelliJ IDEA等。

## 3.Java的基本程序设计结构

### 类名命名规范

大写字母开头，字母、数字任意结合，驼峰命名法。（注意：Java区分大小写。）

### 注释

//...、/*...*/（不可嵌套）、/**...*/。

### 基本数据类型

- 整型

byte，1字节，-2^7 - 2^7-1，即[-128,127]   
short，2字节，-2^15 - 2^15-1，即[-32768,32767]  
int，4字节，-2^31 - 2^31-1，正好超过20亿  
long，8字节，-2^63 - 2^63-1

- 浮点

float，4字节，后缀F或f  
double，8字节，后缀D或d

- 布尔

boolean，false和true 

备注：没有后缀F的浮点数值默认为double类型。  
正无穷大：Double.POSTIVE_INFINITY、Float.POSTIVE_INFINITY  
负无穷大：Double.NEGTIVE_INFINITY、Float.NEGTIVE_INFINITY  
NaN（不是一个数字）：Double.NaN、Float.NaN

- 进制标记

长整型：后缀L或l  
二进制：前缀0b或0B  
八进制：前缀0  
十六进制：前缀0x或0X  
（Java7开始可以为数字字面量加下划线，如1_000_000。Java编译器会去除下划线。）

### 其他数据类型

变量：由字母开头，并由字母和数字构成的序列。  
常量：用final修饰。final表示变量只能被赋值一次，常量名使用全大写。  
类常量：使用static final修饰。

### 运算

- 运算函数

整数被0除会产生异常，浮点数被0除会得到无穷大或NaN的结果。  
平方根：Math.sqrt(x);  
幂运算：Math.pow(x, a);  
三角函数：Math.sin、Math.cos、Math.tan、Math.atan、Math.atan2  
指数函数及反函数：Math.exp、Math.log、Math.log10  
常量值：Math.PI、Math.E  
（备注：不必在数学方法名和常量名前加前缀“Math”，只需引入对应包即可；StrictMath类运行结果更准确，能确保所有平台得到相同的结果。）

- 运算符

位运算符：&（and）、|（or）、^（亦或）、~（not）

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190709124833765.png)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190709124912894.png)


### 格式化输出

- 用于printf的转换符

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190709124949269.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2FubmVDb2Rlcg==,size_16,color_FFFFFF,t_70)


- 文件的输入与输出

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190709125041395.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2FubmVDb2Rlcg==,size_16,color_FFFFFF,t_70)


循环语句：while(conditon) statement、do statement while(conditon)、for each循环  
多重选择：switch语句  
大数值：BigInteger（任意精度的整数运算）、BigDecimal（任意精度的浮点数运算）  
备注：Java未提供运算符重载功能。

数组排序：Arrays.sort(a);  （Java实际上没有多维数组，只有一维数组，多维数组被解释为“数组的数组”。）

