CREATE TABLE roomshare (
  rcode number(5) primary key,
  rname varchar(50),
  rlocation varchar(50),
  rlocationdetail varchar(50),
  rmember NUMBER(3),
  rcontent varchar(1000),
  rpictureurl varchar(100)
);


create sequence Roomshare_seq start with 1 increment by 1;
create sequence schedule_seq start with 1 increment by 1;

INSERT INTO roomshare VALUES(schedule_seq.nextval, '�濵���' , '����' , 'Ŀ��������', 10, 'Ŀ��������1' ,'abcd.jpg');
INSERT INTO roomshare VALUES(schedule_seq.nextval, '�濵���2' ,'����', 'Ŀ��������' , 8, 'Ŀ��������22' ,'c.jpg');
INSERT INTO roomshare VALUES(schedule_seq.nextval, '�濵���3' , '����', 'Ŀ��������' ,  6, 'Ŀ��������33' ,'abc.jpg');
INSERT INTO roomshare VALUES(schedule_seq.nextval, '�濵���4' , '���/��õ', 'ȸ�ǽ�' ,  6, 'Ŀ��������33' ,'abc.jpg');


SELECT * from roomshare;
select * from roomshare order by rcode desc
select * from roomshare where rlocation='����' and rlocationdetail='Ŀ��������'
alter table roomshare modify( rlocation varchar2(30), rlocationdetail varchar2(30));

DROP	 TABLE roomshare;
DROP SEQUENCE Roomshare_seq;

commit


