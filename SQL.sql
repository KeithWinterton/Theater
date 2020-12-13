--Name: Keith Winterton
--Date: August 3, 2020
--Description SQL.sql will create and and populate the database used
--by the TheaterSystem project. 



create table Theater(
	theaterId integer,
	zipcode char(5),
	theaterName varchar(50),
	address varchar(70),
	phone char(12),
	primary key(theaterId)
);

create table Times (
	timeId Integer,
	movieTime varchar(7),
	primary key(timeId)
);

create table Movies (
	movieId integer,
	title varchar(50),
	description varchar(250),
	lengthInMinutes integer,
	releaseyear char(4),
	smallpicture varchar(100),
	bigpicture varchar(100),
	primary key(movieId)
	
);

create table shows(
	theaterId integer,
	movieId integer,
	primary key(theaterId, movieId),
	foreign key (theaterId) references Theater,
	foreign key (movieId) references Movies
);

create table ShowTimes (
	movieId integer,
	timeId integer,
	primary key(movieId, timeId),
	foreign key(movieId) references Movies,
	foreign key(timeId) references Times

);

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (0, '75028', 'AMC Dine-In Grapevine Mills 30',
		 '3150 Grapevine Mills Parkway, Grapevine, TX 76051',
		 '972-539-5909');
		 
insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (1,'75028', 'Studio Movie Grill',
		 '1600 S Stemmons Fwy, Lewisville, TX 75067',
		 '469-312-0583');
		 
insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (2, '75028', 'Palace Arts Center',
		'300 S Main St, Grapevine, TX 76051',
		 '817-410-3100');
		 
insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (3, '75028', 'Harkins Theatres Southlake 14',
		'1450 Plaza Pl, Southlake, TX 76092',
		 '817-310-0345');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (4, '75028', 'AMC Highland Village 12',
		'4090 Barton Creek, Highland Village, TX 75077',
		 '972-317-2609');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (5, '75043', 'Strike + Reel', 
		'5902 N. President George Bush Hwy, Garland, TX 75044',
		'469-385-0300');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (6, '75043', 'AMC Firewheel 18',
		 '100 Coneflower Drive, Garland, TX 75040',
		 '972-496-5473');
		 
		 
insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (7, '75043', 'AMC DINE-IN Mesquite 30',
		 '19919 Lyndon B Johnson Fwy Mesquite, TX 75149',
		 '972-329-3990');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (8, '75043', 'AMC CLASSIC Mesquite 10',
		 '227 US Highway 80 East Mesquite, TX 75150',
		 '214-272-0629');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (9, '75043', 'Walnut Theaters',
		 '3310 W. Walnut St., Garland, TX 75042',
		 '972-494-6684');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (10, '75035', 'Moviehouse Eatery McKinney',
		 '8450 SH 121, McKinney, TX 75070',
		 '972-317-2609');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (11, '75035', 'Studio Movie Grill The Colony',
		 '4800 State Hwy. 121, The Colony, TX 75056',
		 '469-405-8530');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (12, '75035', 'Cinemark West Plano and XD',
		 '3800 Dallas Parkway, Plano, TX 75093',
		 '972-473-2289');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (13, '75035', 'Cinemark Frisco Square and XD',
		 '214 Frisco Square Blvd, Frisco TX 75034',
		 '214-705-9901');


insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (14, '75035', 'AMC DINE-IN Stonebriar 24',
		 '2601 Preston Road Ste 300, Frisco, TX 75034',
		 '972-377-0144');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (15, '75080', 'Alamo Drafthouse Richardson',
		 '100 S. Central Expressway Richardson, TX 75080',
		 '972-534-2120');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (16, '75080', 'Studio Movie Grill - Dallas / Royal',
		 '11170 N. Central Expressway, Dallas TX 75243',
		 '214-361-2966');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (17, '75080', 'Fun Movie Grill - Carrollton',
		 '2661 Midway Road, Carrollton TX 75006',
		 '469-677-5132');
		 
insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (18, '75080', 'Cinemark Legacy and XD',
		 '7201 N. Central Expressway, Plano, TX 75025',
		 '972-527-4385');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (19, '75080', 'Angelika Film Center Dallas',
		 '5321 East Mockingbird Lane, Dallas TX 75206',
		 '214-841-4712');

 insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (20, '75225', 'AMC Northpark 15',
		 '8687 N Central Expy, Ste 300, Dallas, TX 75225',
		 '214-265-7138');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (21,'75225', 'Cinemark 17 and IMAX ',
		 '11819 Webb Chapel, Dallas, TX 75234',
		 '972-247-8172');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (22, '75225', 'AMC Valley View 16',
		 '13331 Preston Rd Ste 2300, Dallas, TX 75240',
		 '972-387-4503');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (23, '75225', 'Inwood Theatre',
		 '5458 W Lovers Ln, Dallas, TX 75209',
		 '214-352-5085');

insert into Theater(theaterId, zipcode, theaterName, address, phone)
	values (24, '75225', 'The Magnolia',
		 '3699 McKinney Ave, Dallas, TX 75204',
		 '214-520-0394');

insert into Times(timeId, movieTime)
	values (0, '10:00AM');

insert into Times(timeId, movieTime)
	values (1, '10:30AM');

insert into Times(timeId, movieTime)
	values (2, '11:00AM');

insert into Times(timeId, movieTime)
	values (3, '11:30AM');

insert into Times(timeId, movieTime)
	values (4, '12:00PM');

insert into Times(timeId, movieTime)
	values (5, '1:00PM');

insert into Times(timeId, movieTime)
	values (6, '1:30PM');

insert into Times(timeId, movieTime)
	values (7, '2:00PM');

insert into Times(timeId, movieTime)
	values (8, '2:30PM');

insert into Times(timeId, movieTime)
	values (9, '3:00PM');

insert into Movies(movieId, title, description, lengthInMinutes, releaseyear, smallpicture, bigpicture) 
	values (0, 'Harry Potter and the Sorcerer''s Stone',
	'A young boy discovers that magic is real and attends
	his first year at Hogworts School of Witchcraft and Wizardy.',
	152, '2001', 'resouces\images\harrypottersm.jpg', 'resouces\images\harrypotter.jpg');

insert into Movies(movieId, title, description, lengthInMinutes, releaseyear, smallpicture, bigpicture) 
	values (1, 'Toy Story',
	'Released in 1995, Toy Story follows a set of toys who come alive 
	when their owners are not around.',
	81, '1995', 'resouces\images\ToyStorysm.jpg', 'resouces\images\ToyStory.jpg');

insert into Movies(movieId, title, description, lengthInMinutes, releaseyear, smallpicture, bigpicture) 
	values (2, 'Airplane!',
	'Released in 1980, Ted Striker, an ex-pilot, must land a plane after its pilots are
	 unable to fly due to food poisoning.',
	87, '1980', 'resouces\images\AirPlane!small.jpg', 'resouces\images\AirPlane!.jpg');

insert into Movies(movieId, title, description, lengthInMinutes, releaseyear, smallpicture, bigpicture) 
	values (3, 'Midway',
	'Based upon WWII’s battle of Midway,
		which occurred in early June 1942.',
	132, '2019', 'resouces\images\Midwaysmall.jpg', 'resouces\images\Midway.jpg');


insert into Movies(movieId, title, description, lengthInMinutes, releaseyear, smallpicture, bigpicture) 
	values (4, 'Apollo 13 ',
	'Apollo 13 follows the Apollo 13 mission, where James A. Lovell, Jr.
	John L. Swigert, Jr. Fred W. Haise, Jr. must loop around the moon after
	an oxygen tank failure.',
	140, '1995', 'resouces\images\Apollo13small.jpg', 'resouces\images\Apollo13.jpg');

insert into Movies(movieId, title, description, lengthInMinutes, releaseyear, smallpicture, bigpicture) 
	values (5, 'The Lord of the Rings: The Fellowship of the Ring',
	'The Lord of the Rings: The Fellowship of the Ring – based upon 
	J.R.R Tolkien’s work, Fordo Baggins, a hobbit, sets out to destroy
	a magical ring left to him by his adopted father.',
	178, '2001', 'resouces\images\lotrsmall.jpg', 'resouces\images\lotr.jpg');

insert into Movies(movieId, title, description, lengthInMinutes, releaseyear, smallpicture, bigpicture) 
	values (6, 'Air Bud',
	'Josh and his family move to a new town,
	where they meet a basketball playing dog.',
	98, '1997', 'resouces\images\AirBudsmall.jpg', 'resouces\images\AirBud.jpg');

