
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS utilisateurs;

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
 
