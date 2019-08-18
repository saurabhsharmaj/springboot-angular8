-- delete from contact where id > 0;
-- DROP TABLE contact;

CREATE TABLE contact (
  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  name VARCHAR(45),
  email  VARCHAR(45),
  phone  VARCHAR(15),
  PRIMARY KEY(id)
);
CREATE TABLE agent_basic_info(
  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  ipaddress VARCHAR(45),
  hostname  VARCHAR(10),
  OS varchar(45),
  arch varchar(10),
  PRIMARY KEY(id)
);

CREATE TABLE feature (
  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  agent_id INTEGER,
  name VARCHAR(45),
  status  VARCHAR(10),
  PRIMARY KEY(id)
);

CREATE TABLE config (
  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  config_key VARCHAR(45) NOT NULL UNIQUE,
  config_value  VARCHAR(255),
 PRIMARY KEY(id)
);

INSERT INTO config(config_key,config_value) VALUES ('jagdish','jakumar@gmail.com');
-- INSERT INTO contact(name,email,phone) VALUES ('jagdish','jakumar@gmail.com','1234567890');
-- INSERT INTO contact(name,email,phone) VALUES ('vishnu','vcv@gmail.com','1234567890');
-- INSERT INTO contact(name,email,phone) VALUES ('saurabh','saurshamra@gmail.com','1234567890');
