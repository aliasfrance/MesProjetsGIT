DROP TABLE IF EXISTS client;
drop table if exists jeux;
drop table if exists genres;
drop table if exists jeux_genres;
DROP TABLE IF EXISTS utilisateurs;

 create table client(  
    /*id SERIAL NOT NULL PRIMARY KEY, */
	
    id SERIAL PRIMARY KEY,
	nom varchar(100) NOT NULL, 
    prenom varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	noTelephone varchar(255) NOT NULL,
	rue varchar (100) NOT NULL,
	codePostal varchar(255) NOT NULL,
	ville varchar(255) NOT NULL
	);  
	
CREATE TABLE jeux (
    noJeu SERIAL PRIMARY KEY,
    titre VARCHAR(100) NOT NULL,
    reference VARCHAR(100) UNIQUE NOT NULL,
    description VARCHAR(500) NOT NULL,
    tarifJournee NUMERIC(8,2) NOT NULL,
    ageMin INTEGER NOT NULL,
	duree INTEGER NOT NULL
);
	
CREATE TABLE genres (
	noGenre INTEGER PRIMARY KEY,
	libelle varchar(100) UNIQUE NOT NULL
);

CREATE TABLE jeux_genres (
    noJeu INTEGER NOT NULL,
    noGenre INTEGER NOT NULL,
    PRIMARY KEY (noJeu, noGenre),
    FOREIGN KEY (noJeu) REFERENCES JEUX(noJeu),
    FOREIGN KEY (noGenre) REFERENCES GENRES(noGenre)
);

insert into client (id,nom, prenom,email, noTelephone, rue, codePostal, ville)
values (1, 'Durand', 'Juliette', 'oeu@gmail.com', '0256897840','Impasse Laurie', '44800', 'Saint-Herblain' );	

CREATE TABLE utilisateurs (
    no_utilisateur SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    mot_de_passe VARCHAR(500) NOT NULL,
    role VARCHAR(255) NOT NULL
);

select * from client;

insert into utilisateurs ( email,  mot_de_passe, role)
values ('bob', '{bcrypt}$2a$10$8IkbsSIu7.OzSwmIWXhMvexDoLDaY2XUAfBcqmYqFtHpnYmBkWpxq',
'EMPLOYE'), ('jane', '{bcrypt}$2a$10$8IkbsSIu7.OzSwmIWXhMvexDoLDaY2XUAfBcqmYqFtHpnYmBkWpxq',
'ADMIN')



 
