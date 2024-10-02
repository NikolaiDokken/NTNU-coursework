DROP TABLE IF EXISTS BORETTSLAG;
DROP TABLE IF EXISTS BYGNINGER;
DROP TABLE IF EXISTS ANDELSEIERE;
DROP TABLE IF EXISTS LEILIGHETER;

CREATE TABLE BORETTSLAG(
  Navn text,
  Addresse text,
  AntallBygninger int,
  EtableringsAar int
  BorettslagNr int, #PK
);
ALTER TABLE BORETTSLAG
ADD PRIMARY KEY (BorettslagNr);

CREATE TABLE BYGNINGER(
  BorettslagNr int, #FK
  AntallLeiligheter int,
  BygningsNr int, #PK
  Etasje INT(11)
);
ALTER TABLE BYGNINGER
ADD PRIMARY KEY (BygningsNr);

CREATE TABLE ANDELSEIERE(
  Navn text,
  MedlemsNr int, #PK
  LeilighetsNr int, #FK
);
ALTER TABLE ANDELSEIERE
ADD PRIMARY KEY (MedlemsNr);

CREATE TABLE LEILIGHETER(
  LeilighetsNr int, #PK
  MedlemsNr int, #FK
  BygningsNr int, # FK
  Rom int,
  KvadratMeter int,
  etasje int #PK
);
ALTER TABLE LEILIGHETER
ADD PRIMARY KEY (LeilighetsNr, Etasje);



# Fremmednøkler
ALTER TABLE BYGNINGER
ADD FOREIGN KEY (BorettslagNr) REFERENCES BORETTSLAG(BorettslagNr);

ALTER TABLE ANDELSEIERE
ADD FOREIGN KEY (LeilighetsNr) REFERENCES LEILIGHETER(LeilighetsNr);

ALTER TABLE LEILIGHETER
ADD FOREIGN KEY (MedlemsNr) REFERENCES ANDELSEIERE(MedlemsNr);

ALTER TABLE LEILIGHETER
ADD FOREIGN KEY (BygningsNr) REFERENCES BYGNINGER(BygningsNr);

# insert
INSERT INTO `Andelseiere`(`Navn`, `MedlemsNr`, `LeilighetsNr`) VALUES ("Per Olson", 0001, 24);
INSERT INTO `Borettslag`(`Navn`, `Addresse`, `AntallBygninger`, `EtableringsAar`, `BorettslagNr`) VALUES ( "Valles borettslag", "Pers vei 20", 4, 2009,2);
INSERT INTO `Bygninger`(`BorettslagNr`, `AntallLeiligheter`, `BygningsNr`, `Etasje`) VALUES (2,120, 3, 6);
INSERT INTO `Leiligheter`(`LeilighetsNr`, `MedlemsNr`, `BygningsNr`, `AntallRom`, `KvadratMeter`, `Etasje`) VALUES (13, 0001, 3, 4, 109, 3);

INSERT INTO `Leiligheter`(`LeilighetsNr`, `MedlemsNr`, `BygningsNr`, `AntallRom`, `KvadratMeter`, `Etasje`) VALUES (13, 0002, 3, 4, 109, 3);
