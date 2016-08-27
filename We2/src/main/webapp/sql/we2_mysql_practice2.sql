
select DATE_FORMAT('05-01-2016', %m-%d-%Y);
select to_days('05-01-2016') - to_days('05-15-2016');

DATE_FORMAT(05/01/2016,'%m/%d/%Y');
DATE_FORMAT(05/12/2016,'%m-%d-%Y');

DATE_FORMAT(NOW(),'%m-%d-%Y')

SELECT TO_DAYS(ENDDATE)-TO_DAYS(STARTDATE) FROM PJTMAKE WHERE PJTCODE=10;

select * from roomshare;
desc pjtmake;
alter table roomshare drop column pjtcode;
show tables;

select  to_days(curDate()) - to_days(endDate) from pjtmake;
select endDate from pjtmake;
select * from roomshare where rlocation="경기/인천" and rlocationdetail="회의실";

select to_days(endDate) - to_days(curDate()) remaindate, curDate(), endDate from pjtmake where pjtcode=93;