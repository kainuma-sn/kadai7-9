DROP TABLE IF EXISTS catalog_list;

CREATE TABLE catalog_list (
 id int unsigned AUTO_INCREMENT,
 productName VARCHAR(50) NOT NULL,
 productPrice int unsigned NOT NULL,
 productStock int unsigned NOT NULL,
 PRIMARY KEY(id)
);

INSERT INTO catalog_list (id, productName, productPrice, productStock) VALUES (1,"SUPERIOR DRUMMER 3", 49500, 50);
INSERT INTO catalog_list (id, productName, productPrice, productStock) VALUES (2,"BFD 3",35799,37);
INSERT INTO catalog_list (id, productName, productPrice, productStock) VALUES (3,"MODO DRUM 1.5",30990,25);
INSERT INTO catalog_list (id, productName, productPrice, productStock) VALUES (4,"TOKYO SCORING DRUM KITS", 44671, 10);
