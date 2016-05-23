
select * from pjtmake;

select * from pjtmanager;

delete from pjtmanager where pjtcode=50 or pjtcode=57;

create database we2;

desc pjtmanager;
select * from pjtmanager;
select * from pjtmake;
desc pjtmake;
desc member;

select pjtCode from pjtMake where userid='park';
ALTER TABLE ptest CHANGE itemContent itemContent VARCHAR(3000);
ALTER TABLE pwithwork CHANGE itemContent itemContent VARCHAR(3000);

# 컬럼의 데이터타입을 바꿈.
# 컬럼타입을 varcarh에서 text로 바꾸면 문자수 제한이 없다.
alter table 테이블명 modify 컬럼명 text;


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
	ex) CREATE USER 'we2admin'@'192.168.100.101' IDENTIFIED BY '123qwe!@#';

	ex) CREATE USER 'we2admin'@'%' IDENTIFIED BY '123qwe!@#';
*/
CREATE USER 'we2admin'@'%' IDENTIFIED BY '1234';
grant all privileges on we2.* to we2admin@'%';
flush privileges;


desc member;


USE mysql;
SELECT User, Host from user;
SELECT * from user;

show tables;
select * from member;
select * from MEMBER where USERID = 'geoseong';


SHOW GRANTS FOR we2admin@'%';


SET PASSWORD FOR we2admin='1234';
# update 
UPDATE user SET password=' ' WHERE user='we2admin';
FLUSH PRIVILEGES;

desc member;
desc pjtmake;

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
insert into member values('geoseong', '占신쇽옙', '1234' ,'imf4@naver.com', '010-2023-6697', 'M', now());
insert into member values('park', '占쏙옙占쏙옙', '1234' ,'hyuk9658@naver.com', '010-1234-6327', 'M', now());
insert into member values('jeon', '占쌍울옙', '1234' ,'jeon@naver.com', '010-2233-6645', 'W', now());
insert into member values('bae', '占쏙옙占쏙옙', '1234' ,'bae@naver.com', '010-2583-9197', 'W', now());
insert into member values('jo', '占쏙옙占쏙옙', '1234' ,'jo@naver.com', '010-2333-2312', 'M', now());

update willwork set dowork = dowork || ', ' || '占쏙옙占쌍깍옙' where name='占쏙옙占쏙옙';
update willwork set dowork = CONCAT(dowork, ', ', '占쌕븝옙') where name='占쏙옙占쏙옙';

select * from willwork where name='占쏙옙占쏙옙';


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

create table pjtManager(
	pjtCode int,
    userId varchar(12),
    isLeader varchar(2),
    FOREIGN KEY(pjtCode) REFERENCES pjtmake(pjtCode) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(userId) REFERENCES member(userId) ON UPDATE CASCADE ON DELETE CASCADE 
);
desc pjtManager;

 *   : http://powerhan.tistory.com/175 */
alter table �뀒�씠釉�_�씠由� engine=InnoDB;
alter table member engine=InnoDB, DEFAULT CHARACTER SET utf8;
alter table pjtMake engine=InnoDB, DEFAULT CHARACTER SET utf8;
alter table pjtManager engine=InnoDB, DEFAULT CHARACTER SET utf8;
alter database we2 DEFAULT CHARACTER SET utf8;



show variables like 'c%';

SHOW TABLE STATUS FROM we2 LIKE 'pjtMake';

SHOW TABLE STATUS FROM we2 LIKE 'pjtManager';

use we2;
show tables;

desc pgroup;

# Change specific Column name
ALTER TABLE member CHANGE userid userId VARCHAR(12);
ALTER TABLE fileshare CHANGE pjtcode pjtCode int;

ALTER TABLE pGroup ADD COLUMN itemDataType varchar(50);

alter table member drop column subEmail;

#INSERT INTO tablename or columns VALUES(25, 'NAME', 5, 25.5 );
insert into member values('geoseong', '거성', '1234' , '1234', 'imf4@naver.com', '010-2023-6697', 'M', now());

insert into pjtMake values('10',
'ttt',
'Thu May 12 00:00:00 KST 2016',
'Fri May 13 00:00:00 KST 2016');

insert into pjtMake(pjtName,pjtClassify,startDate,endDate) values(
'ttt', 
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

DROP USER we2admin@localhost;
DROP USER we2admin@'%';
DROP USER we2admin@'192.168.0.100';