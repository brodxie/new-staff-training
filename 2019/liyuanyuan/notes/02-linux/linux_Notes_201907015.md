## **1. 概念**

Linux继承了Unix以网络为核心的设计思想，是一个性能稳定的多用户网络操作系统。

Linux发行版：Linux内核与应用软件的包。

主要的发行版：Ubuntu、RedHat、CentOS、Debian、Fedora、SuSE、OpenSUSE、Arch Linux、SolusOS 等。

Linux是一个基于POSIX和UNIX的多用户、多任务、支持多线程和多CPU的操作系统。



## **2. 常用命令汇总**

- ### 关机

	sync: 将数据由内存同步到硬盘（重启或关闭系统前务必运行）

	shutdown -h [time]：在设定时间关机（shutdown –h now, halt, poweroff, init 0）

	shutdown -r [time]: 在设定时间重启（shutdown -r now, reboot, init 6）

	

- ### sudo

	sudo(super user do)：可以以root身份去执行一个命令，主要是辅助超级管理员完成一些超级管理员不能登录下的操作。为了保证实际生产环境的安全，root不能远程连接服务器。

	su root或su -: 普通用户切换至超级用户。超级用户拥有安装应用程序的权力。（su命令用于切换用户）

	yum -y install sudo: 安装sudo

	

- ### 网络

	cd /etc/sysconfig/network-scripts/: 网卡存放目录

	ls: 查看网卡路径的文件名称和权限信息等

	wq或wq!: 保存退出 

	systemctl restart network或service network restart: 重启服务

	

- ### 文件与目录

	ls /: 系统目录结构

	ls -a: 当前目录下所有文件

	pwd: 当前目录的绝对路径

	cd: 进入该用户的主目录、目录间的移动

	cd ./目录1/目录2：进入当前目录下的子目录

	mkdir 目录名: 创建一个目录

	rm 文件名: 删除一个文件

	rmdir 文件夹名：删除空文件夹

	rm -rf 文件夹名：删除非空文件夹

	mv 文件名 目的地文件夹：移动文件

	mv 文件名 新文件名：重命名文件

	touch a.txt: 创建文件a.txt

	cp /opt/abc /opt/git/: 复制abc到git目录下

	ln -s /opt/a.txt /opt/git/: 对文件创建软链接

	-r: 向下递归，不管有多少级目录，一并删除

	-f: 直接强行删除，不作任何提示的意思

	

	**文件基本属性：**

	ls -l: 显示文件属性以及文件所属的用户和组（或ll）,详情如下图所示。

	![](..\img\04fileAccess.png)

	chgrp ...：更改文件属组

	- chgrp [-R] 属组名 文件名
	- -R：递归更改文件属组

	chown: 更改文件属主，也可以同时更改文件属组

	- chown [–R] 属主名 文件名
		chown [-R] 属主名：属组名 文件名

	chmod: 更改文件9个属性

	- chmod [-R] xyz 文件或目录: 变更权限

		xyz : 为 rwx 属性数值的相加，r:4, w:2, x:1。

	- `chmod u[+-=][rwx],g[+-=][rwx],o[+-=][rwx]` 文件名

		a:all, u:user, g:group, o:others; +:加入, -:除去, =:设定。

		

- ### 系统信息

	who am i: 查看当前使用的终端

	uname -m: 显示机器的处理器架构

	cat /proc/version: 查看linux版本信息

	date: 系统日期

	**ifconfig: 显示或设置网卡（查ip等）**

	- 如果提示command not found，则替换为ip addr。或执行yum install net-tools即可。

	ping www.baidu.com: 测试百度与本机的连接情况（ctrl+c退出）

	cat /proc/cpuinfo: 显示CPU的信息

	top: 动态实时显示cpu、内存、进程等

	ps aux|grep firefox: 获取火狐浏览器的进程号

	kill -9 进程号：强制关闭进程

	

- ### 查看与查找

	cat 文件名：显示文件内容

	less 文件名：一页一页的显示文件内容

	tail -nf 文件名：显示文件尾n行内容

	cat filename |grep abc -A10: 查看filename中含有abc所在行前10行内容

	less a.txt|grep git: 显示关键词所在行

	locate a.txt: 在系统全局范围内查找文件名包含a.txt字样的文件

	find. -name '*.log'|grep hello: 在当前目录及子目录下查出文件名后缀为log的文件并且文件名包含了hello字样（grep用来处理字符串）

	grep -i 'HELLO' .-r -n: 在当前目录及子目录下查找文件内容中包含hello的文件并显示文件路径(-i表示忽略大小写)

	

