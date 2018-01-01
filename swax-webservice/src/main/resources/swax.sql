DROP TABLE IF EXISTS USER;

CREATE TABLE USER(USER_ID INT PRIMARY KEY, EMAIL VARCHAR(255), PASSWORD VARCHAR(255), USER_NAME VARCHAR(255), 
	COUNTRY VARCHAR(255));

INSERT INTO USER VALUES(1, 'ibarra@hotmail.fr', 'pwd', 'Alcatraz', 'France');
INSERT INTO USER VALUES(2, 'idobi@hotmail.fr', 'pwd', 'Damien', 'France');
INSERT INTO USER VALUES(3, 'coco@gmail.com', 'pwd', 'Coco', 'Belgium');

SELECT * FROM USER ORDER BY USER_ID;