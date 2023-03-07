INSERT INTO users (username, first_name, last_name, email, profile_picture, pass, phone_number, balance_eur)
VALUES
    ('lukeskywalker', 'Luke', 'Skywalker', 'luke@starwars.com', null, 'secretpassword1', '555-555-0001', 131.21),
    ('leiaorgana', 'Leia', 'Organa', 'leia@starwars.com', null, 'secretpassword2', '555-555-0002', 340123.82),
    ('han Solo', 'Han', 'Solo', 'han@starwars.com', null, 'secretpassword3', '555-555-0003', 1762.69),
    ('Chewbacca', 'Chewbacca', '', 'chewie@starwars.com', null, 'secretpassword4', '555-555-0004', 13.87),
    ('ObiWan', 'Obi-Wan', 'Kenobi', 'obiwan@starwars.com', null, 'secretpassword5', '555-555-0005', 6.17),
    ('darthvader', 'Darth', 'Vader', 'vader@starwars.com', null, 'secretpassword6', '555-555-0006', 4435.67),
    ('yoda', 'Yoda', '', 'yoda@starwars.com', null, 'secretpassword7', '555-555-0007', 0.23),
    ('palpatine', 'Emperor', 'Palpatine', 'palpatine@starwars.com', null, 'secretpassword8', '555-555-0008', 8761232.26),
    ('r2d2', 'R2-D2', '', 'r2d2@starwars.com', null, 'secretpassword9', '555-555-0009', 0.00),
    ('c3po', 'C-3PO', '', 'c3po@starwars.com', null, 'secretpassword10', '555-555-0010', 0.00);

INSERT INTO posts (title, description, price, category)
VALUES
    ('New Laptop', 'The latest laptop from Apple with high specs', 380.00, 'electronics'),
    ('Vintage Car', '1950s car in good condition', 4500.00, 'cars'),
    ('Antique Painting', 'A beautiful painting from the 19th century', 29.99, 'art'),
    ('Designer Dress', 'Beautiful designer dress, worn only once', 173.88, 'fashion'),
    ('Guitar Collection', 'Vintage guitar collection, perfect for collectors', 2133.67, 'music'),
    ('Vintage Vinyls', 'Collection of vintage vinyl records, rare finds', 86.79, 'music'),
    ('Limited Edition Sneakers', 'Limited edition sneakers, only 500 made', 69.99, 'fashion'),
    ('Action Figure Set', 'Complete set of Star Wars action figures', 12.43, 'toys'),
    ('Jewelry Set', 'Complete set of jewelry, perfect for special occasions', 230.00, 'fashion'),
    ('Signed Sports Jersey', 'Signed sports jersey from a famous athlete', 85.70, 'sports'),
    ('Vintage Camera', 'Vintage camera, perfect for photography enthusiasts', 12.99, 'electronics'),
    ('Sculpture Collection', 'Collection of sculptures, rare finds', 435.65, 'art'),
    ('Vintage Comic Books', 'Collection of vintage comic books, rare finds', 7.99, 'books'),
    ('Designer Handbags', 'Collection of designer handbags, perfect for fashion lovers', 800.00, 'fashion'),
    ('Antique Furniture', 'Antique furniture, perfect for interior design enthusiasts', 345.65, 'home');

INSERT INTO posts_users (post_id, user_id)
VALUES
    (1, 1),
    (2, 1),
    (3, 2);