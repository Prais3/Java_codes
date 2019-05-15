CREATE TABLE movieTitle
(
	movieID INT NOT NULL,
	title VARCHAR(255) NOT NULL,
	rating VARCHAR(255)NOT NULL,
	genre VARCHAR(255) NOT NULL,
	director VARCHAR(255) NOT NULL,
	star VARCHAR(255) NOT NULL,
	PRIMARY KEY (movieID)
);

CREATE TABLE movieAwards
(
        movieID INT NOT NULL,
	awardYear INT NOT NULL,
	award VARCHAR(255) NOT NULL,
	FOREIGN KEY (movieID) REFERENCES movieTitle(movieID)
);

INSERT INTO movieTitle(movieID, title, rating, genre, director, star)
VALUES
	(100, 'The Godfather', 'R', 'Crime, Drama', 'Francis Ford Coppola', 'Al Pacino'),
	(101, 'John Wick: Chapter 2', 'R', 'Action, Thriller', 'Chad Stahelski', 'Keanu Reeves'),
	(102, 'The Godfather: Part 2', 'R', 'Crime, Drama', 'Francis Ford Coppola', 'Al Pacino, Robert De Niro'),
	(103, 'Black Panther', 'PG-13', 'Action, Sci-Fi', 'Ryan Coogler', 'Chadwick Boseman'),
	(104, 'Avengers: Infinity Wars', 'PG-13', 'Action, Sci-Fi', 'Anthony Russo', 'Robert Downey Jr.'),
	(105, 'Mission:Impossible - Fallout', 'PG-13', 'Action, Thriller', 'Christopher McQuarrie', 'Tom Cruise'),
	(106, 'Aquaman', 'PG-13', 'Action, Fantasy', 'James Wan', 'Jason Momoa'),
	(107, 'Get Out', 'R', 'Horror, Mystery, Thriller', 'Jordan Peele', 'Daniel Kaluuya'),
	(108, 'Wonder Woman', 'PG-13', 'Action, Fantasy', 'Patty Jenkins', 'Gal Gadot'),
	(109, 'Munich', 'R', 'Drama, History, Thriller', 'Steven Spielberg', 'Eric Bana, Daniel Craig');

INSERT INTO movieAwards(movieID, awardYear, award)
VALUES
	(100, 1973, 'Academy Awards: Oscar'),
	(101, 2017, 'Golden Trailer Awards'),
	(102, 1975, 'Academy Awards: Oscar'),
	(103, 2019, 'Academy Awards: Oscar'),
	(104, 2018, 'Austin Film Critics Association'),
	(105, 2019, 'Broadcast Film Critics Association Awards'),
	(106, 0000, 'NULL'),
	(107, 0000, 'NULL'),
	(108, 0000, 'NULL'),
	(109, 0000, 'NULL');


