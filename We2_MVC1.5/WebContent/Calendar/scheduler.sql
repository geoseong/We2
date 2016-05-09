CREATE TABLE calendarmemo (
	calendarmemo_num NUMBER(5) primary key, 
	calendarmemo_year NUMBER(4), 
	calendarmemo_month NUMBER(2), 
	calendarmemo_day NUMBER(2), 
	calendarmemo_contents VARCHAR2(500), 
	calendarmemo_id VARCHAR2(30), 
	calendarmemo_passwd VARCHAR2(30)
);

create sequence Schedule_seq start with 1 increment by 1;
   
INSERT INTO CALENDARMEMO(calendarmemo_num, CALENDARMEMO_YEAR, CALENDARMEMO_MONTH, CALENDARMEMO_DAY,CALENDARMEMO_CONTENTS)
   VALUES (schedule_seq.nextval, 2016, 4, 1,'소잡는 날');

INSERT INTO CALENDARMEMO(calendarmemo_num, CALENDARMEMO_YEAR, CALENDARMEMO_MONTH, CALENDARMEMO_DAY,CALENDARMEMO_CONTENTS)
   VALUES (schedule_seq.nextval, 2016, 4, 6,'잠자는 날')   ;
   
INSERT INTO CALENDARMEMO(calendarmemo_num, CALENDARMEMO_YEAR, CALENDARMEMO_MONTH, CALENDARMEMO_DAY,CALENDARMEMO_CONTENTS)
   VALUES (schedule_seq.nextval, 2016, 4, 8,'노는 날')   ;
   
   INSERT INTO CALENDARMEMO(calendarmemo_num, CALENDARMEMO_YEAR, CALENDARMEMO_MONTH, CALENDARMEMO_DAY,CALENDARMEMO_CONTENTS)
   VALUES (schedule_seq.nextval, 2016, 4, 6,'헤헤')  ;
   
update calendarmemo_num, CALENDARMEMO_YEAR, CALENDARMEMO_MONTH, CALENDARMEMO_DAY,CALENDARMEMO_CONTENTS set calendarmemo_num=2 , calendarmemo_year=2016, calendarmemo_month=4, calendarmemo_day=7, calendarmemo_contents='소잡는날바꿔봄';

select * from calendarmemo;
   
SELECT * FROM calendarmemo where calendarmemo_year=2016 and calendarmemo_month=4 and calendarmemo_day=3;

drop table calendarmemo;
drop sequence schedule_seq;
commit