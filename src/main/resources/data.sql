INSERT INTO Foo(id, name) VALUES (1, 'Foo 1');
INSERT INTO Foo(id, name) VALUES (2, 'Foo 2');
INSERT INTO Foo(id, name) VALUES (3, 'Foo 3');


INSERT INTO SIZES (id, name) VALUES
  (1, 'XS'),
  (2, 'S'),
  (3, 'M'),
  (4, 'L'),
  (5, 'XL')
;


INSERT INTO IMAGE (path) VALUES
  ('https://media.geeksforgeeks.org/wp-content/uploads/20190506164011/logo3.png'),
  ('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1kUVuAjGZ8a6N1Tz9m0i0zKXVkk0CTJnJslJu6Z3Pk17XqOdSyQ&s'),
  ('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1kUVuAjGZ8a6N1Tz9m0i0zKXVkk0CTJnJslJu6Z3Pk17XqOdSyQ&s');
;

INSERT INTO PRODUCT (name, type, id_cover_img, description) VALUES
  ('Dress', 'DRESS',1, 'Something Nice'),
  ('Jumper','JUMPER', NULL,'Something Good'),
  ('Pants','PANTS', NULL, ''),
  ('Sweater','Sweater', NULL, 'Something Else'),
  ('Coat','Coat', NULL, 'Something Bad');
;

INSERT INTO PRODUCT_SIZE (id_product, id_size) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 1),
(3, 1),
(4, 3),
(5, 4)
;




INSERT INTO PRODUCT_IMAGE(id_product,id_image) VALUES
(1,1),
(2,2),
(3,3)
;



