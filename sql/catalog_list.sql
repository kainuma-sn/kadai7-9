DROP TABLE IF EXISTS catalog_list;

CREATE TABLE catalog_list (
 id int unsigned AUTO_INCREMENT,
 name VARCHAR(50) NOT NULL,
 price int unsigned NOT NULL,
 PRIMARY KEY(id)
);

INSERT INTO names (id, name, price) VALUES (1, "SUPERIOR DRUMMER 3", 49500, 50);
INSERT INTO names (id, name, price) VALUES (2, "BFD 3",35799,37);
INSERT INTO names (id, name, price) VALUES (3, "MODO DRUM 1.5",30990,25);
INSERT INTO names (id, name, price) VALUES (4, "TOKYO SCORING DRUM KITS", 44671, 0);
