CREATE TABLE scheduler (
	calendarmemo_num int primary key AUTO_INCREMENT,
	pjtcode int,
	calendarmemo_year int, 
	calendarmemo_month int, 
	calendarmemo_day int, 
	calendarmemo_contents VARCHAR(500) 
)engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;



select * from scheduler;
select * from scheduler where pjtcode=10 order by calendarmemo_day asc;

insert into scheduler(calendarmemo_year, pjtcode, calendarmemo_month, calendarmemo_day, calendarmemo_contents) values( date_format(now() ,'%Y'), 20, date_format(now() ,'%m'), 8, 'test1')

drop table scheduler;



calendarmemo_num, calendarmemo_year, calendarmemo_month, calendarmemo_day, calendarmemo_contents