- ### 用户和用户组

	useradd 选项 用户名：添加新用户账号

	userdel 选项 用户名：删除账号

	usermod 选项 用户名：修改账号

	pwd 选项 用户名：管理用户口令

	groupadd 选项 用户组：增加新的用户组

	groupdel 用户组：删除已有用户组

	groupmod 选项 用户组：修改用户组属性

	newgrp root: 切换用户组

	cat /etc/passwd：查看账号文件

	newusers < user.txt: 创建用户（基于user.txt文件）

	

- ### 文本与磁盘

	ls -l>file: ls -l命令结果输出到file文件中，存在则覆盖

	cat file1 >>file: cat命令结果输出追加到file文件

	vim 文件： 编辑查看文件（同vi）

	chomd -R 777 文件或目录：设置权限

	chown [-R] admin:root /opt/: 变更文件及目录的拥有者和所属组（-R递归处理所有文件和文件夹，admin为拥有者，root为所属者）

	df -h: 显示磁盘空间使用情况及挂载点

	df -h /var/log: 显示log所在分区，目录所在磁盘及可用的磁盘容量

	du -sm /var/log/* |sort -rn: 根据占用磁盘空间大小排序（MB）某目录下文件和目录大小

	fdisk -l: 查所有分区及总容量，加/dev/sda为查硬盘a的分区



- ### vi/vim

	- 三种模式：命令模式、输入模式、底线命令模式



- ### yum

	一个在Fedora和RedHat以及SUSE中的Shell前端软件包管理器。

	yum [options] [command] [package ...]

	- 1.列出所有可更新的软件清单命令：yum check-update
	-  2.更新所有软件命令：yum update
	-  3.仅安装指定的软件命令：yum install <package_name>
	-  4.仅更新指定的软件命令：yum update <package_name>
	-  5.列出所有可安裝的软件清单命令：yum list
	-  6.删除软件包命令：yum remove <package_name> 
	-  7.查找软件包 命令：`yum search <keyword>` 
	-  8.清除缓存命令: 
		- yum clean packages: 清除缓存目录下的软件包
		-  yum clean headers: 清除缓存目录下的 headers
		-  yum clean oldheaders: 清除缓存目录下旧的 headers
		-  yum clean, yum clean all (= yum clean packages; yum clean oldheaders) :清除缓存目录下的软件包及旧的headers



## **2. Linux系统启动过程**

1. 内核的引导：读入/boot下的内核文件

2. 运行init：读取配置文件/etc/initlab
   
- 运行级别：0~6
  
3. 系统初始化

4. 建立终端

5. 用户登录系统

   

## **3. 文件基本属性**

r：read，可读；w：write，可写；x：execute，可执行。



## **4. 文件与目录管理**

绝对路径：路径的写法，由根目录 / 写起，例如： /usr/share/doc 这个目录。

相对路径：路径的写法，不是由 / 写起，例如由 /usr/share/doc 要到 /usr/share/man 底下时，可以写成： cd ../man。



## **5. VMware网络配置**

常见的虚拟机软件：vmware workstations、virtual box等。

vmware的三种网络工作模式：Bridged(桥接模式，VMnet0)、NAT(网络地址转换模型, VMnet8)、Host-Only(仅主机模式, VMnet1)。

Bridged模式：将主机网卡与虚拟机虚拟的网卡利用虚拟网桥进行通信。

![](..\img\01Bridged.png)

NAT模式：利用虚拟的NAT设备以及虚拟DHCP服务器来使虚拟机连接外网，而VMware VMnet8虚拟网卡是用来与虚拟机通信的。

![](..\img\02NAT.png)

Host-Only模式：NAT模式去除了虚拟NAT设备，然后使用VMnet1虚拟网卡连接VMnet1虚拟交换机来与虚拟机通信的。

![](..\img\03Host-Only.png)

## 6.Linux下安装mysql

相关命令：

- 启动:

	`service mysqld start`

	`systemctl start mysqld.service`

- 重启

	`service mysqld restart`

- 登录

	`mysql -u root`: 直接登录mysql不需密码

- 运行状态

	`service mysqld status`

	`systemctl status mysqld.service`

- 授权其他机器登录

	`GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'mypassword' WITH GRANT OPTION;`

	`FLUCH PRIVILEGES;`

	

## 7.磁盘清理

df: 列出文件系统的整体磁盘使用量

- df [-ahikHTm] [目录或文件名]：检查文件系统的磁盘空间占用情况。

du: 检查磁盘空间使用量

- du [-ahskm] 文件或目录名称

fdisk: 用于磁盘分区

- fdisk [-l] 装置名称

mkfs: 磁盘格式化

- mkfs [-t 文件系统格式] 装置文件名

fsck: 磁盘检验

- fsck [-t 文件系统] [-ACay] 装置名称

mount: 磁盘挂载和卸除

- mount [-t 文件系统] [-L Label名] [-o 额外选项] [-n]  装置文件名  挂载点



