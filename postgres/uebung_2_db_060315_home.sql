drop table if exists 
	adresse, leser, 
	hatwohnsitz, ausleihe, 
	medium cascade;

-- Aufgabe 1)
create table adresse (
	strasse varchar(30),
	plz varchar(6),
	hausnummer int,
	ort varchar(30),
	a_id int primary key
) with oids;

create table leser (
	nummer int,
	nachname varchar(30),
	vorname varchar(30),
	l_id int primary key
) with oids;

create table hatwohnsitz(
	a_id int,
	l_id int,
	foreign key (a_id) references adresse(a_id),
	foreign key (l_id) references leser(l_id)
) with oids;

create table medium (
	titel varchar(30),
	verlag varchar(30),
	erscheinungsjahr date,
	signatur int primary key
) with oids;

create table buch (
	isbn varchar(20),
	autoren varchar(30)[]
) inherits(medium) with oids;

create table zeitschrift (
	jahrgang int,
	heft int
) inherits(medium) with oids;

create table ausleihe (
	l_id int,
	signatur int,
	verlaengerung date,
	rueckgabedatum date,
	foreign key (l_id) references leser(l_id),
	foreign key (signatur) references medium(signatur)
) with oids;

-- Aufgabe 2)
insert into adresse (strasse, plz, hausnummer, ort, a_id) values 
	('Straße #1', '04315', 10, 'Leipzig', 1),
	('Straße #2', '04315', 12, 'Leipzig', 2),
	('Straße #3', '04315', 17, 'Leipzig', 3);

insert into leser (nummer, nachname, vorname, l_id) values 
	(1201, 'Nachname #1', 'Vorname #1', 1);

insert into hatwohnsitz (a_id, l_id) values 
	(1, 1),
	(2, 1),
	(3, 1);

insert into buch (titel, verlag, erscheinungsjahr, signatur, isbn, autoren) values
	('Titel #1', 'Verlag #1', '1970-01-30', 1, '1234567890', '{"Autor #1","Autor #2"}'),
	('Titel #2', 'Verlag #2', '1970-03-30', 2, '0987654321', '{"Autor #2","Autor #4"}');

insert into zeitschrift (titel, verlag, erscheinungsjahr, signatur, jahrgang, heft) values 
	('Titel #3', 'Verlag #3', '1970-06-30', 3, 90, 2),
	('Titel #4', 'Verlag #4', '1970-09-30', 4, 80, 4);

insert into ausleihe(l_id, signatur, verlaengerung, rueckgabedatum) values
	(1, 2, '2010-11-10', '2010-12-10'),
	(1, 4, '2011-01-30', '2011-02-20');

-- Aufgabe 3)
create or replace view v_medium as
	-- select titel,verlag,erscheinungsjahr from medium;
	select titel, verlag, erscheinungsjahr from buch
	union
	select titel, verlag, erscheinungsjahr from zeitschrift
	order by titel asc;

select * from v_medium;

-- Aufgabe 4)
alter table buch add bibo_mitarbeiter varchar(30);
alter table buch add zeitpunkt timestamp;

create or replace function fn_ausleihe_buch()
	returns trigger as
		$$
			begin
				new.bibo_mitarbeiter = current_user;
				new.zeitpunkt = current_timestamp;
				return new;
			end
		$$ language plpgsql;

create trigger t_ausleihe_buch
	before insert or update on buch
		for each row execute procedure fn_ausleihe_buch();





