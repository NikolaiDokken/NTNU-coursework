-- MySQL
-- DROP-setninger i tilfelle vi m� kj�re scriptet p� nytt.

DROP TABLE leilighet;
DROP TABLE andelseier;
DROP TABLE bygning;
DROP TABLE borettslag;
DROP TABLE poststed;

-- Lager tabellene, legger inn NOT NULL- og UNIQUE-krav der det er naturlig
-- V�r forsiktig med � legge inn slike krav, det er vanskelig � forandre
-- dem i ettertid.

CREATE TABLE poststed(
  postnr SMALLINT,
  poststed VARCHAR(20) NOT NULL,
  CONSTRAINT poststed_pk PRIMARY KEY(postnr));

CREATE TABLE borettslag(
  bolag_navn VARCHAR(20),
  bolag_adr VARCHAR(40) NOT NULL UNIQUE,
  etabl_aar SMALLINT NOT NULL,
  postnr SMALLINT NOT NULL,
  CONSTRAINT borettslag_pk PRIMARY KEY(bolag_navn));

CREATE TABLE bygning(
  bygn_id INTEGER NOT NULL AUTO_INCREMENT,
  bygn_adr VARCHAR(40) NOT NULL,
  ant_etasjer INTEGER  DEFAULT 1,
  bolag_navn VARCHAR(20) NOT NULL,
  postnr SMALLINT NOT NULL,
  CONSTRAINT bygning_pk PRIMARY KEY(bygn_id));

CREATE TABLE leilighet(
  leil_nr INTEGER NOT NULL AUTO_INCREMENT,
  ant_rom SMALLINT NOT NULL,
  ant_kvm REAL NOT NULL,
  etasje SMALLINT DEFAULT 1,
  bygn_id INTEGER NOT NULL,
  and_eier_nr INTEGER NOT NULL UNIQUE,
  CONSTRAINT leilighet_pk PRIMARY KEY(leil_nr));

CREATE TABLE andelseier(
  and_eier_nr INTEGER NOT NULL AUTO_INCREMENT,
  fornavn VARCHAR(30) NOT NULL,
  etternavn VARCHAR(30) NOT NULL,
  telefon CHAR(15),
  ansiennitet SMALLINT,
  bolag_navn VARCHAR(20) NOT NULL,
  CONSTRAINT andelseier_pk PRIMARY KEY(and_eier_nr));

-- Fremmedn�kler

ALTER TABLE borettslag
  ADD CONSTRAINT borettslag_fk1 FOREIGN KEY(postnr)
  REFERENCES poststed(postnr);

ALTER TABLE bygning
  ADD CONSTRAINT bygning_fk1 FOREIGN KEY(postnr)
  REFERENCES poststed(postnr);

ALTER TABLE bygning
  ADD CONSTRAINT bygning_fk2 FOREIGN KEY(bolag_navn)
  REFERENCES borettslag(bolag_navn);

ALTER TABLE leilighet
  ADD CONSTRAINT leilighet_fk1 FOREIGN KEY(bygn_id)
  REFERENCES bygning(bygn_id);

ALTER TABLE leilighet
  ADD CONSTRAINT leilighet_fk2 FOREIGN KEY(and_eier_nr)
  REFERENCES andelseier(and_eier_nr);

ALTER TABLE andelseier
  ADD CONSTRAINT andelseier_fk2 FOREIGN KEY(bolag_navn)
  REFERENCES borettslag(bolag_navn);



-- Legger inn gyldige data

INSERT INTO poststed(postnr, poststed) VALUES(2020, 'Skedsmokorset');
INSERT INTO poststed(postnr, poststed) VALUES(6408, 'Aureosen');
INSERT INTO poststed(postnr, poststed) VALUES(7033, 'Trondheim');
INSERT INTO poststed(postnr, poststed) VALUES(7020, 'Trondheim');

INSERT INTO borettslag(bolag_navn, bolag_adr, etabl_aar, postnr) VALUES('Tertitten', '�sveien 100', 1980, 7020);
INSERT INTO borettslag(bolag_navn, bolag_adr, etabl_aar, postnr) VALUES('Sisiken', 'Brur�d', 1990, 7033);
INSERT INTO borettslag(bolag_navn, bolag_adr, etabl_aar, postnr) VALUES('Lerken', 'Storgt 5', 2000, 6408);

INSERT INTO andelseier(and_eier_nr, fornavn, etternavn, telefon, ansiennitet, bolag_navn)
                        VALUES(DEFAULT, 'Even', 'Trulsbo', '56667743', 3, 'Tertitten');
INSERT INTO andelseier(and_eier_nr, fornavn, etternavn, telefon, ansiennitet, bolag_navn)
                        VALUES(DEFAULT, 'Anna', 'Olsen', '45674588', 10, 'Tertitten');
