INSERT INTO Foo(id, name) VALUES (1, 'Foo 1');
INSERT INTO Foo(id, name) VALUES (2, 'Foo 2');
INSERT INTO Foo(id, name) VALUES (3, 'Foo 3');

DROP TABLE IF EXISTS Product;

CREATE TABLE Product (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  image_path VARCHAR(250) NOT NULL,
  type VARCHAR(250) NOT NULL

);

INSERT INTO Product (name, type, image_path) VALUES
  ('Dress', 'DRESS', 'https://media.geeksforgeeks.org/wp-content/uploads/20190506164011/logo3.png'),
  ('Jumper','JUMPER', ''),
  ('Pants','PANTS', ''),
  ('Sweater','Sweater', '');

