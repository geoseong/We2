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

INSERT INTO roomshare VALUES(schedule_seq.nextval, '경영기술' , '서울' , '커피전문점', 10, '커피전문점1' ,'abcd.jpg');
INSERT INTO roomshare VALUES(schedule_seq.nextval, '경영기술2' ,'서울', '커피전문점' , 8, '커피전문점22' ,'c.jpg');
INSERT INTO roomshare VALUES(schedule_seq.nextval, '경영기술3' , '서울', '커피전문점' ,  6, '커피전문점33' ,'abc.jpg');
INSERT INTO roomshare VALUES(schedule_seq.nextval, '경영기술4' , '경기/인천', '회의실' ,  6, '커피전문점33' ,'abc.jpg');


SELECT * from roomshare;
select * from roomshare order by rcode desc
select * from roomshare where rlocation='서울' and rlocationdetail='커피전문점'
alter table roomshare modify( rlocation varchar2(30), rlocationdetail varchar2(30));

DROP	 TABLE roomshare;
DROP SEQUENCE Roomshare_seq;

commit


