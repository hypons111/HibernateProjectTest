use HibernateDB

CREATE TABLE ProductType (
	[PT_ID] INT IDENTITY(1, 1) PRIMARY KEY NOT NULL, 
	[PT_Name] VARCHAR(20) UNIQUE NOT NULL, 
)
INSERT INTO ProductType VALUES
('-------新增-------'),
('BEEF'),
('PORK'),
('SEAFOOD')



CREATE TABLE Product (
	[P_ID] INT NOT NULL IDENTITY(1, 1) PRIMARY KEY , 
	[P_Type] VARCHAR(20) NOT NULL, 
	[P_Name] NVARCHAR(100) NOT NULL, 
	[P_Stock] INT NOT NULL, 
	[P_Cost] NUMERIC(6, 1) NOT NULL, 
	[P_Price] NUMERIC(6, 1) NOT NULL, 
	[P_Image] VARCHAR(100) NOT NULL, 
	[P_Description] NVARCHAR(200) NOT NULL, 
	[Supplier_ID] int NOT NULL
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
('PORK',	'Compart Duroc Pork Spareribs Rack “St. Louis Style”',				80,		60.5,	55,		'14.jpg', ''),
('PORK',	'Competition Grade BBQ, Compart Duroc Pork Back Ribs',					80,		60.5,	62,		'15.jpg', ''),
('PORK',	'Competition Grade BBQ, Compart Duroc Boneless Pork Butt',				80,		60.5,	35,		'16.jpg', ''),
('PORK',	'Competition Grade BBQ, Compart Duroc Bone In Pork Butt',				80,		60.5,	39,		'17.jpg', ''),
('PORK',	'Bone In Pork Chop',													80,		60.5,	55,		'18.jpg', ''),
('SEAFOOD',	'Shrimp, Tail On, Raw',													80,		26,	26,			'19.jpg', ''),
('SEAFOOD',	'Norwegian Salmon Filet 8oz (10# Case)',								80,		60.5,	130,	'20.jpg', ''),
('SEAFOOD',	'Wild Caught Alaskan Halibut / Norwegian Salmon Combo Case',			80,		60.5,	89.9,	'21.jpg', ''),
('SEAFOOD',	'Wild Caught, Alaskan Halibut 6oz Portions (10# Case)',					80,		60.5,	229,	'22.jpg', ''),
('SEAFOOD',	'Mahi – Mahi Filet, 6oz',												80,		60.5,	79,		'23.jpg', '')



CREATE TABLE Supplier (
	[Supplier_ID] INT IDENTITY(1, 1) PRIMARY KEY NOT NULL, 
	[Supplier_Name] VARCHAR(30) UNIQUE NOT NULL, 
)
INSERT INTO Supplier VALUES
('-------新增-------'),
('Panorama Meats'),
('American Butcher'),
('Niman Ranch'),
('Hook’s Cheese'),
('Revier Cattle'),
('Compart Duroc'),
('Greater Omaha Packing Co'),
('Jidori Chicken'),
('1855 Black Angus Beef'),
('Cape Grim Tasmanian Beef'),
('Mary’s Free Range Chickens'),
('Diestel Turkey Ranch'),
('Creekstone Farms')


CREATE TABLE OrderItem (
	[TEMP_OrderItem_ID] INT PRIMARY KEY IDENTITY(1001, 1),
	[TEMP_Order_ID] INT,
	[Product_ID] INT REFERENCES Product(P_ID),
	[Product_Quantity] INT Not Null
)




use HibernateDB
select * from supplier ORDER BY Supplier_ID
select * from product ORDER BY Supplier_ID
select * from ProductType ORDER BY PT_ID
select * from OrderItem ORDER BY Product_ID

select * from stock
select * from stocktransaction



drop table product 
drop table ProductType 
drop table OrderItem 