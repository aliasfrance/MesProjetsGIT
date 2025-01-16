
DROP TABLE IF EXISTS client;

 create table client(  
    /*id SERIAL NOT NULL PRIMARY KEY, */
	
    id INT PRIMARY KEY NOT NULL,
	nom varchar(100),  
    prenom varchar(100),
	email varchar(100),
	no_tel varchar(255),
	rue varchar (100),
	code_postal varchar(255),
	ville varchar(255)
	);  
	
	
insert into client (id,nom, prenom,email, no_tel, rue, code_postal, ville)
values (1, 'Durand', 'Juliette', 'oeu@gmail.com', '0256897840','Impasse Laurie', '44800', 'Saint-Herblain' );	


select * from client;