create table if not exists items
(
    id         bigint auto_increment
        constraint `PRIMARY`
        primary key,
    name       varchar(50)  null,
    price      decimal      null,
    pic        varchar(300) null,
    createtime datetime     null,
    detail     varchar(300) null
);

