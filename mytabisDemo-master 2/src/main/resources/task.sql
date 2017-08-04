drop table if exists task;
create table task(
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  publisher_id bigint(20) DEFAULT NULL ,
  create_time datetime DEFAULT NULL ,
  close_time datetime DEFAULT NULL,
  content VARCHAR(255) DEFAULT NULL ,
  accepter_id BIGINT(20) DEFAULT NULL ,
  is_accept BOOLEAN DEFAULT FALSE ,
  is_accomplish_publisher  BOOLEAN DEFAULT FALSE,
  is_accomplish_accepter BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (id),
  CONSTRAINT fk_publisher_id FOREIGN KEY task(publisher_id) REFERENCES user(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8
