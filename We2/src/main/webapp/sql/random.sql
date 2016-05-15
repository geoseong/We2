create database we2;

mysql -uwe2admin -p1234 -h192.168.0.100 we2

/*
> testuser 라는 사용자가 192.168.100.101 아이피를 통해서 접근하는 것을 허용하며, 
	ex) CREATE USER 'we2admin'@'192.168.100.101' IDENTIFIED BY '123qwe!@#';
 비밀번호는 "123qwe!@#" 이고, "mysite" 데이터베이스에 대하여 모든 권한을 부여 받음 
 
 > 모든 IP로의 접근을 허용하기 위해서는 호스트주소 부분을 "%"로 처리한다
	ex) CREATE USER 'we2admin'@'%' IDENTIFIED BY '123qwe!@#';
*/
CREATE USER 'we2admin'@'%' IDENTIFIED BY '1234';
grant all privileges on we2.* to we2admin@'%';
flush privileges;
/* create user 끝 */


/* MySQL 전체 사용자 목록 보기*/
USE mysql;
SELECT User, Host from user;
SELECT * from user;

select * from member;
select * from MEMBER where USERID = 'geoseong';


/* 사용자에게 부여된 권한 확인 */
SHOW GRANTS FOR we2admin@'%';


/* 계정 비밀번호 변경 */
# Set Password 이용
SET PASSWORD FOR we2admin='1234';
# update문 이용
UPDATE user SET password='새비밀번호' WHERE user='we2admin';
FLUSH PRIVILEGES;

-- 테이블 생성
CREATE TABLE member(
	userid VARCHAR(12),
	name VARCHAR(10),
	pwd VARCHAR(12),
	email VARCHAR(30),
    subEmail VARCHAR(30),
	phone VARCHAR(13),
    gender VARCHAR(2),
	PRIMARY KEY(userid)
) engine=InnoDB character set=utf8; 
desc member;

CREATE TABLE pjtMake(
	pjtCode VARCHAR(4),
	pjtName VARCHAR(20),
	pjtClassify VARCHAR(12),
	startDate date,
    endDate date,
	PRIMARY KEY(pjtCode)
) engine=InnoDB character set=utf8; 
desc pjtMake;

/* 테이블 생성 시 외래키 한번에 설정 (업데이트할��나 지워질때나 늘 함께하는 외래키설정) */
create table pjtManager(
	pjtCode varchar(4),
    userId varchar(12),
    isLeader varchar(2),
    FOREIGN KEY(pjtCode) REFERENCES pjtmake(pjtCode) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(userId) REFERENCES member(userId) ON UPDATE CASCADE ON DELETE CASCADE 
);

/* InnoDB테이블 방식으로 안만들었을때 변경하는 명령어
 * 자세설명 : http://powerhan.tistory.com/175 */
alter table 테이블_이름 engine=InnoDB;
alter table member engine=InnoDB, DEFAULT CHARACTER SET utf8;
alter table pjtMake engine=InnoDB, DEFAULT CHARACTER SET utf8;
alter table pjtManager engine=InnoDB, DEFAULT CHARACTER SET utf8;
alter database we2 DEFAULT CHARACTER SET utf8;



/* 현재 문자셋 정보 보기*/
show variables like 'c%';

/* InnoDB 방식인지 등등.. 테이블 정보 확인하기 */
SHOW TABLE STATUS FROM we2 LIKE 'pjtMake';



/* 특정 데이터베이스 안에 있는 테이블 목록 보기 */
use we2;
show tables;


/* 컬럼 이름 바꾸기 */
# ALTER TABLE 테이블명 CHANGE 컬럼이름 새컬럼이름 새컬럼타입
ALTER TABLE member CHANGE userid userId VARCHAR(12);

/* 컬럼 추가하기 */
#ALTER TABLE 테이블명 ADD COLUMN 칼럼이름 칼럼타입
ALTER TABLE member ADD COLUMN regDate date;


/* 삽입 */
# 현재시각은 MySQL에서는 now().
#INSERT INTO tablename or columns VALUES(25, 'NAME', 5, 25.5 );
insert into member values('geoseong', '거성', '1234' ,'imf4@naver.com', 'parkopp@hanmail.net', '010-2023-6697', 'M', now());


/* 사용자 삭제 */
DROP USER we2admin@localhost;
DROP USER we2admin@'%';
DROP USER we2admin@'192.168.0.100';