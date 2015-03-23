drop table if exists
	haus, besichtigung,
	person, objekt, adresse cascade; -- löscht außerdem makler und kunde

create table person (
	vorname varchar(30),
	nachname varchar(30),
	telefon varchar(20),
	id int primary key
) with oids;

create table makler (
	url varchar(30)
) inherits (person) with oids;

create table kunde (
	email varchar(30)
) inherits (person) with oids;

create table objekt (
	flaeche float,
	zimmeranzahl float,
	preis double precision,
	id int primary key
) with oids;

create table haus (
	nebengebaeude varchar(50)[]
) inherits (objekt) with oids;

create table wohnung (
	etage smallint
) inherits (objekt) with oids;

create table adresse (
	strasse varchar(30),
	hnr varchar(5),
	plz varchar(5), -- wegen führender null
	ort varchar(30),
	id int primary key
) with oids;

create table besichtigung(
	mid int,
	kid int,
	obid int,
	datum date,
	zeit time,
	foreign key (mid) references person(id),
	foreign key (kid) references person(id),
	foreign key (obid) references objekt(id)
) with oids;

alter table person add aid int;
alter table person add constraint aid_fk foreign key (aid) references adresse(id);

alter table objekt add aid int;
alter table objekt add constraint objekt_aid_fk foreign key (aid) references adresse(id);

-- Aufgabe 4c)
insert into makler values(
	'Max', 'Mustermann','0341-123456',1,'www.test.com',1
);
insert into adresse values(
	'Dorfplatz','1','04315','Leipzig',1
);

insert into kunde values(
	'Hans', 'Peter','0341-123456',2,'hans_peter@test.com',2
);