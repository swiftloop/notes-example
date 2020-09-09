###例子

* 使用mybatis-plus
* 使用druid
* 分库分表
* 数据治理
* 数据脱敏


###d环境

> docker run -d --name master-mysql -e MYSQL_ROOT_PASSWORD=root -p 3301:3306 mysql

>docker run -d --name slave-mysql -e MYSQL_ROOT_PASSWORD=root -p 3302:3306 mysql

>docker run -d --name slave-mysql -e MYSQL_ROOT_PASSWORD=root -p 3303:3306 mysql

### 主从

* 前提 主机需要开启log-bin 并且两台机子的 server_id 不能是一样

* 主机执行
> create user 'repl'@'172.17.0.3' identified by '123456';
>create user 'repl'@'172.17.0.4' identified by '123456';

> grant replication slave,replication client on *.* to 'repl'@'172.17.0.3';
>grant replication slave,replication client on *.* to 'repl'@'172.17.0.4';
* 查看主机log-bin
> show master status;
* 从机执行 get_master_public_key=1  解决在mysql 8.0 的验证密码错误导致的主从复制失败

> CHANGE MASTER to master_host = '172.17.0.2' ,master_user='repl',master_password='123456', master_port=3306, master_log_file='binlog.000002',master_log_pos=1228,get_master_public_key=1;
> CHANGE MASTER to master_host = '172.17.0.2' ,master_user='repl',master_password='123456', master_port=3306, master_log_file='binlog.000002',master_log_pos=14030,get_master_public_key=1;