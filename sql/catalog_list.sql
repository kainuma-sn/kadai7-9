DROP TABLE IF EXISTS catalog_list;

CREATE TABLE catalog_list (
 id int unsigned AUTO_INCREMENT,
 productName VARCHAR(50) NOT NULL,
 productPrice int unsigned NOT NULL,
 productStock int unsigned NOT NULL,
 PRIMARY KEY(id)
);
