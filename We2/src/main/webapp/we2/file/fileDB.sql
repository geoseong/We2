create table fileshare(
	fcode number(5),
	fname varchar(50),
	fileurl varchar(50),
	fdate varchar(50)
);

INSERT INTO fileshare(fname,fileurl, fdate) VALUES('우리집' ,'agc.jpg', date_format(now(),'%y-%m-%d-%h:%m:%s'));

create sequence file_seq start with 1 increment by 1;



select  * from fileshare;

