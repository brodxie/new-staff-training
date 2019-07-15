**1. 概念**

Linux继承了Unix以网络为核心的设计思想，是一个性能稳定的多用户网络操作系统。

Linux发行版：Linux内核与应用软件的包。

主要的发行版：Ubuntu、RedHat、CentOS、Debian、Fedora、SuSE、OpenSUSE、Arch Linux、SolusOS 等。



**2. Linux系统启动过程**

1. 内核的引导：读入/boot下的内核文件
2. 运行init：读取配置文件/etc/initlab
   - 运行级别：0~6
3. 系统初始化
4. 建立终端
5. 用户登录系统



**3. 文件基本属性**

r：read，可读；w：write，可写；x：execute，可执行。



**4. 文件与目录管理**

绝对路径：路径的写法，由根目录 / 写起，例如： /usr/share/doc 这个目录。

相对路径：路径的写法，不是由 / 写起，例如由 /usr/share/doc 要到 /usr/share/man 底下时，可以写成： cd ../man。



**5. 命令汇总**

- sudo

sudo(super user do)：可以以root身份去执行一个命令，主要是辅助超级管理员完成一些超级管理员不能登录下的操作。为了保证实际生产环境的安全，root不能远程连接服务器。

su root或su -: 普通用户切换至超级用户。超级用户拥有安装应用程序的权力。（su命令用于切换用户）

yum -y install sudo: 安装sudo



- 联网

cd /etc/sysconfig/network-scripts/: 网卡存放目录

ls: 查看网卡路径的文件名称和权限信息等

wq或wq!: 保存退出 

systemctl restart network或service network restart: 重启服务