INSERT INTO andelseier(and_eier_nr, fornavn, etternavn, telefon, ansiennitet, bolag_navn)
                        VALUES(DEFAULT, 'Ingrid', 'Olsen', '45785388', 8, 'Tertitten');
INSERT INTO andelseier(and_eier_nr, fornavn, etternavn, telefon, ansiennitet, bolag_navn)
                        VALUES(DEFAULT, 'Arne', 'Torp', '78565388', 7, 'Tertitten');
INSERT INTO andelseier(and_eier_nr, fornavn, etternavn, telefon, ansiennitet, bolag_navn)
                        VALUES(DEFAULT, 'Arne', 'Martinsen', '78555388', 4, 'Sisiken');

INSERT INTO bygning(bygn_id, bygn_adr, ant_etasjer, bolag_navn, postnr) VALUES(DEFAULT, '�sveien 100a', 3, 'Tertitten', 7020);
INSERT INTO bygning(bygn_id, bygn_adr, ant_etasjer, bolag_navn, postnr) VALUES(DEFAULT, '�sveien 100b', 3, 'Tertitten', 7020);
INSERT INTO bygning(bygn_id, bygn_adr, ant_etasjer, bolag_navn, postnr) VALUES(DEFAULT, '�sveien 100c', 6, 'Tertitten', 7020);
INSERT INTO bygning(bygn_id, bygn_adr, ant_etasjer, bolag_navn, postnr) VALUES(DEFAULT, 'Storgt 10', 2, 'Sisiken', 7020);

-- bruker defaultverdien for antall etasjer
INSERT INTO bygning(bygn_id, bygn_adr, bolag_navn, postnr) VALUES(DEFAULT, '�sveien 100', 'Tertitten', 7020);

INSERT INTO leilighet(leil_nr, ant_rom, ant_kvm, etasje, bygn_id, and_eier_nr) VALUES(DEFAULT, 5, 110, 3, 1, 1);
INSERT INTO leilighet(leil_nr, ant_rom, ant_kvm, etasje, bygn_id, and_eier_nr) VALUES(DEFAULT, 5, 110, 3, 1, 2);
INSERT INTO leilighet(leil_nr, ant_rom, ant_kvm, etasje, bygn_id, and_eier_nr) VALUES(DEFAULT, 2, 50, 1, 3, 3);

-- bruker defaultverdien for etasje
INSERT INTO leilighet(leil_nr, ant_rom, ant_kvm, bygn_id, and_eier_nr) VALUES(DEFAULT, 5, 110, 1, 4);


-- -----------
-- Oppgaver  ( ͡° ͜ʖ ͡°)
-- -----------


-- Oppgave 1
SELECT * FROM borettslag
WHERE (etabl_aar>=1975 && etabl_aar<=1985);

--Oppgave 2
SELECT fornavn, etternavn, "ansiennitet: ", ansiennitet, "år"
FROM andelseier
ORDER BY ansiennitet DESC;

-- Oppgave 3
SELECT MIN(etabl_aar) FROM borettslag;

-- Oppgave 4
SELECT DISTINCT bygn_adr
FROM bygning
INNER JOIN leilighet ON bygning.bygn_id=leilighet.bygn_id
WHERE leilighet.ant_rom>=3;

-- Oppgave 5
SELECT count(*) FROM bygning WHERE bolag_navn="Tertitten";

--Oppgave 6
SELECT * FROM borettslag
LEFT JOIN bygning
USING(bolag_navn)
ORDER BY borettslag.bolag_navn;

-- Oppgave 7
SELECT count(*)
FROM borettslag
NATURAL JOIN bygning NATURAL JOIN leilighet
WHERE bolag_navn="Tertitten"

-- Oppgave 8
SELECT MAX(ant_etasjer) FROM bygning NATURAL JOIN borettslag WHERE bolag_navn="Tertitten";

-- Oppgave 9
SELECT fornavn, etternavn, telefon
FROM andelseier LEFT JOIN leilighet USING(and_eier_nr)
WHERE leilighet.and_eier_nr IS NULL

-- Oppgave 10
SELECT borettslag.bolag_navn, count(*)
FROM andelseier,borettslag
WHERE andelseier.bolag_navn=borettslag.bolag_navn
GROUP BY borettslag.bolag_navn ORDER BY count(*);


-- Oppgave 11
SELECT *
FROM andelseier LEFT JOIN leilighet
ON andelseier.and_eier_nr=leilighet.and_eier_nr;

-- Oppgave 12
SELECT bolag_navn FROM borettslag NATURAL JOIN bygning NATURAL JOIN leilighet WHERE leilighet.ant_rom=4;


-- Oppgave 13
SELECT postnr, poststed, count(*)
FROM poststed NATURAL JOIN bygning NATURAL JOIN leilighet NATURAL JOIN andelseier
GROUP BY postnr;
