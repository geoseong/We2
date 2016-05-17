
//스터디룸 테이블 생성
CREATE TABLE roomshare (
  rcode int primary key AUTO_INCREMENT,
  rname varchar(50),
  rlocation varchar(50),
  rlocationdetail varchar(50),
  rmember int,
  rcontent varchar(1000),
  rpictureurl varchar(100),
  userId varchar(30)

)engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;



//파일 첨부 테이블 생성
create table fileshare(
	fcode int primary key AUTO_INCREMENT,
	fname varchar(50),
	fileurl varchar(50),
	fdate varchar(50)
)engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


update fileshare set  fdate=to_char(sysdate,'mm-dd/HH:MM:SS') where fcode=24
select  * from fileshare;



rcode, rname, rlocation, rlocationdetail, rmemeber, rcontent, rpictureurl

INSERT INTO roomshare(rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl) VALUES('우리집' , '서울' , '커피전문점', 20, '넓고 쾌적합니다' ,'abcd.jpg');

delete * from roomshare where rcode=2

select * from roomshare

drop table roomshare;

select rcode, rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl from roomshare where rcode=3 order by rcode desc  ;
	
update roomshare set rname = '테스트1', rlocation = '서울', rlocationdetail = '커피전문점', rlocationdetail = '커피전문점'
	,rmember = '114', rcontent = '테스트요' where rcode = '3';