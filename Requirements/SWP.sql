create database SWP
use SWP
go

create table Account
(
      Username nvarchar(50) primary key,
      [Password]nvarchar(20),
	  [Type] bit
)
go
create table [Admin]
(
		AdminID int IDENTITY(1,1) primary key,
		[Email] nvarchar(70),
		[Name] nvarchar(50) foreign key references [Account](Username)
)
go
create table [User]
(
	UserID int IDENTITY(1,1) primary key,
	[Name] nvarchar(50) foreign key references [Account](Username),
	Country nvarchar(50),
	AccountBalance float,
	[Email] nvarchar(70)
)
go
create table Payment
(
	PaymentID int IDENTITY(1,1) primary key,
	Paidby int foreign key references [User](UserID),
	PaymentMethod int
)
go
create table Request
(
	RequestID int IDENTITY(1,1) primary key,
	RequestBy int foreign key references [User](UserID),
	[Status] int,
	Content nvarchar(100)
)
go
create table [Notification]
(
	NotiID int IDENTITY(1,1) primary key,
	[Type] int,
	Content nvarchar(100)
)
go
create table [User-Notification]
(
	NotiID int foreign key references [Notification](NotiID),
	UserID int foreign key references [User](UserID)
)
go

create table [Game]
(
	GameID int IDENTITY(1,1) primary key,
	[Name] nvarchar(100),
	Price float,
	PublishedBy nvarchar(50),
	Download int,
	Rate float,
	[Status] int,
	[Description] nvarchar(300)
)
go
create table [User-Game-Comment]
(
	UserID int foreign key references [User](UserID),
	GameID int foreign key references [Game](GameID),
	Content nvarchar(300)
)
go
create table [User-Game-Rate]
(
	UserID int foreign key references [User](UserID),
	GameID int foreign key references [Game](GameID),
	Rate int
)
go
create table [User-Game-Report]
(
	UserID int foreign key references [User](UserID),
	GameID int foreign key references [Game](GameID),
	Content nvarchar(300)
)
go
create table [User-Game-Buy]
(
	UserID int foreign key references [User](UserID),
	GameID int foreign key references [Game](GameID),
	[Date] date
)
go
create table Category
(
	CategoryID int IDENTITY(1,1) primary key,
	CategoryName nvarchar(20)
)
go
create table [Game-Category]
(
	GameID int foreign key references [Game](GameID),
	CategoryID int foreign key references Category(CategoryID)
)
go