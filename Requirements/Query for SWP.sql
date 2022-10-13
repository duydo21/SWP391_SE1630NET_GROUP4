--database Category
INSERT INTO Category (CategoryName) VALUES ('Indie');
INSERT INTO Category (CategoryName) VALUES ('Action-adventure');
INSERT INTO Category (CategoryName) VALUES ('Casual');
INSERT INTO Category (CategoryName) VALUES ('RPG');
INSERT INTO Category (CategoryName) VALUES ('Puzzle');
INSERT INTO Category (CategoryName) VALUES ('Soul-like');
INSERT INTO Category (CategoryName) VALUES ('FPS');
INSERT INTO Category (CategoryName) VALUES ('Third-Person');
INSERT INTO Category (CategoryName) VALUES ('Metroidvania');
INSERT INTO Category (CategoryName) VALUES ('Platformer');
INSERT INTO Category (CategoryName) VALUES ('2D');
INSERT INTO Category (CategoryName) VALUES ('3D');
INSERT INTO Category (CategoryName) VALUES ('Run N Gun');
INSERT INTO Category (CategoryName) VALUES ('Survival');
INSERT INTO Category (CategoryName) VALUES ('Horror');
INSERT INTO Category (CategoryName) VALUES ('Visual novel');
INSERT INTO Category (CategoryName) VALUES ('Rhythm');
INSERT INTO Category (CategoryName) VALUES ('Battle Royale');
INSERT INTO Category (CategoryName) VALUES ('Beat them up');

--select * from Category

INSERT INTO Category (CategoryName) VALUES ('Turn-based');
INSERT INTO Category (CategoryName) VALUES ('Sports');
INSERT INTO Category (CategoryName) VALUES ('Strategy');
INSERT INTO Category (CategoryName) VALUES ('Racing');
INSERT INTO Category (CategoryName) VALUES ('Rouge-like');
INSERT INTO Category (CategoryName) VALUES ('Rouge-lite');
INSERT INTO Category (CategoryName) VALUES ('Simulation');


