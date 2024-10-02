-- Oppgave c

DROP TABLE IF EXISTS kandidat;
DROP TABLE IF EXISTS oppdrag;
DROP TABLE IF EXISTS bedrift;
DROP TABLE IF EXISTS kvalifikasjon;
DROP TABLE IF EXISTS kobling;

CREATE TABLE kandidat(
  kandidatNr INT,
  fornavn VARCHAR(12),
  etternavn VARCHAR(12),
  telefon VARCHAR (8),
  epost VARCHAR(30)
);
ALTER TABLE kandidat ADD PRIMARY KEY (kandidatNr);

CREATE TABLE oppdrag(
  oppdragNr INT,
  navn VARCHAR(15),
  kvalNr INT,
  planStartDato DATE,
  planSluttDato DATE,
  virkeligStartDato DATE,
  virkeligSluttDato DATE
);
ALTER TABLE oppdrag ADD PRIMARY KEY (oppdragNr);

CREATE TABLE bedrift(
  orgNr INT,
  navn VARCHAR(20),
  telefon VARCHAR(8),
  epost VARCHAR(30)
);
ALTER TABLE bedrift ADD PRIMARY KEY (orgNr);

CREATE TABLE kvalifikasjon(
  kvalNr INT,
  kvalifikasjon VARCHAR(30)
);
ALTER TABLE kvalifikasjon ADD PRIMARY KEY (kvalNr);

CREATE TABLE kobling(
  kandidatNr INT,
  kvalNr INT
);
ALTER TABLE kobling ADD PRIMARY KEY (kandidatNr, kvalNr);

ALTER TABLE oppdrag
ADD FOREIGN KEY (orgNr) REFERENCES bedrift(orgNr);

ALTER TABLE kobling
ADD FOREIGN KEY (kandidatNr) REFERENCES kandidat(kandidatNr);

ALTER TABLE kobling
ADD FOREIGN KEY (kvalNr) REFERENCES kvalifikasjon(kvalNr);


INSERT INTO kandidat(kandidatNr, fornavn, etternavn, telefon, epost) VALUES (1, "Nikolai", "Dokken", "98866017", "nikolaidokken@live.no");
INSERT INTO kandidat(kandidatNr, fornavn, etternavn, telefon, epost) VALUES (2, "Ian", "Derouiche", "69696969", "ian@xxx.ng");
INSERT INTO kandidat(kandidatNr, fornavn, etternavn, telefon, epost) VALUES (1, "Terrorist", "Allah", "91191169", "boomboompow@is.is");

INSERT INTO kvalifikasjon(kvalNr, kvalifikasjon) VALUES (1, "excel");
INSERT INTO kvalifikasjon(kvalNr, kvalifikasjon) VALUES (2, "word");
INSERT INTO kvalifikasjon(kvalNr, kvalifikasjon) VALUES (3, "våpen");

INSERT INTO bedrift(orgNr, navn, telefon, epost) VALUES (1, "google inc", "67549872", "google@gmail.com");
INSERT INTO bedrift(orgNr, navn, telefon, epost) VALUES (2, "speedingo", "42042069", "speedingo@gmail.com");

INSERT INTO kobling(kandidatNr, kvalNr) VALUES (1, 2);
INSERT INTO kobling(kandidatNr, kvalNr) VALUES (1, 3);
INSERT INTO kobling(kandidatNr, kvalNr) VALUES (2, 1);

INSERT INTO oppdrag(oppdragNr, orgNr, bedriftNavn, kvalNr, planStartDato, planSluttDato, virkeligStartDato, virkeligSluttDato) VALUES (1, 1, "google inc", 3, DATE('2019-01-05'),DATE('2020-10-18'), NULL, NULL);
INSERT INTO oppdrag(oppdragNr, orgNr, bedriftNavn, kvalNr, planStartDato, planSluttDato, virkeligStartDato, virkeligSluttDato) VALUES (2, 2, "speedingo", 1, DATE('2018-01-05'),DATE('2019-10-18'), NULL, NULL);


-- Oppgave d
SELECT navn, telefon, epost FROM bedrift;

SELECT oppdragNr, navn, telefon
FROM oppdrag JOIN bedrift USING(orgNr);

SELECT kandidatNr, fornavn, etternavn, kvalNr, kvalifikasjon
FROM kobling JOIN kandidat USING(kandidatNr) JOIN kvalifikasjon USING(kvalNr);

SELECT kandidatNr, fornavn, etternavn, kvalNr, kvalifikasjon
FROM kvalifikasjon JOIN kobling USING(kvalNr) RIGHT JOIN kandidat USING(kandidatNr);

SELECT fornavn, etternavn, planSluttDato, oppdragNr, bedriftNavn
FROM kandidat JOIN kobling USING(kandidatNr) JOIN oppdrag USING(kvalNr) WHERE kandidatNr=1;
