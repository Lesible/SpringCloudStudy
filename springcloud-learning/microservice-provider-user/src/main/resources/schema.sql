drop table if exists user;
create table user
(
    id       bigint,
    username varchar(30),
    name     varchar(50),
    gender   tinyint(1),
    age      int(3),
    primary key (id)
);