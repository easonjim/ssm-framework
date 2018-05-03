create schema `ssm_framework` default character set utf8 collate utf8_bin ;

use ssm_framework;

drop table if exists `sys_user`;
create table `sys_user` (
  `id` bigint(11) not null auto_increment,
  `user_name` varchar(255) default null comment '用户名',
  `user_phone` varchar(20) default null comment '手机号',
  `user_email` varchar(255) default null comment '邮箱地址',
  `user_pwd` varchar(32) default null comment '加盐后用户密码',
  `user_sex` tinyint(4) default null comment '性别',
  `create_time` datetime default null comment '创建时间',
  `modify_time` datetime default null comment '最后修改时间',
  `is_delete` tinyint(4) default null comment '是否删除，0-未删除；1-已删除',
  primary key (`id`)
) engine=innodb auto_increment=560 default charset=utf8 comment='用户表';
