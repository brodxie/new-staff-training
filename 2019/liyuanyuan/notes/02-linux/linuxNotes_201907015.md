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



**5. VMware网络配置**

常见的虚拟机软件：vmware workstations、virtual box等。

vmware的三种网络工作模式：Bridged(桥接模式，VMnet0)、NAT(网络地址转换模型, VMnet8)、Host-Only(仅主机模式, VMnet1)。

Bridged模式：将主机网卡与虚拟机虚拟的网卡利用虚拟网桥进行通信。

![](..\img\01Bridged.png)

NAT模式：利用虚拟的NAT设备以及虚拟DHCP服务器来使虚拟机连接外网，而VMware VMnet8虚拟网卡是用来与虚拟机通信的。

![](..\img\02NAT.png)

Host-Only模式：NAT模式去除了虚拟NAT设备，然后使用VMnet1虚拟网卡连接VMnet1虚拟交换机来与虚拟机通信的。

![](..\img\03Host-Only.png)

**附1. 常用命令汇总**

- sudo

  sudo(super user do)：可以以root身份去执行一个命令，主要是辅助超级管理员完成一些超级管理员不能登录下的操作。为了保证实际生产环境的安全，root不能远程连接服务器。

  su root或su -: 普通用户切换至超级用户。超级用户拥有安装应用程序的权力。（su命令用于切换用户）

  yum -y install sudo: 安装sudo

  

- 联网

  cd /etc/sysconfig/network-scripts/: 网卡存放目录

  ls: 查看网卡路径的文件名称和权限信息等

  wq或wq!: 保存退出 

  systemctl restart network或service network restart: 重启服务

  

- 文件与目录

  ls -a: 当前目录下所有文件

  ls -l: 当前目录下文件详情

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
  
  


- 系统信息

  who am i: 查看当前使用的终端

  uname -m: 显示机器的处理器架构

  cat /proc/version: 查看linux版本信息

  date: 系统日期

  **ifconfig: 显示或设置网卡（查ip等）**

  - 如果提示command not found，则替换为ip addr。或执行yum install net-tools即可。

  ping www.baidu.com: 测试百度与本机的连接情况 **// 无法退出？**

  cat /proc/cpuinfo: 显示CPU的信息

  top: 动态实时显示cpu、内存、进程等

  ps aux|grep firefox: 获取火狐浏览器的进程号

  kill -9 进程号：强制关闭进程

  

- 查看与查找

  cat 文件名：显示文件内容

  less 文件名：一页一页的显示文件内容

  tail -nf 文件名：显示文件尾n行内容

  cat filename |grep abc -A10: 查看filename中含有abc所在行前10行内容

  less a.txt|grep git: 显示关键词所在行
  
  locate a.txt: 在系统全局范围内查找文件名包含a.txt字样的文件
  
  find. -name '*.log'|grep hello: 在当前目录及子目录下查出文件名后缀为log的文件并且文件名包含了hello字样（grep用来处理字符串）
  
  grep -i 'HELLO' .-r -n: 在当前目录及子目录下查找文件内容中包含hello的文件并显示文件路径(-i表示忽略大小写)
  
  
  
- 文本与磁盘

	ls -l>file: ls -l命令结果输出到file文件中，存在则覆盖

	cat file1 >>file: cat命令结果输出追加到file文件

	vim 文件： 编辑查看文件（同vi）

	chomd -R 777 文件或目录：设置权限

	chown [-R] admin:root /opt/: 变更文件及目录的拥有者和所属组（-R递归处理所有文件和文件夹，admin为拥有者，root为所属者）

	df -h: 显示磁盘空间使用情况及挂载点

	df -h /var/log: 显示log所在分区，目录所在磁盘及可用的磁盘容量

	du -sm /var/log/* |sort -rn: 根据占用磁盘空间大小排序（MB）某目录下文件和目录大小

	fdisk -l: 查所有分区及总容量，加/dev/sda为查硬盘a的分区

	

	

	

	

	

	












