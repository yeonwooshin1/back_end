# 실습2
-- 1.
drop database if exists ex2;
create database ex2;
use ex2;
create table members(
	member_id varchar(20) not Null ,
    member_name varchar(50) not Null, 
    email varchar(100) unique ,
    join_date datetime default now() ,
    points int default 0 ,
    constraint primary key(member_id) 
);

-- 2.
insert into members( member_id , member_name , email , points ) values( 'user01' , '김철수' , 'chulsoo@example.com' , 1000 );	

-- 3.
select member_id , email from members;

-- 4.
set SQL_SAFE_UPDATES = 0;	# safe mode 끄기 , 반대로 1 켜기 

update members set points = 1500 where member_id ='user01';

-- 5.
delete from members where member_id = 'user01';

-- 6.
create table products (
	product_code int auto_increment ,
    product_name varchar(100) not Null, 
    price int unsigned not Null ,
    stock_quantity int not Null default 0 ,
    category varchar(50) ,
    constraint primary key(product_code) 
);

-- 7.
insert into products( product_name , price , stock_quantity ) values( '프리미엄 키보드' , 120000 , 50 );

-- 8.

select * from products where category = '컴퓨터 주변기기'; 

-- 9.
update products set stock_quantity = 45 where product_name ='프리미엄 키보드';

-- 10.
delete from products where product_name = '프리미엄 키보드';	#  product_name : '프리미엄 키보드' 와 같은 레코드 삭제 




