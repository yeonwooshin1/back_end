# 데이터베이스 조작어 
# 1. 데이터베이스 생성 
drop database if exists mydb0716;
create database mydb0716;
use mydb0716;
# 2. 테이블 생성 
create table test(
	mno int auto_increment , # 속성명 타입 제약조건
    mname varchar(30) not null unique , # 속성명 타입 제약조건1 제약조건2
    mcount int default 2 , 	 # 속성명 타입 제약조건 
    constraint primary key(mno) # 식별키 설정 # 만약에 속성명 뒤에 ,(쉼표)생략
);
# [*] DML : 데이터베이스 조작어 
# 1.insert 	2.select  3.update 	4.delete 
#  [C:저장]	 [R:조회]		[U:수정]	  [D:삭제] 

# [1] INSERT : 레코드 삽입 , *레코드란? 테이블내 행(가로) 단위 의 데이터들 , 1레코드 vs 1행 vs 1줄
# 주의할점 : 테이블내 데이터 삽입시 레코드 단위 , 한칸한칸에 데이터삽입이 아닌 줄/행/레코드 단위 삽입
# (1) insert into 테이블명( 속성명1 , 속성명2 ) values( 값1 , 값2 );
insert into test( mno , mname , mcount ) values( 1 , "유재석" , 30 );		# ;(세미콜론) 마침
# 작성한 속성명 에 대응하는 값 삽입한다. 
insert into test( mcount ,  mno , mname ) values( 40 , 2 , "강호동" ); 	# ctrl+enter 실행 
# (2) auto_increment 제약조건의 속성은 값 생략할경우 자동번호(1씩증가된) 할당	 
insert into test( mcount , mname ) values ( 50 , "신동엽" );
# (3) default 제약조건의 속성은 값 생략할경우 정의된 기본값이 할당 				
insert into test( mname ) value ( "서장훈" );
# (4) not null 제약조건의 속성은 값이 꼭 삽입해야한다. Error Code: 1364. Field 'mname' doesn't have a default value
# insert into test( mno , mcount ) value( 5 , 40 );
# (5) unique 제약조건의 속성은 중복값일 경우 삽입 불가능. Error Code: 1062. Duplicate entry '유재석' for key 'test.mname'	0.000 sec
# insert into test( mname ) values ("유재석");
# (6) 모든 속성명을 순서대로 작성할 경우는 속성명 생략 가능하다.
insert into test values( 5 , "하하" , 10 );
# (7) 하나의 insert 에서 여러개 레코드 삽입할경우 , values( ) , ( ) , ( );
insert into test values( 6 , "박명수" , 50 ) , ( 7 , "박명수2" , 60 );
select * from test; # 확인차 조회 

# [2] SELECT : 레코드 조회 
# 주의할점 : 조회 결과는 기존 테이블과 상관 없다. select만 result table 존재한다. 조회 결과는 항상 테이블/표
# (1) select * from 테이블명 : 전체속성(*) 의 모든레코드 조회 
select * from test;
# (2) select 속성명1 , 속성명2 from 테이블명 : 특정 속성의 모든레코드 조회 
select mname from test;	# 이름 속성만 조회 
select mname , mcount , mno from test;
# (3) select 속성명 from 테이블명 where 조건절;
# 'test' 테이블에서 'manme'속성 값이 '유재석' 과 같은 레코드를 조회 
select * from test where mname = "유재석"; # =(대입이아닌 같다라는 뜻)
select * from test where mno = 3;	# 'mno'속성 값이 3 과 같은 레코드 조회 

# [3] UPDATE : 레코드 수정 
# mysqlWorkbench 에서는 수정/삭제를 safeMode 이므로 불가능 
# safeMode 해제 : set SQL_SAFE_UPDATES = 0 
set SQL_SAFE_UPDATES = 0;	# safe mode 끄기 , 반대로 1 켜기 

# 1. update 테이블명 set 속성명 = 값;				: 전체 레코드의 속성값 수정
update test set mcount = 0;  
# 2. update 테이블명 set 속성명 = 값 where 조건절; 	: 조건에 충족하는 레코드의 속성값 수정 
update test set mcount = 10 where mname ="유재석";
# 3. update 테이블명 set 속성명1 = 값1 , 속성명2 = 값2 where 조건절; : 다수의 속성값 수정 
update test set mcount = 20 , mname ="강호동2" where mno = 2 ;
select * from test;

# [4] DELETE : 레코드 삭제 
# 2. delete from 테이블명 where 조건절 		: 조건에 중족하는 레코드 삭제 
delete from test where mno = 2;	# 회원번호가 2 와 같은 레코드 삭제 
# 1. delete from 테이블명;				: 전체 레코드 삭제 
delete from test;

select * from test;