--database for games
select * from Game
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description], [Date], Poster) VALUES ('Cuphead', 180000,  5370156, 9.6, 1, 'Cuphead is a classic run and gun action game heavily focused on boss battles. Inspired by cartoons of the 1930s, the visuals and audio are painstakingly created with the same techniques of the era, i.e. traditional hand drawn cel animation, watercolor backgrounds, and original jazz recordings.', '2017-9-29','games/Cuphead.jpg');
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description], [Date], Poster) VALUES ('Hollow Knight', 165000,  5686231, 9.7, 1, 'Forge your own path in Hollow Knight! An epic action adventure through a vast ruined kingdom of insects and heroes. Explore twisting caverns, battle tainted creatures and befriend bizarre bugs, all in a classic, hand-drawn 2D style.', '2017-2-25','games/Hollow Knight.jpg');
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('Anger Foot', '0',  '0', '0', '2', 'Anger Foot is a lightning-fast action FPS where the only things harder than your ass-kicking feet are the ass-kicking beats.',  '2023-1-1','games/Anger Foot.jpg');
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('Cult of the Lamb', '400000',  '125468', '9.2', '1', 'Start your own cult in a land of false prophets, venturing out into diverse and mysterious regions to build a loyal community of woodland Followers and spread your Word to become the one true cult.',  '2022-8-11','games/Cult of the Lamb.jpg');
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('The Binding of Isaac: Rebirth', '70000',  '3521230', '9.7', '1', 'The Binding of Isaac is a randomly generated action RPG shooter with heavy Rogue-like elements. Following Isaac on his journey players will find bizarre treasures that change Isaac’s form giving him super human abilities and enabling him to fight off droves of mysterious creatures, discover secrets and fight his way to safety.',  '2011-9-29','games/TBOI Rebirth.jpg');
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('The Binding of Isaac', '165000', '12565871', '9.3', '1', 'The Binding of Isaac: Rebirth is a randomly generated action RPG shooter with heavy Rogue-like elements. Following Isaac on his journey players will find bizarre treasures that change Isaac’s form giving him super human abilities and enabling him to fight off droves of mysterious creatures, discover secrets...',  '2014-11-5','games/TBOI.jpg');
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('DOOM', '450000',  '7463210', '9.6', '1', 'Developed by id software, the studio that pioneered the first-person shooter genre and created multiplayer Deathmatch, DOOM returns as a brutally fun and challenging modern-day shooter experience. Relentless demons, impossibly destructive guns, and fast, fluid movement provide the foundation for intense, first-person combat – whether you’re obliterating demon hordes through the depths of Hell in the single-player campaign, or competing against your friends in numerous multiplayer modes. Expand your gameplay experience using DOOM SnapMap game editor to easily create, play, and share your content with the world.',  '2016-12-5','games/DOOM.jpg');
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('Dying Light', '329000',  '15000354', '9.5', '1', 'First-person action survival game set in a post-apocalyptic open world overrun by flesh-hungry zombies. Roam a city devastated by a mysterious virus epidemic. Scavenge for supplies, craft weapons, and face hordes of the infected',  '2015-1-26','games/Dying Light.jpg');
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('Shotgun King: The Final Checkmate', '129000',  '75230', '9.1', '1', 'Chess, but you replace your entire army with a royal shotgun. A unique strategy roguelike based on the timeless checkboard classic.',  '2022-5-12','games/Shotgun King The Final Checkmate.jpg');
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('Vampire Survivors', '70000',  '1265040', '9.7', '2', 'Mow down thousands of night creatures and survive until dawn! Vampire Survivors is a gothic horror casual game with rogue-lite elements, where your choices can allow you to quickly snowball against the hundreds of monsters that get thrown at you.',  '2021-12-17','games/Vampire Survivors.jpg');
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('Deep Rock Galatic', '250000',  '6154280', '9.7', '1', 'Deep Rock Galactic is a 1-4 player co-op FPS featuring badass space Dwarves, 100% destructible environments, procedurally-generated caves, and endless hordes of alien monsters.',  '2020-5-13','games/Deep Rock Galatic.jpg');
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('UNBEATABLE [white label]', '0',  '322350', '9.6', '1', 'A young girl learns a song. An exclusive side-story set in the world of D-CELL GAMES\ upcoming rhythm-adventure.',  '2021-5-7','games/UNBEATABLE.jpg');
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description], [Date], Poster) VALUES ('Notia', '188000',  '1503462', '9.5', '1', 'Noita is a magical action roguelite set in a world where every pixel is physically simulated. Fight, explore, melt, burn, freeze and evaporate your way through the procedurally generated world using spells you have created yourself.', '2020-10-16','games/Notia.jpg');
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('Back 4 Blood', '990000',  '1356202', '6.5', '1', 'Back 4 Blood is a thrilling cooperative first-person shooter from the creators of the critically acclaimed Left 4 Dead franchise. Experience the intense 4 player co-op narrative campaign, competitive multiplayer as human or Ridden, and frenetic gameplay that keeps you in the action.',  '2021-12-10','games/Back 4 Blood.jpg');
INSERT INTO Game ([Name], Price,  Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('Madden NFL 23', '990000',  '22301', '3.9', '1', 'Play your way into the history books. Control your impact with every decision in all-new ways. Call the shots in Franchise with free agency and trade logic updates, leave a legacy in Face of the Franchise: The League, and assemble the most powerful roster in all of Madden Ultimate Team™.',  '2022-8-19','games/Madden NFL 23.jpg');
INSERT INTO Game ([Name], Price, Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('Left 4 Dead 2', '120000', '32541200', '9.7', '1', 'Set in the zombie apocalypse, Left 4 Dead 2 (L4D2) is the highly anticipated sequel to the award-winning Left 4 Dead, the #1 co-op game of 2008. This co-operative action horror FPS takes you and your friends through the cities, swamps and cemeteries of the Deep South, from Savannah to New Orleans across five expansive campaigns.',  '2009-11-17','games/Left 4 Dead 2.jpg');
INSERT INTO Game ([Name], Price, Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('Resident Evil 2', '538000',  '4230158', '9.7', '1', 'A deadly virus engulfs the residents of Raccoon City in September of 1998, plunging the city into chaos as flesh eating zombies roam the streets for survivors. An unparalleled adrenaline rush, gripping storyline, and unimaginable horrors await you. Witness the return of Resident Evil 2.',  '2019-1-25','games/Resident Evil 2.jpg');
INSERT INTO Game ([Name], Price, Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('The Death | Thần Trùng', '75000',  '100032', '9.4', '1', 'Thần Trùng | The Death là trò chơi phiêu lưu kinh dị tâm lý do 3 ngư�?i Việt phát triển. Game lấy bối cảnh thành phố Hà Nội năm 2021.',  '2022-9-15','games/The Death.jpg');
INSERT INTO Game ([Name], Price, Download, Rate, [Status], [Description],  [Date], Poster) VALUES ('Persona 4 Golden', '380000', '2015487', '9.7', '1', 'A coming of age story that sets the protagonist and his friends on a journey kickstarted by a chain of serial murders.',  '2020-6-14','games/Persona 4 Golden.jpg');

--database for user-game-developer
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,1) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,2) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,3) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,4) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,5) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,6) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,7) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,8) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,9) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,10) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,11) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,12) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,13) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,14) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,15) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,16) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,17) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,18) ;
--INSERT INTO [dbo].[User-Game-Developer] (UserID, GameID) VALUES (,19) ;

