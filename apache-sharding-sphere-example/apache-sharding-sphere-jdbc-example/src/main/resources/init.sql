create database if not exists `test`;

create table if not exists `sys_user0`
(
    id       bigint unsigned auto_increment comment 'id',
    username varchar(20) not null comment 'username',
    password varchar(32) not null comment 'password',
    pwd_salt varchar(10) not null comment 'salt',
    created  datetime    not null default current_timestamp() comment 'create time',
    primary key (id)
);

create table if not exists `sys_user1`
(
    id       bigint unsigned auto_increment comment 'id',
    username varchar(20) not null comment 'username',
    password varchar(32) not null comment 'password',
    pwd_salt varchar(10) not null comment 'salt',
    created  datetime    not null default current_timestamp() comment 'create time',
    primary key (id)
);