insert into Movies(movieId, title, description, lengthInMinutes, releaseyear, smallpicture, bigpicture) 
	values (7, 'Miracle',
	'Miracle follows the story of the story of
	 the 1980 United States Men’s hockey team. ',
	135, '2004', 'resouces\images\miriclesmall.jpg', 'resouces\images\miricle.jpg');

insert into Movies(movieId, title, description, lengthInMinutes, releaseyear, smallpicture, bigpicture) 
	values (8, 'Glory Road',
	'Glory Road follows the 1966 Texas Western''s basketball team
	coached by Don Haskins.',
	118, '2006', 'resouces\images\gloryroadsmall.jpg', 'resouces\images\gloryroad.jpg');

insert into Movies(movieId, title, description, lengthInMinutes, releaseyear, smallpicture, bigpicture) 
	values (9, 'Monsters, Inc.',
	'Monsters, Inc. follows the lives of James P. Sullivan and Mike Wazowski
	 who work at the Monsters, Inc. factory, which gathers the resouces needed
	 to fuel Monstropolis.',
	92, '2001', 'resouces\images\Monstersincsm.jpg', 'resouces\images\Monstersinc_.jpg');

insert into shows(theaterId, movieId) 
	values (0, 0);

insert into shows(theaterId, movieId) 
	values (0, 1);

insert into shows(theaterId, movieId) 
	values (0, 2);

insert into shows(theaterId, movieId) 
	values (0, 3);

insert into shows(theaterId, movieId) 
	values (0, 4);

insert into shows(theaterId, movieId) 
	values (1, 5);

insert into shows(theaterId, movieId) 
	values (1, 6);

insert into shows(theaterId, movieId) 
	values (1, 7);

insert into shows(theaterId, movieId) 
	values (1, 8);

insert into shows(theaterId, movieId) 
	values (1, 9);

insert into shows(theaterId, movieId) 
	values (2, 9);
	
insert into shows(theaterId, movieId) 
	values (2, 3);

insert into shows(theaterId, movieId) 
	values (2, 4);

insert into shows(theaterId, movieId) 
	values (2, 5);

insert into shows(theaterId, movieId) 
	values (2, 6);

insert into shows(theaterId, movieId) 
	values (3, 7);

insert into shows(theaterId, movieId) 
	values (3, 8);

insert into shows(theaterId, movieId) 
	values (3, 2);
	
insert into shows(theaterId, movieId) 
	values (3, 3);

insert into shows(theaterId, movieId) 
	values (3, 5);

insert into shows(theaterId, movieId) 
	values (4, 0);

insert into shows(theaterId, movieId) 
	values (4, 3);

insert into shows(theaterId, movieId) 
	values (4, 6);
	
insert into shows(theaterId, movieId) 
	values (4, 8);

insert into shows(theaterId, movieId) 
	values (4, 9);	

insert into shows(theaterId, movieId) 
	values (5, 5);

insert into shows(theaterId, movieId) 
	values (5, 0);

insert into shows(theaterId, movieId) 
	values (5, 3);

insert into shows(theaterId, movieId) 
	values (5, 4);

insert into shows(theaterId, movieId) 
	values (5, 2);

insert into shows(theaterId, movieId) 
	values (6, 6);

insert into shows(theaterId, movieId) 
	values (6, 7);

insert into shows(theaterId, movieId) 
	values (6, 8);

insert into shows(theaterId, movieId) 
	values (6, 9);

insert into shows(theaterId, movieId) 
	values (6, 1);

insert into shows(theaterId, movieId) 
	values (7, 0);

insert into shows(theaterId, movieId) 
	values (7, 1);

insert into shows(theaterId, movieId) 
	values (7, 2);

insert into shows(theaterId, movieId) 
	values (7, 3);

insert into shows(theaterId, movieId) 
	values (7, 4);

insert into shows(theaterId, movieId) 
	values (8, 2);

insert into shows(theaterId, movieId) 
	values (8, 4);

insert into shows(theaterId, movieId) 
	values (8, 9);

insert into shows(theaterId, movieId) 
	values (8, 5);

insert into shows(theaterId, movieId) 
	values (8, 3);

insert into shows(theaterId, movieId) 
	values (9, 3);

insert into shows(theaterId, movieId) 
	values (9, 5);

insert into shows(theaterId, movieId) 
	values (9, 6);

