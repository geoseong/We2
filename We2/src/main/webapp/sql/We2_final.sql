/* root 계정에서 진행*/
/* 데이터베이스 생성 */
create database we2;

/* 계정생성 */
/* Localhost (오직 내 PC안에서만) */
CREATE USER we2admin@localhost IDENTIFIED BY '1234';
grant all on we2.* to we2admin@localhost;

/* 옵션 실행사항 : % (다른 모든 PC에서 접근 허용) */
CREATE USER 'we2admin'@'%' IDENTIFIED BY '1234';
grant all privileges on we2.* to we2admin@'%';

flush privileges;


/* 여기서부터는 we2admin@localhost, database : we2 로 접속한다. */

/* 본격 테이블 생성 */
CREATE TABLE member(
   userId VARCHAR(12),
   name VARCHAR(10),
   pwd VARCHAR(12),
   pwd_confirm varchar(12),
   email VARCHAR(30),
   phone VARCHAR(13),
    gender VARCHAR(2),
    regDate date,
   PRIMARY KEY(userid)
) engine=InnoDB character set=utf8; 


/*pjtMake 테이블 */
CREATE TABLE pjtMake(
   pjtCode int auto_increment,
   pjtName VARCHAR(20),
   pjtClassify VARCHAR(12),
   startDate date,
   endDate date,
   PRIMARY KEY(pjtCode)
) engine=InnoDB character set=utf8;


/*pjtManager 테이블 */
create table pjtManager(
   pjtCode int,
   userId varchar(12),
   isLeader varchar(2),
   FOREIGN KEY(pjtCode) REFERENCES pjtmake(pjtCode) ON UPDATE CASCADE ON DELETE CASCADE,
   FOREIGN KEY(userId) REFERENCES member(userId) ON UPDATE CASCADE ON DELETE CASCADE
) engine=InnoDB character set=utf8;


/*willwork 테이블 */
CREATE TABLE willwork(
   userId VARCHAR(12),
   pjtCode int,
   dowork VARCHAR(200),
   donework VARCHAR(200),
   statework VARCHAR(30),
   name VARCHAR(10),
   FOREIGN KEY(pjtCode) REFERENCES pjtmake(pjtCode) ON UPDATE CASCADE ON DELETE CASCADE,
   FOREIGN KEY(userId) REFERENCES member(userId) ON UPDATE CASCADE ON DELETE CASCADE
) engine=InnoDB character set=utf8;


/*notice 테이블 */
create table notice(
   num int NOT NULL AUTO_INCREMENT, 
   pjtCode int,
   title VARCHAR(50),
   userId VARCHAR(12),
   writedate DATE,
   content VARCHAR(1000),
   PRIMARY KEY(num),
   FOREIGN KEY(pjtCode) REFERENCES pjtmake(pjtCode) ON UPDATE CASCADE ON DELETE CASCADE,
   FOREIGN KEY(userId) REFERENCES member(userId) ON UPDATE CASCADE ON DELETE CASCADE 
) engine=InnoDB character set=utf8;


/*scheduler 테이블 */
CREATE TABLE scheduler (
   calendarmemo_num int primary key AUTO_INCREMENT,
   pjtcode int,
   calendarmemo_year int, 
   calendarmemo_month int, 
   calendarmemo_day int, 
   calendarmemo_contents VARCHAR(500),
  FOREIGN KEY(pjtCode) REFERENCES pjtmake(pjtCode) ON UPDATE CASCADE ON DELETE CASCADE
)engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;

/* fileShare 테이블 */
create table fileShare(
	fcode int NOT NULL AUTO_INCREMENT,
	pjtCode int,
	fdate DATE,
	fname varchar(30),
	userId varchar(12), /* 추가됨 */
	fileurl varchar(50),	
	primary key(fcode),
	FOREIGN KEY(pjtCode) REFERENCES pjtmake(pjtCode) ON UPDATE CASCADE ON DELETE CASCADE
)engine=InnoDB character set=utf8;


/*pGroup 테이블 */
create table pGroup (
   itemNum   int NOT NULL AUTO_INCREMENT,
   itemTitle      varchar(80),
   userId      varchar(12),
   itemDate   DATE,
   itemClick   int,
   itemPath   varchar(50),
   itemContent    varchar(1000),
   itemdatatype text,
   primary key (itemNum),
  FOREIGN KEY(userId) REFERENCES member(userId) ON UPDATE CASCADE ON DELETE CASCADE 
) engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


/*pTest 테이블 */
create table pTest (
   itemNum   int NOT NULL AUTO_INCREMENT,
   itemTitle      varchar(80),
   userId      varchar(12),
   itemDate   DATE,
   itemClick   int,
   itemPath   varchar(50),
   itemContent    varchar(1000),
   itemdatatype text,
   primary key (itemNum),
  FOREIGN KEY(userId) REFERENCES member(userId) ON UPDATE CASCADE ON DELETE CASCADE 
) engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


/*pWithWork 테이블 */
create table pWithWork (
   itemNum   int NOT NULL AUTO_INCREMENT,
   itemTitle      varchar(80),
   userId      varchar(12),
   itemDate   DATE,
   itemClick   int,
   itemPath   varchar(50),
   itemContent    varchar(1000),
   itemdatatype text,
   primary key (itemNum),
  FOREIGN KEY(userId) REFERENCES member(userId) ON UPDATE CASCADE ON DELETE CASCADE 
) engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


/*cFreework 테이블 */
create table cFreework (
   itemNum   int NOT NULL AUTO_INCREMENT,
   itemTitle      varchar(80),
   userId      varchar(12),
   itemDate   DATE,
   itemClick   int,
   itemPath   varchar(50),
   itemContent    varchar(1000),
   itemdatatype text,
   primary key (itemNum),
  FOREIGN KEY(userId) REFERENCES member(userId) ON UPDATE CASCADE ON DELETE CASCADE 
) engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


/* cFindwork 테이블 */
create table cFindwork (
   itemNum   int NOT NULL AUTO_INCREMENT,
   itemTitle      varchar(80),
   userId      varchar(12),
   itemDate   DATE,
   itemClick   int,
   itemPath   varchar(50),
   itemContent    varchar(1000),
   itemdatatype text,
   primary key (itemNum),
  FOREIGN KEY(userId) REFERENCES member(userId) ON UPDATE CASCADE ON DELETE CASCADE 
) engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;

/* roomshare 테이블 */
create table roomshare(
	rcode int NOT NULL AUTO_INCREMENT,
	rname varchar(50),
	rlocation varchar(50),
	rlocationdetail varchar(50),
	rmember int,
	rcontent varchar(1000),
	rpictureurl varchar(100),
	primary key (rcode)
) engine=InnoDB character set=utf8;
/* 테이블 생성 끝 */
