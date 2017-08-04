drop table if exists discuss;
create table discuss(
  id BIGINT(20) NOT NULL AUTO_INCREMENT ,
  founder_id BIGINT(20) DEFAULT NULL ,
  create_time datetime DEFAULT NULL ,
  content VARCHAR(255) DEFAULT NULL ,
  task_id BIGINT(20) DEFAULT NULL ,
  PRIMARY KEY (id),
  CONSTRAINT fk_task_id FOREIGN KEY discuss(task_id) REFERENCES task(id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8


