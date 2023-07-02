INSERT INTO users (username, first_name, last_name, email, profile_picture, pass, role, phone_number, balance_eur, creation_ts)
VALUES
    ('barackobama', 'Barack', 'Obama', 'barack@obama.com', null, 'eb74fb2a66cf4a7b7db6f1842852696e51249e5635f142c4ad4295b97e1cb923', 1, '555-555-0003', 560.75, '1458489907'),
    ('oprahwinfrey', 'Oprah', 'Winfrey', 'oprah@winfrey.com', null, 'c063248894114be80b20597004e0a180a115eefa220b8efbafcf79c8721544b0', 2, '555-555-0004', 1240.89, '1504236175'),
    ('elonmusk', 'Elon', 'Musk', 'elon@musk.com', null, '964adae145db765d705f2557784873b4aedd65d15fdda75a95c7f24bc87d166b', 2, '555-555-0005', 547800.00, '1491456393'),
    ('angelinajolie', 'Angelina', 'Jolie', 'angelina@jolie.com', null, 'fae9182ee1a8b7ffefa6bf7505c884e135606fd64acbbee4a2b32b9bc2fccf64', 1, '555-555-0006', 1090800.10, '1434273745'),
    ('billgates', 'Bill', 'Gates', 'bill@gates.com', null, '6a2c650bdea67cb3789e8be1c8a5f0ef695e03c797bb31a6438c54cc84242134', 1, '555-555-0007', 760000.99, '1434233725'),
    ('serenawilliams', 'Serena', 'Williams', 'serena@williams.com', null, '33cd7bf9b7144938204cffb608e19928b5a931e9b0ffdef734cc84374d2d61a6', 1, '555-555-0008', 23453.21, '1437673745'),
    ('malalayousafzai', 'Malala', 'Yousafzai', 'malala@yousafzai.com', null, '6954ca88953cfec93a3e45e24d6c3bd27dc995807a1899cfac6687285deef491', 1, '555-555-0009', 1478.22, '1577070868'),
    ('jeffbezos', 'Jeff', 'Bezos', 'jeff@bezos.com', null, 'ac36d4e1ac31452bd1ec0c0513a4126fa17637f4087daae6f3f7eba8e6cf4d6f', 1, '555-555-0010', 19200000.01, '1577070861'),
    ('jacindaardern', 'Jacinda', 'Ardern', 'jacinda@ardern.com', null, '56a74c93db8f0ce8cea637ddb4ae78007a313d92831bd0c092e3176318f6ec16', 1, '555-555-0011', 3549.67, '1577070268'),
    ('donaldtrump', 'Donald', 'Trump', 'donald@trump.com', null, '1e2f0d9b36b940c816503ff71cab40ebf483faf13260784b75b2512505f197ae', 1, '555-555-0012', 10000.00, '1577070865'),
    ('lukeskywalker', 'Luke', 'Skywalker', 'luke@starwars.com', null, 'ffea381cdd88b8b19d13ef888dd2934328fe92bfa239eae16d7aaee355a3d2d0', 1, '555-555-0001', 131.21, '1547070868'),
    ('leiaorgana', 'Leia', 'Organa', 'leia@starwars.com', null, '318630a1e235cdb3a497fb63a9e0d9c1c70e2edbc1cd900488066477e4d714d0', 1, '555-555-0002', 340123.82, '1577070268'),
    ('han Solo', 'Han', 'Solo', 'han@starwars.com', null, '9abde4c06511e7fcf9f08d073c93854670daa2e47661d58841cf18ef1a5d4446', 1, '555-555-0003', 1762.69, '1577210868'),
    ('Chewbacca', 'Chewbacca', '', 'chewie@starwars.com', null, 'd3140bb2ffc3f8cd0e214da3f0138e1b9638ef05a0308a24eaa9578f3784c56a', 1, '555-555-0004', 13.87, '1577070368'),
    ('ObiWan', 'Obi-Wan', 'Kenobi', 'obiwan@starwars.com', null, '0e4b71ed1c21c8d4ecdad0f794d3d1e03b8da6be2957e046b28bf5dfee0d1017', 1, '555-555-0005', 6.17, '1577072868'),
    ('darthvader', 'Darth', 'Vader', 'vader@starwars.com', null, '3b6e683e3e8f684dafbfce395b433c7747b7e9df4415c3b213b9041270b34d03', 1, '555-555-0006', 4435.67, '1577070818'),
    ('yoda', 'Yoda', '', 'yoda@starwars.com', null, '4f5deec1f2bf6dd901a40c0ed0c530d68a98568f79a885b307d0e82aa113012e', 1, '555-555-0007', 0.23, '1577020868'),
    ('palpatine', 'Emperor', 'Palpatine', 'palpatine@starwars.com', null, '2b14baf964c58de4a01c9a072478dc6958d03c030a21d2564524f2c44defc75e', 1, '555-555-0008', 8761232.26, '1577072828'),
    ('r2d2', 'R2-D2', '', 'r2d2@starwars.com', null, '63ddf3cf52005d05519550a07b9470001d0feabb22cbc921086966c350db08f3', 1, '555-555-0009', 0.00, '1571170168'),
    ('c3po', 'C-3PO', '', 'c3po@starwars.com', null, 'fb41985d01382e2d10c2ad47964f0a389e2e3f9e709fbdd87b2ad22e1a159b53', 1, '555-555-0010', 0.00, '1577070868'),
    ('a', 'name', 'lastName', 'a@a.a', null, '863c49aa476327b3c0c28e0013b47299de68431cf5c92bebe76d0baa2c4aa314', 2, '0913453443', 250.00, '1577070868');

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
    (3, 2),
    (4, 3),
    (5, 3),
    (6, 4),
    (7, 5),
    (8, 5),
    (9, 6),
    (10, 6),
    (11, 7),
    (12, 7),
    (13, 9),
    (14, 10),
    (15, 10);

