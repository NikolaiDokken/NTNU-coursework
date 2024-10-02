DROP TABLE ordredetalj;
DROP TABLE prisinfo;
DROP TABLE ordrehode;
DROP TABLE delinfo;
DROP TABLE levinfo;

CREATE TABLE delinfo(
delnr       INTEGER,
beskrivelse VARCHAR(30) NOT NULL,
CONSTRAINT delinfo_pk PRIMARY KEY(delnr));

CREATE TABLE levinfo(
levnr   INTEGER,
navn    VARCHAR(20) NOT NULL,
adresse VARCHAR(20) NOT NULL,
levby   VARCHAR(20) NOT NULL,
fylke   VARCHAR(20) NOT NULL,
postnr  INTEGER NOT NULL,
CONSTRAINT levinfo_pk PRIMARY KEY(levnr));

CREATE TABLE ordrehode(
ordrenr INTEGER,
dato    DATE NOT NULL,
levnr   INTEGER NOT NULL,
status  CHAR(1) NOT NULL,
CONSTRAINT ordrehode_pk PRIMARY KEY(ordrenr),
CONSTRAINT ordrehode_fk FOREIGN KEY(levnr) REFERENCES levinfo(levnr));

CREATE TABLE ordredetalj(
ordrenr    INTEGER,
delnr        INTEGER NOT NULL,
kvantum   INTEGER NOT NULL,
CONSTRAINT ordredetalj_pk PRIMARY KEY(ordrenr,delnr),
CONSTRAINT ordredetalj_fk1 FOREIGN KEY(ordrenr) REFERENCES ordrehode(ordrenr),
CONSTRAINT ordredetalj_fk2 FOREIGN KEY(delnr) REFERENCES delinfo(delnr));

CREATE TABLE prisinfo(
delnr     INTEGER,
levnr     INTEGER,
katalognr CHAR(6),
pris      REAL,
CONSTRAINT prisinfo_pk PRIMARY KEY(delnr, levnr),
CONSTRAINT prisinfo_fk1 FOREIGN KEY(delnr)REFERENCES delinfo(delnr),
CONSTRAINT prisinfo_fk2 FOREIGN KEY(levnr)REFERENCES levinfo(levnr));

insert into delinfo(delnr, beskrivelse) values(51173,'Binders');
insert into delinfo(delnr, beskrivelse) values(1,'Kontorstol');
insert into delinfo(delnr, beskrivelse) values(51200,'Linjalsett');
insert into delinfo(delnr, beskrivelse) values(3,'Pult');
insert into delinfo(delnr, beskrivelse) values(4,'Skrivebord');
insert into delinfo(delnr, beskrivelse) values(1909,'Skriveunderlag');
insert into delinfo(delnr, beskrivelse) values(201,'Svarte kulepenner');
insert into delinfo(delnr, beskrivelse) values(202,'Bl� kulepenner');

insert into levinfo(levnr, navn, adresse, levby, fylke, postnr) values(6,'Kontorekspressen AS','Skolegata 3','Oslo','Oslo',1234);
insert into levinfo(levnr, navn, adresse, levby, fylke, postnr) values(82,'Kontordata AS','�sveien 178','Trondheim','S-Tr�ndelag',7023);
insert into levinfo(levnr, navn, adresse, levby, fylke, postnr) values(9,'Kontorutstyr AS','Villa Villekulla','�s','�stfold',1456);
insert into levinfo(levnr, navn, adresse, levby, fylke, postnr) values(44,'Billig og Bra AS','Aveny 56','Oslo','Oslo',1222);
insert into levinfo(levnr, navn, adresse, levby, fylke, postnr) values(12,'Mister Office AS','Storgt 56','�s','�stfold',1456);
insert into levinfo(levnr, navn, adresse, levby, fylke, postnr) values(81,'Kontorbutikken AS','Gjennomveien 78','�l','Telemark',3345);

insert into ordrehode(ordrenr, dato, levnr, status)  values(11,'1986-05-10',6,'c');
insert into ordrehode(ordrenr, dato, levnr, status)  values(12,'1986-07-17',82,'c');
insert into ordrehode(ordrenr, dato, levnr, status)  values(13,'1986-09-13',44,'p');
insert into ordrehode(ordrenr, dato, levnr, status)  values(14,'1986-12-17',44,'p');
insert into ordrehode(ordrenr, dato, levnr, status)  values(15,'1987-01-03',44,'p');
insert into ordrehode(ordrenr, dato, levnr, status)  values(16,'1987-01-31',6,'c');
insert into ordrehode(ordrenr, dato, levnr, status)  values(17,'1987-05-14',6,'c');
insert into ordrehode(ordrenr, dato, levnr, status)  values(18,'1987-05-12',82,'p');