insert into shows(theaterId, movieId) 
	values (9, 8);

insert into shows(theaterId, movieId) 
	values (9, 9);

insert into shows(theaterId, movieId) 
	values (10, 5);

insert into shows(theaterId, movieId) 
	values (10, 6);

insert into shows(theaterId, movieId) 
	values (10, 7);

insert into shows(theaterId, movieId) 
	values (10, 8);

insert into shows(theaterId, movieId) 
	values (10, 9);

insert into shows(theaterId, movieId) 
	values (11, 0);

insert into shows(theaterId, movieId) 
	values (11, 1);

insert into shows(theaterId, movieId) 
	values (11, 2);

insert into shows(theaterId, movieId) 
	values (11, 3);

insert into shows(theaterId, movieId) 
	values (11, 4);

insert into shows(theaterId, movieId) 
	values (12, 5);

insert into shows(theaterId, movieId) 
	values (12, 6);

insert into shows(theaterId, movieId) 
	values (12, 7);

insert into shows(theaterId, movieId) 
	values (12, 8);

insert into shows(theaterId, movieId) 
	values (12, 9);

insert into shows(theaterId, movieId) 
	values (13, 2);

insert into shows(theaterId, movieId) 
	values (13, 4);

insert into shows(theaterId, movieId) 
	values (13, 6);

insert into shows(theaterId, movieId) 
	values (13, 7);

insert into shows(theaterId, movieId) 
	values (13, 9);

insert into shows(theaterId, movieId) 
	values (14, 0);

insert into shows(theaterId, movieId) 
	values (14, 3);

insert into shows(theaterId, movieId) 
	values (14, 5);

insert into shows(theaterId, movieId) 
	values (14, 7);

insert into shows(theaterId, movieId) 
	values (14, 8);

insert into shows(theaterId, movieId) 
	values (15, 0);

insert into shows(theaterId, movieId) 
	values (15, 3);

insert into shows(theaterId, movieId) 
	values (15, 6);

insert into shows(theaterId, movieId) 
	values (15, 7);

insert into shows(theaterId, movieId) 
	values (15, 9);

insert into shows(theaterId, movieId) 
	values (16, 0);

insert into shows(theaterId, movieId) 
	values (16, 2);

insert into shows(theaterId, movieId) 
	values (16, 4);

insert into shows(theaterId, movieId) 
	values (16, 6);

insert into shows(theaterId, movieId) 
	values (16, 8);

insert into shows(theaterId, movieId) 
	values (17, 1);

insert into shows(theaterId, movieId) 
	values (17, 3);

insert into shows(theaterId, movieId) 
	values (17, 5);

insert into shows(theaterId, movieId) 
	values (17, 7);

insert into shows(theaterId, movieId) 
	values (17, 9);

insert into shows(theaterId, movieId) 
	values (18, 2);

insert into shows(theaterId, movieId) 
	values (18, 3);

insert into shows(theaterId, movieId) 
	values (18, 4);

insert into shows(theaterId, movieId) 
	values (18, 5);

insert into shows(theaterId, movieId) 
	values (18, 6);

insert into shows(theaterId, movieId) 
	values (19, 1);

insert into shows(theaterId, movieId) 
	values (19, 2);

insert into shows(theaterId, movieId) 
	values (19, 4);

insert into shows(theaterId, movieId) 
	values (19, 7);

insert into shows(theaterId, movieId) 
	values (19, 9);

insert into shows(theaterId, movieId) 
	values (20, 0);

insert into shows(theaterId, movieId) 
	values (20, 1);

insert into shows(theaterId, movieId) 
	values (20, 5);

insert into shows(theaterId, movieId) 
	values (20, 8);

insert into shows(theaterId, movieId) 
	values (20, 9);

insert into shows(theaterId, movieId) 
	values (21, 0);

insert into shows(theaterId, movieId) 
	values (21, 1);

insert into shows(theaterId, movieId) 
	values (21, 3);

insert into shows(theaterId, movieId) 
	values (21, 4);

insert into shows(theaterId, movieId) 
	values (21, 5);

insert into shows(theaterId, movieId) 
	values (22, 3);

insert into shows(theaterId, movieId) 
	values (22, 4);

insert into shows(theaterId, movieId) 
	values (22, 6);

insert into shows(theaterId, movieId) 
	values (22, 7);

