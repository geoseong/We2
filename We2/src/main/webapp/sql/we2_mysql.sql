create database we2;

/*  create user 시작
> testuser 라는 사용자가 192.168.100.101 아이피를 통해서 접근하는 것을 허용하며, 
drop table pjtmake cascade constraint;
drop table pjtmanager cascade constraint;

SET foreign_key_checks = 0;
select * from pjtmake;
desc pjtmake;
SET foreign_key_checks = 1;
drop table pjtmake;

ALTER TABLE pjtmake DROP pjtCode;
ALTER TABLE pjtmake DROP FOREIGN KEY pjtmanager_ibfk_1;
drop table pjtmake ON DELETE CASCADE ON UPDATE CASCADE;
show create table pjtmake;
drop table pjtmake on delete cascade;
drop table pjtmake cascade constraints;

desc pjtmake;
select * from pjtmake;

alter table pjtmake modify pjtCode int auto_increment;


/*
> testuser ��� ����ڰ� 192.168.100.101 �����Ǹ� ���ؼ� �����ϴ� ���� ����ϸ�, 
	ex) CREATE USER 'we2admin'@'192.168.100.101' IDENTIFIED BY '123qwe!@#';
 비밀번호는 "123qwe!@#" 이고, "we2" 데이터베이스에 대하여 모든 권한을 부여 받음 
 
 > 모든 IP로의 접근을 허용하기 위해서는 호스트주소 부분을 "%"로 처리한다
	ex) CREATE USER 'we2admin'@'%' IDENTIFIED BY '123qwe!@#';
*/
CREATE USER 'we2admin'@'%' IDENTIFIED BY '1234';
grant all privileges on we2.* to we2admin@'%';
flush privileges;
/* create user 끝 */

desc member;

/* MySQL 전체 사용자 목록 보기*/
USE mysql;
SELECT User, Host from user;
SELECT * from user;

show tables;
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
desc member;
desc pjtmake;
-- ���̺� ����
CREATE TABLE willwork(
	userId VARCHAR(12),
	pjtcode int,
	dowork VARCHAR(200),
	donework VARCHAR(200),
    statework VARCHAR(30),
	name VARCHAR(10),
    FOREIGN KEY(pjtCode) REFERENCES pjtmake(pjtCode) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(userId) REFERENCES member(userId) ON UPDATE CASCADE ON DELETE CASCADE 
) engine=InnoDB character set=utf8; 
desc willwork;

//테이블안에 update문을 사용하는 문법
UPDATE member SET name='우아',pwd='5555',pwd_confirm='5555', email='aa@naver.com',
phone='010-1111-2222', gender='1', regDate='2000-06-11' WHERE userId='jo';

insert into willwork values('pts119', '20', '�ڵ�ϼ�' ,'����ó��', 'Y', '�¼�');
insert into willwork values('park', '20', '�ڵ�ϼ�' ,'����ó��', 'Y', '����');
insert into willwork values('jeon', '20', '�ڵ�ϼ�' ,'����ó��', 'Y', '�ֿ�');
insert into willwork values('bae', '20', '�ڵ�ϼ�' ,'����ó��', 'Y', '����');
insert into willwork values('jo', '20', '�ڵ�ϼ�' ,'����ó��', 'Y', '����');

desc member;
insert into member values('geoseong', '�ż�', '1234' ,'imf4@naver.com', '010-2023-6697', 'M', now());
insert into member values('park', '����', '1234' ,'hyuk9658@naver.com', '010-1234-6327', 'M', now());
insert into member values('jeon', '�ֿ�', '1234' ,'jeon@naver.com', '010-2233-6645', 'W', now());
insert into member values('bae', '����', '1234' ,'bae@naver.com', '010-2583-9197', 'W', now());
insert into member values('jo', '����', '1234' ,'jo@naver.com', '010-2333-2312', 'M', now());

update willwork set dowork = dowork || ', ' || '���ֱ�' where name='����';
update willwork set dowork = CONCAT(dowork, ', ', '�ٺ�') where name='����';

select * from willwork where name='����';


select * from pjtMake;
select * from member;

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
desc member;

CREATE TABLE pjtMake(
	pjtCode int auto_increment,
	pjtName VARCHAR(20),
	pjtClassify VARCHAR(12),
	startDate date,
    endDate date,
	PRIMARY KEY(pjtCode)
) engine=InnoDB character set=utf8; 

desc pjtMake;
select * from pjtMake;
commit;

/* 테이블 생성 시 외래키 한번에 설정 (업데이트할때나 지워질때나 늘 함께하는 외래키설정) */
create table pjtManager(
	pjtCode int,
    userId varchar(12),
    isLeader varchar(2),
    FOREIGN KEY(pjtCode) REFERENCES pjtmake(pjtCode) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(userId) REFERENCES member(userId) ON UPDATE CASCADE ON DELETE CASCADE 
);
desc pjtManager;

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

/* InnoDB ������� ���.. ���̺� ���� Ȯ���ϱ� */
SHOW TABLE STATUS FROM we2 LIKE 'pjtManager';

/* 특정 데이터베이스 안에 있는 테이블 목록 보기 */
use we2;
show tables;

desc pgroup;

/* 컬럼 이름 바꾸기 */
# ALTER TABLE 테이블명 CHANGE 컬럼이름 새컬럼이름 새컬럼타입
ALTER TABLE member CHANGE userid userId VARCHAR(12);

/* 컬럼 추가하기 */
#ALTER TABLE 테이블명 ADD COLUMN 칼럼이름 칼럼타입
ALTER TABLE pGroup ADD COLUMN itemDataType varchar(50);

/* 컬럼 삭제하기 */
#ALTER TABLE 테이블명 DROP COLUMN 칼럼이름
alter table member drop column subEmail;

/* 삽입 */
# 현재시각은 MySQL에서는 now().
#INSERT INTO tablename or columns VALUES(25, 'NAME', 5, 25.5 );
insert into member values('geoseong', '거성', '1234' , '1234', 'imf4@naver.com', '010-2023-6697', 'M', now());

insert into pjtMake values('10',
'ttt',
'��������',
'Thu May 12 00:00:00 KST 2016',
'Fri May 13 00:00:00 KST 2016');

insert into pjtMake(pjtName,pjtClassify,startDate,endDate) values(
'ttt', 
'��������',
STR_TO_DATE('05/12/2016','%m/%d/%Y'),
STR_TO_DATE('05/14/2016','%m/%d/%Y'));

desc pjtMake;
select pjtCode, pjtName, pjtClassify from pjtMake;
select count(1) from pjtMake;

pjtCode int auto_increment,
	pjtName VARCHAR(20),
	pjtClassify VARCHAR(12),
	startDate date,
    endDate date,
show create table pjtMake;

/* 사용자 삭제 */
DROP USER we2admin@localhost;
DROP USER we2admin@'%';
DROP USER we2admin@'192.168.0.100';