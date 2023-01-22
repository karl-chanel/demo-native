create table if not exists tb_user
(
    USER_ID      int not null primary key auto_increment,
    USER_NAME    varchar(100),
    USER_ADDRESS varchar(100) DEFAULT 'anhui',
    USER_PHONE   varchar(100) DEFAULT '17682893539',
    USER_DATE    timestamp    DEFAULT now()
);