create table fileshare(
	fcode number(5),
	fname varchar(50),
	fileurl varchar(50),
	fdate varchar(50)
);

INSERT INTO fileshare(fname,fileurl, fdate) VALUES('우리집' ,'agc.jpg', now());

create sequence file_seq start with 1 increment by 1;


update fileshare set  fdate=to_char(sysdate,'mm-dd/HH:MM:SS') where fcode=24
select  * from fileshare;