insert into ordredetalj(ordrenr, delnr, kvantum) values(11,1,5);
insert into ordredetalj(ordrenr, delnr, kvantum) values(11,201,100);
insert into ordredetalj(ordrenr, delnr, kvantum) values(11,202,100);
insert into ordredetalj(ordrenr, delnr, kvantum) values(11,1909,6);
insert into ordredetalj(ordrenr, delnr, kvantum) values(11,51200,20);
insert into ordredetalj(ordrenr, delnr, kvantum) values(12,3,2);
insert into ordredetalj(ordrenr, delnr, kvantum) values(12,201,50);
insert into ordredetalj(ordrenr, delnr, kvantum) values(12,202,60);
insert into ordredetalj(ordrenr, delnr, kvantum) values(13,51173,20);
insert into ordredetalj(ordrenr, delnr, kvantum) values(14,201,100);
insert into ordredetalj(ordrenr, delnr, kvantum) values(14,202,100);
insert into ordredetalj(ordrenr, delnr, kvantum) values(14,51173,30);
insert into ordredetalj(ordrenr, delnr, kvantum) values(15,201,100);
insert into ordredetalj(ordrenr, delnr, kvantum) values(15,202,100);
insert into ordredetalj(ordrenr, delnr, kvantum) values(16,201,50);
insert into ordredetalj(ordrenr, delnr, kvantum) values(16,202,50);
insert into ordredetalj(ordrenr, delnr, kvantum) values(16,51173,20);
insert into ordredetalj(ordrenr, delnr, kvantum) values(16,1909,10);
insert into ordredetalj(ordrenr, delnr, kvantum) values(17,1,10);
insert into ordredetalj(ordrenr, delnr, kvantum) values(17,3,1);
insert into ordredetalj(ordrenr, delnr, kvantum) values(17,4,5);
insert into ordredetalj(ordrenr, delnr, kvantum) values(18,3,2);
insert into ordredetalj(ordrenr, delnr, kvantum) values(18,4,8);

insert into prisinfo(delnr, levnr, katalognr, pris) values(51173,6,'37S',0.57);
insert into prisinfo(delnr, levnr, katalognr, pris) values(51173,44,'312/2',0.44);
insert into prisinfo(delnr, levnr, katalognr, pris) values(51173,82,'300021',0.35);
insert into prisinfo(delnr, levnr, katalognr, pris) values(1,6,'97s',120.00);
insert into prisinfo(delnr, levnr, katalognr, pris) values(1,9,'x120',219.99);
insert into prisinfo(delnr, levnr, katalognr, pris) values(51200,6,'54s',7.35);
insert into prisinfo(delnr, levnr, katalognr, pris) values(1909,9,'X7770',3.00);
insert into prisinfo(delnr, levnr, katalognr, pris) values(201,44,'100/1',1.60);
insert into prisinfo(delnr, levnr, katalognr, pris) values(201,6,'21s',1.90);
insert into prisinfo(delnr, levnr, katalognr, pris) values(202,44,'101/1',1.50);
insert into prisinfo(delnr, levnr, katalognr, pris) values(202,9,'22s',1.76);
insert into prisinfo(delnr, levnr, katalognr, pris) values(3,82,'2077',1299.00);
insert into prisinfo(delnr, levnr, katalognr, pris) values(4,82,'2177',899.00);
insert into prisinfo(delnr, levnr, katalognr, pris) values(201,82,'3140',2.60);
insert into prisinfo(delnr, levnr, katalognr, pris) values(202,82,'3141',1.50);
insert into prisinfo(delnr, levnr, katalognr, pris) values(3,6,'34P',1199.00);
insert into prisinfo(delnr, levnr, katalognr, pris) values(4,6,'67P',550.00);
insert into prisinfo(delnr, levnr, katalognr, pris) values(1909,6,'53P',0.85);
insert into prisinfo(delnr, levnr, katalognr, pris) values(202,6,'345u',6.50);
insert into prisinfo(delnr, levnr, katalognr, pris) values(3,9,'a48',1050.00);

