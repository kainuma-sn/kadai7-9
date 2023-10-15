DROP TABLE IF EXISTS purchase_record;

CREATE TABLE purchase_record (
 id int unsigned AUTO_INCREMENT,
 catalog_list_id int unsigned NOT NULL,
 created_at TIMESTAMP,
 PRIMARY KEY(id)
);

