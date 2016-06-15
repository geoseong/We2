
select DATE_FORMAT('05-01-2016', %m-%d-%Y);
select to_days('05-01-2016') - to_days('05-15-2016');

DATE_FORMAT(05/01/2016,'%m/%d/%Y');
DATE_FORMAT(05/12/2016,'%m-%d-%Y');

DATE_FORMAT(NOW(),'%m-%d-%Y')

SELECT TO_DAYS(ENDDATE)-TO_DAYS(STARTDATE) FROM PJTMAKE WHERE PJTCODE=10;

select * from roomshare;
desc roomshare;
alter table roomshare drop column pjtcode;
show tables;

select * from roomshare where rlocation="경기/인천" and rlocationdetail="회의실";

insert into roomshare(rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl)
 values('스터디룸테스트', '경기/인천', '회의실', 6, '페이징테스트', '1.jpg');
 insert into roomshare(rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl)
 values('스터디룸테스트', '경기/인천', '회의실', 6, '페이징테스트', '1.jpg');
 insert into roomshare(rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl)
 values('스터디룸테스트', '경기/인천', '회의실', 6, '페이징테스트', '1.jpg');
 insert into roomshare(rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl)
 values('스터디룸테스트', '경기/인천', '회의실', 6, '페이징테스트', '1.jpg');
 insert into roomshare(rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl)
 values('스터디룸테스트', '경기/인천', '회의실', 6, '페이징테스트', '1.jpg');
 insert into roomshare(rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl)
 values('스터디룸테스트', '경기/인천', '회의실', 6, '페이징테스트', '1.jpg');
 insert into roomshare(rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl)
 values('스터디룸테스트', '경기/인천', '회의실', 6, '페이징테스트', '1.jpg');
 insert into roomshare(rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl)
 values('스터디룸테스트', '경기/인천', '회의실', 6, '페이징테스트', '1.jpg');
 insert into roomshare(rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl)
 values('스터디룸테스트', '경기/인천', '회의실', 6, '페이징테스트', '1.jpg');
 insert into roomshare(rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl)
 values('스터디룸테스트', '경기/인천', '회의실', 6, '페이징테스트', '1.jpg');