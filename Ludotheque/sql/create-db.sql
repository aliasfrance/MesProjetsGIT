
DROP TABLE IF EXISTS client;

 create table client(  
    /*id SERIAL NOT NULL PRIMARY KEY, */
	
    id SERIAL PRIMARY KEY,
	nom varchar(100),  
    prenom varchar(100),
	email varchar(100),
	noTelephone varchar(255),
	rue varchar (100),
	codePostal varchar(255),
	ville varchar(255)
	);  
	
	
insert into client (id,nom, prenom,email, noTelephone, rue, codePostal, ville)
values (1, 'Durand', 'Juliette', 'oeu@gmail.com', '0256897840','Impasse Laurie', '44800', 'Saint-Herblain' );	


select * from client;