insert into shows(theaterId, movieId) 
	values (22, 9);

insert into shows(theaterId, movieId) 
	values (23, 0);

insert into shows(theaterId, movieId) 
	values (23, 3);

insert into shows(theaterId, movieId) 
	values (23, 5);

insert into shows(theaterId, movieId) 
	values (23, 6);

insert into shows(theaterId, movieId) 
	values (23, 8);

insert into shows(theaterId, movieId) 
	values (24, 0);

insert into shows(theaterId, movieId) 
	values (24, 3);

insert into shows(theaterId, movieId) 
	values (24, 6);

insert into shows(theaterId, movieId) 
	values (24, 7);

insert into shows(theaterId, movieId) 
	values (24, 8);

insert into ShowTimes(movieId, timeId) 
	values (0, 0);

insert into ShowTimes(movieId, timeId) 
	values (0, 1);

insert into ShowTimes(movieId, timeId) 
	values (0, 2);

insert into ShowTimes(movieId, timeId) 
	values (0, 3);

insert into ShowTimes(movieId, timeId) 
	values (0, 4);

insert into ShowTimes(movieId, timeId) 
	values (1, 5);

insert into ShowTimes(movieId, timeId) 
	values (1, 6);

insert into ShowTimes(movieId, timeId) 
	values (1, 7);

insert into ShowTimes(movieId, timeId) 
	values (1, 8);

insert into ShowTimes(movieId, timeId) 
	values (1, 9);

insert into ShowTimes(movieId, timeId) 
	values (2, 0);

insert into ShowTimes(movieId, timeId) 
	values (2, 3);

insert into ShowTimes(movieId, timeId) 
	values (2, 4);

insert into ShowTimes(movieId, timeId) 
	values (2, 5);

insert into ShowTimes(movieId, timeId) 
	values (2, 6);

insert into ShowTimes(movieId, timeId) 
	values (3, 3);

insert into ShowTimes(movieId, timeId) 
	values (3, 5);

insert into ShowTimes(movieId, timeId) 
	values (3, 7);

insert into ShowTimes(movieId, timeId) 
	values (3, 8);

insert into ShowTimes(movieId, timeId) 
	values (3, 9);

insert into ShowTimes(movieId, timeId) 
	values (4, 0);

insert into ShowTimes(movieId, timeId) 
	values (4, 2);

insert into ShowTimes(movieId, timeId) 
	values (4, 4);

insert into ShowTimes(movieId, timeId) 
	values (4, 6);

insert into ShowTimes(movieId, timeId) 
	values (4, 8);

insert into ShowTimes(movieId, timeId) 
	values (5, 3);

insert into ShowTimes(movieId, timeId) 
	values (5, 5);

insert into ShowTimes(movieId, timeId) 
	values (5, 6);

insert into ShowTimes(movieId, timeId) 
	values (5, 8);

insert into ShowTimes(movieId, timeId) 
	values (5, 9);

insert into ShowTimes(movieId, timeId) 
	values (6, 1);

insert into ShowTimes(movieId, timeId) 
	values (6, 4);

insert into ShowTimes(movieId, timeId) 
	values (6, 6);

insert into ShowTimes(movieId, timeId) 
	values (6, 7);

insert into ShowTimes(movieId, timeId) 
	values (6, 9);

insert into ShowTimes(movieId, timeId) 
	values (7, 0);

insert into ShowTimes(movieId, timeId) 
	values (7, 1);

insert into ShowTimes(movieId, timeId) 
	values (7, 6);

insert into ShowTimes(movieId, timeId) 
	values (7, 7);

insert into ShowTimes(movieId, timeId) 
	values (7, 8);

insert into ShowTimes(movieId, timeId) 
	values (8, 1);

insert into ShowTimes(movieId, timeId) 
	values (8, 5);

insert into ShowTimes(movieId, timeId) 
	values (8, 7);

insert into ShowTimes(movieId, timeId) 
	values (8, 8);

insert into ShowTimes(movieId, timeId) 
	values (8, 9);

insert into ShowTimes(movieId, timeId) 
	values (9, 0);

insert into ShowTimes(movieId, timeId) 
	values (9, 2);

insert into ShowTimes(movieId, timeId) 
	values (9, 5);

insert into ShowTimes(movieId, timeId) 
	values (9, 7);

insert into ShowTimes(movieId, timeId) 
	values (9, 8);