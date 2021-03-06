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



### Part 3：Spring IoC

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



### Part 4：Spring AOP

AOP术语

连接点：对应具体被拦截的对象，因为Spring只能支持方法，被拦截的对象往往指特定的方法。

切点：切面可应用于方法，或多个类的不同方法。可以通过正则式和指示器的规则去定义，从而适配连接点。

通知：按照约定流程下的方法，分为前置通知、后置通知、环绕通知、事后返回通知、异常通知。

目标对象：即被代理对象。

引入：指引入新的类和其方法，增强现有Bean的功能。

织入：通过动态代理技术，为原有服务对象生成代理对象，然后将于切点定义匹配的连接点拦截，并按约定将各类通知织入约定流程的过程。

切面：是一个可以定义切点、各类通知和引入的内容，Spring AOP将通过它的信息来增强Bean的功能或将对应方法织入流程。



AOP流程

确定连接点、开发切面、切点定义、测试AOP、环绕通知、引入、通知获取参数、织入。



### Part 5：访问数据库

MyBatis与Hibernate的比较

MyBatis

- 半自动

- SQL优化更细致，可减少查询字段
- 容易掌握。

Hibernate

- 全自动

- DAO层开发相较于Mybatis简单，无需维护SQL和结果映射

- 对对象的维护和缓存更好

- 数据库移植性很好

- 有更好的耳机缓存机制，可使用第三方缓存

  

MyBatis：支持定制化SQL、存储过程以及高级映射的优秀的持久层框架。

配置文件：基础配置文件+映射文件。



### Part 6：数据库事务管理

@Transational：声明启用数据库事务。

- 标注在类上，代表该类所有公共非静态方法都将启用事务功能。
- 也可标注在方法上。

- 配置项：

  propagation：传播行为；

  isolation：隔离级别；

  timeout：超时时间；

  readOnly：是否只读事务；

  rollbackFor：指定异常时回滚，默认所有异常回滚；

  noRollbackFor：指定异常不回滚，默认所有异常都回滚；

  noRollbackForClassName：指定异常名称时不回滚，默认所有异常都回滚。



数据库事务ACID

​	Atomic 原子性、Consistency 一致性、Isolation 隔离性、Durability 持久性。



传播行为

​	REQUIRED, REQUIRES_NEW, NESTED



### Part7-8：Redis&MongoDB

定义：

Redis是一个开源、使用ANSI C语言编写、遵守BSD协议、支持网络、可基于内存亦可持久化的日志型、键值数据库，并提供多种语言的API。

MongoDB是由C++语言编写的一种NoSQL，是一个基于分布式文件存储的开源数据库系统。在负载高时可以添加更多的节点，以保证服务器性能。其目的在于为Web应用提供可扩展的高性能数据存储解决方案。



### Part 9：Rest

Rest, Representational State Transfer，表现层状态转换。

REST风格特点：

- 服务器存在一系列的资源，每一个资源通过单独唯一的URI进行标识；
- 客户端和服务器之间可以相互传递资源，而资源会以某种表现层得以展示；
- 客户端通过HTTP协议所定义的动作对资源进行操作，以实现资源的状态转换。



HTTP的动作：

GET（VISIT）：访问服务器资源（一个或者多个资源）。

POST（CREATE）：提交服务器资源信息，用来创建新的资源。

PUT（UPDATE）：修改服务器已存在的资源，使用时需要把资源的所有属性一并提交。

PATCH（UPDATE）：修改服务器已存在的资源，使用时只需要将部分资源属性提交。目前此动作并不常用也不普及，有些Java类还不能完全支持它。

DELETE（DELETE）：从服务器将资源删除。

HEAD：获取资源的元数据（Content-type）。

OPTIONS：提供资源可供客户端修改的属性信息。



Spring4.3之后除了@RequestMapping外，还可以使用以下注解：

@GetMapping、@PostMapping、#PutMapping、@PatchMapping、@DeleteMapping



### Part10：其他

异步线程池：一个请求可能在两个或者以上的线程运行。

AsyncConfigurer接口：配置异步线程池。

@EnableAsync: Spring开启异步可用。

@Async：驱动Spring使用异步调用。

@Nullable: 允许空指针

@NotNull: 不允许空指针



异步消息

JMS: Java Message Service，Java消息服务。

JMS按规范分为点对点和发布订阅两种形式。

实现JMS服务的规范：ActiveMQ、分布式Kafka

