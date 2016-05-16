CREATE TABLE roomshare (
  rcode int primary key AUTO_INCREMENT,
  rname varchar(50),
  rlocation varchar(50),
  rlocationdetail varchar(50),
  rmember int,
  rcontent varchar(1000),
  rpictureurl varchar(100),

)engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


rcode, rname, rlocation, rlocationdetail, rmemeber, rcontent, rpictureurl

INSERT INTO roomshare(rname, rlocation, rlocationdetail, rmember, rcontent, rpictureurl) VALUES('엔젤리너스' , '서울' , '커피전문점', 20, '넓고 쾌적합니다' ,'abcd.jpg');

select * from roomshare

drop table roomshare;