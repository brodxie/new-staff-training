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



### Part 2

Spring MVC的视图解析器（ViewResolver）：定位视图，例如解析控制器返回的逻辑名称。



### Part 3

Spring是一种基于IoC容器编程的框架。

Spring Boot是基于注解的开发Spring IoC。

@Configuration：表示Java配置文件，Spring容器会根据它来生成IoC容器去装配Bean。

@Bean：将特定方法返回的POJO装配到IoC容器中。

@Component：标明哪个类被扫描进入Spring IoC容器。

@ComponentScan：标明采用何种策略去扫描装配Bean。

@Autowired：根据属性类型找到对应的Bean进行注入。可注解属性、方法、参数。

@Primary：优先权的注解。

@Quelifier：与Autowired组合以区别Bean实例。



Spring Bean的主要生命周期：初始化--》依赖注入--》setBeanName方法–》setBeanFactory方法–》setApplicationContext方法–》postProcessBeforeInitialization方法--》自定义初始化方法–》afterPropertiesSet方法–-》postProcessAfterInitialization方法–》生存期–》自定义销毁方法--》destroy方法。



@PostConstruct：定义初始化方法。

@PreDestroy：定义销毁方法。

@Value：使用${…}占位符对属性文件内容进行配置。#{…}启用Spring表达式，使其具有运算的功能。

@PropertySource：定义对应的属性文件，加载到Spring的上下文中。



Bean的作用域：单例、原型两类。

作用域类型：

| 作用域类型    | 使用范围       | 作用域描述                                           |
| ------------- | -------------- | ---------------------------------------------------- |
| singleton     | 所有Spring应用 | 默认值，IoC容器只存在单例                            |
| prototype     | 所有Spring应用 | 每当从IoC容器取出一个Bean，则创建一个新Bean          |
| session       | Spring Web应用 | HTTP会话                                             |
| application   | Spring Web应用 | web工程生命周期                                      |
| request       | Spring Web应用 | web工程单次请求                                      |
| globalSession | Spring Web应用 | 在一个全局HTTP Session中，一个Bean定义对应一个实例。 |



项目环境：开发环境、测试环境、准生产环境（用于模拟真实生产环境部署所用）、生产环境。

