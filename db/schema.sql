drop table if exists `role_permission`;
drop table if exists `permission`;
drop table if exists `user_role`;
drop table if exists `role`;
drop table if exists `user`;
drop table if exists `category`;
drop table if exists `article`;
drop table if exists `comment`;

create table `permission` (
	id          int(20)      not null auto_increment
	comment 'id',
	method      char(16)     not null
	comment '请求方式',
	url         varchar(128) not null
	comment '请求url',
	description varchar(128) not null
	comment '描述',
	primary key (id)
)
	comment '权限表';

create table `role` (
	id          int(20)      not null auto_increment
	comment 'id',
	name        varchar(64)  not null
	comment '名称',
	description varchar(128) not null
	comment '描述',
	primary key `id`(id)
)
	comment '角色表';

create table `role_permission` (
	role_id       int(20)  not null
	comment '角色id',
	permission_id int(20)  not null
	comment '权限id',
	create_at     datetime not null default now()
	comment '创建时间'
)
	comment '角色权限关系表';

create table `user_role` (
	user_id   int(20)  not null
	comment '用户id',
	role_id   int(20)  not null
	comment '角色id',
	create_at datetime not null default now()
	comment '创建时间'
)
	comment '用户角色关系表';

create table `user` (
	id        int(20)     not null auto_increment
	comment 'id',
	username  varchar(64) not null
	comment '用户名',
	password  varchar(64) not null
	comment '密码',
	nickname  varchar(64) not null
	comment '昵称',
	gender    char(16)    not null
	comment '性别',
	status    char(16)    not null
	comment '用户状态（激活、删除等）',
	create_at datetime    not null default now()
	comment '创建时间',
	primary key (id)
)
	comment '用户表';


create table `category` (
	id            int(20)      not null auto_increment
	comment 'id',
	name          varchar(64)  not null
	comment '名称',
	create_at     datetime     not null default now()
	comment '创建时间',
	author_id     int(20)      not null
	comment '分类的作者',
	description   varchar(128) not null
	comment '分类的描述',
	article_count int(20)      not null default 0
	comment '分类下的文章总数',
	primary key `id`(id),
	key (author_id)
)
	comment '文章分类表';

create table `article` (
	id           int(20)      not null auto_increment
	comment 'id',
	category_id  int(20)      not null
	comment '文章分类id',
	author_id    int(20)      not null
	comment '作者id',
	title        varchar(256) not null
	comment '标题',
	content      text         not null
	comment '文章内容',
	content_type char(16)     not null
	comment '文章内容类型',
	create_at    datetime     not null default now()
	comment '创建时间',
	update_at    datetime     not null
	comment '更新时间',
	comment_count  int(20)      not null default 0
	comment '文章评论数',
	primary key (id),
	key (category_id),
	key (author_id)
)
	comment '文章表';

create table `comment` (
	id           int(20)  not null auto_increment
	comment 'id',
	article_id   int(20)  not null
	comment '文章id',
	author_id    int(20)  not null
	comment '作者id',
	parent_id    int(20)           default null
	comment '父评论',
	content      text     not null
	comment '文章内容',
	content_type char(16) not null
	comment '文章内容类型',
	create_at    datetime not null default now()
	comment '创建时间',
	update_at    datetime not null
	comment '更新时间',
	floor_num int(20) not null
	comment '楼层',
	primary key (id),
	key (parent_id),
	key (author_id)
)
	comment '文章表';