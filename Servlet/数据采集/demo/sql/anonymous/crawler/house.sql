create table house
(
    id       int auto_increment
        primary key,
    city     varchar(50)  not null,
    img      varchar(255) not null,
    title    varchar(255) not null,
    price    varchar(50)  not null,
    location varchar(255) not null,
    img_url  varchar(255) null
);

