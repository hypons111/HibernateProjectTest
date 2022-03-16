
use HibernateDemo;

drop table member;

create table member(
	memberid int not null primary key identity(1001,1),
	membername nvarchar(10) not null,
	gender nvarchar(2) not null,
	account varchar(10) not null unique,
	encrypt_pwd varchar(10) not null,
	salt int not null,
	email varchar(64) not null,
	imagefilename varchar(20) not null,
	registertime datetime2(0) not null,
	roleid int not null
);

select * from member;

insert into member values('�s�մD','�k','vicky','1450575499','40','vicky@gmail.com','2.jpg',getdate(),9);
insert into member values('��s�N','�k','john','1450575534','75','john@gmail.com','1646043885278.jpg',getdate(),10);
insert into member values('���ӻ�','�k','ethan','1450575477','18','ethan@gmail.com','1.jpg',getdate(),9);
insert into member values('�����M','�k','tommy','1450575503','44','tommy@gmail.com','1.jpg',getdate(),9);
insert into member values('���~��','�k','ivan','1450575463','4','ivan@gmail.com','1.jpg',getdate(),9);
insert into member values('������','�k','annie','1450575492','33','annie@gmail.com','2.jpg',getdate(),0);
insert into member values('�L�Ӿ�','�k','jeff','1450575557','98','jeff@gmail.com','1.jpg',getdate(),0);
insert into member values('������','�k','cyrus','1450575555','96','cyrus@gmail.com','1.jpg',getdate(),0);
insert into member values('�d����','�k','tony','1450575483','24','tony@gmail.com','1.jpg',getdate(),0);
insert into member values('�i�ʦt','�k','tim','1450575491','32','tim@gmail.com','1.jpg',getdate(),0);

select * from member;