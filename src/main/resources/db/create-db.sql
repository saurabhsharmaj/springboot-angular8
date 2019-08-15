-- delete from contact where id > 0;
-- DROP TABLE contact;

CREATE TABLE contact (
  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  name VARCHAR(45),
  email  VARCHAR(45),
  phone  VARCHAR(15),
  PRIMARY KEY(id)
);

-- INSERT INTO contact(name,email,phone) VALUES ('jagdish','jakumar@gmail.com','1234567890');
-- INSERT INTO contact(name,email,phone) VALUES ('vishnu','vcv@gmail.com','1234567890');
-- INSERT INTO contact(name,email,phone) VALUES ('saurabh','saurshamra@gmail.com','1234567890');
