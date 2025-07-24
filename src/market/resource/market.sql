drop database if exists marketDB;
create database marketDB;
use marketDB;


create table product( # 글 정보 테이블
        pNo int auto_increment ,
        pSeller varchar(30) not null ,
        pName varchar (20) not null ,
        pContent longtext not null ,
        pPrice int not null ,
        pPassword  varchar(30) not null ,
        pDate datetime default now() ,
        pStatus int not null default 1 ,
        constraint  primary key( pNo ) 
);

create table inquiry (        # 익명 문의 테이블
	iNo int auto_increment,
    pNo int not null,
    iName varchar (20) not null ,
    iContent longtext not null ,
    iPassword varchar(30) not null ,
    iDate datetime default now() ,
    constraint primary key( iNo ) ,
    constraint foreign key( pNo ) references product( pNo ) on delete cascade
);

INSERT INTO product (pseller, pname, pcontent, pprice, ppassword, pstatus)
VALUES 
('연우연어', '밥솥', '밥은 먹고 살자', 1000, '1234', 1),
('연우연어', '에어팟', '공기가 들어간 팟', 200000, '5678', 2),
('나는소정', '선풍기', '여름엔 필수지', 30000, '9999', 1),
('철수맨', '자전거', '산도 잘 타요!', 80000, 'bike123', 1),
('영희냥', '책상', '공부할 맛 나는 책상', 45000, 'deskpass', 2),
('김코딩', '노트북', '코딩용으로 딱', 500000, 'code999', 1),
('박해커', '스마트워치', '심박수 잘 찍힘', 75000, 'watchman', 2),
('최백수', '마우스', '왼쪽 클릭 잘 됨', 5000, 'mouse1', 1),
('정프로', '키보드', '갈축입니다', 30000, 'kb1234', 1),
('홍디자이너', '모니터', '광시야각 최고', 120000, 'design!', 2);

INSERT INTO inquiry (pno, iname, icontent, ipassword)
VALUES
(1, '나는소정', '너무 싸요 사기 아닌가요?', '1111'),
(1, '익명', '정상 작동하나요?', '1233'),
(2, '호기심천국', '정품 맞나요?', 'aaaa'),
(2, '익명', '이어팁 포함인가요?', 'bbbb'),
(3, '무더위킬러', '에너지 효율 등급은?', 'c123'),
(4, '산악마', '타이어 상태 어때요?', '8888'),
(5, '책벌레', '의자는 포함인가요?', 'book1'),
(6, '프로그래머', '배터리 수명 괜찮나요?', 'dev123'),
(7, '운동왕', '운동할 때 좋을까요?', '9999'),
(9, '익명', '기계식인가요?', 'qwerty');
select * from product;

