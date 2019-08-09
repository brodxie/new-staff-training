## **《ServletJSP和SpringMVC初学指南》**

Spring MVC

依赖注入：接管对象的创建工作，并将该对象的引用注入需要该对象的组件。

beans：Spring管理的对象。

​	标识：id或name属性。

Java Web应用开发的两种设计模型：页面中心（适合小应用开发）、基于MVC模式。

​	MVC：模型-视图-控制器

​	视图：页面的展示；模型：封装了应用数据和业务逻辑；控制器：负责接收用户输入、改变模型以及调整视图的显示。

Spring MVC支持多种视图技术。最常见的JSP技术以及其他技术包括Velocity和FreeMarker。



## **《深入浅出Spring Boot2.x》**

### Part 1

**Spring特性**

控制反转（IoC）：管理各类Java资源，降低资源耦合；提供极低的侵入性，即应用Spring框架开发的编码，脱离Spring API也可以继续使用。

面向切面编程（AOP）：通过动态代理技术，允许按照约定进行配置编程，进而增强Bean的功能，擦除大量重复代码，使开发人员集中精力于业务开发。

整合了较为流行的框架模板。



主导思想：约定优于配置。



**其他：**

Jar、war、EAR的区别

Jar文件：Java Application Archive，包含Java类的普通库、资源（resources）、辅助文件（auxiliary files）等。

war文件：Web Application Archive，包含全部Web应用程序。

Ear文件：Enterprise Application Archive，包含全部企业应用程序。在这种情形下，一个企业应用程序被定义为多个jar文件、资源、类和Web应用程序的集合。

Linux安装jdk：https://www.cnblogs.com/imyalost/p/8709578.html

Linux下安装Tomcat服务器和部署Web应用：https://www.cnblogs.com/xdp-gacl/p/4097608.html