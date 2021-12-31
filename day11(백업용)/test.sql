create table board22(
   bid int primary key,
   title varchar(20),
   writer varchar(10),
   content varchar(50),
   bdate date default sysdate,
   cnt int default 0
);

select * from BOARD22
select nvl(max(bid),0) from board22

create table member22(
	mid varchar(10) primary key,
	password varchar(10),
	mname varchar(10),
	role varchar(10)
);


