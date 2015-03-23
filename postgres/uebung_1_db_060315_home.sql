drop table if exists angestellter cascade;

-- Aufgabe 1)
create table angestellter (
	nachname varchar(30),
	vorname varchar(30),
	gebdatum date,
	personalnummer int primary key
) with oids;

create table vertriebsmitarbeiter (
	vertriebsbereiche varchar(30)[],
	jahresumsatz double precision
) inherits(angestellter) with oids;

create table techniker (
	qualifikationen varchar(30)[]
) inherits(angestellter) with oids;


-- Aufgabe 2)
insert into vertriebsmitarbeiter(nachname, vorname, gebdatum, personalnummer, vertriebsbereiche, jahresumsatz) values 
	('Nachname #1', 'Vorname #1', '1980-10-30', 1, '{"Bereich #1","Bereich #2"}', 100000),
	('Nachname #2', 'Vorname #2', '1980-11-30', 2, '{"Bereich #3","Bereich #4"}', 200000),
	('Nachname #3', 'Vorname #3', '1980-12-30', 3, '{"Bereich #5","Bereich #6"}', 300000);

INSERT INTO techniker(nachname, vorname, gebdatum, personalnummer, qualifikationen) values
	('Nachname #10', 'Vorname #10', '1990-10-30', 4, '{"Quali #1","Quali #2"}'),
	('Nachname #20', 'Vorname #20', '1990-10-30', 5, '{"Quali #3","Quali #4"}'),
	('Nachname #30', 'Vorname #30', '1990-10-30', 6, '{"Quali #5","Quali #6"}');


-- Aufgabe 3)
create or replace view v_vertriebsmitarbeiter as
	select nachname, vorname, jahresumsatz 
	from vertriebsmitarbeiter;

select * from v_vertriebsmitarbeiter;


-- Aufgabe 4)
alter table techniker add username varchar(30);
alter table techniker add changed date;

create or replace function fn_techniker_geaendert()
	returns trigger as 		
		$$
			begin
				new.username = current_user;
				new.changed = current_date;
				return new;
			end
			
		$$ language plpgsql;

create trigger t_techniker_geaendert
	before insert or update on techniker
		for each row execute procedure fn_techniker_geaendert();