-- -----------------
-- ----Oppgaver-----
-- -----------------

-- Oppgave 1a
SELECT * FROM ordrehode NATURAL JOIN ordredetalj WHERE levnr=44;

-- Oppgave 1b
SELECT navn, levby FROM levinfo NATURAL JOIN ordrehode NATURAL JOIN ordredetalj WHERE delnr=1;

-- Oppgave 1c
SELECT levnr, navn, pris
FROM levinfo JOIN prisinfo USING(levnr)
WHERE delnr=201 ORDER BY prisinfo.pris LIMIT 1;

-- Oppgave 1d
SELECT ordrenr, dato, delnr, beskrivelse, kvantum, pris, pris*kvantum "Beregnet beløp"
FROM ordrehode JOIN ordredetalj USING(ordrenr) JOIN prisinfo USING(delnr) JOIN delinfo USING(delnr)
WHERE ordrenr=16;

-- Oppgave 1e
SELECT delnr, levnr FROM prisinfo WHERE pris>(SELECT pris FROM prisinfo WHERE katalognr='X7770');

-- Oppgave 1f
  -- i
      CREATE TABLE byer(
        lev_by VARCHAR(20) NOT NULL,
        fylke VARCHAR(20) NOT NULL,
        CONSTRAINT byer_pk PRIMARY KEY(lev_by));

      INSERT INTO byer (levby, fylke) SELECT DISTINCT levby, fylke FROM levinfo;

      CREATE TABLE levinfo2(
      levnr   INTEGER,
      navn    VARCHAR(20) NOT NULL,
      adresse VARCHAR(20) NOT NULL,
      levby   VARCHAR(20) NOT NULL,
      postnr  INTEGER NOT NULL,
      CONSTRAINT levinfo_pk PRIMARY KEY(levnr));

      INSERT INTO levinfo2 (levnr, navn, adresse, levby, postnr)
      SELECT DISTINCT levnr, navn, adresse, levby, postnr
      FROM levinfo;

  -- ii
      CREATE VIEW virtuellTabell SELECT levnr, navn, adresse, levby, fylke, postnr FROM byer JOIN levinfo2 USING(lev_by)
      UPDATE virtuellTabell SET navn = 'Nikolais kontorrotter' WHERE levnr = 6;
      INSERT INTO virtuellTabell VALUES(5, "Zaims slaver", "Nazigate 4", "Oslo", "Oslo", 2550); -- Fungerer ikke

-- Oppgave 1g
SELECT DISTINCT levby
FROM levinfo WHERE levby
NOT IN (SELECT levby FROM prisinfo, levinfo WHERE (prisinfo.levnr = levinfo.levnr));

-- Oppgave 1h
CREATE VIEW leverandører AS SELECT * FROM ordredetalj JOIN prisinfo USING(delnr)

SELECT levnr FROM leverandorer WHERE

-- Finner antall deler i ordrenr 18, ser at dette er 2
SELECT levnr, totalpris FROM (SELECT b.tot as tot, SUM(pris) as totalpris, levnr
FROM (SELECT levnr, pris, ordrenr FROM prisinfo JOIN ordredetalj USING(delnr) WHERE ordrenr=18) as a
JOIN (SELECT COUNT(*) as tot, ordrenr FROM ordredetalj GROUP BY ordrenr) as b USING(ordrenr)
GROUP BY levnr HAVING COUNT(pris)=tot) as c ORDER by totalpris ASC LIMIT 1

-- Oppgave 2
-- Oppgave a
SELECT * FROM forlag WHERE telefon LIKE '2%'
UNION
SELECT * FROM forlag WHERE telefon NOT LIKE '2%'
UNION
SELECT * FROM forlag WHERE telefon IS NULL;

-- Oppgave b
SELECT SUM(2019 - fode_aar) / count(*)
FROM forfatter WHERE fode_aar IS NOT NULL
AND IF(dod_aar IS NULL, fode_aar > 1900, dod_aar);

-- Oppgave c
SELECT count(*) / (SELECT count(*) FROM forfatter)
FROM forfatter WHERE fode_aar IS NOT NULL
AND IF(dod_aar IS NULL, fode_aar > 1900, dod_aar);
