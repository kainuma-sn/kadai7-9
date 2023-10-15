DROP TABLE IF EXISTS purchase_record;

CREATE TABLE purchase_record (
 id int unsigned AUTO_INCREMENT,
 name VARCHAR(50) NOT NULL,
 price int unsigned NOT NULL,
 catalog_id int unsigned NOT NULL,
 PRIMARY KEY(id)
);


