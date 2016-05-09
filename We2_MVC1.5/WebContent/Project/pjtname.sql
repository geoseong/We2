create table pjts(
	pjtname varchar2(30),
	userid varchar2(20),
	primary key (userid)
);

select * from pjts;

insert into pjts values('We2_page','admin');

select userid, pwd from member;

select * from WILLWORK;
select * from pjtmake;
create sequence willwork_seq start with 39 increment by 1;

select * from seq;
select willwork_seq.currval from dual;

create table pjtMake(
pjtCode number(4) primary key,
pjtName varchar2(16),
pjtClassify varchar2(8),
startDate date,
endDate date
);
alter table pjtMake add (userId varchar2(12));
alter table pjtMake add foreign key (userId) references member(userId);


alter table pjtMake add foreign key (userId) references member(userId);

select dowork, donework from willwork where userid='park9658';

create sequence pjtMake_seq start with 1 increment by 1;

---------------------------------------------------------------------------------------
create table WillWork(
userId varchar2(12) primary key constraint willwork_pk_fk  references member(UserId),
pjtCode number(4), 
doWork varchar2(80),
doneWork varchar2(80),
stateWork varchar2(10),
name varchar2(10)
);
-------------------------------------------------------------------------------------
drop table member cascade constraints;

create table member(
name varchar2(10),
userid varchar2(12), 
pwd varchar2(12) not null,
email varchar2(30),
sub_email varchar2(30),
phone char(13),
gender number(1) default(0), --1:����,0:����
primary key(userid)
);

alter table member add pjtcode1 number(4);
alter table member add pjtcode2 number(4);
alter table member add pjtcode3 number(4);
alter table member add pjtcode4 number(4);
alter table member add pjtcode5 number(4);

alter table member add foreign key (pjtcode1) references pjtMake(pjtcode);
alter table member add foreign key (pjtcode2) references pjtMake(pjtcode);
alter table member add foreign key (pjtcode3) references pjtMake(pjtcode);
alter table member add foreign key (pjtcode4) references pjtMake(pjtcode);
alter table member add foreign key (pjtcode5) references pjtMake(pjtcode);

insert into willwork values('Taeseong',0,'�ڵ� ������','�� ȸ��',0, '���¼�');
insert into willwork values('JO',0,'������','�� ȸ��',1, '������');
insert into willwork values('Park',0,'���','�� ȸ��',1, '�ڻ���');
insert into willwork values('Jeon',0,'��������','�� ȸ��',0, '���ֿ�');
insert into willwork values('Bae',0,'CSS','�� ȸ��',0, '�����');


alter table pjtmake modify(startdate varchar2(20), enddate varchar2(20));
