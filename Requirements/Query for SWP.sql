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
--delete from Game
select * from Game
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer,[Date]) VALUES ('Cuphead', 180000, 'Studio MDHR Entertainment Inc.', 5370156, 9.6, 1, 'Cuphead is a classic run and gun action game heavily focused on boss battles. Inspired by cartoons of the 1930s, the visuals and audio are painstakingly created with the same techniques of the era, i.e. traditional hand drawn cel animation, watercolor backgrounds, and original jazz recordings.', 'Studio MDHR Entertainment Inc.','2017-9-29');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer,[Date]) VALUES ('Hollow Knight', 165000, 'Team Cherry', 5686231, 9.7, 1, 'Forge your own path in Hollow Knight! An epic action adventure through a vast ruined kingdom of insects and heroes. Explore twisting caverns, battle tainted creatures and befriend bizarre bugs, all in a classic, hand-drawn 2D style.', 'Team Cherry','2017-2-25');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('Anger Foot', '0', 'Devolver Digital', '0', '0', '2', 'Anger Foot is a lightning-fast action FPS where the only things harder than your ass-kicking feet are the ass-kicking beats.', 'Free Lives', '2023-1-1');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('Cult of the Lamb', '400000', 'Devolver Digital', '125468', '9.2', '1', 'Start your own cult in a land of false prophets, venturing out into diverse and mysterious regions to build a loyal community of woodland Followers and spread your Word to become the one true cult.', 'Massive Monster', '2022-8-11');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('The Binding of Isaac: Rebirth', '70000', 'Nicalis, Inc.', '3521230', '9.7', '1', 'The Binding of Isaac is a randomly generated action RPG shooter with heavy Rogue-like elements. Following Isaac on his journey players will find bizarre treasures that change Isaac’s form giving him super human abilities and enabling him to fight off droves of mysterious creatures, discover secrets and fight his way to safety.', 'Edmund McMillen', '2011-9-29');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('The Binding of Isaac', '165000', 'Nicalis, Inc.', '12565871', '9.3', '1', 'The Binding of Isaac: Rebirth is a randomly generated action RPG shooter with heavy Rogue-like elements. Following Isaac on his journey players will find bizarre treasures that change Isaac’s form giving him super human abilities and enabling him to fight off droves of mysterious creatures, discover secrets...', 'Edmund McMillen', '2014-11-5');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('DOOM', '450000', 'Bethesda Softworks', '7463210', '9.6', '1', 'Developed by id software, the studio that pioneered the first-person shooter genre and created multiplayer Deathmatch, DOOM returns as a brutally fun and challenging modern-day shooter experience. Relentless demons, impossibly destructive guns, and fast, fluid movement provide the foundation for intense, first-person combat – whether you’re obliterating demon hordes through the depths of Hell in the single-player campaign, or competing against your friends in numerous multiplayer modes. Expand your gameplay experience using DOOM SnapMap game editor to easily create, play, and share your content with the world.', 'id Software', '2016-12-5');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('Dying Light', '329000', 'Techland', '15000354', '9.5', '1', 'First-person action survival game set in a post-apocalyptic open world overrun by flesh-hungry zombies. Roam a city devastated by a mysterious virus epidemic. Scavenge for supplies, craft weapons, and face hordes of the infected', 'Techland', '2015-1-26');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('Shotgun King: The Final Checkmate', '129000', 'PUNKCAKE Delicieux', '75230', '9.1', '1', 'Chess, but you replace your entire army with a royal shotgun. A unique strategy roguelike based on the timeless checkboard classic.', 'PUNKCAKE Delicieux', '2022-5-12');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('Vampire Survivors', '70000', 'poncle', '1265040', '9.7', '2', 'Mow down thousands of night creatures and survive until dawn! Vampire Survivors is a gothic horror casual game with rogue-lite elements, where your choices can allow you to quickly snowball against the hundreds of monsters that get thrown at you.', 'poncle', '2021-12-17');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('Deep Rock Galatic', '250000', 'Coffee Stain Publishing', '6154280', '9.7', '1', 'Deep Rock Galactic is a 1-4 player co-op FPS featuring badass space Dwarves, 100% destructible environments, procedurally-generated caves, and endless hordes of alien monsters.', 'Ghost Ship Games', '2020-5-13');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('UNBEATABLE [white label]', '0', 'D-CELL GAMES', '322350', '9.6', '1', 'A young girl learns a song. An exclusive side-story set in the world of D-CELL GAMES\ upcoming rhythm-adventure.', 'D-CELL GAMES', '2021-5-7');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('Notia', '188000', 'Nolla Games', '1503462', '9.5', '1', 'Noita is a magical action roguelite set in a world where every pixel is physically simulated. Fight, explore, melt, burn, freeze and evaporate your way through the procedurally generated world using spells you have created yourself.', 'Nolla Games', '2020-10-16');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('Back 4 Blood', '990000', 'Warner Bros. Games', '1356202', '6.5', '1', 'Back 4 Blood is a thrilling cooperative first-person shooter from the creators of the critically acclaimed Left 4 Dead franchise. Experience the intense 4 player co-op narrative campaign, competitive multiplayer as human or Ridden, and frenetic gameplay that keeps you in the action.', 'Turtle Rock Studios', '2021-12-10');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('Madden NFL 23', '990000', 'Electronic Arts', '22301', '3.9', '1', 'Play your way into the history books. Control your impact with every decision in all-new ways. Call the shots in Franchise with free agency and trade logic updates, leave a legacy in Face of the Franchise: The League, and assemble the most powerful roster in all of Madden Ultimate Team™.', 'Tiburon', '2022-8-19');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('Left 4 Dead 2', '120000', 'Valve', '32541200', '9.7', '1', 'Set in the zombie apocalypse, Left 4 Dead 2 (L4D2) is the highly anticipated sequel to the award-winning Left 4 Dead, the #1 co-op game of 2008. This co-operative action horror FPS takes you and your friends through the cities, swamps and cemeteries of the Deep South, from Savannah to New Orleans across five expansive campaigns.', 'Valve', '2009-11-17');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('Resident Evil 2', '538000', 'CAPCOM Co., Ltd.', '4230158', '9.7', '1', 'A deadly virus engulfs the residents of Raccoon City in September of 1998, plunging the city into chaos as flesh eating zombies roam the streets for survivors. An unparalleled adrenaline rush, gripping storyline, and unimaginable horrors await you. Witness the return of Resident Evil 2.', 'CAPCOM Co., Ltd.', '2019-1-25');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('The Death | Thần Trùng', '75000', 'DUT Studio', '100032', '9.4', '1', 'Thần Trùng | The Death là trò chơi phiêu lưu kinh dị tâm lý do 3 người Việt phát triển. Game lấy bối cảnh thành phố Hà Nội năm 2021.', 'DUT Studio', '2022-9-15');
INSERT INTO Game ([Name], Price, PublishedBy, Download, Rate, [Status], [Description], Developer, [Date]) VALUES ('Persona 4 Golden', '380000', 'SEGA', '2015487', '9.7', '1', 'A coming of age story that sets the protagonist and his friends on a journey kickstarted by a chain of serial murders.', 'ATLUS', '2020-6-14');

