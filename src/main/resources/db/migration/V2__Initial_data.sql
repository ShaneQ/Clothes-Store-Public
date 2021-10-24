INSERT INTO size (id, name) VALUES
  (1, 'XS'),
  (2, 'S'),
  (3, 'M'),
  (4, 'L'),
  (5, 'XL')
;

INSERT INTO occasion (id, name) VALUES
  (1, 'Casual'),
  (2, 'Cocktail'),
  (3, 'Night out'),
  (4, 'Vacation'),
  (5, 'Work')
;


INSERT INTO product_category (id, name) VALUES
  (1, 'Dresses'),
  (2, 'Tops & Tshirts'),
  (3, 'Sweaters'),
  (4, 'Jackets & Coats'),
  (5, 'Pants'),
  (6, 'Skirts'),
  (7, 'Jumpsuits'),
  (8, 'Accessories')
;

INSERT INTO product_measurement (id, length, chest, hips, waist) VALUES
  (1, 99,100,99,100),
  (2, 99,100,75,33),
  (3, 99,NULL,99,100),
  (4, 99,64,99,100),
  (5, 99,100,99,NULL),
  (6, 99,100,99,33),
  (7, 99,NULL,99,100),
  (8, 99,100,99,65)
;


INSERT INTO image (id, path) VALUES
  (1,'https://media.geeksforgeeks.org/wp-content/uploads/20190506164011/logo3.png'),
  (2,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1kUVuAjGZ8a6N1Tz9m0i0zKXVkk0CTJnJslJu6Z3Pk17XqOdSyQ&s'),
  (3,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1kUVuAjGZ8a6N1Tz9m0i0zKXVkk0CTJnJslJu6Z3Pk17XqOdSyQ&s');
;

INSERT INTO product (id, name, id_product_measurement, id_product_category, id_cover_img, dry_clean, rental_price, retail_price, quick_desc, material, description, fitting_info, wash_info  ) VALUES
  (1,'Dress',1, 1,1,TRUE, 10.50, 100 ,'Something Nice and Short', 'cotton','something very long', 'Its tight', 'Dryclean only'),
  (2,'Jumper',2, 2, NULL,FALSE, 20,200,'Something Good','denim','something very long', 'Its loose', 'No spills or i will cut you'),
  (3,'Pants',3, 5, NULL,TRUE,30.40, 300, '','silk', 'something very long', 'It weird', 'you wouldnt believe how much this cost dont hand wash'),
  (4,'Sweater',4, 2, NULL, TRUE, 40, 400.50,'Cotton', 'Something Else','something very long', 'Its descriptive', 'some other cut and wash info'),
  (5,'Coat',5, 4, NULL, FALSE, 40.66, 500,'Something Bad','Nylon','something very long','i will make you feel 30','care for it really well');
;

INSERT INTO product_size (id,id_product, id_size) VALUES
  (1,1, 1),
  (2,1, 2),
  (3,1, 3),
  (4,2, 1),
(5,3, 1),
(6,4, 3),
(7,5, 4)
;

INSERT INTO product_occasion (id,id_product, id_occasion) VALUES
  (1,1, 1),
  (2,1, 2),
  (3,1, 3),
  (4,2, 1),
(5,3, 1),
(6,4, 3),
(7,5, 4)
;





INSERT INTO product_image(id, id_product,id_image) VALUES
(1,1,1),
(2,2,2),
(3,3,3)
;