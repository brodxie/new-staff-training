create table t_user (
  id          bigint primary key,
  username    varchar(255),
  password    varchar(255),
  name        varchar(255),
  email       varchar(255),
  mobile      varchar(255),
  status      tinyint,
  create_time bigint,
  modify_time bigint
);