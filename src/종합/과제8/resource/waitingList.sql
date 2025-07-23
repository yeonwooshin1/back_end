drop database if exists waitingList;
create database waitingList;
use waitingList;
create table list(
    phone varchar(30) not null ,
    count int not null ,
    seq int auto_increment ,
	constraint primary key(seq)
);
select * from list;