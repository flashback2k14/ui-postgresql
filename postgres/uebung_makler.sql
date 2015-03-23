drop table if exists 
	person, objekt, adresse cascade;
drop table if exists
 wohnt, liegt, besichtigung;


-- Aufgabe 1)
create table person (
	pid int primary key,
	vorname varchar(30),
	nachname varchar(30),
	telefonnummer varchar(20)
) with oids;

create table makler (
	website_url varchar(40)
) inherits(person) with oids;

create table kunde (
	email varchar(40)
) inherits(person) with oids;

create table objekt (
	obid int primary key,
	flaeche float,
	zimmerzahl float,
	preis double precision
) with oids;

create table haeuser (
	nebengebauede varchar(30)[]
) inherits(objekt) with oids;

create table wohnung (
	etage int
) inherits(objekt) with oids;

create table adresse (
	aid int primary key,
	strasse varchar(30),
	ort varchar(30),
	plz varchar(5),
	hnr int
) with oids;

create table wohnt (
	pid int,
	aid int,
	foreign key (pid) references person(pid),
	foreign key (aid) references adresse(aid)
) with oids;

create table liegt (
	obid int,
	aid int,
	foreign key (obid) references objekt(obid),
	foreign key (aid) references adresse(aid)
) with oids;

create table besichtigung (
	mid int,
	kid int,
	obid int,
	foreign key (mid) references person(pid),
	foreign key (kid) references person(pid),
	foreign key (obid) references objekt(obid)
) with oids;


-- Aufgabe 2)
insert into makler (pid, vorname, nachname, telefonnummer, website_url) values 
	(1, 'Max', 'Muster', '0123/456', 'www.muster.test');

insert into kunde (pid, vorname, nachname, telefonnummer, email) values 
	(2, 'Erika', 'Mustermann', '0456/123456', 'em@mail.org');

insert into haeuser (obid, flaeche, zimmerzahl, preis, nebengebauede) values 
	(1, 140.0, 5.0, 158000, '{"Garage","Gartenhaus"}'),
	(2, 210.0, 8.0, 210000, '{"Garage","Stall","Scheune"}');

insert into wohnung (obid, flaeche, zimmerzahl, preis, etage) values
	(3, 56.0, 2.0, 68000, 2),
	(4, 86.0, 3.0, 12000, 3);

insert into adresse (aid, strasse, ort, plz, hnr) values 
	(1, 'Dorfplatz', 'Ödland', '12345', 1),
	(2, 'Bahnhofsplatz', 'Großmusterstadt', '34567', 2),
	(3, 'Am Wald', 'Ödland', '12345', 5),
	(4, 'Am Wald', 'Ödland', '12345', 8),
	(5, 'Bahnhofsplatz', 'Ödland', '12345', 45),
	(6, 'Lindenallee', 'Ödland', '12345', 34);

-- Aufgabe 3)
alter table besichtigung add username varchar(30);
alter table besichtigung add datum date;

create or replace function fn_besichtigung_changed()
	returns trigger as
		$$
			begin
				new.username = current_user;
				new.datum = current_date;
				return new;
			end
		$$ language plpgsql;

create trigger trig_bes_changed
	before insert or update on besichtigung
		for each row execute procedure fn_besichtigung_changed();


-- Zusatz)
create or replace view v_makler as
	select pid, vorname, nachname
	from makler;

create or replace view v_kunde as
	select pid, vorname, nachname
	from kunde;

create or replace view v_objekte as 
	select obid, preis, flaeche
	from objekt;

select * from v_makler;
select * from v_kunde;
select * from v_objekte;




