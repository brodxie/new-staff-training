## 一、MySQL教程

- ### **概念**

	- MySQL是最流行的关系型数据库管理系统，在WEB应用方面MySQL是最好的RDBMS应用软件之一。

	- 术语：

		- **复合键**：复合键（组合键）将多个列作为一个索引键，一般用于复合索引。
		- **索引：**使用索引可快速访问数据库表中的特定信息。索引是对数据库表中一列或多列的值进行排序的一种结构。类似于书籍的目录。
		- **参照完整性:** 参照的完整性要求关系中不允许引用不存在的实体。与实体完整性是关系模型必须满足的完整性约束条件，目的是保证数据的一致性。

	- 特性：

		- 使用标准SQL数据语言形式；

		- 开源。可定制，采用了GPL协议，可修改源码开发自己的MySQL系统；
		- 可运行多个系统上，支持C\C ++\Python\Java\Perl\PHP\Eiffel\Ruby\TCL等多种编程语言；

		- 支持大型数据库，支持 5000 万条记录的数据仓库，32 位系统表文件最大可支持 4GB，64 位系统支持最大的表文件为8TB。

			

- ### 管理

	|      |          Windows           |              Linux               |
	| :--: | :------------------------: | :------------------------------: |
	| 启动 |      mysqld --console      |         ./mysqld_safe &          |
	| 关闭 | mysqladmin -uroot shutdown | ./mysqladmin -u root -p shutdown |




- ### sql语句

	① 创建表格：CREATE TABLE table_name (column_name column_type);

	- AUTO_INCREMENT: 自增; ENGINE: 设置存储引擎; CHARSET: 设置编码。
	- 常见的两种InnoDB和MyISAM两种存储引擎具有以下区别：
		- InnoDB有实物操作，存储并发修改；
		- MyISAM追求快速查询，且数据修改较少；
		- 在使用权威索引方面，如果不引用第三方框架，可以选择MyISAM，但是可以选用第三方框架和InnDB效率会更高。

	② 删除数据库表：DROP TABLE table_name;

	③ 插入数据：INSERT INTO table_name ( field1, field2,...fieldN ) VALUES ( value1, value2,...valueN );

	④ 查询数据：`SELECT column_name,column_name FROM table_name [WHERE Clause] [LIMIT N] [ OFFSET M]`

	- LIMIT：设定返回的记录数；
	- OFFSET：指定SELECT语句开始查询的数据偏移量。默认情况下偏移量为0。

	

## 二、JDBC教程