create database SWP
use SWP
go
--type true: admin, false: user
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
	Nickname nvarchar(50),
	Country nvarchar(50),
	AccountBalance float,
	[Email] nvarchar(70),
	Avatar nvarchar(100),
	IsDev bit,
	[Description] nvarchar(max),
	IsPrivate bit
)
go
--payment method 1: paypal 2: credit card 3: banking 4: buy game 5: sell game
create table Payment
(
	PaymentID int IDENTITY(1,1) primary key,
	Paidby int foreign key references [User](UserID),
	PaymentMethod int,
	[Money] float,
	[Date] date
)
go
create table Request
(
	RequestID int IDENTITY(1,1) primary key,
	RequestBy int foreign key references [User](UserID),
	[Status] int,
	Content nvarchar(100),
	[Time] smallDatetime
)
go
create table [Notification]
(
	NotiID int IDENTITY(1,1) primary key,
	[Type] int,
	Content nvarchar(max)
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
	--PublishedBy nvarchar(50),
	Download int,
	Discount int,
	Rate float,
	[Status] int,
	[Description] nvarchar(max),
	--Developer nvarchar(300),
	[Date] date,
	Poster nvarchar(max)
)
go

create table[User-Game-Developer]
(
	UserID int foreign key references [User](UserID),
	GameID int foreign key references [Game](GameID)
)
go
create table [User-Game-Comment]
(
	UserID int foreign key references [User](UserID),
	GameID int foreign key references [Game](GameID),
	Content nvarchar(max)
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
	CategoryName nvarchar(20),
	Cover nvarchar(max)
)
go
create table [Game-Category]
(
	GameID int foreign key references [Game](GameID),
	CategoryID int foreign key references Category(CategoryID)
)
go
--type 1: anh demo trong game, 2: poster, 3: video demo trong game
create table [Media]
(
	GameID int foreign key references [Game](GameID),
	Link nvarchar(100) primary key,
	[Type] int
)
go

