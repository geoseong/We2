/*
create table test_table (
idx int NOT NULL auto_increment,
name varchar(255),
... 블라 블라,
... 블라 블라,
... 블라 블라,  
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=euckr;
 */

-- 프로젝트게시판 - 조별과제
create table pGroup (
	itemNum	int NOT NULL AUTO_INCREMENT,
	itemTitle		varchar(80),
	userId		varchar(12),
	itemDate	DATE,
	itemClick	int,
	itemPath	varchar(50),
	itemContent 	varchar(1000),
	primary key (itemNum)
) engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


-- 가끔은 이놈을 초기화 시켜야 할때가 있습니다. 초기화 시키기 위한 꼬라지는 아래와 같습니다.
-- 테이블을 지워야지면 관련 auto_increment가 지워지는 듯? 그냥은 초기화가 안됨.
# ALTER TABLE [테이블명] AUTO_INCREMENT=[시작할려는 순서]



-- itemNum내림차순으로 select
select * from pGroup order by itemNum desc;

-- limit을 이용한 출력
select * from pGroup order by itemNum desc limit 0, 10;

SHOW TABLE STATUS FROM we2 LIKE 'pGroup';

select 
itemNum, itemTitle, userId, 
date_format(itemDate,%Y-%m-%d), 
itemClick, itemPath, itemContent
from pGroup limit 1, 10;

select 
date_format(itemDate,'%Y-%m-%d')  as idate,
itemClick, itemPath, itemContent
from pGroup ;

select  * from pgroup;

insert into pGroup(itemTitle,userId,itemDate,itemClick,itemPath,itemContent, itemDataType)
values('AOP 성공.', 'geoseong', curdate(), 
0, 'GitHub참고사이트4.xlsx', 
'게시판 업로드도 잘 되어야..', 
'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');

/** 참고로 MySQL에서는 UTF-8일 경우 한글은 3bytes, 영어는 1bytes 처리하네요 ^^*/
select length('application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');
select length('안녕');
select length(
"
MySQL은 UTF-8에선 한글 1글자가 3바이트로 인식된대요..
-
js/board.js에 현재 글자수가 몇글자인지 인식될수있도록 alert를 띄우게 해놨어요(시연할때에는 없앨거임)

자바스크립트에서는 한글자에 그냥 1byte인것마냥 인식하는듯하니..

MySQL의 itemContent 컬럼의 글자길이를 1000 => 3000 으로 바꿉시다.

아래 SQL문처럼!

# 컬럼 이름 & 데이터타입 바꾸기
ALTER TABLE pgroup CHANGE itemContent itemContent VARCHAR(3000);
");
desc pgroup;
delete from pgroup where itemnum=68;

# 컬럼 이름 & 데이터타입 바꾸기
ALTER TABLE pgroup CHANGE itemContent itemContent VARCHAR(3000);