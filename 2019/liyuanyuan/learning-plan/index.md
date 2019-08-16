## 前言
培训的一些资料会放在百度网盘中：
>链接：https://pan.baidu.com/s/18Nc1VRh8scory0ZU70KxdQ  
>提取码：05z1 


## Java语言 2W
- [monkey1024教程](http://www.monkey1024.com/javaseroute)  
- Java核心技术卷I：ch1~ch9、ch14  
- Java核心技术卷II：ch1、2、6、7  
- 注解的使用（Java8编程参考：12.4）  

IDE使用IDEA。
基本的知识脉络按照JAVA核心技术中列出的章节，同时可以参考JAVA8变成参考中相关的章节。使用markdown记录相关的笔记（[markdown教程](https://www.jianshu.com/p/335db5716248  "markdown教程")）


## Linux基础 3D
- VMware下CentOS安装  
  [VMware下载地址](https://my.vmware.com/cn/web/vmware/info/slug/desktop_end_user_computing/vmware_workstation_pro/15_0)  
  CentOS镜像可以到[163源](http://mirrors.163.com/)下载  
  SSH工具使用[XShell](https://www.netsarang.com/zh/xshell/), 安装包见百度网盘链接中
- Linux基本操作  
  参考[菜鸟教程](https://www.runoob.com/linux/linux-tutorial.html)  
  深入了解可以参考网盘分享的电子书  

## Mysql+JDBC 1W
- Linux下安装、配置与管理  
  先安装5.7版本  
  参考网上[教程](https://www.cnblogs.com/nicknailo/articles/8563737.html)  
- SQL  
  https://www.runoob.com/mysql/mysql-tutorial.html  
  数据库事务（https://www.runoob.com/mysql/mysql-transaction.html）  
- JDBC  
  参见Java核心技术一书

## TOMCAT+Servlet+JSP 1W
- HTTP协议  
  了解HTTP协议：https://www.runoob.com/http/http-tutorial.html
- TOMCAT安装配置使用  
  [monkey1024web教程](http://www.monkey1024.com/javawebroute) 
- Servlet
- JSP
- 使用JSP+Servlet+JSP+JDBC实现一个简单的贴吧系统
  可以查看帖子列表
  可以查看帖子详情，显示每一楼
  设置一个超级管理员，超级管理员可以添加用户，可以设置用户为管理员
  管理员可以删除帖子，每个人可以删除自己发的帖子
  

## Ajax+JSON 2D

## Maven学习
学习基本的maven知识，参考电子书maven3.0.4学习教程一书

## SpringBoot+SpringMVC+MyBatis 3W
参照《深入浅出SpringBoot2.x》一书进行学习。  
学习第1、2、3、5（整合mybatis）、6（简单了解，知道事务的概念，知道@Transactional注解的使用）、9、10、11、12、15 
具体项目示例可以参考https://github.com/brodxie/xieyu-security  
mybatis深入学习参考http://www.mybatis.org/mybatis-3/zh/sqlmap-xml.html  
完成模拟百度贴吧系统的开发(SpringBoot,SpringMVC,MyBatis,MySQL,页面使用thymeleaf+bootstrap+jquery)  
只有一个论坛、可以用户注册，注销，发帖，跟帖  
管理员界面、系统有个初始管理员（admin），可以进入管理平台，可以添加管理员，管理员可以删帖，可以封人 
部署到linux上  
步骤：  
1. 功能、设计页面（原型）
2. 设计数据库表结构（Navicat）
3. 设计接口（http://www.xiaoyaoji.cn）
4. 搭建框架（maven多模块项目，提交到github上）



