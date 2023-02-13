drop table if exists t_user;
create table t_user
(
    id       integer      not null auto_increment,
    username varchar(100) not null,
    password varchar(200) not null,
    primary key (id)
);