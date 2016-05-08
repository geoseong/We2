create database we2;

/* 
> testuser ��� ����ڰ� 192.168.100.101 �����Ǹ� ���ؼ� �����ϴ� ���� ����ϸ�, 
	ex) CREATE USER 'we2admin'@'192.168.100.101' IDENTIFIED BY '123qwe!@#';
 ��й�ȣ�� "123qwe!@#" �̰�, "mysite" �����ͺ��̽��� ���Ͽ� ��� ������ �ο� ���� 
 
 > ��� IP���� ������ ����ϱ� ���ؼ��� ȣ��Ʈ�ּ� �κ��� "%"�� ó���Ѵ�
	ex) CREATE USER 'we2admin'@'%' IDENTIFIED BY '123qwe!@#';
*/
CREATE USER 'we2admin'@'%' IDENTIFIED BY '1234';
grant all privileges on we2.* to we2admin@'%';
flush privileges;
/* create user �� */


/* MySQL ��ü ����� ��� ����*/
USE mysql;
SELECT User, Host from user;
SELECT * from user;

select * from member;
select * from MEMBER where USERID = 'geoseong';


/* ����ڿ��� �ο��� ���� Ȯ�� */
SHOW GRANTS FOR we2admin@'%';


/* ���� ��й�ȣ ���� */
# Set Password �̿�
SET PASSWORD FOR we2admin='1234';
# update�� �̿�
UPDATE user SET password='����й�ȣ' WHERE user='we2admin';
FLUSH PRIVILEGES;

-- ���̺� ����
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

/* ���̺� ���� �� �ܷ�Ű �ѹ��� ���� (������Ʈ�ҋ��� ���������� �� �Բ��ϴ� �ܷ�Ű����) */
create table pjtManager(
	pjtCode varchar(4),
    userId varchar(12),
    isLeader varchar(2),
    FOREIGN KEY(pjtCode) REFERENCES pjtmake(pjtCode) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(userId) REFERENCES member(userId) ON UPDATE CASCADE ON DELETE CASCADE 
);

/* InnoDB���̺� ������� �ȸ�������� �����ϴ� ��ɾ�
 * �ڼ����� : http://powerhan.tistory.com/175 */
alter table ���̺�_�̸� engine=InnoDB;
alter table member engine=InnoDB, DEFAULT CHARACTER SET utf8;
alter table pjtMake engine=InnoDB, DEFAULT CHARACTER SET utf8;
alter table pjtManager engine=InnoDB, DEFAULT CHARACTER SET utf8;
alter database we2 DEFAULT CHARACTER SET utf8;



/* ���� ���ڼ� ���� ����*/
show variables like 'c%';

/* InnoDB ������� ���.. ���̺� ���� Ȯ���ϱ� */
SHOW TABLE STATUS FROM we2 LIKE 'pjtMake';



/* Ư�� �����ͺ��̽� �ȿ� �ִ� ���̺� ��� ���� */
use we2;
show tables;


/* �÷� �̸� �ٲٱ� */
# ALTER TABLE ���̺�� CHANGE �÷��̸� ���÷��̸� ���÷�Ÿ��
ALTER TABLE member CHANGE userid userId VARCHAR(12);

/* �÷� �߰��ϱ� */
#ALTER TABLE ���̺�� ADD COLUMN Į���̸� Į��Ÿ��
ALTER TABLE member ADD COLUMN regDate date;


/* ���� */
# ����ð��� MySQL������ now().
#INSERT INTO tablename or columns VALUES(25, 'NAME', 5, 25.5 );
insert into member values('geoseong', '�ż�', '1234' ,'imf4@naver.com', 'parkopp@hanmail.net', '010-2023-6697', 'M', now());


/* ����� ���� */
DROP USER we2admin@localhost;
DROP USER we2admin@'%';
DROP USER we2admin@'192.168.0.100';