实现AMQP协议的：RabbitMQ



编程实践：

[Windows下ActiveMQ的下载和启动](https://baijiahao.baidu.com/s?id=1609552706887055762&wfr=spider&for=pc)

[ActiveMQ应用](https://www.e-learn.cn/content/java/487993)



AMQP：一种常用的消息协议。是一个提供统一消息服务的应用层标准协议，基于此协议的客户端与消息中间件可传递消息，并不受客户端/中间件不同产品、不同开发语言等条件的限制。



定时任务

@EnableScheduling：使用注解驱动定时任务的机制

@Scheduled：配置如何定时



WebSocked

基于TCP的一种新的网络协议。实现了浏览器与服务器全双工通信——允许服务器主动发送信息给客户端，这样就可以实现从客户端发送消息到服务器，而服务器又可以转发消息到客户端，这样就能够实现客户端之间的交互。P



### Part11: WebFlux

响应式编程

灵敏、可恢复、可伸缩、消息驱动



两种开发方式：一种是类似于Spring MVC的模式，另一种则是函数功能性的编程。



对高并发超发现象的处理：

悲观锁：使用数据库内部的锁对记录进行加锁，从而使得其他事务等待以保证数据的一致。但这样会造成过多的等待和事务上下文的切换导致缓慢，因为悲观锁中资源只能被一个事务锁持有，所以也被称为独占锁或排他锁。

乐观锁：一种不使用数据库锁的机制，并且不会造成线程的阻塞，只是采用多版本号机制来实现。但因为版本的冲突造成了请求失败的概率剧增，所以这时往往需要通过重入的机制将请求失败的概率降低。多次的重入会带来过多执行SQL的问题。为了克服此问题，可考虑使用时间戳或限制重入次数的办法。

Redis处理：Redis性能比数据库要快得多，所以在响应高并发时比数据库要快得多。但Redis存储不稳定，需及时将数据保存到数据库。



### Part12: 部署、测试和监控

部署 Maven、测试JUnit、监控 Actuator



**部署步骤**

将项目打包（war、jar、rar、ear、pom等包）：mvn package（idea以管理员身份运行）

运行项目（内嵌服务器、第三方服务器）



[Maven教程](https://www.yiibai.com/maven)     [一个小时学会Maven](https://www.cnblogs.com/best/p/9676515.html)

Maven：Java项目管理构建自动化综合工具，类似于Java中的Ant、node.js中的npm、dotNet中的nuget、PHP中的Composer。

作用：统一开发规范与工具，统一管理jar包

功能：依赖的管理、项目的构建、项目的知识管理

Maven库：http://repo2.maven.org/maven2/ 

中央仓库资源：http://mvnrepository.com/；https://search.maven.org/

将maven项目转为idea项目：mvn idea:idea

POM：Project Object Model，项目对象模型



**依赖范围**：

表：依赖范围(scope)与classpath的关系

| 依赖范围（Scope） | 编译 | 测试 | 运行 |              例子               |
| :---------------: | :--: | :--: | :--: | :-----------------------------: |
|      compile      |  Y   |  Y   |  Y   |           spring-core           |
|       test        |  –   |  Y   |  –   |              JUnit              |
|     provided      |  Y   |  Y   |  –   |           servlet-api           |
|      runtime      |  –   |  Y   |  Y   |          JDBC驱动实现           |
|      system       |  Y   |  Y   |  –   | 本地的，Maven仓库之外的类库文件 |

**maven项目构建**

**过程**：编译、测试、打包、集成测试、验证、部署



**三种生命周期**

Clean Lifecycle、Default Lifecycle、Site Lifecycle



**约束优于配置**

作用：减少修改配置的工作量，降低学习成本，给项目引入了统一规范

**SNAPSHOT**：这个版本一般用于开发过程中，表示不稳定的版本。

**LATEST**：指某个特定构件的最新发布，这个发布可能是一个发布版，也可能是一个snapshot版，具体看哪个时间最后。

**RELEASE**：是指仓库中最后的一个非快照版本

规范：

1、同一项目中所有模块版本保持一致
2、子模块统一继承父模块的版本
3、统一在顶层模块Pom的<dependencyManagement/>节中定义所有子模块的依赖版本号，子模块中添加依赖时不要添加版本号
4、开发测试阶段使用SNAPSHOT
5、生产发布使用RELEASE
6、新版本迭代只修改顶层POM中的版本



Thymeleaf



