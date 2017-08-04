drop table if exists user;
create table user(
	id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	username varchar(255) DEFAULT NULL COMMENT '用户名',
	email varchar(255) DEFAULT NULL COMMENT '邮箱',
	phone varchar(255) DEFAULT NULL COMMENT '电话',
	password varchar(255) DEFAULT NULL COMMENT '密码',
	last_login_time datetime DEFAULT NULL,
	role varchar(255) DEFAULT NULL COMMENT '角色',
	PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8