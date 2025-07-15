# db day02
# 데이터베이스는 여러개의 테이블(표) 저장할수 있다.

# [1] 데이터베이스 생성 
create database mydb0715;
# [2] 데이터베이스 사용/활성화
use mydb0715;

# [3] 현재 활성화된 데이터베이스 안에 테이블/표 생성
# create: 생성한다 뜻  , table: 표 뜻  , test1: 아무거나 표이름 
# ( :정의시작 , ):정의끝 , 필드명:아무거나 속성명 , int : 속성의타입 
create table test1( 필드명 int );

# [4] 현재 활성화된 데이터베이스의 테이블 목록 조회 
show tables;

# 2개 이상의 속성을 정의할때 : ,쉼표로 구분한다.
create table test2( 필드명1 int , 필드명2 double );

# [5] 현재 활성화된 데이터베이스내 테이블 삭제
drop table test1;      # ctrl+enter
# 만약에 테이블이 존재하면 삭제
drop table if exists test1;

# [6] MYSQL 데이터 타입
# 다양한 데이터 타입 이용한 테이블 생성 
create table test3( # 테이블 정의 시작 
   # 속성명 타입 , 속성명 타입 
    정수필드1 tinyint , 정수필드2 smallint , 정수필드3 mediumint ,
    정수필드4 int        , 정수필드5 bigint  , 정수필드6 int unsigned ,
    실수필드1 float    , 실수필드2 double , 실수필드3 decimal ,
    날짜필드1 date      , 시간필드2 time   , 날짜시간필드3 datetime ,
    문자필드1 char(3)  , 문자필드2 varchar(3) , 
    문자필드3 text      , 문자필드4 longtext , 
    논리필드1 bool    # 마지막 속성 끝에는 ,(쉼표) 붙이지 않는다. 
); # 테이블 정의 끝 
show tables;
# select * from 테이블명;
select * from test3;

# 예1] 방문록을 기록하는 테이블 설계
create table board(
   content longtext   ,   # 게시물의 내용   # private String content
    writer varchar(30)      # 게시물의 작성자   # private String writer 
);
select * from board;   # select * from 테이블명; 

# 예2] 대기번호발급 기록하는 테이블 설계
create table waiting( 
   phone char(13)      ,   # 핸드폰 번호 # 고정길이13글자 # private String phone 
    count tinyint         # 인원수     # 최대 100정도  # pricate byte count
);
select * from waiting;

# [7] 제약조건을 이용한 테이블 설계 
# 제약조건 목적 : 데이터들 간의 문제와 결함이 되는 입력 방지/해결
create table test4(
   # 필드명 타입 제약조건 
    필드명1 tinyint not null             , -- 지정한 속성에는 null를 저장 할수 없도록 조건 설정 
    필드명2 smallint unique              , -- 지정한 속성에는 중복값을 저장 할수 없도록 조건 설정 
    필드명3 int default 10               , -- 지정한 속성에는 값이 생략될때 자동으로 10 기본값 으로 설정 
    필드명4 bigint auto_increment         , -- 지정한 속성에는 값이 생략될때 자동으로 순서번호 설정 , 1 2 3 4 5 
    constraint primary key( 필드명4 )      -- '필드명4' 속성을 PK 필드로 설정 
);
select * from test4; 
# [7]
create table test5( 
   필드명1 bigint ,    -- 지정한 속성 선언 
    constraint foreign key( 필드명1 ) references test4( 필드명4 ) 
    -- test5의'필드명1'속성을 FK필드로 설정하고 test4의'필드명4'속성의PK를 참조한다.
);

# 예3] 회원제 게시판 DB 설계하시오. 
drop database if exists boardService0715;   -- 새로만들 데이터베이스가 존재하면 삭제 
create database boardService0715;         -- 데이터베이스 생성 
use boardService0715;                  -- 데이터베이스 활성화 
create table member(                  -- [1] 회원테이블 
   mno int auto_increment,               -- 회원번호 : 정수 , 자동번호 , *PK사용할 예정
   mid varchar(30) not null unique ,       -- 회원아이디 : 문자최대30 , 공백x , 중복x
    mpwd varchar(30) not null ,            -- 회원비밀번호 : 문자최대30 , 공백x 
    mname varchar(10) not null ,         -- 회원닉네임 : 문자최대10 , 공백x 
    constraint primary key( mno )         -- 위에서 선언된 '회원번호'속성을 *PK필드로 설정 
);
select * from member;                  -- 확인차 회원테이블 조회
create table board(                     -- [2] 게시물 테이블 
   bno int auto_increment ,             -- 게시물번호 : 정수 , 자동번호 , *PK사용할 예정 
    btitle varchar(100) not null ,          -- 게시물제목 : 문자최대100 , 공백x 
    bcontent longtext ,                  -- 게시물내용 : 4GB 대용량(사진/긴글) 
    bdate datetime default now() ,          -- 게시물작성일 : 날짜/시간 , 기본값 , now() : 현재 날짜/시간 반환함수
    bview int default 0 ,               -- 게시물조회수 : 정수 , 기본값 , 0
    constraint primary key( bno ) ,         -- 위에서 선언된 '게시물번호'속성을 *PK필드로 설정
    mno int ,                        -- 게시물작성자 : *FK사용할 예정 --> PK필드 타입과 일치 
    constraint foreign key( mno ) references member( mno )
);
select * from board;
# 여럿 테이블 간의 관계 확인( 다이어그램 ) 
#  workbench 상단메뉴 -> [database] -> 
