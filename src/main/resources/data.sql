
INSERT INTO VEHICLE_SUPER_TYPES (ID,DESCRIPTION,PLEDGE_AMOUNT) VALUES ('L','Motor vehicles with less than four wheels.',100);
INSERT INTO VEHICLE_SUPER_TYPES(ID,DESCRIPTION,PLEDGE_AMOUNT) VALUES ('M','Vehicles having at least four wheels and used for the carriage of passengers.',100);
INSERT INTO VEHICLE_SUPER_TYPES(ID,DESCRIPTION,PLEDGE_AMOUNT) VALUES ('N','Power-driven vehicles having at least four wheels and used for the carriage of goods.',100);
INSERT INTO VEHICLE_SUPER_TYPES(ID,DESCRIPTION,PLEDGE_AMOUNT) VALUES ('O','Trailers.',300);
INSERT INTO VEHICLE_SUPER_TYPES(ID,DESCRIPTION,PLEDGE_AMOUNT) VALUES ('T','Agricultural and Forestry tractors.',300);
INSERT INTO VEHICLE_SUPER_TYPES(ID,DESCRIPTION,PLEDGE_AMOUNT) VALUES ('G','Off-road vehicles.',300);
INSERT INTO VEHICLE_SUPER_TYPES(ID,DESCRIPTION,PLEDGE_AMOUNT) VALUES ('S','Special purpose vehicles.',300);

INSERT INTO MEMBER_SHIP_TYPES(ID,PAYS_PLEDGE) VALUES ('Gold',false);
INSERT INTO MEMBER_SHIP_TYPES(ID,PAYS_PLEDGE) VALUES ('Regular',true);

INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('L1','L','5.05','3.75',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('L2','L','5.15','3.85',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('L3','L','5.25','3.95',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('l4','L','5.35','3.95',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('L5','L','5.35','3.95',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('L6','L','5.35','3.95',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('L7','L','5.35','3.95',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('M1','M','9.45','8.75',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('M2','M','9.55','8.85',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('M3','M','9.65','8.95',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('N1','N','3.15','2.95',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('N2','N','3.15','2.95',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('N3','N','3.15','2.95',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('O1','O','19','17.5',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('O2','O','19','17.5',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('O3','O','19','17.5',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('O4','O','19','17.5',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('T','T','30','25',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('G','G','30.05','25',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('SA','S','30','25',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('SB','S','64','55',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('SC','S','23.5','19.5',NULL);
INSERT INTO VEHICLE_TYPES(ID,VEHICLE_SUPER_TYPE_ID,RENTAL_PRICE,GOLD_PRICE,DESCRIPTION) VALUES ('SD','S','40','35',NULL);
