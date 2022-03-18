use hibernateDemo

CREATE TABLE ProductType (
	[PT_ID] INT IDENTITY(1, 1) PRIMARY KEY NOT NULL, 
	[PT_Name] VARCHAR(20) NOT NULL, 
)
INSERT INTO ProductType VALUES
('-------·s¼W-------'),
('MEAT'),
('VEGE'), 
('SNACK'),
('BEVERAGE'),
('SEASONING'),
('STARCHY')



CREATE TABLE Product (
	[P_ID] INT NOT NULL IDENTITY(1, 1) PRIMARY KEY , 
	[PT_ID] INT NOT NULL REFERENCES ProductType(PT_ID), 
	[P_Name] NVARCHAR(20) NOT NULL, 
	[P_Stock] INT NOT NULL, 
	[P_Cost] NUMERIC(6, 1) NOT NULL, 
	[P_Price] NUMERIC(6, 1) NOT NULL, 
	[P_Image] VARCHAR(100) NOT NULL, 
	[P_Description] NVARCHAR(200) NOT NULL
)

INSERT INTO Product VALUES
(2, 	'¦w®æ´µ¤û',			20,		10,		15,		'1.jpg',	''),
(2, 	'«p¤Á¤û¤p±Æ',		50,		400,	470.5,	'2.jpg',	''),
(2, 	'¨F®Ô¤û±Æ',			50,		420.5,	490,	'3.jpg',	''),
(2, 	'µá¤O¹à¤Á»ë¤l¤û',	10,		500,	600.5,	'4.jpg',	''),
(3,	'°ªÄRµæ',			70,		80,		90,		'5.jpg',	''),
(3,	'«½«½µæ',			60,		60,		70.5,	'6.jpg',	''),
(3,	'¤é¥»Ó¦»U',			80,		60.5,	90,		'7.jpg',	''),
(3,	'½Ü¨§­]',			20,		55,		70,		'8.jpg',	'')

INSERT INTO Product VALUES
('MEAT', 	'¦w®æ´µ¤û',			20,		10,		15,		'1.jpg',	''),
('MEAT', 	'«p¤Á¤û¤p±Æ',		50,		400,	470.5,	'2.jpg',	''),
('MEAT', 	'¨F®Ô¤û±Æ',			50,		420.5,	490,	'3.jpg',	''),
('MEAT', 	'µá¤O¹à¤Á»ë¤l¤û',	10,		500,	600.5,	'4.jpg',	''),
('VEGE',	'°ªÄRµæ',			70,		80,		90,		'5.jpg',	''),
('VEGE',	'«½«½µæ',			60,		60,		70.5,	'6.jpg',	''),
('VEGE',	'¤é¥»Ó¦»U',			80,		60.5,	90,		'7.jpg',	''),
('VEGE',	'½Ü¨§­]',			20,		55,		70,		'8.jpg',	'')

CREATE TABLE Tag (
	[TagID] INT NOT NULL IDENTITY(1, 1) PRIMARY KEY , 
	[TagName] NVARCHAR(10) NOT NULL, 	
)
INSERT INTO Tag VALUES
('¦×'), ('µæ'), ('®üÂA'), ('¾ý¯»'), ('«æ­á'), ('§Y­¹'), ('·Lªi'), ('¯S»ù') 





select * from ProductType ORDER BY PT_ID
select * from product 
select * from product inner join ProductType on Product.PT_ID = ProductType.PT_ID
select * from Tag 

drop table product 
drop table ProductType 