INSERT INTO locations (country, region, city)
VALUES
    ('Germany', 'Bavaria', 'Munich'),
    ('Croatia', 'Varazdinska', 'Varazdin'),
    ('Croatia', 'Varazdinska', 'Sracinec'),
    ('Japan', 'Tokyo', 'Shibuya'),
    ('Australia', 'New South Wales', 'Sydney'),
    ('United States', 'California', 'San Francisco'),
    ('Canada', 'Ontario', 'Toronto'),
    ('Brazil', 'Sao Paulo', 'Sao Paulo'),
    ('France', 'Ile-de-France', 'Paris'),
    ('Spain', 'Catalonia', 'Barcelona'),
    ('Mexico', 'Jalisco', 'Guadalajara'),
    ('Mexico', 'Yucatan', 'Merida'),
    ('Italy', 'Lombardy', 'Milan'),
    ('Italy', 'Lazio', 'Rome'),
    ('China', 'Shanghai', 'Shanghai'),
    ('China', 'Guangdong', 'Shenzhen'),
    ('India', 'Karnataka', 'Bangalore'),
    ('India', 'Maharashtra', 'Mumbai'),
    ('South Africa', 'Gauteng', 'Johannesburg'),
    ('South Africa', 'Western Cape', 'Cape Town'),
    ('Russia', 'Moscow', 'Moscow'),
    ('Croatia', 'Zagreb', 'Zagreb'),
    ('Croatia', 'Splitsko-Dalmatinska', 'Split');

INSERT INTO users_locations (user_id, location_id)
VALUES
    (1, 7),
    (2, 6),
    (3, 3),
    (4, 3),
    (5, 11),
    (6, 12),
    (7, 12),
    (8, 1),
    (9, 1),
    (10, 15),
    (11, 9),
    (12, 14),
    (13, 19),
    (14, 1),
    (15, 2),
    (16, 20),
    (17, 5),
    (18, 4),
    (19, 17),
    (20, 13),
    (21, 2);

INSERT INTO roles (id, name)
VALUES
    (1, 'USER'),
    (2, 'ADMIN')