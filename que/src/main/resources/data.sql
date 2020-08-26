INSERT INTO buildings
( city, street, number, owner_Id, size, market_value, type)
VALUES('Kaunas','Taikos pr', '192a',1,32.5,500000.6,'APARTMENT'),
       ('Vilnius','Savanoriu pr.','24b',3,66.2,290900.5,'APARTMENT'),
       ('Prienai','Liepu g.','24b',2,66.2,190900.5,'HOUSE'),
       ('Klaipeda','Juros g.','21',3,62.2,90900.5,'APARTMENT'),
       ('Vilnius','Vytauto pr.','2',2,660.2,2000900.5,'INDUSTRIAL'),
       ('Druskininkai','Egliu g.','5',4,38.2,40900.5,'APARTMENT'),
       ('Raseiniai','Janonio g.','24',1,120.1,120900.5,'HOUSE');
INSERT INTO owners
(`first_name`,`last_name`)
VALUES
('Petras','Petraitis'),
('Jonas','Jonaitis'),
('Antanas','Antanaitis'),
('Rimas','Rimaitis'),
('Domas','Adomaitis');