create database we2;

desc pjtmanager;
select * from pjtmanager;
select * from pjtmake;
desc pjtmake;
desc member;

select pjtCode from pjtMake where userid='park';

/*  create user �떆�옉
> testuser �씪�뒗 �궗�슜�옄媛� 192.168.100.101 �븘�씠�뵾瑜� �넻�빐�꽌 �젒洹쇳븯�뒗 寃껋쓣 �뿀�슜�븯硫�, 
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
> testuser 占쏙옙占� 占쏙옙占쏙옙微占� 192.168.100.101 占쏙옙占쏙옙占실몌옙 占쏙옙占쌔쇽옙 占쏙옙占쏙옙占싹댐옙 占쏙옙占쏙옙 占쏙옙占쏙옙玖占�, 
	ex) CREATE USER 'we2admin'@'192.168.100.101' IDENTIFIED BY '123qwe!@#';
 鍮꾨�踰덊샇�뒗 "123qwe!@#" �씠怨�, "we2" �뜲�씠�꽣踰좎씠�뒪�뿉 ���븯�뿬 紐⑤뱺 沅뚰븳�쓣 遺��뿬 諛쏆쓬 
 
 > 紐⑤뱺 IP濡쒖쓽 �젒洹쇱쓣 �뿀�슜�븯湲� �쐞�빐�꽌�뒗 �샇�뒪�듃二쇱냼 遺�遺꾩쓣 "%"濡� 泥섎━�븳�떎
	ex) CREATE USER 'we2admin'@'%' IDENTIFIED BY '123qwe!@#';
*/
CREATE USER 'we2admin'@'%' IDENTIFIED BY '1234';
grant all privileges on we2.* to we2admin@'%';
flush privileges;
/* create user �걹 */

desc member;

/* MySQL �쟾泥� �궗�슜�옄 紐⑸줉 蹂닿린*/
USE mysql;
SELECT User, Host from user;
SELECT * from user;

show tables;
select * from member;
select * from MEMBER where USERID = 'geoseong';


/* �궗�슜�옄�뿉寃� 遺��뿬�맂 沅뚰븳 �솗�씤 */
SHOW GRANTS FOR we2admin@'%';


/* 怨꾩젙 鍮꾨�踰덊샇 蹂�寃� */
# Set Password �씠�슜
SET PASSWORD FOR we2admin='1234';
# update臾� �씠�슜
UPDATE user SET password='�깉鍮꾨�踰덊샇' WHERE user='we2admin';
FLUSH PRIVILEGES;

-- �뀒�씠釉� �깮�꽦
desc member;
desc pjtmake;
-- 占쏙옙占싱븝옙 占쏙옙占쏙옙
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

insert into willwork values('pts119', '20', '占쌘듸옙究占�' ,'占쏙옙占쏙옙처占쏙옙', 'Y', '占승쇽옙');
insert into willwork values('park', '20', '占쌘듸옙究占�' ,'占쏙옙占쏙옙처占쏙옙', 'Y', '占쏙옙占쏙옙');
insert into willwork values('jeon', '20', '占쌘듸옙究占�' ,'占쏙옙占쏙옙처占쏙옙', 'Y', '占쌍울옙');
insert into willwork values('bae', '20', '占쌘듸옙究占�' ,'占쏙옙占쏙옙처占쏙옙', 'Y', '占쏙옙占쏙옙');
insert into willwork values('jo', '20', '占쌘듸옙究占�' ,'占쏙옙占쏙옙처占쏙옙', 'Y', '占쏙옙占쏙옙');

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

/* �뀒�씠釉� �깮�꽦 �떆 �쇅�옒�궎 �븳踰덉뿉 �꽕�젙 (�뾽�뜲�씠�듃�븷�븣�굹 吏��썙吏덈븣�굹 �뒛 �븿猿섑븯�뒗 �쇅�옒�궎�꽕�젙) */
create table pjtManager(
	pjtCode int,
    userId varchar(12),
    isLeader varchar(2),
    FOREIGN KEY(pjtCode) REFERENCES pjtmake(pjtCode) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(userId) REFERENCES member(userId) ON UPDATE CASCADE ON DELETE CASCADE 
);
desc pjtManager;

/* InnoDB�뀒�씠釉� 諛⑹떇�쑝濡� �븞留뚮뱾�뿀�쓣�븣 蹂�寃쏀븯�뒗 紐낅졊�뼱
 * �옄�꽭�꽕紐� : http://powerhan.tistory.com/175 */
alter table �뀒�씠釉�_�씠由� engine=InnoDB;
alter table member engine=InnoDB, DEFAULT CHARACTER SET utf8;
alter table pjtMake engine=InnoDB, DEFAULT CHARACTER SET utf8;
alter table pjtManager engine=InnoDB, DEFAULT CHARACTER SET utf8;
alter database we2 DEFAULT CHARACTER SET utf8;



/* �쁽�옱 臾몄옄�뀑 �젙蹂� 蹂닿린*/
show variables like 'c%';

/* InnoDB 諛⑹떇�씤吏� �벑�벑.. �뀒�씠釉� �젙蹂� �솗�씤�븯湲� */
SHOW TABLE STATUS FROM we2 LIKE 'pjtMake';

/* InnoDB 占쏙옙占쏙옙占쏙옙占� 占쏙옙占�.. 占쏙옙占싱븝옙 占쏙옙占쏙옙 확占쏙옙占싹깍옙 */
SHOW TABLE STATUS FROM we2 LIKE 'pjtManager';

/* �듅�젙 �뜲�씠�꽣踰좎씠�뒪 �븞�뿉 �엳�뒗 �뀒�씠釉� 紐⑸줉 蹂닿린 */
use we2;
show tables;

desc pgroup;

/* 而щ읆 �씠由� 諛붽씀湲� */
# ALTER TABLE �뀒�씠釉붾챸 CHANGE 而щ읆�씠由� �깉而щ읆�씠由� �깉而щ읆���엯
ALTER TABLE member CHANGE userid userId VARCHAR(12);

/* 而щ읆 異붽��븯湲� */
#ALTER TABLE �뀒�씠釉붾챸 ADD COLUMN 移쇰읆�씠由� 移쇰읆���엯
ALTER TABLE pGroup ADD COLUMN itemDataType varchar(50);

/* 而щ읆 �궘�젣�븯湲� */
#ALTER TABLE �뀒�씠釉붾챸 DROP COLUMN 移쇰읆�씠由�
alter table member drop column subEmail;

/* �궫�엯 */
# �쁽�옱�떆媛곸� MySQL�뿉�꽌�뒗 now().
#INSERT INTO tablename or columns VALUES(25, 'NAME', 5, 25.5 );
insert into member values('geoseong', '嫄곗꽦', '1234' ,'imf4@naver.com', '010-2023-6697', 'M', now());

insert into pjtMake values('10',
'ttt',
'占쏙옙占쏙옙占쏙옙占쏙옙',
'Thu May 12 00:00:00 KST 2016',
'Fri May 13 00:00:00 KST 2016');

insert into pjtMake(pjtName,pjtClassify,startDate,endDate) values(
'ttt', 
'占쏙옙占쏙옙占쏙옙占쏙옙',
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

/* �궗�슜�옄 �궘�젣 */
DROP USER we2admin@localhost;
DROP USER we2admin@'%';
DROP USER we2admin@'192.168.0.100';