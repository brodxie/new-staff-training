## 一、HTTP

HTTP协议（HyperText Transfer Protocol，超文本传输协议），用于从万维网（WWW:World Wide Web ）服务器传输超文本到本地浏览器的传送协议，所有的WWW文件都必须遵守这个标准。

特点：无连接、媒体独立、无状态。



消息结构：

​		客户端请求消息格式：请求行、请求头部、空行、请求数据。

​		服务器响应消息格式：状态行、消息报头、空行、响应正文。



请求方法：

​		HTTP1.0定义了三种：GET, POST 和 HEAD。

​		HTTP1.1 新增了六种：OPTIONS、PUT、PATCH、DELETE、TRACE 和 CONNECT。



响应头：

​		Allow、Content-Encoding、Content-Length 、Content-Type、Date 、Expires、Last-Modified、Location、Refresh、Server、Set-Cookie、WWW-Authenticate。



状态码：

​		常见状态码：200(请求成功)，301(资源被永久转移到其他URL)，404(请求的资源不存在)，500(内部服务器错误)。

​		分类：状态码由三个十进制数字组成，第一个数字定义了状态码的类型，后两个数字没有分类的作用。

​		1**：信息，服务器收到请求，需要请求者继续执行操作；

​		2**：成功，操作被成功接收并处理；

​		3**：重定向，需要进一步的操作以完成请求；

​		4**：客户端错误，请求包含语法错误或无法完成请求；

​		5**：服务器错误，服务器在处理请求的过程中发生了错误。



Content-type：

​		定义网络文件的类型和网页的编码。



## 二、tomcat

主要作用：在网络环境提供外界可访问的资源。

包括静态资源（html, css, javascript…)、动态资源(servlet, JSP…)两种。

常用的web服务器软件：WebLogic, WebSphere, Jboss, tomcat.



## 三、servlet

servlet: 服务器端的小应用程序,可以通过 HTTP协议接收和响应来自 Web 客户端的请求。

生命周期: 实例化、初始化、服务、销毁。

特征：单例多线程

ServletConfig接口：对当前 Servlet类的配置信息。

ServletContext接口：Web应用中所有 Servlet 在 Web 容器中的一些数据信息。包含了 web.xml 文件中的配置信息，以及当前应用中所有Servlet可以共享的数据。



## 四、JSP

JSP: Java Server Pages，一种动态网页技术，JSP其实就是在html中插入了java代码和JSP标签之后形成的文件，文件名以.jsp结尾。其实JSP就是一个servlet。



工作流程：

JSP文件——>.java文件——>.class文件

在tomcat内部有一个翻译引擎，当JSP页面**第一次**被访问时由翻译引擎转换为.java文件并编译出.class文件。之后再运行该class文件。
在JSP中的html代码都会翻译到servlet中的out.write()中。



注释：

html注释：<!-- -->

JSP注释：<%-- --%>



Java相关的标签：

<% %>：嵌入Java代码

<%! %>：声明方法或静态代码块等内容

<%= %>：在JSP中输出变量、常量等



9个内置对象：pageContext，request,session,application,response,config,out,page,exception。



指令：

三类指令：页面指令page, 包含指令include, 标签库指令taglib

语法格式：<%@ 指令名称  属性名=属性值 ... %>



常用标签：

语法格式：

`<jsp:标签名称 属性名=属性值 ... ></jsp:标签名称>`

或<jsp:标签名称 属性名=属性值 ... />

< jsp:forward>：把请求转发给另外一个资源（在jsp标签中没有用于重定向的标签）。

< jsp:include>：另外一个文件引入到当前JSP里面，这种引入方式叫做动态引入。



静态引入：

<%@ include file="/xxx.jsp" %>

静态引入会生成一个java文件，两个jsp文件中可以共享同一个变量，但不能定义重名的变量。

动态引入：

<jsp:include page="/xxx.jsp"/>

动态引入会生成两个java文件，两个jsp文件中不可以共享同一个变量，可以定义重名的变量。

在静态引入与动态引入均可使用时，一般使用静态引入。因为在程序运行时只存在一个Servlet，对资源的消耗较少，且不存在调用问题，执行效率较高。