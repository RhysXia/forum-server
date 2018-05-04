drop table if exists `role_permission`;
drop table if exists `permission`;
drop table if exists `user`;
drop table if exists `user_role`;

create table `permission`(
	id int(20) not null auto_increment comment 'id',
	method char(16) not null comment '请求方式',
	url varchar(128) not null comment '请求url',
	description varchar(128) not null comment '描述',
	primary key `id`(id)
) comment '权限表';

create table `role`(
	id int(20) not null auto_increment comment 'id',
	name varchar(64) not null comment '名称',
	description varchar(128) not null comment '描述',
	primary key `id`(id)
) comment '角色表';

create table `role_permission`(
	role_id int(20) not null comment '角色id',
	permission_id int(20) not null comment '权限id',
	create_at timestamp not null default now() comment '创建时间'
) comment '角色权限关系表';

create table `user_role` (
	user_id int(20) not null comment '用户id',
	role_id int(20) not null comment '角色id',
	create_at timestamp not null default now() comment '创建时间'
) comment '用户角色关系表';

create table `user`(
	id int(20) not null auto_increment comment 'id',
	username varchar(64) not null comment '用户名',
	password varchar(64) not null comment '密码',
	gender char(16) not null comment '性别',
	status char(16) not null comment '用户状态（激活、删除等）',
	primary key `id`(id)
) comment '用户表';