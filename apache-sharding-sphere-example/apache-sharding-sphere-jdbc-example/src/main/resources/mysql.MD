###配置 两个主从数据库

####  主库1 master0 ip: 172.16.220.2

> 创建账户

>create user 'repl'@'172.16.220.4' identified by '123456';
grant replication slave,replication client on *.* to 'repl'@'172.16.220.4';

>create user 'repl'@'172.16.220.5' identified by '123456';
 grant replication slave,replication client on *.* to 'repl'@'172.16.220.5';

>刷新 FLUSH PRIVILEGES; 
 
 > Notes: 修改三个库的server_id
 
 
 * 从库1 master0slave0 172.16.220.4  从库2 master0slave1 172.16.220.5
 
 
 * 查看主库状态 show master status;
 * 查看从库状态 show slave status;
 * 从库建立与主库的连接
> CHANGE MASTER to master_host = '172.16.220.2' ,master_user='repl',master_password='123456', master_port=3306, master_log_file='binlog.000002',master_log_pos=156,get_master_public_key=1;
> CHANGE MASTER to master_host = '172.16.220.2' ,master_user='repl',master_password='123456', master_port=3306, master_log_file='binlog.000002',master_log_pos=156,get_master_public_key=1;
 * 重置从库状态 reset slave    (可选);
 * 启动复制 start slave;
 * 停止复制 stop slave;
 
 
 
 
 
#### 主库2 master1 ip: 172.16.220.3
 
> 创建账号

>create user 'repl'@'172.16.220.6' identified by '123456';
grant replication slave,replication client on *.* to 'repl'@'172.16.220.6';


>create user 'repl'@'172.16.220.7' identified by '123456';
  grant replication slave,replication client on *.* to 'repl'@'172.16.220.7';

>刷新 FLUSH PRIVILEGES; 
 
 * 从库1 master1slave0 172.16.220.6   从库2  master1slave1 172.16.220.7