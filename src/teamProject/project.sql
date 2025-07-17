
drop database if exists libraryService;  -- libraryService 있으면 삭제 // 기존 삭제
create database libraryService;        	 -- libraryService 데이터베이스 생성 
use libraryService;                  	 -- libraryService 데이터베이스 활성화 

create table member(					--  [1] 도서관 회원 리스트
	memberNo int auto_increment ,			-- memberNo // 회원 리스트
    memberId varchar(20) not null unique, 	-- 글자수20제한, 공백없음, 중복없음
    memberPwd varchar(30) not null, 		-- 글자수30제한, 공백없음
    memberTel varchar(11) not null, 		-- 글자수11제한, 공백없음
    memberName varchar(10) not null , 		-- 글자수10제한, 공백없음
    constraint primary key ( memberNo )		-- // 식별키 만들기
);
select * from member;						-- 확인차 도서관회원 조회

create table bookInfo(                  	-- [2] 도서정보 테이블
	bookNo int auto_increment ,            -- 도서정보번호 : 정수 타입 , 자동번호부여 , PK로 사용 예정
	bookName varchar(10) not null   ,         -- 도서명 : 문자최대 10 타입 , 공백x , 도서명도 중복가능으로 일단 설정
	bookAuthor varchar(10) not null   ,          -- 도서저자 : 문자최대 10 타입 , 공백x , 저자 중복가능
    constraint primary key( bookNo )       -- 위에서 선언된 '도서번호(bno)'속성을 *PK필드로 설정
);
select * from bookInfo;                 	 -- 확인차 도서정보테이블 조회.


create table bookList (                  		-- [3] 도서목록테이블 
	bookLog int auto_increment ,				-- 도서목록로그번호
    remark int not null  ,             			-- 책 상태 비고
    constraint primary key( bookLog ) ,			-- 도서목록로그번호 PK
	bookNo int ,                        		-- 도서정보번호 : *FK사용할 예정 --> PK필드 타입과 일치 
    constraint foreign key( bookNo ) references bookinfo( bookNo )	-- FK하기
   
);
select * from bookList;                  -- 확인차 도서목록리스트 조회

create table lendingStatus(                		-- [4] 도서대출현황 테이블 
	loanLog int auto_increment ,				-- 도서대출 로그 번호
    loanDate datetime default now() ,           -- 게시물작성일 : 날짜/시간 , 기본값 , now() : 현재 날짜/시간 반환함수
    dueDate datetime ,         					-- 게시물작성일 : 날짜/시간 , 기본값 , now() : 현재 날짜/시간 반환함수
    constraint primary key( loanLog ) ,			-- 도서대출 로그 식별키
    bookLog int ,								-- 도서목록로그 : *FK사용할 예정 --> PK필드 타입과 일치 
    memberNo int ,								-- 회원목록 : *FK사용할 예정 --> PK필드 타입과 일치 
    constraint foreign key( bookLog ) references bookList( bookLog ) ,	-- FK 사용
    constraint foreign key( memberNo ) references member( memberNo ) 	-- FK 사용
);
select * from lendingStatus;					-- 확인차 도서대출로그 조회