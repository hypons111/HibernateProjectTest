use HibernateDemo

CREATE TABLE ProductType (
	[PT_ID] INT IDENTITY(1, 1) PRIMARY KEY NOT NULL, 
	[PT_Name] VARCHAR(20) UNIQUE NOT NULL, 
)
INSERT INTO ProductType VALUES
(''),
('-------新增-------'),
('MEAT'),
('VEGE'), 
('SNACK'),
('BEVERAGE'),
('SEASONING'),
('STARCHY')


CREATE TABLE Product (
	[P_ID] INT NOT NULL IDENTITY(1, 1) PRIMARY KEY , 
	[PT_ID] VARCHAR(20) NOT NULL, 
	[P_Name] NVARCHAR(20) NOT NULL, 
	[P_Stock] INT NOT NULL, 
	[P_Cost] NUMERIC(6, 1) NOT NULL, 
	[P_Price] NUMERIC(6, 1) NOT NULL, 
	[P_Image] VARCHAR(100) NOT NULL, 
	[P_Description] NVARCHAR(200) NOT NULL
)

INSERT INTO Product VALUES
(3, '安格斯牛',			20,		10,		15,		'1.jpg',	''),
(3, '厚切牛小排',		50,		400,	470.5,	'2.jpg',	''),
(3, '沙朗牛排',			50,		420.5,	490,	'3.jpg',	''),
(3, '菲力嫩切骰子牛',	10,		500,	600.5,	'4.jpg',	''),
(4,	'高麗菜',			70,		80,		90,		'5.jpg',	''),
(4,	'娃娃菜',			60,		60,		70.5,	'6.jpg',	''),
(4,	'日本茼蒿',			80,		60.5,	90,		'7.jpg',	''),
(4,	'豌豆苗',			20,		55,		70,		'8.jpg',	'')

select * from product 
select * from ProductType ORDER BY PT_ID

drop table product 
drop table ProductType 


