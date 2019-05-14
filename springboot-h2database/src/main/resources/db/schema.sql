DROP TABLE IF EXISTS product;

CREATE TABLE IF NOT EXISTS product(
  id varchar(32) unsigned not null primary key,
  name varchar(32),
  price int,
  tenant_id varchar(32),
  created_by varchar(32),
  updated_by varchar(32),
  created_at date,
  updated_at date, dr int(1)
);