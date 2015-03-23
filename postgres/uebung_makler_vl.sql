drop table if exists
	haus2, besichtigung2,
	person2, objekt2, adresse2 cascade; -- löscht außerdem makler und kunde

create table person2 (
	vorname varchar(30),
	nachname varchar(30),
	telefon varchar(20),
	id int primary key
) with oids;

create table makler2 (
	url varchar(30)
) inherits (person2) with oids;

create table kunde2 (
	email varchar(30)
) inherits (person2) with oids;

create table objekt2 (
	flaeche float,
	zimmeranzahl float,
	preis double precision,
	id int primary key
) with oids;

create table haus2 (
	nebengebaeude varchar(50)[]
) inherits (objekt2) with oids;

create table wohnung2 (
	etage smallint
) inherits (objekt2) with oids;

create table adresse2 (
	strasse varchar(30),
	hnr varchar(5),
	plz varchar(5), -- wegen führender null
	ort varchar(30),
	id int primary key
) with oids;

create table besichtigung2(
	mid int,
	kid int,
	obid int,
	datum date,
	zeit time,
	foreign key (mid) references person2(id),
	foreign key (kid) references person2(id),
	foreign key (obid) references objekt2(id)
) with oids;

alter table person2 add aid int;
alter table person2 add constraint aid_fk foreign key (aid) references adresse2(id);

alter table objekt2 add aid int;
alter table objekt2 add constraint objekt_aid_fk foreign key (aid) references adresse2(id);

-- Aufgabe 4c)
insert into makler2 values(
	'Max', 'Mustermann','0341-123456',1,'www.test.com',1
);
insert into adresse2 values(
	'Dorfplatz','1','04315','Leipzig',1
);

insert into kunde2 values(
	'Hans', 'Peter','0341-123456',2,'hans_peter@test.com',2
);