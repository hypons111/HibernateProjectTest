use HibernateDB

CREATE TABLE ProductType (
	[ProductType_ID] INT IDENTITY(1, 1) PRIMARY KEY NOT NULL, 
	[ProductType_Name] VARCHAR(20) UNIQUE NOT NULL, 
)
INSERT INTO ProductType VALUES
('-------·s¼W-------'),
('BEEF'),
('PORK'),
('SEAFOOD')



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
('BEEF', 	'Choice Angus Bone-In Standing Rib Roast (4-Bone)',						100,	10,		220,	'1.jpg', ''),
('BEEF', 	'Choice Angus Bone In, Standing Rib Roast (7-Bone)',					100,	400,	299,	'2.jpg', ''),
('BEEF', 	'USDA Prime Grade, Standing Rib Roast, Boneless (half of Rib, Netted)',	100,	420.5,	175,	'3.jpg', ''),
('BEEF', 	'USDA Prime Grade, Standing Rib Roast, Boneless (Whole Rib, Netted)',	100,	500,	315,	'4.jpg', ''),
('BEEF',	'USDA Choice Filet Steak',												100,	90,		100,	'5.jpg', ''),
('BEEF',	'USDA Choice Ribeye Steak',												100,	60,		110,	'6.jpg', ''),
('BEEF',	'USDA Prime Top Sirloin Steak (Thick Cut, Defatted)', 					100,	60,		39,		'7.jpg', ''),
('BEEF',	'Gourmet Blend Premium Hamburger Patty, 3/1',							100,	60,		28,		'8.jpg', ''),
('BEEF',	'Cape Grim, All Natural, Grass Fed, Hamburger Patty, 3/1',				100,	60,		25,		'9.jpg', ''),
('BEEF',	'USDA Choice Angus Tri Tip, Defatted',									100,	60,		64,		'10.jpg', ''),
('BEEF',	'Filet Mignon Brochette',												100,	60,		49,		'11.jpg', ''),
('PORK',	'Nueske Applewood Smoked, Spiral Sliced, Bone In Ham',					80,		60.5,	109.9,	'12.jpg', ''),
('PORK',	'Nueske Premium Applewood Smoked Bacon (5# Bulk)',						80,		60.5,	62,		'13.jpg', ''),
('PORK',	'Compart Duroc Pork Spareribs Rack ¡§St. Louis Style¡¨',				80,		60.5,	55,		'14.jpg', ''),
('PORK',	'Competition Grade BBQ, Compart Duroc Pork Back Ribs',					80,		60.5,	62,		'15.jpg', ''),
('PORK',	'Competition Grade BBQ, Compart Duroc Boneless Pork Butt',				80,		60.5,	35,		'16.jpg', ''),
('PORK',	'Competition Grade BBQ, Compart Duroc Bone In Pork Butt',				80,		60.5,	39,		'17.jpg', ''),
('PORK',	'Bone In Pork Chop',													80,		60.5,	55,		'18.jpg', ''),
('SEAFOOD',	'Shrimp, Tail On, Raw',													80,		26,	26,			'19.jpg', ''),
('SEAFOOD',	'Norwegian Salmon Filet 8oz (10# Case)',								80,		60.5,	130,	'20.jpg', ''),
('SEAFOOD',	'Wild Caught Alaskan Halibut / Norwegian Salmon Combo Case',			80,		60.5,	89.9,	'21.jpg', ''),
('SEAFOOD',	'Wild Caught, Alaskan Halibut 6oz Portions (10# Case)',					80,		60.5,	229,	'22.jpg', ''),
('SEAFOOD',	'Mahi ¡V Mahi Filet, 6oz',												80,		60.5,	79,		'23.jpg', '')








use HibernateDB
select * from product ORDER BY product_ID
select * from ProductType ORDER BY producttype_ID




drop table product 
drop table ProductType 


