**系统功能**

帖子查看：
查看帖子列表 可以查看帖子详情，显示每一楼

帖子操作：
管理员可以删除帖子，每个人可以删除自己发的帖子

用户管理：
超级管理员可以添加用户，可以设置用户为管理员


## 一、数据库

帖子表：tbl_post_info(**post_id**, post_title, post_content, user_id, create_time, update_time)

跟帖表：tbl_post_detail(**detail_id**, post_id, detail_title, detail_content, create_time, update_time)

用户表：tbl_user_info(**user_id**, user_name, password, type_id, create_time, update_time)

user_id, not null, user_name, not null, type_id, not null, default=3(普通用户)

用户类型表：tbl_user_type(**type_id**, power_id_list, user_type, create_time, update_time)

用户权限表：tbl_power_info(**power_id**, power_titile, create_time, update_time)



## 二、功能页面

帖子列表页：帖子标题、用户名、发布时间、更新时间

跟帖详情页：详情ID、跟帖标题、跟帖内容、用户名、发布时间、更新时间

用户权限页：用户ID、用户名、用户类型

用户类型：普通用户（删除个人帖子）、管理员（删除帖子）、超级管理员（添加用户）