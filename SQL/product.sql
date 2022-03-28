use HibernateDB

CREATE TABLE ProductType (
	[ProductType_ID] INT IDENTITY(1, 1) PRIMARY KEY NOT NULL, 
	[ProductType_Name] VARCHAR(20) UNIQUE NOT NULL, 
)
INSERT INTO ProductType VALUES
('-------·s¼W-------'),
('Beef'),
('Pork'),
('Seafood')



CREATE TABLE Product (
	[Product_ID] INT NOT NULL IDENTITY(1, 1) PRIMARY KEY , 
	[Product_Type] VARCHAR(20) NOT NULL, 
	[Product_Name] NVARCHAR(100) NOT NULL, 
	[Product_Stock] INT NOT NULL, 
	[Product_Cost] NUMERIC(6, 1) NOT NULL, 
	[Product_Price] NUMERIC(6, 1) NOT NULL, 
	[Product_Image] VARCHAR(100) NOT NULL, 
	[Product_Description] NVARCHAR(200) NOT NULL
)

INSERT INTO Product VALUES
('Beef', 	'Choice Angus Bone-In Standing Rib Roast (4-Bone)',						100,	10,		220,	'1.jpg', ''),
('Beef', 	'Choice Angus Bone In, Standing Rib Roast (7-Bone)',					100,	400,	299,	'2.jpg', ''),
('Beef', 	'USDA Prime Grade, Standing Rib Roast, Boneless (half of Rib, Netted)',	100,	420.5,	175,	'3.jpg', ''),
('Beef', 	'USDA Prime Grade, Standing Rib Roast, Boneless (Whole Rib, Netted)',	100,	500,	315,	'4.jpg', ''),
('Beef',	'USDA Choice Filet Steak',												100,	90,		100,	'5.jpg', ''),
('Beef',	'USDA Choice Ribeye Steak',												100,	60,		110,	'6.jpg', ''),
('Beef',	'USDA Prime Top Sirloin Steak (Thick Cut, Defatted)', 					100,	60,		39,		'7.jpg', ''),
('Beef',	'Gourmet Blend Premium Hamburger Patty, 3/1',							100,	60,		28,		'8.jpg', ''),
('Beef',	'Cape Grim, All Natural, Grass Fed, Hamburger Patty, 3/1',				100,	60,		25,		'9.jpg', ''),
('Beef',	'USDA Choice Angus Tri Tip, Defatted',									100,	60,		64,		'10.jpg', ''),
('Beef',	'Filet Mignon Brochette',												100,	60,		49,		'11.jpg', ''),
('Pork',	'Nueske Applewood Smoked, Spiral Sliced, Bone In Ham',					80,		60.5,	109.9,	'12.jpg', ''),
('Pork',	'Nueske Premium Applewood Smoked Bacon (5# Bulk)',						80,		60.5,	62,		'13.jpg', ''),
('Pork',	'Compart Duroc Pork Spareribs Rack ¡§St. Louis Style¡¨',				80,		60.5,	55,		'14.jpg', ''),
('Pork',	'Competition Grade BBQ, Compart Duroc Pork Back Ribs',					80,		60.5,	62,		'15.jpg', ''),
('Pork',	'Competition Grade BBQ, Compart Duroc Boneless Pork Butt',				80,		60.5,	35,		'16.jpg', ''),
('Pork',	'Competition Grade BBQ, Compart Duroc Bone In Pork Butt',				80,		60.5,	39,		'17.jpg', ''),
('Pork',	'Bone In Pork Chop',													80,		60.5,	55,		'18.jpg', ''),
('Seafood',	'Shrimp, Tail On, Raw',													80,		26,	26,			'19.jpg', ''),
('Seafood',	'Norwegian Salmon Filet 8oz (10# Case)',								80,		60.5,	130,	'20.jpg', ''),
('Seafood',	'Wild Caught Alaskan Halibut / Norwegian Salmon Combo Case',			80,		60.5,	89.9,	'21.jpg', ''),
('Seafood',	'Wild Caught, Alaskan Halibut 6oz Portions (10# Case)',					80,		60.5,	229,	'22.jpg', ''),
('Seafood',	'Mahi ¡V Mahi Filet, 6oz',												80,		60.5,	79,		'23.jpg', '')








use HibernateDB
select * from product ORDER BY product_ID
select * from ProductType ORDER BY producttype_ID




use HibernateDB
drop table product 
drop table ProductType 


