**ϵͳ����**

���Ӳ鿴��
�鿴�����б� ���Բ鿴�������飬��ʾÿһ¥

���Ӳ�����
����Ա����ɾ�����ӣ�ÿ���˿���ɾ���Լ���������

�û�����
��������Ա��������û������������û�Ϊ����Ա


## һ�����ݿ�

���ӱ�tbl_post_info(**post_id**, post_title, post_content, user_id, create_time, update_time)

������tbl_post_detail(**detail_id**, post_id, detail_title, detail_content, create_time, update_time)

�û���tbl_user_info(**user_id**, user_name, password, type_id, create_time, update_time)

user_id, not null, user_name, not null, type_id, not null, default=3(��ͨ�û�)

�û����ͱ�tbl_user_type(**type_id**, power_id_list, user_type, create_time, update_time)

�û�Ȩ�ޱ�tbl_power_info(**power_id**, power_titile, create_time, update_time)



## ��������ҳ��

�����б�ҳ�����ӱ��⡢�û���������ʱ�䡢����ʱ��

��������ҳ������ID���������⡢�������ݡ��û���������ʱ�䡢����ʱ��

�û�Ȩ��ҳ���û�ID���û������û�����

�û����ͣ���ͨ�û���ɾ���������ӣ�������Ա��ɾ�����ӣ�����������Ա������û���