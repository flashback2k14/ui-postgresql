drop table if exists versuch;

create table versuch(
	vnr varchar(5) primary key,
	vname varchar(30),
	datum date,
	benutzer varchar(30)
); 

create or replace function versuch_datum_geaendert()
	returns trigger as
	$$
		begin
			if NEW.vnr is null then
				raise exception 'feld vnr ist leer';
			end if;
			if NEW.vname is null then
				raise exception 'feld vname ist leer';
			end if;

			NEW.datum := now();
			NEW.benutzer := current_user;
			
			return NEW;
		end
	$$ language plpgsql;


create trigger versuch_datum_geaendert
	before insert or update on versuch
		for each row execute procedure
			versuch_datum_geaendert();