update Game set Discount = 0 
--select * from Media
--type 1: anh demo trong game, 2: video demo trong game
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (1,'asset/cuphead/c1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (1,'asset/cuphead/c2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (1,'asset/cuphead/c3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (1,'asset/cuphead/c4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (1,'asset/cuphead/c5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (1,'asset/cuphead/c6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (1,'asset/cuphead/c7.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (1,'asset/cuphead/c8.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (1,'asset/cuphead/Cuphead.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (2,'asset/Hollow Knight/h1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (2,'asset/Hollow Knight/h2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (2,'asset/Hollow Knight/h3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (2,'asset/Hollow Knight/h4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (2,'asset/Hollow Knight/h5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (2,'asset/Hollow Knight/h6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (2,'asset/Hollow Knight/h7.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (2,'asset/Hollow Knight/Hollow Knight.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (3,'asset/anger foot/a1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (3,'asset/anger foot/a2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (3,'asset/anger foot/a3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (3,'asset/anger foot/a4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (3,'asset/anger foot/a5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (3,'asset/anger foot/a6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (3,'asset/anger foot/a7.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (3,'asset/anger foot/Anger Foot.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (4,'asset/Cult Of The Lamb/c1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (4,'asset/Cult Of The Lamb/c2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (4,'asset/Cult Of The Lamb/c3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (4,'asset/Cult Of The Lamb/c4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (4,'asset/Cult Of The Lamb/c5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (4,'asset/Cult Of The Lamb/c6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (4,'asset/Cult Of The Lamb/c7.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (4,'asset/Cult Of The Lamb/c8.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (4,'asset/Cult Of The Lamb/c9.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (4,'asset/Cult Of The Lamb/c10.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (4,'asset/Cult Of The Lamb/Cult Of The Lamb.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (5,'asset/TBOI Rebirth/t1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (5,'asset/TBOI Rebirth/t2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (5,'asset/TBOI Rebirth/t3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (5,'asset/TBOI Rebirth/t4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (5,'asset/TBOI Rebirth/t5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (5,'asset/TBOI Rebirth/t6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (5,'asset/TBOI Rebirth/t7.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (5,'asset/TBOI Rebirth/t8.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (5,'asset/TBOI Rebirth/t9.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (5,'asset/TBOI Rebirth/movie480.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (6,'asset/TBOI/c1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (6,'asset/TBOI/c2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (6,'asset/TBOI/c3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (6,'asset/TBOI/c4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (6,'asset/TBOI/c5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (6,'asset/TBOI/c6.jpg',1)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (7,'asset/DOOM/d1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (7,'asset/DOOM/d2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (7,'asset/DOOM/d3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (7,'asset/DOOM/d4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (7,'asset/DOOM/d5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (7,'asset/DOOM/d6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (7,'asset/DOOM/d7.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (7,'asset/DOOM/d8.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (7,'asset/DOOM/Doom.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (8,'asset/Dying Light/c1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (8,'asset/Dying Light/c2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (8,'asset/Dying Light/c3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (8,'asset/Dying Light/c4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (8,'asset/Dying Light/c5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (8,'asset/Dying Light/c6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (8,'asset/Dying Light/c7.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (8,'asset/Dying Light/c8.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (8,'asset/Dying Light/c9.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (8,'asset/Dying Light/c10.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (8,'asset/Dying Light/c11.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (8,'asset/Dying Light/movie480.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (9,'asset/Shotgun King/s1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (9,'asset/Shotgun King/s2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (9,'asset/Shotgun King/s3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (9,'asset/Shotgun King/s4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (9,'asset/Shotgun King/s5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (9,'asset/Shotgun King/s6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (9,'asset/Shotgun King/movie480_vp9.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (10,'asset/Vampire Survivors/c1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (10,'asset/Vampire Survivors/c2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (10,'asset/Vampire Survivors/c3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (10,'asset/Vampire Survivors/c4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (10,'asset/Vampire Survivors/c5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (10,'asset/Vampire Survivors/movie480_vp9.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (11,'asset/DRG/c1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (11,'asset/DRG/c2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (11,'asset/DRG/c3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (11,'asset/DRG/c4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (11,'asset/DRG/c5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (11,'asset/DRG/c6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (11,'asset/DRG/c7.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (11,'asset/DRG/c8.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (11,'asset/DRG/c9.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (11,'asset/DRG/c10.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (11,'asset/DRG/movie480_vp9.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (12,'asset/UNBEATABLE/c1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (12,'asset/UNBEATABLE/c2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (12,'asset/UNBEATABLE/c3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (12,'asset/UNBEATABLE/c4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (12,'asset/UNBEATABLE/c5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (12,'asset/UNBEATABLE/c6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (12,'asset/UNBEATABLE/c7.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (12,'asset/UNBEATABLE/movie480_vp9.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (13,'asset/Noita/c1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (13,'asset/Noita/c2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (13,'asset/Noita/c3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (13,'asset/Noita/c4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (13,'asset/Noita/c5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (13,'asset/Noita/c6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (13,'asset/Noita/c7.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (13,'asset/Noita/c8.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (13,'asset/Noita/c9.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (13,'asset/Noita/c10.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (13,'asset/Noita/movie480_vp9.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (14,'asset/B4B/c1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (14,'asset/B4B/c2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (14,'asset/B4B/c3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (14,'asset/B4B/c4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (14,'asset/B4B/c5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (14,'asset/B4B/c6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (14,'asset/B4B/movie480_vp9.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (15,'asset/NFL 23/c1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (15,'asset/NFL 23/c2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (15,'asset/NFL 23/c3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (15,'asset/NFL 23/c4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (15,'asset/NFL 23/c5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (15,'asset/NFL 23/movie480_vp9.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (16,'asset/Left 4 Dead 2/c1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (16,'asset/Left 4 Dead 2/c2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (16,'asset/Left 4 Dead 2/c3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (16,'asset/Left 4 Dead 2/c4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (16,'asset/Left 4 Dead 2/c5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (16,'asset/Left 4 Dead 2/c6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (16,'asset/Left 4 Dead 2/c7.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (16,'asset/Left 4 Dead 2/c8.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (16,'asset/Left 4 Dead 2/c9.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (16,'asset/Left 4 Dead 2/c10.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (16,'asset/Left 4 Dead 2/c11.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (16,'asset/Left 4 Dead 2/c12.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (16,'asset/Left 4 Dead 2/c13.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (16,'asset/Left 4 Dead 2/movie480.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (17,'asset/Resident Evil 2/c1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (17,'asset/Resident Evil 2/c2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (17,'asset/Resident Evil 2/c3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (17,'asset/Resident Evil 2/c4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (17,'asset/Resident Evil 2/c5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (17,'asset/Resident Evil 2/c6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (17,'asset/Resident Evil 2/c7.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (17,'asset/Resident Evil 2/c8.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (17,'asset/Resident Evil 2/c9.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (17,'asset/Resident Evil 2/c10.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (17,'asset/Resident Evil 2/movie480.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (18,'asset/The Death/c1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (18,'asset/The Death/c2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (18,'asset/The Death/c3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (18,'asset/The Death/c4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (18,'asset/The Death/c5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (18,'asset/The Death/movie480_vp9.webm',2)

INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (19,'asset/Persona 4 Golden/c1.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (19,'asset/Persona 4 Golden/c2.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (19,'asset/Persona 4 Golden/c3.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (19,'asset/Persona 4 Golden/c4.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (19,'asset/Persona 4 Golden/c5.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (19,'asset/Persona 4 Golden/c6.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (19,'asset/Persona 4 Golden/c7.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (19,'asset/Persona 4 Golden/c8.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (19,'asset/Persona 4 Golden/c9.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (19,'asset/Persona 4 Golden/c10.jpg',1)
INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (19,'asset/Persona 4 Golden/movie480_vp9.webm',2)

--INSERT INTO [dbo].[Media]([GameID] ,[Link] ,[Type]) VALUES (,'asset/',)
--select * from Game
--select * from Media order by GameID

--select * from [Game-Category]
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (1,1)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (1,10)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (1,11)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (2,1)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (2,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (2,6)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (2,9)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (2,10)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (2,11)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (3,1)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (3,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (3,7)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (4,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (4,24)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (4,25)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (5,1)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (5,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (5,24)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (6,1)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (6,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (6,24)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (7,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (7,7)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (7,13)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (8,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (8,15)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (9,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (9,20)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (9,22)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (9,24)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (10,1)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (10,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (10,4)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (10,11)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (10,24)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (11,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (11,7)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (11,13)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (12,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (12,11)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (13,1)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (13,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (13,11)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (13,24)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (14,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (14,7)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (14,13)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (15,12)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (15,21)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (15,26)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (16,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (16,7)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (16,13)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (16,15)


INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (17,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (17,8)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (17,15)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (18,1)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (18,2)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (18,5)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (18,15)

INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (19,4)
INSERT INTO [dbo].[Game-Category]([GameID],[CategoryID]) VALUES (19,20)
