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

	**- 创建表格**：CREATE TABLE table_name (column_name column_type);

	- AUTO_INCREMENT: 自增; ENGINE: 设置存储引擎; CHARSET: 设置编码。
	- 常见的两种InnoDB和MyISAM两种存储引擎具有以下区别：
		- InnoDB有实物操作，存储并发修改；
		- MyISAM追求快速查询，且数据修改较少；
		- 在使用权威索引方面，如果不引用第三方框架，可以选择MyISAM，但是可以选用第三方框架和InnDB效率会更高。

	

	**- 删除数据库表**：DROP TABLE table_name;

	

	**- 插入数据**：INSERT INTO table_name ( field1, field2,...fieldN ) VALUES ( value1, value2,...valueN );
	

	
	**- 查询数据**：`SELECT column_name,column_name FROM table_name [WHERE Clause] [LIMIT N] [ OFFSET M]`
	
	- LIMIT：设定返回的记录数；
		- 语法：SELECT * FROM table LIMIT [offset,] rows | rows OFFSET offset
		- LIMIT 接受一个或两个数字参数。参数为整数常量。若含有两个参数，第一个参数指定第一个返回记录行的偏移量，第二个参数指定返回记录行的最大数目。初始记录行的偏移量是 0(而不是 1)： 为了与 PostgreSQL 兼容，MySQL 也支持句法： LIMIT # OFFSET #。
	- OFFSET：指定SELECT语句开始查询的数据偏移量。默认情况下偏移量为0。
	
	
	
	**- where子句**：
	
	SELECT field1, field2,...fieldN FROM table_name1, table_name2...
	[WHERE condition1 [AND [OR]] condition2.....
	
	- MySQL的WHERE子句的字符串比较是不区分大小写的，可以使用BINARY关键字来设定WHERE子句的字符串比较来区分大小写。
	
		
	
	**- UPDATE更新**：UPDATE table_name SET field1=new-value1, field2=new-value2 [WHERE Clause]
	
	
	
	**- DELETE语句**：DELETE FROM table_name [WHERE Clause]
	
	- delete、drop、truncate的区别：
	
		- delete、truncate仅删除表数据，drop表数据和结构一起删除。
	
		- delete是DML语句，提交事务可以回滚，truncate和drop是DDL语句，操作完立刻生效。
	
		- 执行速度：drop>truncate>delete.
	
			
	
	**- LIKE子句**：SELECT field1, field2,...fieldN FROM table_name WHERE field1 LIKE condition1 [AND [OR]] filed2 = 'somevalue'
	
	- **%**：表示任意 0 个或多个字符。可匹配任意类型和长度的字符，有些情况下若是中文，请使用两个百分号（%%）表示。
	
	- **_**：表示任意单个字符。匹配单个任意字符，它常用来限制表达式的字符长度语句。
	
	- **[]**：表示括号内所列字符中的一个（类似正则表达式）。指定一个字符、字符串或范围，要求所匹配对象为它们中的任一个。
	
	- **[^]** ：表示不在括号所列之内的单个字符。其取值和 [] 相同，但它要求所匹配对象为指定字符以外的任一个字符。
	
	- 查询内容包含通配符时,由于通配符的缘故，导致我们查询特殊字符 “%”、“_”、“[” 的语句无法正常实现，而把特殊字符用 “[ ]” 括起便可正常查询。
	
		
	
	**- UNION操作符**：
	
	SELECT expression1, expression2, ... expression_n
	FROM tables
	[WHERE conditions]
	UNION [ALL | DISTINCT]
	SELECT expression1, expression2, ... expression_n
	FROM tables
	[WHERE conditions];
	
	
	
	**- 排序**：
	
	`SELECT field1, field2,...fieldN FROM table_name1, table_name2...`
	`ORDER BY field1 [ASC [DESC][默认 ASC]], [field2...] [ASC [DESC][默认 ASC]]`
	
	-  ASC升序、DESC 降序；默认升序；
	- 可以添加 WHERE...LIKE 子句来设置条件。
	
	
	
	**- 分组**：
	
	SELECT column_name, function(column_name)
	FROM table_name
	WHERE column_name operator value
	GROUP BY column_name;
	
	- WITH ROLLUP：在分组统计数据基础上再进行相同的统计（SUM,AVG,COUNT…）。
	
		
	
	**- 连接**
	
	- **INNER JOIN（内连接,或等值连接）**：获取两个表中字段匹配关系的记录。
	- **LEFT JOIN（左连接）：**获取左表所有记录，即使右表没有对应匹配的记录。
	- **RIGHT JOIN（右连接）：** 与 LEFT JOIN 相反，用于获取右表所有记录，即使左表没有对应匹配的记录。



- ### 拓展

	SQL分页：

	方案二：(利用ID大于多少和SELECT TOP分页）效率最高，需拼接SQL语句 

	方案一：(利用Not In和SELECT TOP分页) 效率次之，需拼接SQL语句 

	方案三：(利用SQL的游标存储过程分页) 效率最差，最为通用 



## 二、JDBC教程